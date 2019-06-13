package team.javaSpirit.teachingAssistantPlatform.vediotape.service;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jim2mov.core.DefaultMovieInfoProvider;
import org.jim2mov.core.ImageProvider;
import org.jim2mov.core.Jim2Mov;
import org.jim2mov.core.MovieInfoProvider;
import org.jim2mov.core.MovieSaveException;
import org.jim2mov.utils.MovieUtils;

import team.javaSpirit.teachingAssistantPlatform.vediotape.dao.Sound;
import team.javaSpirit.teachingAssistantPlatform.vediotape.dao.SoundersToOne;
import team.javaSpirit.teachingAssistantPlatform.vediotape.dao.TurnToOne;

public class VediotapeService  implements ActionListener, Runnable {
	public static long start_time; //执行的开始时间
	public static long stop_time;//执行的结束时间
	public static int sum=0;//截图的次数，为了方便计算合成后的帧数
	private String fileName; // 文件的前缀
	private String defaultName = "GuiCamera";
	static int serialNum = 0;
	private String imageFormat; // 图像文件的格式
	private String defaultImageFormat = "JPEG";
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	static String showname = null;
	static int shownum = 1;
	Thread ko_Thread;//线程，负责整个录屏的开始截止
	Sound s=new Sound();//创建一个全局的录音线程，方便以后能够关闭它
	

//构造函数
	public VediotapeService(String s, String format) {//存放图片的路径和格式
		fileName = s;
		imageFormat = format;


	}

	// 线程开始
	public void start() {
		//以防万一，先把目录下的文件删除掉。
		
		if (ko_Thread == null) {
			ko_Thread = new Thread(this);
			ko_Thread.start();//此时会调用run函数
			
			s.captureAudio();
			
		}		
		
	}
	// 结束

	public void stop() {

		if (ko_Thread != null) {

			ko_Thread = null;

		}
		s.targetDataLine.stop();
		s.targetDataLine.close();
		
		
	}
	
	//线程主要执行的方法。 执行

	@Override
	public void run() {
		//Thread thisThread = Thread.currentThread();
		while (ko_Thread != null) {
			
				snapShot();//拍照
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public void openVedio() {

			start();
			Date d=new Date();
			System.out.println("开始时间："+d);
			start_time= System.currentTimeMillis();
			System.out.println("开始时间："+System.currentTimeMillis());

	}
	public void pauseVedio() {
			stop();
			Date d=new Date();
			System.out.println("结束时间："+d);
			System.out.println("结束时间："+System.currentTimeMillis());
			stop_time=System.currentTimeMillis();
     }
	public void stopVedio() {
			stop();
			JFileChooser jchooser=new JFileChooser();
			jchooser.setBounds(20, 24, 564, 367);
			jchooser.setCurrentDirectory(new File("c:/"));
			jchooser.setDialogTitle("保存文件");
			jchooser.setSelectedFile(new File("视频.avi"));
			int x=jchooser.showDialog(null,"保存");
			File file=jchooser.getSelectedFile();
			String path=file.getAbsolutePath();	
			if(x==JFileChooser.APPROVE_OPTION) {
				SoundersToOne one=new SoundersToOne();
				try {
					play();
					try {
						one.Sound2One();
					} catch (UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//询问用户保存目录
					//pass
					//把1个音频和一个视频结合在一起。
					
					TurnToOne oneAvi=new TurnToOne();
					oneAvi.finallyOne(path);
					//删除之前所有形成的文件
					JOptionPane.showMessageDialog(null, "已成功保存到您选择的文件夹下！！！");
					
				} catch (MovieSaveException e1) {
					e1.printStackTrace();
				}

			}
			
		}

//转换成视频
	public static void play() throws MovieSaveException {
		// jpgs目录放置jpg图片,图片文件名为(1.jpg,2.jpg...)
		String relativelyPath=System.getProperty("user.dir");
		 String  filePath  =  relativelyPath+"//picture//";		
//		final File[] jpgs = new File("E:\\record\\").listFiles();//所有的图片
		 final File[] jpgs = new File(filePath).listFiles();//所有的图片
				// 对文件名进行排序(本示例假定文件名中的数字越小,生成视频的帧数越靠前)
				Arrays.sort(jpgs, new Comparator<File>() {//排序接口
					@Override
					public int compare(File file1, File file2) {
						String numberName1 = file1.getName().replace(".jpeg", "");//替换，去掉后缀
						String numberName2 = file2.getName().replace(".jpeg", "");
						return new Integer(numberName1) - new Integer(numberName2);
					}
				});
				for(File f:jpgs) {
					System.out.println(f.getName());
				}
				DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("file:///"+relativelyPath+"/pictureToAVI/out1.avi");//后面这个是转储之后的文件名
				long timer=stop_time-start_time;
				System.out.println("timer:"+timer);
				
				Long l=new Long(timer);
				int lll=l.intValue();
				System.out.println(l.intValue());
				
				
				System.out.println("lla:"+sum*1000/(lll));
				System.out.println("sum:"+sum);
			
				dmip.setFPS(4);
				dmip.setNumberOfFrames(jpgs.length); // 总帧数
				dmip.setMWidth(1440);//100
				dmip.setMHeight(860);//200

				new Jim2Mov(new ImageProvider() {
					public byte[] getImage(int frame) {
						try {
							// 设置压缩比
							return MovieUtils.convertImageToJPEG((jpgs[frame]), 1.0f);//1.0
						} catch (IOException e) {
							e.printStackTrace();
						}
						return null;
					}
				}, dmip, null).saveMovie(MovieInfoProvider.TYPE_QUICKTIME_JPEG);//TYPE_AVI_MJPEG
			}
	
	
	

//* 对屏幕进行拍照
//* snapShot the Gui once
//****************************************************************/
	public void snapShot() {
		sum=sum+1;
System.out.println("开："+System.currentTimeMillis());
		try {
			// 拷贝屏幕到一个BufferedImage对象screenshot
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(), (int) d.getHeight()));
			serialNum++;
			// 根据文件前缀变量和文件格式变量，自动生成文件名
			String name = fileName + String.valueOf(serialNum) + "." + imageFormat;
			File f = new File(name);
			
			// 将screenshot对象写入图像文件
			ImageIO.write(screenshot, imageFormat, f);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("结："+System.currentTimeMillis());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	

}

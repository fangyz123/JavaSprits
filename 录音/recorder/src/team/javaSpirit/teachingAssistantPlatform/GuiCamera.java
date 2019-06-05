package team.javaSpirit.teachingAssistantPlatform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jim2mov.core.DefaultMovieInfoProvider;
import org.jim2mov.core.ImageProvider;
import org.jim2mov.core.Jim2Mov;
import org.jim2mov.core.MovieInfoProvider;
import org.jim2mov.core.MovieSaveException;
import org.jim2mov.utils.MovieUtils;

public class GuiCamera extends JFrame implements ActionListener, Runnable {
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
	int flag;

	JButton jb1 = new JButton("开始");
	JButton jb2 = new JButton("暂停"); 
	JButton jb3 = new JButton("停止");
	JButton jb4 = new JButton("播放录象");
	JButton jb5 = new JButton("选择");
	JPanel jpanel = new JPanel();//一个大玻璃窗
	JLabel label = new JLabel();//一些组件

	public void paint(Graphics g) {//画布
		if (showname != null) {
			Image image = getToolkit().getImage(showname);// 声明一个成员变量
			g.drawImage(image, 0, 0, 1440, 860, this);
		}
	}

	public GuiCamera() throws HeadlessException {
		fileName = defaultName;
		imageFormat = defaultImageFormat;
	}
//构造函数
	public GuiCamera(String s, String format) {//存放图片的路径和格式
		super("欢迎使用java版的屏幕录象软件");
		fileName = s;
		imageFormat = format;
		this.setSize(1440, 900);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jpanel, BorderLayout.SOUTH);
		this.add(label, BorderLayout.CENTER);
		this.setVisible(true);
		jpanel.setLayout(new GridLayout(1, 4));

		jpanel.add(jb1);
		jpanel.add(jb2);
		jpanel.add(jb3);
		jpanel.add(jb4);

		jb1.addActionListener(this);
		 jb4.addActionListener(this);
		/*jb4.addActionListener(new ActionListener() {
			public void actionPerform(ActionEvent e) {
				JFrame jframe = new youFrame(); // 获得你的那个jframe
				jframe.getPanel1().setVisible(false); // 获得jframe里面的第一个面板，并设置隐藏
				jframe.getPane2().setVisible(true); // 获得jframe 里面第二个面板，设置显示.
				Combination c = new Combination();
				c.play();
				// 一上俩个 getPane() 方法，为 你在jframe 里面，对俩个面板提供的getter 方法。
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});*/
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		ImageIcon icon = new ImageIcon();
		label.setIcon(icon);
		jpanel.setVisible(true);
		label.setVisible(true);
	}

	// 线程开始
	public void start() {
		//以防万一，先把目录下的文件删除掉。
		/*ToDoFile tdf=new ToDoFile();
		tdf.deleteFiles();*/
		if (ko_Thread == null) {
			ko_Thread = new Thread(this);
			ko_Thread.start();//此时会调用run函数
			
			s.captureAudio();
			/*s.targetDataLine.stop();//【【【【【【】】】】新修改
			s.targetDataLine.close();*/
		}
//		
		
	}
	// 结束

	public void stop() {

		if (ko_Thread != null) {

			ko_Thread = null;

		}
		s.targetDataLine.stop();
		s.targetDataLine.close();
		
		/*if(s.thread!=null) {
			System.out.println("yinpinshinull");
			s.targetDataLine.stop();
			s.targetDataLine.close();
			try {
				s.stream.close();
			} catch (IOException e) {
				System.out.println("关闭流失败");
				e.printStackTrace();
			}
			s.thread=null;
			
		}*/
		
		//s.setStopflag(true);
	}
	
	//线程主要执行的方法。 执行

	@Override
	public void run() {
		//Thread thisThread = Thread.currentThread();
		while (ko_Thread != null) {//ko_Thread == thisThread【【【【【【】】】】
			
			if (flag == 0)
				snapShot();//拍照
			if (flag == 1) {
				/*System.out.println("hahhah");
				showname = "hello" + shownum + ".JPEG";
				if (shownum < serialNum)
					shownum++;
				repaint();// 重画
*/			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();//找到当前的事件是哪个按钮
		if (source == jb1) {
			// ImageIcon icon = new ImageIcon("hello1.JPEG");
			// label.setIcon(icon);
			// snapShot();
			flag = 0;// 录制标记
			start();
			Date d=new Date();
			System.out.println("开始时间："+d);
			start_time= System.currentTimeMillis();
			System.out.println("开始时间："+System.currentTimeMillis());
		}
		if (source == jb3) {
			stop();
			Date d=new Date();
			System.out.println("结束时间："+d);
			System.out.println("结束时间："+System.currentTimeMillis());
			stop_time=System.currentTimeMillis();
		}
		if (source == jb2) {
			stop();
		}
		if (source == jb4) {
			
			flag = 1;// 播放标记
			Combination c=new Combination();
			SoundersToOne one=new SoundersToOne();//one.Sound2One();
					
			try {
				//c.play();
				play();
				try {
					one.Sound2One();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//询问用户保存目录
				//pass
				//把1个音频和一个视频结合在一起。
				
				TurnToOne oneAvi=new TurnToOne();
				oneAvi.finallyOne();
				//删除之前所有形成的文件
				/*ToDoFile tdf=new ToDoFile();
				tdf.deleteFiles();*/
				//play();
				System.out.println("保存成功！");
				System.exit(0);
				
				
				//ko_Thread.stop();
			} catch (MovieSaveException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//start();

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
				
				/*Long l1=new Long(start_time);
				int lstart=l1.intValue();
				Long l2=new Long(stop_time);
				int lstop=l2.intValue();
				System.out.println("s:"+lstop);
				System.out.println("t:"+lstart);*/
				System.out.println("lla:"+sum*1000/(lll));
				System.out.println("sum:"+sum);
				//dmip.setFPS(sum*1000/lll); // 设置每秒帧数,最好和截图的速度一样。比较逼真
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
			// System.out.print("Save File "+name);
			// 将screenshot对象写入图像文件
			ImageIO.write(screenshot, imageFormat, f);
			// System.out.print("..Finished!\n");

//System.out.print(d.getWidth()+"        "+d.getHeight());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("结："+System.currentTimeMillis());
	}
}

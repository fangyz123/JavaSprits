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
	public static long start_time; //ִ�еĿ�ʼʱ��
	public static long stop_time;//ִ�еĽ���ʱ��
	public static int sum=0;//��ͼ�Ĵ�����Ϊ�˷������ϳɺ��֡��
	private String fileName; // �ļ���ǰ׺
	private String defaultName = "GuiCamera";
	static int serialNum = 0;
	private String imageFormat; // ͼ���ļ��ĸ�ʽ
	private String defaultImageFormat = "JPEG";
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	static String showname = null;
	static int shownum = 1;
	Thread ko_Thread;//�̣߳���������¼���Ŀ�ʼ��ֹ
	Sound s=new Sound();//����һ��ȫ�ֵ�¼���̣߳������Ժ��ܹ��ر���
	int flag;

	JButton jb1 = new JButton("��ʼ");
	JButton jb2 = new JButton("��ͣ"); 
	JButton jb3 = new JButton("ֹͣ");
	JButton jb4 = new JButton("����¼��");
	JButton jb5 = new JButton("ѡ��");
	JPanel jpanel = new JPanel();//һ��������
	JLabel label = new JLabel();//һЩ���

	public void paint(Graphics g) {//����
		if (showname != null) {
			Image image = getToolkit().getImage(showname);// ����һ����Ա����
			g.drawImage(image, 0, 0, 1440, 860, this);
		}
	}

	public GuiCamera() throws HeadlessException {
		fileName = defaultName;
		imageFormat = defaultImageFormat;
	}
//���캯��
	public GuiCamera(String s, String format) {//���ͼƬ��·���͸�ʽ
		super("��ӭʹ��java�����Ļ¼�����");
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
				JFrame jframe = new youFrame(); // �������Ǹ�jframe
				jframe.getPanel1().setVisible(false); // ���jframe����ĵ�һ����壬����������
				jframe.getPane2().setVisible(true); // ���jframe ����ڶ�����壬������ʾ.
				Combination c = new Combination();
				c.play();
				// һ������ getPane() ������Ϊ ����jframe ���棬����������ṩ��getter ������
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

	// �߳̿�ʼ
	public void start() {
		//�Է���һ���Ȱ�Ŀ¼�µ��ļ�ɾ������
		/*ToDoFile tdf=new ToDoFile();
		tdf.deleteFiles();*/
		if (ko_Thread == null) {
			ko_Thread = new Thread(this);
			ko_Thread.start();//��ʱ�����run����
			
			s.captureAudio();
			/*s.targetDataLine.stop();//�����������������������޸�
			s.targetDataLine.close();*/
		}
//		
		
	}
	// ����

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
				System.out.println("�ر���ʧ��");
				e.printStackTrace();
			}
			s.thread=null;
			
		}*/
		
		//s.setStopflag(true);
	}
	
	//�߳���Ҫִ�еķ����� ִ��

	@Override
	public void run() {
		//Thread thisThread = Thread.currentThread();
		while (ko_Thread != null) {//ko_Thread == thisThread��������������������
			
			if (flag == 0)
				snapShot();//����
			if (flag == 1) {
				/*System.out.println("hahhah");
				showname = "hello" + shownum + ".JPEG";
				if (shownum < serialNum)
					shownum++;
				repaint();// �ػ�
*/			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();//�ҵ���ǰ���¼����ĸ���ť
		if (source == jb1) {
			// ImageIcon icon = new ImageIcon("hello1.JPEG");
			// label.setIcon(icon);
			// snapShot();
			flag = 0;// ¼�Ʊ��
			start();
			Date d=new Date();
			System.out.println("��ʼʱ�䣺"+d);
			start_time= System.currentTimeMillis();
			System.out.println("��ʼʱ�䣺"+System.currentTimeMillis());
		}
		if (source == jb3) {
			stop();
			Date d=new Date();
			System.out.println("����ʱ�䣺"+d);
			System.out.println("����ʱ�䣺"+System.currentTimeMillis());
			stop_time=System.currentTimeMillis();
		}
		if (source == jb2) {
			stop();
		}
		if (source == jb4) {
			
			flag = 1;// ���ű��
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
				//ѯ���û�����Ŀ¼
				//pass
				//��1����Ƶ��һ����Ƶ�����һ��
				
				TurnToOne oneAvi=new TurnToOne();
				oneAvi.finallyOne();
				//ɾ��֮ǰ�����γɵ��ļ�
				/*ToDoFile tdf=new ToDoFile();
				tdf.deleteFiles();*/
				//play();
				System.out.println("����ɹ���");
				System.exit(0);
				
				
				//ko_Thread.stop();
			} catch (MovieSaveException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//start();

		}

	}
	
	
	
	
	
//ת������Ƶ
	public static void play() throws MovieSaveException {
		// jpgsĿ¼����jpgͼƬ,ͼƬ�ļ���Ϊ(1.jpg,2.jpg...)
		String relativelyPath=System.getProperty("user.dir");
		 String  filePath  =  relativelyPath+"//picture//";		
//		final File[] jpgs = new File("E:\\record\\").listFiles();//���е�ͼƬ
		 final File[] jpgs = new File(filePath).listFiles();//���е�ͼƬ
				// ���ļ�����������(��ʾ���ٶ��ļ����е�����ԽС,������Ƶ��֡��Խ��ǰ)
				Arrays.sort(jpgs, new Comparator<File>() {//����ӿ�
					@Override
					public int compare(File file1, File file2) {
						String numberName1 = file1.getName().replace(".jpeg", "");//�滻��ȥ����׺
						String numberName2 = file2.getName().replace(".jpeg", "");
						return new Integer(numberName1) - new Integer(numberName2);
					}
				});
				for(File f:jpgs) {
					System.out.println(f.getName());
				}
				DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("file:///"+relativelyPath+"/pictureToAVI/out1.avi");//���������ת��֮����ļ���
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
				//dmip.setFPS(sum*1000/lll); // ����ÿ��֡��,��úͽ�ͼ���ٶ�һ�����Ƚϱ���
				dmip.setFPS(4);
				dmip.setNumberOfFrames(jpgs.length); // ��֡��
				dmip.setMWidth(1440);//100
				dmip.setMHeight(860);//200

				new Jim2Mov(new ImageProvider() {
					public byte[] getImage(int frame) {
						try {
							// ����ѹ����
							return MovieUtils.convertImageToJPEG((jpgs[frame]), 1.0f);//1.0
						} catch (IOException e) {
							e.printStackTrace();
						}
						return null;
					}
				}, dmip, null).saveMovie(MovieInfoProvider.TYPE_QUICKTIME_JPEG);//TYPE_AVI_MJPEG
			}
	
	
	

//* ����Ļ��������
//* snapShot the Gui once
//****************************************************************/
	public void snapShot() {
		sum=sum+1;
System.out.println("����"+System.currentTimeMillis());
		try {
			// ������Ļ��һ��BufferedImage����screenshot
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(), (int) d.getHeight()));
			serialNum++;
			// �����ļ�ǰ׺�������ļ���ʽ�������Զ������ļ���
			String name = fileName + String.valueOf(serialNum) + "." + imageFormat;
			File f = new File(name);
			// System.out.print("Save File "+name);
			// ��screenshot����д��ͼ���ļ�
			ImageIO.write(screenshot, imageFormat, f);
			// System.out.print("..Finished!\n");

//System.out.print(d.getWidth()+"        "+d.getHeight());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("�᣺"+System.currentTimeMillis());
	}
}

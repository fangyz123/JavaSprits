package team.javaSpirit.teachingAssistantPlatform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public  class Sounder extends JFrame implements MouseListener {

	

	public Sounder(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Sounder(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Sounder(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		
		//创造一个实例
		Sounder mr = new Sounder();
			
		}
	
	
	
	//定义录音格式
		AudioFormat af = null;
		//定义目标数据行,可以从中读取音频数据,该 TargetDataLine 接口提供从目标数据行的缓冲区读取所捕获数据的方法。
		TargetDataLine td = null;
		//定义源数据行,源数据行是可以写入数据的数据行。它充当其混频器的源。应用程序将音频字节写入源数据行，这样可处理字节缓冲并将它们传递给混频器。
		SourceDataLine sd = null;
		//定义字节数组输入输出流
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		//定义音频输入流
		AudioInputStream ais = null;
		//定义停止录音的标志，来控制录音线程的运行
		Boolean stopflag = false;
		//记录开始录音的时间
		long startPlay;
		//设置一个播放的标志
		Boolean playflag;
		//每次保存的最后的文件名
		File tarFile = null;
		//定义音频波形每次显示的字节数
		int intBytes = 0;
		//定义每次录音的时候每次提取字节来画音频波
		byte audioDataBuffer[] = null;
		//定义所需要的组件
		JPanel jp1,jp2,jp3;
		JLabel jl1=null;
		JButton captureBtn;
		//设置画波形线程的终止的标志
		boolean flag = true;
		//定义播放录音时的一个计数值
		int cnt;
		//定义播放录音时一个缓冲数组
		byte btsPlay[] = null;
	 
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		Insets inset;
		GridBagConstraints c;
		
		
		//构造函数
		public Sounder()
		{
			//组件初始化
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
		
			//定义jp1的字体
			Font jpFont = new Font("华文新魏",Font.BOLD,40);
			jl1 = new JLabel("请留下您想说的话");
			jl1.setFont(jpFont);
			jl1.setForeground(Color.red);
			jp1.add(jl1);
			//定义按钮上面的字体
			Font btFont = new Font("华文新魏",Font.BOLD,40);
			captureBtn = new JButton("按住 说话");
			//setForeground可以设置按钮上面字体的颜色
			captureBtn.setForeground(Color.RED);
			captureBtn.setFont(btFont);
			//对开始录音按钮进行鼠标监听
			captureBtn.addMouseListener(this);
			
			
			this.add(jp1,BorderLayout.NORTH);
			this.add(jp2,BorderLayout.CENTER);
			this.add(jp3,BorderLayout.SOUTH);
			GridBagLayout gridbag = null;
			jp3.setLayout(gridbag = new GridBagLayout());
			gridx=1;
			gridy=2;
			gridwidth=1;
			gridheight=1;
			weightx=1;
			weighty=1;
			anchor=GridBagConstraints.CENTER;
			fill=GridBagConstraints.HORIZONTAL;
			inset=new Insets(1,1,1,1);
			ipadx=0;
			ipady=30;
			c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
					weightx, weighty, anchor, fill, inset, ipadx, ipady);
			gridbag.setConstraints(captureBtn, c);
			jp3.add(captureBtn);
	 
			//设置窗口的属性
			this.setSize(800,500);
			this.setTitle("录音机");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//设置窗口居中
			this.setLocationRelativeTo(null);
			//将窗口的边框去掉
			this.setUndecorated(true);
			this.setVisible(true);
			//设置窗口上的图标
			//Image img = this.getToolkit().getImage(getClass().getResource("/image/Recorder.jpg"));
			//this.setIconImage(img);
			//设置窗口在最前端显示
			this.setAlwaysOnTop(true);
		}
		
		public void mousePressed(MouseEvent e) {
			//当开始录音按钮被按下时就开始录音
			if(e.getSource().equals(captureBtn))
			{
		        //改变按钮上面的字的内容
		        captureBtn.setText("松开 结束");
				
		        //调用录音的方法
		        capture();
		        
		        //记录开始录音的时间
		        startPlay = System.currentTimeMillis();
			}
			
		}
	 
		public void mouseReleased(MouseEvent e) {
			//当松开录音按钮时停止录音并保存录音的文件
			if(e.getSource().equals(captureBtn))
			{
				//调用停止录音的方法
				stop();
				//当松开按钮后对显示波形的面板进行清空
				jp2.repaint();
				//改变按钮上面的字的内容
				captureBtn.setText("按住 说话");
				//调用保存录音的方法
				save();
				//将其放到指定的路径下
				//定义最终要存放的文件路径
				String destPath = "E:/AAA/";
				copyFile("E:/"+tarFile.getName(), destPath);
				
				System.exit(0);
			}
		}
		
		
		//开始录音
		public void capture()
		{
			try {
				//af为AudioFormat也就是音频格式
				af = getAudioFormat();
				DataLine.Info info = new DataLine.Info(TargetDataLine.class,af);
				td = (TargetDataLine)(AudioSystem.getLine(info));
				
				//打开具有指定格式的行，这样可使行获得所有所需的系统资源并变得可操作。
				td.open(af);
				//允许某一数据行执行数据 I/O
				td.start();
				
				//启动显示波形的进程
				RecordWave aw = new RecordWave();
				Thread t2 = new Thread(aw);
				t2.start();
				//把显示波形的进程标志设为true
				flag = true;
				
				Record record = new Record();
				Thread t1 = new Thread(record);
				t1.start();
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}
		}
		//停止录音
		public void stop()
		{
			stopflag = true;
			//将画波形的进程终止
			flag = false;
		}
		//保存录音
		public void save()
		{
			af = getAudioFormat();
	        byte audioData[] = baos.toByteArray();
	        bais = new ByteArrayInputStream(audioData);
	        ais = new AudioInputStream(bais,af, audioData.length / af.getFrameSize());
	        //定义最终保存的文件名
	        File file = null;
	        //写入文件
	        try {	
	        	//以当前的时间命名录音的名字
	        	//将录音的文件存放到F盘下语音文件夹下
	        	File filePath = new File("E:/recordyin");
	        	String tarPath = "E:/";
	        	if(!filePath.exists())
	        	{//如果文件不存在，则创建该目录
	        		filePath.mkdirs();
	        	}
	        	long time = System.currentTimeMillis();
	        	file = new File(filePath+"/"+time+".wav");      
	            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, file);
	            //将录音产生的wav文件转换为容量较小的mp3格式
	            //定义产生后文件名
	            tarFile = new File(tarPath+time+".mp3"); 
	            Runtime run = null;
	            //测试当前的路径
	            
	            try {
					run = Runtime.getRuntime();
					//调用编码器来将wav文件转换为mp3文件
	                //把编码得到的mp3文件先存放到D盘下，然后利用文件拷贝函数将它放到指定的文件夹下同时将D盘下的文件删除
					Process p=run.exec("cmd -c"+filePath+"\\"+"lame -b 16 "+filePath+"/"+file.getName()+" "+tarPath+tarFile.getName()); //16为码率，可自行修改
					//释放进程
					p.getOutputStream().close();
					p.getInputStream().close();
					p.getErrorStream().close();
					//等待
					p.waitFor();
	 
//					//删除之前保存的的wav文件
//					if(file.exists())
//					{
//						file.delete();
//					}
					
//					//定义最终要存放的文件路径
//					String destPath = "D:/Program Files/apache-tomcat-6.0.35/webapps/XWZ/tempFile/";
//					copyFile(tarPath+tarFile.getName(), destPath);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					//最后都要执行的语句
					//run调用lame解码器最后释放内存
					run.freeMemory();
				}
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	        	//关闭流
	        	try {
	        		
	        		if(bais != null)
	        		{
	        			bais.close();
	        		} 
	        		if(ais != null)
	        		{
	        			ais.close();		
	        		}
				} catch (Exception e) {
					e.printStackTrace();
				}   	
	        }
		}
		//文件拷贝方法
		public void copyFile(String srcPath , String destPath)
		{
			File srcFile = new File(srcPath);
			//如果目的文件夹没有则创建目的文件夹
			(new File(destPath)).mkdirs();
			//在目的文件夹下创建要复制的文件
			File destFile = new File(destPath+"/"+srcFile.getName());
			if(srcFile.isFile() && srcFile.exists())
			{
				InputStream in = null;
				OutputStream out = null;
				try {
					in = new FileInputStream(srcFile);
					out = new FileOutputStream(destFile);
					//设置缓冲数组
					byte[] buff = new byte[1024*5];   
			        int len = 0;   
			        while ((len = in.read(buff)) != -1) 
			        {   
			            out.write(buff, 0, len);   
			        }
//			        //测试该函数是否执行
//			        System.out.println("ok1");
			         
				} catch(Exception e) {
					e.printStackTrace();
				}finally{
					//关闭流，先开的后关闭
					try {
						if(out != null)
						{
							out.close(); 
						}
						if(in != null)
						{
							in.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			//复制过后删除源文件夹中的的文件
			if(srcFile.exists())
			{
				srcFile.delete();
			}
		}
		//设置AudioFormat的参数
		public AudioFormat getAudioFormat() 
		{
			//下面注释部分是另外一种音频格式，两者都可以
			AudioFormat.Encoding encoding = AudioFormat.Encoding.
	        PCM_SIGNED ;
			float rate = 8000f;
			int sampleSize = 16;
			String signedString = "signed";
			boolean bigEndian = true;
			int channels = 1;
			return new AudioFormat(encoding, rate, sampleSize, channels,
					(sampleSize / 8) * channels, rate, bigEndian);
//			//采样率是每秒播放和录制的样本数
//			float sampleRate = 16000.0F;
//			// 采样率8000,11025,16000,22050,44100
//			//sampleSizeInBits表示每个具有此格式的声音样本中的位数
//			int sampleSizeInBits = 16;
//			// 8,16
//			int channels = 1;
//			// 单声道为1，立体声为2
//			boolean signed = true;
//			// true,false
//			boolean bigEndian = true;
//			// true,false
//			return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,bigEndian);
		}
		//录音类，因为要用到MyRecord类中的变量，所以将其做成内部类
		class Record implements Runnable
		{
			//定义存放录音的字节数组,作为缓冲区
			byte bts[] = new byte[10000];
			//将字节数组包装到流里，最终存入到baos中
			//重写run函数
			public void run() {	
				baos = new ByteArrayOutputStream();		
				try {
					stopflag = false;
					while(stopflag != true)
					{
						//当停止录音没按下时，该线程一直执行	
						//从数据行的输入缓冲区读取音频数据。
						//要读取bts.length长度的字节,cnt 是实际读取的字节数
						int cnt = td.read(bts, 0, bts.length);
						if(cnt > 0)
						{
							baos.write(bts, 0, cnt);
						}
						
						//开始从音频流中读取字节数
						byte copyBts[] = bts;
						bais = new ByteArrayInputStream(copyBts);
						ais = new AudioInputStream(bais, af, copyBts.length/af.getFrameSize());
						try{
							DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, af);
				            sd = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
				            sd.open(af);
				            sd.start();
				            
				            //从音频流中读取
				            int Buffer_Size = 10000;
				            audioDataBuffer = new byte[Buffer_Size];
				            int outBytes;
				       
							intBytes = ais.read(audioDataBuffer, 0,audioDataBuffer.length);
							
//							不写到混频器中这样就不会播放
//							if (intBytes >= 0) {
//								outBytes = sd.write(audioDataBuffer, 0,audioDataBuffer.length);
//							}   
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						//intBytes = -1;
						//关闭打开的字节数组流
						if(baos != null)
						{
							baos.close();
						}	
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						//下面这句td.drain()不能要，这样如果不播放数据就阻塞再次录音会出现其他程序访问错误
						//td.drain();
						td.close();
						//刷新显示波形的面板
						jp2.repaint();
					}
				}
			}
			
		}
		
		//画波形的类
		//因为要使用一些主函数中的数据，所以做成内部类
		class RecordWave extends JPanel implements Runnable
		{
			//用画笔画出波形
			public void paint(Graphics g)
			{
				super.paint(g);
				g.fillRect(jp2.getX(),jp2.getY() , 800, 380);
				if( audioDataBuffer != null)
				{
					g.drawLine(jp2.getWidth() / 256, 700, jp2.getWidth() / 256, 700);
					
					for(int i=0; i<audioDataBuffer.length-1; ++i)
					{
						g.setColor(Color.RED);
						g.drawLine(i * jp2.getWidth() / 256, (int)audioDataBuffer[i]+200 , (i + 1)
	 
								* jp2.getWidth() / 256, (int)audioDataBuffer[i+1]+200);
					}
				}
			}
			public void run() 
			{
				//刷新波形
				while(true)
				{
					//System.out.println("ok");
					try {
						synchronized (this) {
							//隔多长时间获取
							Thread.sleep(300);
						}
					} catch (Exception e) {
	 
						e.printStackTrace();
					}
					this.paint(jp2.getGraphics());
					//终止线程
					if(flag == false)
					{
						break;
					}
				}
			}	
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
}

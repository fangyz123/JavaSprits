package team.javaspirit.remoteControl.operation.service;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

/**
 * 
* <p>Title: CaptureThread</p>
* <p>Description:��ͼ������ͼƬ���߳� </p>
* @author �λ�ϼ
* @date 2018��11��24��
 */
public class CaptureThread extends Thread {
	private DataOutputStream dataOutputStream;
	private Socket socket;
	private Toolkit tk ;
	private  Dimension dm ;
	private Rectangle rec;
	private  Robot robot ;
	public CaptureThread(DataOutputStream dataOutputStream,Socket socket) throws AWTException {
		this.dataOutputStream = dataOutputStream;
		this.socket=socket;
		tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		//������Ļ�趨ͼƬ�Ĵ�С
		rec = new Rectangle(0, 0, (int)dm.getWidth(), (int)dm.getHeight());
		robot  = new Robot();//����������˳�ʼ������������new�ˡ�ǰ�浰����Բ�ֱ��new��
		//�ڹ��캯����new  ���ǹ��캯����û��new
	}
	
	/**
	 * 
	 * <p>Title: createCature</p>
	 * <p>Description:��Ҫ���ڽ�ͼ����ȡ��ǰ��Ļ��ͼ����Ҫʹ����robot����ࡣ�ѽ�ȡ��ͼƬ
	 * ת�����ֽ���������������������ֽ�����д��������д��䵽��ʦ�ˣ�չʾѧ���˵���Ļ </p>
	 * @return
	 */
	private byte[] createCature() {
		//���һ����Ļ�Ľ�ͼ
		BufferedImage bimage = robot.createScreenCapture(rec);
		////����һ���ڴ���
		ByteArrayOutputStream byout = new ByteArrayOutputStream();
		try {
			//��ͼƬ����д���ڴ�����
			ImageIO.write(bimage, "png", byout);
		} catch (IOException e) {
			System.out.println("����ͼƬд���ڴ����г����쳣");
			try {
				dataOutputStream.close();
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return byout.toByteArray();
	}
	
	/**
	 * �����̵߳����麯����������û�йرյ�ʱ��ÿ��100������н�ͼ��Ȼ���ͼд�뵽�������
	 * ���С�������ܻ����쳣��Ϊ�˷������Ϳͻ���һ���ȹر�����һֱ������catch�йر����ӡ�
	 */
	@Override
	public void run() {
		while(!socket.isClosed()){
			//��ý�ͼ���ֽ�����
			byte[] data = createCature();
			try {
				dataOutputStream.writeInt(data.length);
				dataOutputStream.write(data);
				dataOutputStream.flush();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//1000/20
				
			} catch (IOException e) {
				try {
					dataOutputStream.close();
					socket.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				System.out.println("����������,����ʧ��");
			}
			
		}
	}
	

}

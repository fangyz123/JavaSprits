package team.javaspirit.remoteControl.operation.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import team.javaspirit.remoteControl.ui.MyJframe;

/**
 * 
 * <p>
 * Title: ShowImageThread
 * </p>
 * <p>
 * Description:չʾѧ���˴��͹����Ľ�ͼ���̣߳���չ����jframe�ϡ�
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��12��4��
 */
public class ShowImageThread extends Thread {

	private DataInputStream ins;// ������
	private ServerSocket serverSocket;
	private MyJframe jf;

	ShowImageThread(DataInputStream ins, ServerSocket serverSocket, MyJframe jf) {
		this.ins = ins;
		this.serverSocket = serverSocket;
		this.jf = jf;
	}

	@Override
	public void run() {
		while (!serverSocket.isClosed()) {
			int len = 0;
			try {
				len = ins.readInt();

				byte[] data = new byte[len];// ����һ���յ��ֽ�����
				ins.readFully(data);// �Ѷ�ȡ�����ݴ洢��data������
				// ����������������Ϊһ��ͼ�����
				// ImageIcon ic=new ImageIcon(data);
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				BufferedImage image = ImageIO.read(in);
				// �ŵ�������.�ӵ���ǩ��
				jf.setImgLabel(image);
			} catch (IOException e) {
				System.out.println("ѧ���˶Ͽ�����");
				try {
					ins.close();
					serverSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			} // ͼƬ����
		}
	}

}

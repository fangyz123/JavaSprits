package add;

import java.io.IOException;

import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;

public class FirstInvoke {
	public static void firstInvoke() throws Exception, InterruptedException, IOException {
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		grabber.setImageHeight(720);
		grabber.setImageWidth(720);
		grabber.start();
		boolean c = true;
		// ��ʼ��ȡ����ͷ����
		CanvasFrame canvas = new CanvasFrame("����ͷ");// �½�һ������
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("��ȡ����ͷ�ɹ�");
		System.out.println("�������");
		while (true) {
			if (!canvas.isDisplayable()) {
				grabber.stop();// ֹͣץȡ
				System.exit(2);// �˳�
			}
			Frame frame = grabber.grab();
			canvas.showImage(frame);// ��ȡ����ͷͼ�񲢷ŵ���������ʾ��frame��һ֡��Ƶͼ��
			ToIplImage ti = new ToIplImage();
			Mat src = ti.convertToMat(frame);
			FirstDetection.faceDetection(src);
			if((FirstDetection.faceDetection(src)==0)&&c) {
				c=false;
				FirstRecord.recordCamera(grabber,canvas);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
			canvas.setAlwaysOnTop(true);
			Thread.sleep(50);// 50����ˢ��һ��ͼ��
		}
	}
}

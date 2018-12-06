package Demo;

import java.io.IOException;

import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;
import org.bytedeco.javacv.OpenCVFrameGrabber;

/**
 * <p>
 * Title: JcvTest
 * </p>
 * <p>
 * Description:�����´��ڻ�ȡ����ͷ���ݣ���һ��ͼ���ʽ������������⺯��
 * </p>
 * 
 * @author ������
 * @date 2018��11��19��
 */
public class JcvTest {
	public static void captureFace() throws Exception, InterruptedException, IOException {
		/**
		 * <p>
		 * Title:initTrain
		 * </p>
		 * <p>
		 * Description:
		 * ����opencv�࣬ newһ������ͷ�Ķ��� OpenCVFrameGrabber(0);
		 * newһ�����ڣ�ȡ��Ϊ������ͷ��
		 * ������ͷ�ر�ʱ���˳�����
		 * ��һ��������ͼ�����ͳһ��С
		 * ������ͷ�ڵ�������Ϣ����ΪMAt���󣬷����Ժ����ҶȻ��;���ֱ��ͼ����
		 * ��������ɹ��󣬽�������ʶ����򣬵����ص�ֵ��Ϊ-1����ʶ�������ɹ������������ڱ��ػ����ݿ�
		 * </p>
		 */
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
			ToIplImage ti = new ToIplImage();
			Mat src = ti.convertToMat(frame);
			boolean bool=true;
			faceDetection.faceDetection(src,bool);
			canvas.showImage(frame);// ��ȡ����ͷͼ�񲢷ŵ���������ʾ��frame��һ֡��Ƶͼ��
			
			if (faceDetection.faceDetection(src,bool)!=-1&&c) {
				c=false;
				recordCamera.recordCamera(grabber,canvas);
			}
			canvas.setAlwaysOnTop(true);
			Thread.sleep(50);// 50����ˢ��һ��ͼ��
		}
	}

}

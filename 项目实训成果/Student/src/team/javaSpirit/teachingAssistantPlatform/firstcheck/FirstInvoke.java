package team.javaSpirit.teachingAssistantPlatform.firstcheck;

import java.io.IOException;

import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class FirstInvoke {
	public static String firstInvoke() throws Exception, InterruptedException, IOException {
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		grabber.setImageHeight(720);
		grabber.setImageWidth(720);
		grabber.start();
		boolean c = true;
		// 开始获取摄像头数据
		CanvasFrame canvas = new CanvasFrame("正在签到");// 新建一个窗口
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String imagesrc = null;
		while (true) {
			Frame frame = grabber.grab();
			ToIplImage ti = new ToIplImage();
			Mat src = ti.convertToMat(frame);
			FirstDetection.faceDetection(src);
			canvas.showImage(frame);
			if(/*(FirstDetection.faceDetection(src)!=-1)&&*/c) {
				c=false;
				imagesrc = FirstRecord.recordCamera(grabber,canvas);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				canvas.dispose();
			}
			if (!canvas.isDisplayable()) {
				grabber.stop();// 停止抓取
				break;
			}
			canvas.setAlwaysOnTop(true);
			Thread.sleep(50);// 50毫秒刷新一次图像
		}
		return imagesrc;
	}
}

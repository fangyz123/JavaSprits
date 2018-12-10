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
		// 开始获取摄像头数据
		CanvasFrame canvas = new CanvasFrame("摄像头");// 新建一个窗口
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("获取摄像头成功");
		System.out.println("检测人脸");
		while (true) {
			if (!canvas.isDisplayable()) {
				grabber.stop();// 停止抓取
				System.exit(2);// 退出
			}
			Frame frame = grabber.grab();
			canvas.showImage(frame);// 获取摄像头图像并放到窗口上显示，frame是一帧视频图像
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
			Thread.sleep(50);// 50毫秒刷新一次图像
		}
	}
}

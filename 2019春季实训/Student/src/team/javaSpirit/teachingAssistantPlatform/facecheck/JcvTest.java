package team.javaSpirit.teachingAssistantPlatform.facecheck;

import java.io.IOException;

import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;

import team.javaSpirit.teachingAssistantPlatform.facematch.FaceMatch;
import team.javaSpirit.teachingAssistantPlatform.firstcheck.FirstRecord;

import org.bytedeco.javacv.OpenCVFrameGrabber;

/**
 * <p>
 * Title: JcvTest
 * </p>
 * <p>
 * Description:创建新窗口获取摄像头数据，归一化图像格式，调用人脸检测函数
 * </p>
 * 
 * @author 郭程媛
 * @date 2018年11月19日
 */
public class JcvTest {
	public static String captureFace() throws Exception, InterruptedException, IOException {
		/**
		 * <p>
		 * Title:initTrain
		 * </p>
		 * <p>
		 * Description:
		 * 加载opencv类， new一个摄像头的对象 OpenCVFrameGrabber(0);
		 * new一个窗口，取名为“摄像头”
		 * 当摄像头关闭时，退出程序
		 * 归一化处理，将图像处理成统一大小
		 * 将摄像头内的人像信息处理为MAt矩阵，方便以后做灰度化和均衡直方图处理
		 * 检测人脸成功后，进入人脸识别程序，当返回的值不为-1，即识别人脸成功，存入人像在本地或数据库
		 * </p>
		 */
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		grabber.setImageHeight(720);
		grabber.setImageWidth(720);
		grabber.start();
		boolean c = true;
		// 开始获取摄像头数据
		CanvasFrame canvas = new CanvasFrame("摄像头");// 新建一个窗口
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String imagesrc = null;
		while (true) {
			Frame frame = grabber.grab();
			ToIplImage ti = new ToIplImage();
			Mat src = ti.convertToMat(frame);
			boolean bool=true;
			FaceDetection.faceDetection(src,bool);
			canvas.showImage(frame);// 获取摄像头图像并放到窗口上显示，frame是一帧视频图像
			if (c) {
				c=false;
				imagesrc = recordCamera.recordCamera(grabber,canvas);
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

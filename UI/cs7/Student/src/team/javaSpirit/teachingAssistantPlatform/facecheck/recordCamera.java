package team.javaSpirit.teachingAssistantPlatform.facecheck;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.helper.opencv_objdetect;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;

/**
 * <p>
 * Title:recordCamera
 * </p>
 * <p>
 * 接受grabber，canvas参数 开启摄像头，保存图片
 * </p>
 * 
 * @author 郭程媛
 * @date 2018年12月5日
 *
 */
public class recordCamera {
	public static void recordCamera(FrameGrabber grabber, CanvasFrame canvas) throws Exception {
		/**
		 * <p>
		 * Title:initTrain
		 * </p>
		 * <p>
		 * Description:加载opencv类， new一个转换器OpenCVFrameConverter.ToIplImage(); IplImage
		 * grabbedImage = converter.convert(grabber.grab()); 抓取一帧视频并将其转换为图像，用于人脸识别的检测
		 * opencv_imgcodecs.imwrite()将符合逻辑要求的图像存入本地或数据库
		 * </p>
		 */
		Loader.load(opencv_objdetect.class);
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// 转换器
		IplImage grabbedImage = converter.convert(grabber.grab());
		// 抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile,
		// width,height);
		opencv_imgcodecs.imwrite("faceimg\\1-hello.jpg", mat);
		System.out.println("照片保存成功");
		System.exit(0);
		// recorder.start();//开启录制器
		Frame rotatedFrame = converter.convert(grabbedImage);// 不知道为什么这里不做转换就不能推到rtmp
		while (canvas.isVisible() && (grabbedImage = converter.convert(grabber.grab())) != null) {
			rotatedFrame = converter.convert(grabbedImage);
			canvas.showImage(rotatedFrame);
			if (startTime == 0) {
				startTime = System.currentTimeMillis();
			}

		}
	}
}

package team.javaSpirit.teachingAssistantPlatform.firstcheck;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.helper.opencv_objdetect;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;

public class FirstRecord {
	public static boolean recordCamera(FrameGrabber grabber, CanvasFrame canvas) throws Exception, InterruptedException {
		Loader.load(opencv_objdetect.class);
		boolean bool=false;
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// 转换器
		IplImage grabbedImage = converter.convert(grabber.grab());
		// 抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile,
		// width,height);
		opencv_imgcodecs.imwrite("..\\faceimg\\1-hello.jpg", mat);
		bool=true;
		System.out.println("照片保存成功");
		return bool;
	}
}

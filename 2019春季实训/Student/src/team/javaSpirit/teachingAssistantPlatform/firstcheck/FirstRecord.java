package team.javaSpirit.teachingAssistantPlatform.firstcheck;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.helper.opencv_objdetect;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;

public class FirstRecord {
	public static String recordCamera(FrameGrabber grabber, CanvasFrame canvas) throws Exception, InterruptedException {
		Loader.load(opencv_objdetect.class);
		boolean bool = false;
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// 转换器
		IplImage grabbedImage = converter.convert(grabber.grab());
		// 抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile,
		// width,height);
		String sid = Constant.myStudent.getSid();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		String d = dateFormat.format(date);
		//String src = "faceimg\\" + d + "-" + sid + ".jpg";
		String src = "faceimg\\" + sid + ".jpg";
		opencv_imgcodecs.imwrite(src, mat);
		bool = true;
		return src;
	}
}

package camera;


import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.helper.opencv_objdetect;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;

public class RecordCamera {
	public static void recordCamera(FrameGrabber grabber,/*String outputFile, double frameRate, */CanvasFrame canvas)// 截取第一张照片在屏幕上
			throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
		Loader.load(opencv_objdetect.class);
		grabber.start();// 开启抓取器

		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// 转换器
		IplImage grabbedImage = converter.convert(grabber.grab());
		// 抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile, width,height);
		opencv_imgcodecs.imwrite("E:\\test\\hello2.jpg", mat);
		System.out.println("照片保存成功");
		// recorder.start();//开启录制器
		Frame rotatedFrame = converter.convert(grabbedImage);// 不知道为什么这里不做转换就不能推到rtmp
		while (canvas.isVisible() && (grabbedImage = converter.convert(grabber.grab())) != null) {
			rotatedFrame = converter.convert(grabbedImage);
			canvas.showImage(rotatedFrame);
			if (startTime == 0) {
				startTime = System.currentTimeMillis();
			}

		}
		canvas.dispose();
		grabber.stop();
	}
}

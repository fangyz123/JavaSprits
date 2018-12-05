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
	public static void recordCamera(FrameGrabber grabber,/*String outputFile, double frameRate, */CanvasFrame canvas)// ��ȡ��һ����Ƭ����Ļ��
			throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
		Loader.load(opencv_objdetect.class);
		grabber.start();// ����ץȡ��

		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// ת����
		IplImage grabbedImage = converter.convert(grabber.grab());
		// ץȡһ֡��Ƶ������ת��Ϊͼ�����������ͼ��������ʲô����ˮӡ������ʶ��ȵ��������
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile, width,height);
		opencv_imgcodecs.imwrite("E:\\test\\hello2.jpg", mat);
		System.out.println("��Ƭ����ɹ�");
		// recorder.start();//����¼����
		Frame rotatedFrame = converter.convert(grabbedImage);// ��֪��Ϊʲô���ﲻ��ת���Ͳ����Ƶ�rtmp
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

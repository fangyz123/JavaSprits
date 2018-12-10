package add;

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
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// ת����
		IplImage grabbedImage = converter.convert(grabber.grab());
		// ץȡһ֡��Ƶ������ת��Ϊͼ�����������ͼ��������ʲô����ˮӡ������ʶ��ȵ��������
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile,
		// width,height);
		opencv_imgcodecs.imwrite("E:\\test\\1-hello.jpg", mat);
		bool=true;
		System.out.println("��Ƭ����ɹ�");
		return bool;
	}
}

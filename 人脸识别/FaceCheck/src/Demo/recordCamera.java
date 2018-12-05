package Demo;

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
 * ����grabber��canvas����
 * ��������ͷ������ͼƬ
 * </p>
 * 
 * @author ������
 * @date 2018��12��5��
 *
 */
public class recordCamera {
	public static void recordCamera(FrameGrabber grabber, CanvasFrame canvas) throws Exception {
		/**
		 * <p>
		 * Title:initTrain
		 * </p>
		 * <p>
		 * Description:����opencv�࣬ newһ��ת����OpenCVFrameConverter.ToIplImage(); 
		 * IplImage grabbedImage = converter.convert(grabber.grab()); ץȡһ֡��Ƶ������ת��Ϊͼ����������ʶ��ļ��
		 * opencv_imgcodecs.imwrite()�������߼�Ҫ���ͼ����뱾�ػ����ݿ�
		 * </p>
		 */
		Loader.load(opencv_objdetect.class);
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();// ת����
		IplImage grabbedImage = converter.convert(grabber.grab());
		// ץȡһ֡��Ƶ������ת��Ϊͼ�����������ͼ��������ʲô����ˮӡ������ʶ��ȵ��������
		long startTime = 0;
		Mat mat = converter.convertToMat(grabber.grabFrame());
		// FrameRecorder recorder = FrameRecorder.createDefault(outputFile,
		// width,height);
		opencv_imgcodecs.imwrite("E:\\test\\1-hello.jpg", mat);
		System.out.println("��Ƭ����ɹ�");
		System.exit(0);
		// recorder.start();//����¼����
		Frame rotatedFrame = converter.convert(grabbedImage);// ��֪��Ϊʲô���ﲻ��ת���Ͳ����Ƶ�rtmp
		while (canvas.isVisible() && (grabbedImage = converter.convert(grabber.grab())) != null) {
			rotatedFrame = converter.convert(grabbedImage);
			canvas.showImage(rotatedFrame);
			if (startTime == 0) {
				startTime = System.currentTimeMillis();
			}

		}
	}
}

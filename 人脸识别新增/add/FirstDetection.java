package add;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;

public class FirstDetection {

	public static int faceDetection(org.bytedeco.javacpp.opencv_core.Mat src) {
		String filenameFaceCascade = "haarcascade_frontalface_alt.xml";
		String filenameEyesCascade = "haarcascade_eye.xml";

		// ���ط�����
		CascadeClassifier faceCascade = new CascadeClassifier();// ����������
		CascadeClassifier eyesCascade = new CascadeClassifier();// �۲�������

		faceCascade.load(filenameFaceCascade);
		eyesCascade.load(filenameEyesCascade);

		// �ҶȻ��������⻯ֱ��ͼ
		Mat frameGray = new Mat();
		opencv_imgproc.cvtColor(src, frameGray, opencv_imgproc.COLOR_BGR2GRAY);// �ҶȻ�����
		opencv_imgproc.equalizeHist(frameGray, frameGray);// ���⻯ֱ��ͼ

		// -- Detect faces
		RectVector faces = new RectVector();
		faceCascade.detectMultiScale(frameGray, faces);// ������������ý���������⣨�����ͼ������ľ��������飩
		// ��4�����--������������
		for (int i = 0; i < faces.size(); i++) {
			Rect face_i = faces.get(i);
			opencv_imgproc.rectangle(src, face_i, new Scalar(0, 255, 0, 2));
			return 0;
		}
		return -1;
	}
}

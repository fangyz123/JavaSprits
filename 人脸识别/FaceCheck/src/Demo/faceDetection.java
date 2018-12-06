package Demo;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;

/**
 * <p>
 * Title:FaceDetection
 * </p>
 * <p>
 * Description:���������
 * 
 * Detailed description��
 * ��CascadeClassifier����������ط���������Haar�㷨Ϊ������������������õ�haarcascade_frontalface_alt.xml
 * �������ۼ���õ�haarcascade_eye.xml���������������۲�����������Ҫ��ͼ�����Ԥ������Ϊ��ͨ������ͷ����ȡ������ͼƬ���ܹ��յ�
 * �ⲿ������Ӱ����Ҫ��ͼƬ���о��⻯��������ͼ��ֱ��ͼ�ԶԱȶȽ��е�����Ϊ�˼�Сͼ��ԭʼ�����������ں�������ʱ���������٣���Ϊͼ����
 * ��һ����Ҫ�Բ�ɫͼ���RGB�������������д��� ���󲿷ֵĲ�ɫͼ���ǲ���RGB��ɫģʽ������ͼ���ʱ��Ҫ�ֱ��RGB���ַ������д���ʵ
 * ����RGB�����ܷ�ӳͼ�����̬������ֻ�Ǵӹ�ѧ��ԭ���Ͻ�����ɫ�ĵ��䣬������Ҫ�ҶȻ�����ͼ��
 * ��javacv�лҶȻ�����ͼ����opencv_imgproc.cvtColor(@ByVal Mat arg0, @ByVal Mat arg1, int
 * arg2)�����⻯���� opencv_imgproc.equalizeHist(@ByVal Mat arg0, @ByVal Mat arg1)��
 * ������⣬new RectVector��ž��������飨һ��������Ӧһ�����������飩detectMultiScale(frameGray, faces)����
 * ��������ý���������⣨�����ͼ������ľ��������飩 rectangle����������⵽�������������ο�
 * </p>
 * 
 * @author �Ŷ�
 * 
 * @date 2018��12��4��
 */
public class faceDetection {
	public static int faceDetection(org.bytedeco.javacpp.opencv_core.Mat src, boolean bool) {
		/**
		 * <p>
		 * 	1.����opencv�Դ��������������ۼ�������
		 * 	2.ͼ��Ԥ�����ҶȻ��������⻯ֱ��ͼ
		 * 	3.detect face�������ʹ��detectMultiScale��������ʶ��
		 * 	4.���--������������ ,�������������
		 * 	Detailed description�� 
		 * 		��CascadeClassifier����������ط���������Haar����Ϊ������������������õ�haarcascade_frontalface_alt.xml
		 * 	�������ۼ���õ�haarcascade_eye.xml���������������۲�����������Ҫ��ͼ�����Ԥ������Ϊ��ͨ������ͷ����ȡ������ͼƬ���ܹ��յ�
		 * 	�ⲿ������Ӱ����Ҫ��ͼƬ���о��⻯��������ͼ��ֱ��ͼ�ԶԱȶȽ��е�����Ϊ�˼�Сͼ��ԭʼ�����������ں�������ʱ���������٣���Ϊͼ����
		 * 	��һ����Ҫ�Բ�ɫͼ���RGB�������������д��� ���󲿷ֵĲ�ɫͼ���ǲ���RGB��ɫģʽ������ͼ���ʱ��Ҫ�ֱ��RGB���ַ������д���ʵ
		 * 	����RGB�����ܷ�ӳͼ�����̬������ֻ�Ǵӹ�ѧ��ԭ���Ͻ�����ɫ�ĵ��䣬������Ҫ�ҶȻ�����ͼ����javacv�лҶȻ�����ͼ����opencv_imgproc.cvtColor(@ByVal Mat arg0, @ByVal Mat arg1, int arg2)�����⻯����
		 * 	opencv_imgproc.equalizeHist(@ByVal Mat arg0, @ByVal Mat arg1)��
		 * 		������⣬new RectVector��ž��������飨һ��������Ӧһ�����������飩detectMultiScale(frameGray, faces)����
		 * 	��������ý���������⣨�����ͼ������ľ��������飩
		 * 		rectangle����������⵽�������������ο�
		 * �������ɹ��󣬽��г�ʼѵ������������ʶ����faceRecognise();
		 * @param src ��Ҫ����һ��Mat���͵Ĳ���
		 * @return
		 */
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
		System.out.println("��Ǿ���");
		// ��4�����--������������
		for (int i = 0; i < faces.size(); i++) {
			Rect face_i = faces.get(i);
			opencv_imgproc.rectangle(src, face_i, new Scalar(0, 255, 0, 2));

			if (bool) {
				bool = false;
				faceRecognition.initTrain();// ������ʼѵ��
				int count = faceRecognition.faceRecognise(src);// ������ʶ��
				System.out.println("ʶ�����");
				return count;
			}

		}

		return -1;
	}
}

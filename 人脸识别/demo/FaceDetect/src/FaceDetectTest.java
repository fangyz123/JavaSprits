
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;



public class FaceDetectTest {

	/**
	 * �������
	 */
	public static Mat faceDetect(Mat src) {
		 // ��1�����ط����� 
		CascadeClassifier cascade = new CascadeClassifier("D:\\opencv\\opencv-3.4.1-vc14_vc15\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
		System.out.println("���ط�����");
//		boolean a = cascade.load(Constant.FACE_CASCADE_FILE);
//		System.out.println(a);
		 // ��2����ȡͼƬ���лҶȻ��������⻯ֱ��ͼ����ͼ����з���������,���·���ͼ����Ԫֵ,ʹһ���Ҷȷ�Χ����Ԫֵ������������ȣ� 
		
		System.out.println(src);
		Mat graysrc = new Mat();
		System.out.println(graysrc);
		org.bytedeco.javacpp.opencv_imgproc.cvtColor(src, graysrc, org.bytedeco.javacpp.opencv_imgproc.COLOR_BGRA2GRAY);// ����ͷ�ǲ�ɫͼ�������ȻҶȻ���
		System.out.println(graysrc);
		org.bytedeco.javacpp.opencv_imgproc.equalizeHist(graysrc, graysrc);// ���⻯ֱ��ͼ
		System.out.println(graysrc);
		 //	��3�����  
		RectVector faces = new RectVector();//��ž��������飨һ��������Ӧһ�����������飩
		System.out.println(4);
		cascade.detectMultiScale(graysrc, faces);//������������ý���������⣨�����ͼ������ľ��������飩
		cascade.close();
		//	��4�����--������������ 
		for (int i = 0; i < faces.size(); i++) {
			Rect face_i = faces.get(i);
			org.bytedeco.javacpp.opencv_imgproc.rectangle(src, face_i, new Scalar(0, 255, 0, 2));
		}
		return src;
	}
	
	public static void main(String[] args) {
		System.out.println(1);
		Mat src = opencv_imgcodecs.imread("D://head//dd.jpg");
		System.out.println(2);
		faceDetect(src);
		System.out.println(3);
		opencv_imgcodecs.imwrite("D://head//dd.jpg", src);
		

	}

}

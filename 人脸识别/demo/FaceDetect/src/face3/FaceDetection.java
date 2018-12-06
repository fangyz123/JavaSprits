package face3;

import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;

/**
 * <p>Title:FaceDetection</p>
 * <p>Description:���������
 * 	
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
 * 	
 * </p>
 * @author �Ŷ�
 * @author ������
 * @date 2018��12��4��
 */
public class FaceDetection {
/**
 * <p>
 * 	1.����opencv�Դ��������������ۼ�������
 * 	2.ͼ��Ԥ�����ҶȻ��������⻯ֱ��ͼ
 * 	3.detect face�������ʹ��detectMultiScale��������ʶ��
 * 	4.���--������������ ,���������ۼ��
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
 * </p>
 * @param src ��Ҫ����һ��Mat���͵Ĳ���
 * @return
 */
	public static Mat faceDetection(Mat src) {
		 String filenameFaceCascade = "D:\\opencv\\opencv-3.4.1-vc14_vc15\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml";
	     String filenameEyesCascade = "D:\\opencv\\opencv-3.4.1-vc14_vc15\\opencv\\sources\\data\\haarcascades\\haarcascade_eye.xml";
	    
	     //���ط�����
	     CascadeClassifier faceCascade = new CascadeClassifier();//����������
	     CascadeClassifier eyesCascade = new CascadeClassifier();//�۲�������
	     
	     faceCascade.load(filenameFaceCascade);
	     eyesCascade.load(filenameEyesCascade);
	     
	     //�ҶȻ��������⻯ֱ��ͼ
	     Mat frameGray = new Mat();
	     org.bytedeco.javacpp.opencv_imgproc.cvtColor(src, frameGray,org.bytedeco.javacpp.opencv_imgproc.COLOR_BGR2GRAY);//�ҶȻ�����
	     org.bytedeco.javacpp.opencv_imgproc.equalizeHist(frameGray, frameGray);//���⻯ֱ��ͼ
	     
	     // -- Detect faces
	     RectVector faces = new RectVector();
	     faceCascade.detectMultiScale(frameGray, faces);//������������ý���������⣨�����ͼ������ľ��������飩

//	 	��4�����--������������ ,���������ۼ��
			for (int i = 0; i < faces.size(); i++) {
				Rect face_i = faces.get(i);
				org.bytedeco.javacpp.opencv_imgproc.rectangle(src, face_i, new Scalar(0, 255, 0, 2));
				
				Mat faceROI = frameGray.clone();
				RectVector eyes = new RectVector();
				eyesCascade.detectMultiScale(faceROI, eyes);
				
				for(int j = 0;j<eyes.size();j++) {
					Rect eye_i = eyes.get(j);
					org.bytedeco.javacpp.opencv_imgproc.rectangle(src, eye_i, new Scalar(0, 255, 0, 2));
				}
				
			}
	     
			
			
			
//	        List<Rect> listOfFaces = faces.toList();
//	        for (Rect face : listOfFaces) {
////	            Point center = new Point(face.x + face.width / 2, face.y + face.height / 2);
////	            Imgproc.ellipse(frame, center, new Size(face.width / 2, face.height / 2), 0, 0, 360,
////	                    new Scalar(0, 0, 255));
//	        	Imgproc.rectangle(src,new Point(face.x+face.width,face.y + face.height ), new Point(face.x,face.y), new Scalar(0,0,255));
//	        	
//	            Mat faceROI = frameGray.submat(face);
//
//	            // -- In each face, detect eyes
//	            MatOfRect eyes = new MatOfRect();
//	            eyesCascade.detectMultiScale(faceROI, eyes);
//
//	            List<Rect> listOfEyes = eyes.toList();
////	            for (Rect eye : listOfEyes) {
////	                Point eyeCenter = new Point(face.x + eye.x + eye.width / 2, face.y + eye.y + eye.height / 2);
////	                int radius = (int) Math.round((eye.width + eye.height) * 0.25);
//	// //               Imgproc.circle(frame, eyeCenter, radius, new Scalar(255, 0, 0), 2);
////	                Imgproc.rectangle(frame, eyeCenter, new Scalar(255, 0, 0));
////	            }
//	        }
	        
//	        HighGui.imshow("Capture - Face detection", src );
	        return src;
	}
}

package face3;

import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;

/**
 * <p>Title:FaceDetection</p>
 * <p>Description:人脸检测类
 * 	
 * 	Detailed description： 
 * 		用CascadeClassifier这个类来加载分类器，以Haar算子为基础，进行人脸检测用到haarcascade_frontalface_alt.xml
 * 	进行人眼检测用到haarcascade_eye.xml，加载了脸部和眼部分类器。需要对图像进行预处理，因为是通过摄像头来获取的人脸图片，受光照等
 * 	外部条件的影响需要对图片进行均衡化处理，利用图像直方图对对比度进行调整。为了减小图像原始数据量，便于后续处理时计算量更少，因为图像处理
 * 	不一定需要对彩色图像的RGB三个分量都进行处理 ，大部分的彩色图像都是采用RGB颜色模式，处理图像的时候，要分别对RGB三种分量进行处理，实
 * 	际上RGB并不能反映图像的形态特征，只是从光学的原理上进行颜色的调配，所以需要灰度化处理图像。在javacv中灰度化处理图像用opencv_imgproc.cvtColor(@ByVal Mat arg0, @ByVal Mat arg1, int arg2)。均衡化处理
 * 	opencv_imgproc.equalizeHist(@ByVal Mat arg0, @ByVal Mat arg1)。
 * 		人脸检测，new RectVector存放矩形向量组（一个人脸对应一个矩形向量组）detectMultiScale(frameGray, faces)分类
 * 	器对象调用进行人脸检测（输入的图像，输出的矩形向量组）
 * 		rectangle用于在所检测到的人脸部画矩形框
 * 	
 * </p>
 * @author 张鼎
 * @author 郭程媛
 * @date 2018年12月4日
 */
public class FaceDetection {
/**
 * <p>
 * 	1.加载opencv自带的人脸检测和人眼检测分类器
 * 	2.图像预处理，灰度化处理，均衡化直方图
 * 	3.detect face检测人脸使用detectMultiScale函数进行识别
 * 	4.标记--在脸部画矩形 ,并进行人眼检测
 * 	Detailed description： 
 * 		用CascadeClassifier这个类来加载分类器，以Haar算子为基础，进行人脸检测用到haarcascade_frontalface_alt.xml
 * 	进行人眼检测用到haarcascade_eye.xml，加载了脸部和眼部分类器。需要对图像进行预处理，因为是通过摄像头来获取的人脸图片，受光照等
 * 	外部条件的影响需要对图片进行均衡化处理，利用图像直方图对对比度进行调整。为了减小图像原始数据量，便于后续处理时计算量更少，因为图像处理
 * 	不一定需要对彩色图像的RGB三个分量都进行处理 ，大部分的彩色图像都是采用RGB颜色模式，处理图像的时候，要分别对RGB三种分量进行处理，实
 * 	际上RGB并不能反映图像的形态特征，只是从光学的原理上进行颜色的调配，所以需要灰度化处理图像。在javacv中灰度化处理图像用opencv_imgproc.cvtColor(@ByVal Mat arg0, @ByVal Mat arg1, int arg2)。均衡化处理
 * 	opencv_imgproc.equalizeHist(@ByVal Mat arg0, @ByVal Mat arg1)。
 * 		人脸检测，new RectVector存放矩形向量组（一个人脸对应一个矩形向量组）detectMultiScale(frameGray, faces)分类
 * 	器对象调用进行人脸检测（输入的图像，输出的矩形向量组）
 * 		rectangle用于在所检测到的人脸部画矩形框
 * </p>
 * @param src 需要传递一个Mat类型的参数
 * @return
 */
	public static Mat faceDetection(Mat src) {
		 String filenameFaceCascade = "D:\\opencv\\opencv-3.4.1-vc14_vc15\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml";
	     String filenameEyesCascade = "D:\\opencv\\opencv-3.4.1-vc14_vc15\\opencv\\sources\\data\\haarcascades\\haarcascade_eye.xml";
	    
	     //加载分类器
	     CascadeClassifier faceCascade = new CascadeClassifier();//脸部分类器
	     CascadeClassifier eyesCascade = new CascadeClassifier();//眼部分类器
	     
	     faceCascade.load(filenameFaceCascade);
	     eyesCascade.load(filenameEyesCascade);
	     
	     //灰度化处理，均衡化直方图
	     Mat frameGray = new Mat();
	     org.bytedeco.javacpp.opencv_imgproc.cvtColor(src, frameGray,org.bytedeco.javacpp.opencv_imgproc.COLOR_BGR2GRAY);//灰度化处理
	     org.bytedeco.javacpp.opencv_imgproc.equalizeHist(frameGray, frameGray);//均衡化直方图
	     
	     // -- Detect faces
	     RectVector faces = new RectVector();
	     faceCascade.detectMultiScale(frameGray, faces);//分类器对象调用进行人脸检测（输入的图像，输出的矩形向量组）

//	 	【4】标记--在脸部画矩形 ,并进行人眼检测
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

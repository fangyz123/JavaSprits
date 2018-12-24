package team.javaSpirit.teachingAssistantPlatform.firstcheck;

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

		// 加载分类器
		CascadeClassifier faceCascade = new CascadeClassifier();// 脸部分类器
		CascadeClassifier eyesCascade = new CascadeClassifier();// 眼部分类器

		faceCascade.load(filenameFaceCascade);
		eyesCascade.load(filenameEyesCascade);

		// 灰度化处理，均衡化直方图
		Mat frameGray = new Mat();
		opencv_imgproc.cvtColor(src, frameGray, opencv_imgproc.COLOR_BGR2GRAY);// 灰度化处理
		opencv_imgproc.equalizeHist(frameGray, frameGray);// 均衡化直方图

		// -- Detect faces
		RectVector faces = new RectVector();
		faceCascade.detectMultiScale(frameGray, faces);// 分类器对象调用进行人脸检测（输入的图像，输出的矩形向量组）
		// 【4】标记--在脸部画矩形
		for (int i = 0; i < faces.size(); i++) {
			Rect face_i = faces.get(i);
			opencv_imgproc.rectangle(src, face_i, new Scalar(0, 255, 0, 2));
			return 0;
		}
		return -1;
	}
}

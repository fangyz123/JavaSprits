package team.javaSpirit.teachingAssistantPlatform.facecheck;

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
 * Description:人脸检测类
 * 
 * Detailed description：
 * 用CascadeClassifier这个类来加载分类器，以Haar算法为基础，进行人脸检测用到haarcascade_frontalface_alt.xml
 * 进行人眼检测用到haarcascade_eye.xml，加载了脸部和眼部分类器。需要对图像进行预处理，因为是通过摄像头来获取的人脸图片，受光照等
 * 外部条件的影响需要对图片进行均衡化处理，利用图像直方图对对比度进行调整。为了减小图像原始数据量，便于后续处理时计算量更少，因为图像处理
 * 不一定需要对彩色图像的RGB三个分量都进行处理 ，大部分的彩色图像都是采用RGB颜色模式，处理图像的时候，要分别对RGB三种分量进行处理，实
 * 际上RGB并不能反映图像的形态特征，只是从光学的原理上进行颜色的调配，所以需要灰度化处理图像。
 * 在javacv中灰度化处理图像用opencv_imgproc.cvtColor(@ByVal Mat arg0, @ByVal Mat arg1, int
 * arg2)。均衡化处理 opencv_imgproc.equalizeHist(@ByVal Mat arg0, @ByVal Mat arg1)。
 * 人脸检测，new RectVector存放矩形向量组（一个人脸对应一个矩形向量组）detectMultiScale(frameGray, faces)分类
 * 器对象调用进行人脸检测（输入的图像，输出的矩形向量组） rectangle用于在所检测到的人脸部画矩形框
 * </p>
 * 
 * @author 张鼎
 * 
 * @date 2018年12月4日
 */
public class FaceDetection {
	/**
	 * <p>
	 * 1.加载opencv自带的人脸检测和人眼检测分类器 2.图像预处理，灰度化处理，均衡化直方图 3.detect
	 * face检测人脸使用detectMultiScale函数进行识别 4.标记--在脸部画矩形 ,并进行人脸检测 Detailed description：
	 * 用CascadeClassifier这个类来加载分类器，以Haar算子为基础，进行人脸检测用到haarcascade_frontalface_alt.xml
	 * 进行人眼检测用到haarcascade_eye.xml，加载了脸部和眼部分类器。需要对图像进行预处理，因为是通过摄像头来获取的人脸图片，受光照等
	 * 外部条件的影响需要对图片进行均衡化处理，利用图像直方图对对比度进行调整。为了减小图像原始数据量，便于后续处理时计算量更少，因为图像处理
	 * 不一定需要对彩色图像的RGB三个分量都进行处理 ，大部分的彩色图像都是采用RGB颜色模式，处理图像的时候，要分别对RGB三种分量进行处理，实
	 * 际上RGB并不能反映图像的形态特征，只是从光学的原理上进行颜色的调配，所以需要灰度化处理图像。在javacv中灰度化处理图像用opencv_imgproc.cvtColor(@ByVal
	 * Mat arg0, @ByVal Mat arg1, int arg2)。均衡化处理 opencv_imgproc.equalizeHist(@ByVal
	 * Mat arg0, @ByVal Mat arg1)。 人脸检测，new
	 * RectVector存放矩形向量组（一个人脸对应一个矩形向量组）detectMultiScale(frameGray, faces)分类
	 * 器对象调用进行人脸检测（输入的图像，输出的矩形向量组） rectangle用于在所检测到的人脸部画矩形框
	 * 人脸检测成功后，进行初始训练，调用人脸识别函数faceRecognise();
	 * 
	 * @param src 需要传递一个Mat类型的参数
	 * @return
	 */
	public static int faceDetection(org.bytedeco.javacpp.opencv_core.Mat src, boolean bool) {
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

			if (bool) {
				bool = false;
				FaceRecognition.initTrain();// 人脸初始训练
				int count = FaceRecognition.faceRecognise(src);// 人脸的识别
				return count;
			}

		}

		return -1;
	}
}

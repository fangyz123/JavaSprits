
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;



public class FaceDetectTest {

	/**
	 * 人脸检测
	 */
	public static Mat faceDetect(Mat src) {
		 // 【1】加载分类器 
		CascadeClassifier cascade = new CascadeClassifier("D:\\opencv\\opencv-3.4.1-vc14_vc15\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
		System.out.println("加载分类器");
//		boolean a = cascade.load(Constant.FACE_CASCADE_FILE);
//		System.out.println(a);
		 // 【2】获取图片进行灰度化处理，均衡化直方图（对图像进行非线性拉伸,重新分配图像象元值,使一定灰度范围内象元值的数量大致相等） 
		
		System.out.println(src);
		Mat graysrc = new Mat();
		System.out.println(graysrc);
		org.bytedeco.javacpp.opencv_imgproc.cvtColor(src, graysrc, org.bytedeco.javacpp.opencv_imgproc.COLOR_BGRA2GRAY);// 摄像头是彩色图像，所以先灰度化下
		System.out.println(graysrc);
		org.bytedeco.javacpp.opencv_imgproc.equalizeHist(graysrc, graysrc);// 均衡化直方图
		System.out.println(graysrc);
		 //	【3】检测  
		RectVector faces = new RectVector();//存放矩形向量组（一个人脸对应一个矩形向量组）
		System.out.println(4);
		cascade.detectMultiScale(graysrc, faces);//分类器对象调用进行人脸检测（输入的图像，输出的矩形向量组）
		cascade.close();
		//	【4】标记--在脸部画矩形 
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

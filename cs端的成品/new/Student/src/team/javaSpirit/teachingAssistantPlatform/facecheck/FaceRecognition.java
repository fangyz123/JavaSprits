package team.javaSpirit.teachingAssistantPlatform.facecheck;

import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_RGB2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import org.bytedeco.javacpp.opencv_face.LBPHFaceRecognizer;

/**
 * <p>
 * Title:FaceRecognition
 * </p>
 * <p>
 * Description:人脸识别类 init初始训练 、人脸识别
 * </p>
 * 
 * @author 张鼎
 * @date 2018年12月5日
 *
 */
public class FaceRecognition {
	/**
	 * <p>Title:initTrain</p>
	 * <p>
	 * 	Description:人脸识别分类器训练
	 *  	LBPHFaceRecognizer.create()
	 *  	创建样本和标签向量MatVector images Mat labels加入样本和标签
	 *  	进行训练faceRecognizer.train(images,labels)
	 *  	保存训练的分类器faceRecognizer.save(face.xml);
	 *  Detail Description:
	 *  	new 一个图片过滤器只接受以".jpg",".pgm",".png"为后缀的图片
	 *  	将过滤的图片放入listFiles的集合，new 一个MatVetor images存放图片矩阵即人脸样本
	 *  	labelsBuf=labels.createBuffer 存放标签
	 *  	依次遍历imageFiles，将图片处理成矩阵放入到images里作为样本，即images.put(@Cast(value={"size_t"}) long arg0, Mat arg1)
	 * 		图片名称处理后获得标签label,放入标签池中即labelsBuf.put(int index, int i)
	 *  	LBPHFaceRecognizer.create()
	 *  	创建样本和标签向量MatVector images Mat labels加入样本和标签
	 *  	进行训练faceRecognizer.train(images,labels)
	 *  	保存训练的分类器faceRecognizer.save(face.xml);
	 * </p>
	 */
	public static void initTrain() {
		File root = new File("cameraImage");
		FilenameFilter imgFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
			}
		};
		File[] imageFiles = root.listFiles(imgFilter);
		MatVector images = new MatVector(imageFiles.length);
		Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
		IntBuffer labelsBuf = labels.createBuffer();

		int counter = 0;
		for (File image : imageFiles) {
			Mat img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
			int label = Integer.parseInt(image.getName().split("\\-")[3]);
			images.put(counter, img);
			labelsBuf.put(counter, label);
			counter++;
		}

		FaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();
		faceRecognizer.train(images, labels);
		faceRecognizer.save("e:\\test\\lbphfaces.xml");
		faceRecognizer.close();
	}

	/**
	 * <p>
	 * Title:FaceRecognise
	 * </p>
	 * <p>
	 * Description:
	 * 人脸识别用到LBPH算法，即创建以一个LBPHFaceRecognizer对象LBPHFaceRecognizer.create()
	 * 加载训练好的分类器faceReconizer.read(face.xml) new一个int类型的指针类和一个double类型的指针类
	 * new一个grayImage存放灰度化后的样本值 待识别图像预处理cvtColor 预测输入图像获取标签值label,confidence，进行预测
	 * </p>
	 */
	public static int faceRecognise(Mat testImage) {
		FaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();
		faceRecognizer.read("xmlCreate\\lbphfaces.xml");
		IntPointer label = new IntPointer(1);
		DoublePointer confidence = new DoublePointer(1);
		Mat grayImage = new Mat();
		cvtColor(testImage, grayImage, COLOR_RGB2GRAY);
		faceRecognizer.predict(grayImage, label, confidence);
		faceRecognizer.close();
		return label.get(0);
	}
}

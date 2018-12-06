package facerecognition;

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
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import org.bytedeco.javacpp.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;


/**
 * <p>Title:FaceRecognition</p>
 * <p>
 * 	Description:����ʶ����
 * 	init��ʼѵ�� ������ʶ��
 * </p>
 * @author �Ŷ�
 * @date 2018��12��5��
 *
 */

public class FaceRecognition {
	/**
	 * <p>Title:initTrain</p>
	 * <p>
	 * 	Description:����ʶ�������ѵ��
	 *  	������һ������ͼ���Сһ�¡��ҶȻ���ֱ��ͼ���⻯��
	 *  	LBPHFaceRecognizer.create()
	 *  	���������ͱ�ǩ����MatVector images Mat labels���������ͱ�ǩ
	 *  	����ѵ��faceRecognizer.train(images,labels)
	 *  	����ѵ���ķ�����faceRecognizer.save(face.xml);
	 *  Detail Description:
	 *  	new һ��ͼƬ������ֻ������".jpg",".pgm",".png"Ϊ��׺��ͼƬ
	 *  	�����˵�ͼƬ����listFiles�ļ��ϣ�new һ��MatVetor images���ͼƬ������������
	 *  	labelsBuf=labels.createBuffer ��ű�ǩ
	 *  	���α���imageFiles����ͼƬ����ɾ�����뵽images����Ϊ��������images.put(@Cast(value={"size_t"}) long arg0, Mat arg1)
	 * 		ͼƬ���ƴ�����ñ�ǩlabel,�����ǩ���м�labelsBuf.put(int index, int i)
	 * 		������һ������ͼ���Сһ�¡��ҶȻ���ֱ��ͼ���⻯��
	 *  	LBPHFaceRecognizer.create()
	 *  	���������ͱ�ǩ����MatVector images Mat labels���������ͱ�ǩ
	 *  	����ѵ��faceRecognizer.train(images,labels)
	 *  	����ѵ���ķ�����faceRecognizer.save(face.xml);
	 * </p>
	 */
	public static void initTrain() {
		File root = new File(Constant.FACE_IMAGE_PATH);
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
			int label = Integer.parseInt(image.getName().split("\\-")[0]);
			images.put(counter, img);
			labelsBuf.put(counter, label);
			counter++;
		}

		FaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();
		faceRecognizer.train(images, labels);
		faceRecognizer.save(Constant.FACE_MODEL_PATH);
		faceRecognizer.close();
	}
	/**
	 * <p>Title:FaceRecognise</p>
	 * <p>
	 * 	Description:
	 * 	����ʶ���õ�LBPH�㷨����������һ��LBPHFaceRecognizer����LBPHFaceRecognizer.create()
	 * 	����ѵ���õķ�����faceReconizer.read(face.xml)
	 *  newһ��int���͵�ָ�����һ��double���͵�ָ����
	 *  newһ��grayImage��ŻҶȻ��������ֵ
	 * 	��ʶ��ͼ��Ԥ����cvtColor
	 * 	Ԥ������ͼ���ȡ��ǩֵlabel,confidence������Ԥ��
	 * </p>
	 */
	public static int faceRecognise(Mat testImage) {
		FaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();
		faceRecognizer.read(Constant.FACE_MODEL_PATH);
		IntPointer label = new IntPointer(1);
		DoublePointer confidence = new DoublePointer(1);
		Mat grayImage = new Mat();
		cvtColor(testImage, grayImage, COLOR_RGB2GRAY);
		faceRecognizer.predict(grayImage, label, confidence);
		faceRecognizer.close();
		return label.get(0);
	}
}

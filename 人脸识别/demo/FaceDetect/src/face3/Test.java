package face3;

import java.awt.Frame;

import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.opencv.core.Mat;

import facerecognition.FaceRecognition;

public class Test {

	public static void main(String[] args) throws Exception, InterruptedException {
		 OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);    
		    try {
				grabber.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   //��ʼ��ȡ����ͷ����  
		    CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������  
		    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    canvas.setAlwaysOnTop(true);  
		    
		    boolean a = true;
		    
		    while(true)  
		    {  
		        if(!canvas.isDisplayable())  
		        {//�����Ƿ�ر�  
		            grabber.stop();//ֹͣץȡ  
		            System.exit(2);//�˳�  
		        }  
		        org.bytedeco.javacv.Frame frame = grabber.grab();
		        ToIplImage ti = new ToIplImage();
				org.bytedeco.javacpp.opencv_core.Mat src = ti.convertToMat(frame);
//		        opencv_imgcodecs.imwrite("D://head//tt.jpg", src);
				canvas.showImage(frame);//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����Frame frame=grabber.grab(); frame��һ֡��Ƶͼ��  
				FaceDetection faceDetection = new FaceDetection();
				faceDetection.faceDetection(src);//�������
				FaceRecognition faceRecognition = new FaceRecognition();
		        faceRecognition.initTrain();//������ʼѵ��
				int count = faceRecognition.faceRecognise(src);//������ʶ��
				if(count!=-1&&a) {
					a =false;
					System.out.println("---Ting");
					opencv_imgcodecs.imwrite("D://head//2-ww.jpg", src);
					if(a==false) {
						System.exit(0);
					}
//					break;
				}
				
		        Thread.sleep(100);//50����ˢ��һ��ͼ��  
		    }  
	}
}





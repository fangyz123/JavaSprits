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
			}   //开始获取摄像头数据  
		    CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口  
		    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    canvas.setAlwaysOnTop(true);  
		    
		    boolean a = true;
		    
		    while(true)  
		    {  
		        if(!canvas.isDisplayable())  
		        {//窗口是否关闭  
		            grabber.stop();//停止抓取  
		            System.exit(2);//退出  
		        }  
		        org.bytedeco.javacv.Frame frame = grabber.grab();
		        ToIplImage ti = new ToIplImage();
				org.bytedeco.javacpp.opencv_core.Mat src = ti.convertToMat(frame);
//		        opencv_imgcodecs.imwrite("D://head//tt.jpg", src);
				canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像  
				FaceDetection faceDetection = new FaceDetection();
				faceDetection.faceDetection(src);//人脸检测
				FaceRecognition faceRecognition = new FaceRecognition();
		        faceRecognition.initTrain();//人脸初始训练
				int count = faceRecognition.faceRecognise(src);//人脸的识别
				if(count!=-1&&a) {
					a =false;
					System.out.println("---Ting");
					opencv_imgcodecs.imwrite("D://head//2-ww.jpg", src);
					if(a==false) {
						System.exit(0);
					}
//					break;
				}
				
		        Thread.sleep(100);//50毫秒刷新一次图像  
		    }  
	}
}





package face;
import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Point;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;
import org.bytedeco.javacpp.opencv_videoio.VideoCapture;
import org.bytedeco.javacpp.opencv_imgcodecs;



class ObjectDetection {
    public void detectAndDisplay(Mat frame, CascadeClassifier faceCascade, CascadeClassifier eyesCascade) {
        Mat frameGray = new Mat();
        org.bytedeco.javacpp.opencv_imgproc.cvtColor(frame, frameGray, org.bytedeco.javacpp.opencv_imgproc.COLOR_BGR2GRAY);
        org.bytedeco.javacpp.opencv_imgproc.equalizeHist(frameGray, frameGray);

        // -- Detect faces
        RectVector faces = new RectVector();
        faceCascade.detectMultiScale(frameGray, faces);

       for(int i=0;i<=faces.size();i++) {
    	   Rect face_i = faces.get(i);
    	   org.bytedeco.javacpp.opencv_imgproc.rectangle(frame, face_i, new Scalar(0, 255, 0, 2));
    	   
    	   Mat faceROI = frameGray.clone();
    	   
    	   RectVector eyes = new RectVector();
    	   eyesCascade.detectMultiScale(faceROI, eyes);
    	   for(int j = 0;j<=eyes.size();j++) {
    		   Rect eye_i = eyes.get(j);
    		   org.bytedeco.javacpp.opencv_imgproc.rectangle(frame, eye_i, new Scalar(0, 255, 0, 2));   
    	   }
       }
//        for (Rect face : listOfFaces) {
//            Point center = new Point(face.x + face.width() / 2, face.y() + face.height() / 2);
//            org.bytedeco.javacpp.opencv_imgproc.ellipse(frame, center, new Size(face.width() / 2, face.height() / 2), 0, 0, 360,
//                    new Scalar(255, 0, 255));
//
//            Mat faceROI = frameGray.submat(face);
//
//            // -- In each face, detect eyes
//            MatOfRect eyes = new MatOfRect();
//            eyesCascade.detectMultiScale(faceROI, eyes);
//
//            List<Rect> listOfEyes = eyes.toList();
//            for (Rect eye : listOfEyes) {
//                Point eyeCenter = new Point(face.x + eye.x + eye.width / 2, face.y + eye.y + eye.height / 2);
//                int radius = (int) Math.round((eye.width + eye.height) * 0.25);
//                Imgproc.circle(frame, eyeCenter, radius, new Scalar(255, 0, 0), 4);
//            }
//        }

        //-- Show what you got
//        HighGui.imshow("Capture - Face detection", frame );
       opencv_imgcodecs.imwrite("D://head", frame);
    }

    public void run(String[] args) {
        String filenameFaceCascade =  "D://haarcascade_frontalface_alt.xml";
        String filenameEyesCascade =  "D://haarcascade_eye_tree_eyeglasses.xml";
        int cameraDevice = args.length > 2 ? Integer.parseInt(args[2]) : 0;

        CascadeClassifier faceCascade = new CascadeClassifier();
        CascadeClassifier eyesCascade = new CascadeClassifier();

        if (!faceCascade.load(filenameFaceCascade)) {
            System.err.println("--(!)Error loading face cascade: " + filenameFaceCascade);
            System.exit(0);
        }
        if (!eyesCascade.load(filenameEyesCascade)) {
            System.err.println("--(!)Error loading eyes cascade: " + filenameEyesCascade);
            System.exit(0);
        }

        VideoCapture capture = new VideoCapture(cameraDevice);
        if (!capture.isOpened()) {
            System.err.println("--(!)Error opening video capture");
            System.exit(0);
        }

        Mat frame = new Mat();
        while (capture.read(frame)) {
            if (frame.empty()) {
                System.err.println("--(!) No captured frame -- Break!");
                break;
            }

            //-- 3. Apply the classifier to the frame
            detectAndDisplay(frame, faceCascade, eyesCascade);

//            if (HighGui.waitKey(10) == 27) {
//                break;// escape
//            }
        }

        System.exit(0);
    }
}

public class ObjectDetectionDemo {
    public static void main(String[] args) {
        // Load the native OpenCV library
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        new ObjectDetection().run(args);
    }
}
package team.javaSpirit.teachingAssistantPlatform.FaceCheck;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException, org.bytedeco.javacv.FrameRecorder.Exception {
		try {
			JcvTest.captureFace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

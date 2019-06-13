package team.javaSpirit.teachingAssistantPlatform.vediotape.dao;

import java.io.IOException;

public class TurnToOne {

	public TurnToOne() {
		// TODO Auto-generated constructor stub
	}
	static String relativelyPath=System.getProperty("user.dir");
	String  ffmPath  =  relativelyPath+"//ffmpeg//bin//ffmpeg.exe";
	//String  filePath  =  relativelyPath+"//ffmpeg//bin";
	private final static String PATH = relativelyPath+"\\pictureToAVI\\out1.avi";  //这个是已有的完整视频
	public void finallyOne(String path) {
		try {
			String voice=relativelyPath+"//voice//he.wav";
			String avi=relativelyPath+"//pictureToAVI//out1.avi";
			Runtime r = Runtime.getRuntime();
			String pan=relativelyPath.substring(0, 2);
			r.exec("cmd /c "+pan);
			r.exec(ffmPath+" -i "+voice+" -i "+avi+" "+path );//F:\\ahe000.avi"
			System.out.println("over");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

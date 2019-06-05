package team.javaSpirit.teachingAssistantPlatform;

import java.io.IOException;

public class TurnToOne {

	public TurnToOne() {
		// TODO Auto-generated constructor stub
	}
	static String relativelyPath=System.getProperty("user.dir");
	String  ffmPath  =  relativelyPath+"//ffmpeg//bin//ffmpeg.exe";
	//String  filePath  =  relativelyPath+"//ffmpeg//bin";
	private final static String PATH = relativelyPath+"\\pictureToAVI\\out1.avi";  //这个是已有的完整视频
	public void finallyOne() {
		try {
			String voice=relativelyPath+"//voice//he.wav";
			String avi=relativelyPath+"//pictureToAVI//out1.avi";
			Runtime r = Runtime.getRuntime();
			String path = "cmd /c cd D:\\\\AA三下\\\\java精灵\\ffmpeg-20190513-dcc9998-win64-static\\bin";
			r.exec("cmd /c d:");
			// r.exec("cd D:\\AA三下\\java精灵\ffmpeg-20190513-dcc9998-win64-static\bin");
			//r.exec(path);
			r.exec(ffmPath+" -i "+voice+" -i "+avi+" E:\\recorder\\ahe000.avi");
			System.out.println("over");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

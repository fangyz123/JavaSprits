package recorderTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {
	public Test() {
		// TODO Auto-generated constructor stub
	}

	//private final static String PATH = "E:\\\\recordAVI\\\\out2.avi";  
	public void runner() {
		try {
			Runtime r = Runtime.getRuntime();
			String path = "cmd /c cd D:\\\\AA三下\\\\java精灵\\ffmpeg-20190513-dcc9998-win64-static\\bin";
			r.exec("cmd /c d:");
			// r.exec("cd D:\\AA三下\\java精灵\ffmpeg-20190513-dcc9998-win64-static\bin");
			//r.exec(path);
			r.exec("D:\\\\\\\\AA三下\\\\\\\\java精灵\\\\ffmpeg-20190513-dcc9998-win64-static\\\\bin\\\\ffmpeg.exe -i E:\\recordyin\\1.wav -i E:\\recordAVI\\out2.avi E:\\recorder\\a11.avi");
			System.out.println("over");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public static void turn2flv(String oldfilepath) {
		// 文件命名  
		Calendar c=Calendar.getInstance();
		String savename=String.valueOf(c.getTimeInMillis())+Math.round(Math.random()*100000);
		List<String> commend=new ArrayList<String>();
		commend.add("c:\\ffmpeg\\ffmpeg");
		commend.add("-i");
		commend.add(oldfilepath);
		commend.add("-ab");
		commend.add("56");
		commend.add("-ar");
		commend.add("22050");
		commend.add("-qscale");
		commend.add("8");
		commend.add("-r");
		commend.add("15");
		commend.add("-s");
		commend.add("600x500");
		commend.add("E:\\\\recorder\\\\a3.avi");
		try{
			Runtime runtime=Runtime.getRuntime();
			Process proce=null;
			String cmd= "";
			String cut="D:\\\\AA三下\\\\java精灵\\ffmpeg-20190513-dcc9998-win64-static\\bin\\ffmpeg.exe -i"+oldfilepath+
					"-y-fimage2-ss8-t 0.001   -s   600x500   c:\\ffmpeg\\output\\"
		+"a.jpg";
			String cutCmd=cmd+cut;
			proce=runtime.exec(cutCmd);
			ProcessBuilder builder=new ProcessBuilder(commend);
			builder.command(commend);
			builder.start();
		}catch (Exception e) {  
            e.printStackTrace();  
           
        }  
		
	}*/
	
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
			r.exec(ffmPath+" -i "+voice+" -i "+avi+" E:\\recorder\\a5.avi");
			System.out.println("over");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Test t = new Test();
		//turn2flv(PATH);
		//t.runner();
		t.finallyOne();

	}

}

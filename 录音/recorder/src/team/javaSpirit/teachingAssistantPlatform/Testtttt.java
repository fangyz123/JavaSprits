package team.javaSpirit.teachingAssistantPlatform;

import java.io.File;

public class Testtttt {

	public Testtttt() {
		// TODO Auto-generated constructor stub
	}
	public void deleteFiles() {
		String relativelyPath=System.getProperty("user.dir");
		String  filePath1  =  relativelyPath+"//picture//";
		String filePath2= relativelyPath+"//voice//";
		String filePath3= relativelyPath+"//pictureToAVI//";
		File picture=new File(filePath1);
		File voice=new File(filePath2);
		File avi=new File(filePath3);
		 if (picture.isDirectory()) {
           
             File[] files = picture.listFiles();
             for (File file : files) {
              file.delete();
             }
             System.out.println("de p");
          }
		 if (voice.isDirectory()) {
	           
             File[] files = picture.listFiles();
             for (File file : files) {
              file.delete();
             }
             System.out.println("de voi");
          }
		 if (avi.isDirectory()) {
	           
             File[] files = picture.listFiles();
             for (File file : files) {
              file.delete();
             }
             System.out.println("de avi");
          }
	}
	public static void main(String[] args) {
		Testtttt t=new Testtttt();
		t.deleteFiles();

	}

}

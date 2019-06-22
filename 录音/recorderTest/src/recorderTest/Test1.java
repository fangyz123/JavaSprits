package recorderTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test1 {

	public Test1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		String relativelyPath=System.getProperty("user.dir");
		System.out.println(relativelyPath);
		 String  filePath  =  relativelyPath+"//picture//test.txt";    
         /*filePath  =  filePath.toString();    
         File  myFilePath  =  new  File(filePath);    
         if  (!myFilePath.exists())  {    
             myFilePath.createNewFile();    
         }    
         FileWriter  resultFile  =  new  FileWriter(myFilePath);    
         PrintWriter  myFile  =  new  PrintWriter(resultFile);    
         String  strContent  =  "hello";    
         myFile.println(strContent);    
         try {
			resultFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    */
		// String  filePath  =  filePathAndName;    
         filePath  =  filePath.toString();    
         java.io.File  myDelFile  =  new  java.io.File(filePath);    
         myDelFile.delete();    
         
         
        /* if (oldPath.isDirectory()) {
             System.out.println(oldPath + "ÊÇÎÄ¼þ¼Ð--");
             File[] files = oldPath.listFiles();
             for (File file : files) {
               deleteFile(file);
             }
            }else{
            }*/

	}

}

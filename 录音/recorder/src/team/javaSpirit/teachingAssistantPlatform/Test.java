package team.javaSpirit.teachingAssistantPlatform;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//GuiCamera cam= new GuiCamera("E:\\record\\", "jpeg");
		ToDoFile tdf=new ToDoFile();
		tdf.deleteFiles();
		String relativelyPath=System.getProperty("user.dir");
		String  filePath  =  relativelyPath+"//picture//";
		GuiCamera cam= new GuiCamera(filePath, "jpeg");
		
       // cam.snapShot();


	}

}

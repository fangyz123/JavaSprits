package recorderTest;

public class T {

	public T() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 String relativelyPath=System.getProperty("user.dir");
		 System.out.println(relativelyPath);
		 String pan=relativelyPath.substring(0, 2);
		 System.out.println(pan+"/");

	}

}

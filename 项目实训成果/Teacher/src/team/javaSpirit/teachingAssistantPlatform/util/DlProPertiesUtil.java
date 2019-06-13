package team.javaSpirit.teachingAssistantPlatform.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class DlProPertiesUtil {
	/**
	 * 
	 * <p>Title: getRemberPassword</p>
	 * <p>Description: 获得用户是否记住密码标识</p>
	 * @param s
	 * @return
	 */
	public static boolean getRemberPassword(String s) {
		Properties pro=new Properties();
		boolean b=false;
		try {
			InputStream is=
			new FileInputStream(s);
			pro.load(is);
			String temp=pro.getProperty("remberpassword");
			if(temp==null||temp.equals("")) {
				b=false;
			}else {
				b=Boolean.parseBoolean(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 
	 * <p>Title: getUsername</p>
	 * <p>Description:获得用户的用户名 </p>
	 * @param s
	 * @return
	 */
	public static String getUsername(String s) {
		Properties pro=new Properties();
		String b="";
		try {
			InputStream is=new FileInputStream(s);
			pro.load(is);
			b=pro.getProperty("username");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 
	 * <p>Title: getPassword</p>
	 * <p>Description:获得用户名 </p>
	 * @param s
	 * @return
	 */
	public static String getPassword(String s) {
		Properties pro=new Properties();
		String b="";
		try {
			InputStream is=new FileInputStream(s);
			pro.load(is);
			b=pro.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 
	 * <p>Title: setDlProperties</p>
	 * <p>Description:更新dl.properties文件重新存储用户信息 </p>
	 * @param b
	 * @param s1
	 * @param s2
	 * @param s
	 */
	public static void setDlProperties(boolean b,String s1,String s2,String s) {
		Properties pro=new Properties();
		Boolean bl=new Boolean(b);
		try {
			InputStream is=new FileInputStream(s);
			pro.load(is);
			pro.setProperty("remberpassword",bl.toString());
			pro.setProperty("username", s1);
			pro.setProperty("password", s2);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OutputStream os=new FileOutputStream(s);
			pro.store(os, "");
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * <p>Title: setRemberword</p>
	 * <p>Description: 设置是否记得密码的标志</p>
	 * @param s
	 * @param b
	 */
	public static void setRemberword(String s,boolean b) {
		Properties pro=new Properties();
		Boolean bl=new Boolean(b);;
		try {
			InputStream is=new FileInputStream(s);
			pro.load(is);
			pro.setProperty("remberpassword",bl.toString());
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OutputStream os=new FileOutputStream(s);
			pro.store(os, "");
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

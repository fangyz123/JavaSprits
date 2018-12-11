package com.ryy.ui.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class DlProPertiesUtil {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
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
	public static void setDlProperties(boolean b,String s1,String s2,String s) {
		Properties pro=new Properties();
		Boolean bl=new Boolean(b);
		System.out.println(bl.toString());
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
}

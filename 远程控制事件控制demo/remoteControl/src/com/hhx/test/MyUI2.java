package com.hhx.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyUI2 {

	private JFrame jframe =new JFrame("控制台");
	private JLabel jlabel=new JLabel();
	MyUI2() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screenDimension.getWidth();
		int height=(int)screenDimension.getHeight();
		jframe.setSize(width, height);
		jframe.setVisible(true); // 可见
		jframe.setAlwaysOnTop(true);
		jframe.setDefaultCloseOperation(3); // 关闭方式
		jframe.add(jlabel);
	}
	public void showUI() {
		int width=jlabel.getWidth();
		int height=jlabel.getHeight();
		System.out.println("jlable:"+width+","+height);
	}
}

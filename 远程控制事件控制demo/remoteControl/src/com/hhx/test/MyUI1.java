package com.hhx.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyUI1 extends JFrame {

	private static JLabel jLabel = new JLabel();// 创建一个显示框

	public MyUI1() {
		super("控制台");

		// jLabel.setOpaque(true);
		// jLabel.setBackground(Color.BLUE);
		// 获取屏幕的边界
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		System.out.println(screenInsets);
		// 获取底部任务栏高度
		int taskBarHeight = screenInsets.bottom;

		System.out.println(taskBarHeight);
		// 获取屏幕的大小
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println((int) screenDimension.getWidth() + "h" + (int) screenDimension.getHeight());
		setSize((int) screenDimension.getWidth(), ((int) screenDimension.getHeight() - taskBarHeight));
		// setSize(1000,700);
		setVisible(true); // 可见
		setAlwaysOnTop(true);
		System.out.println(getX() + "," + getY());
		setDefaultCloseOperation(3); // 关闭方式
		ImageIcon icon = new ImageIcon("images/蔡徐坤壁纸.jpg");
		jLabel.setIcon(icon);
//		jLabel.setBounds(30, 30, 500, 400);
		System.out.println(jLabel.getX() + ",," + jLabel.getY());
		// jLabel.setSize(screenDimension);

		add(jLabel);// 把这个面板加入到控制台中
		System.out.println(jLabel.getWidth() + "hahahah" + jLabel.getHeight());

	}
	public void name() {
		System.out.println(jLabel.getWidth() + "hahahah" + jLabel.getHeight());
		
		
	}

}

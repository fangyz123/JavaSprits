package com.hhx.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyUI1 extends JFrame {

	private static JLabel jLabel = new JLabel();// ����һ����ʾ��

	public MyUI1() {
		super("����̨");

		// jLabel.setOpaque(true);
		// jLabel.setBackground(Color.BLUE);
		// ��ȡ��Ļ�ı߽�
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		System.out.println(screenInsets);
		// ��ȡ�ײ��������߶�
		int taskBarHeight = screenInsets.bottom;

		System.out.println(taskBarHeight);
		// ��ȡ��Ļ�Ĵ�С
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println((int) screenDimension.getWidth() + "h" + (int) screenDimension.getHeight());
		setSize((int) screenDimension.getWidth(), ((int) screenDimension.getHeight() - taskBarHeight));
		// setSize(1000,700);
		setVisible(true); // �ɼ�
		setAlwaysOnTop(true);
		System.out.println(getX() + "," + getY());
		setDefaultCloseOperation(3); // �رշ�ʽ
		ImageIcon icon = new ImageIcon("images/��������ֽ.jpg");
		jLabel.setIcon(icon);
//		jLabel.setBounds(30, 30, 500, 400);
		System.out.println(jLabel.getX() + ",," + jLabel.getY());
		// jLabel.setSize(screenDimension);

		add(jLabel);// ����������뵽����̨��
		System.out.println(jLabel.getWidth() + "hahahah" + jLabel.getHeight());

	}
	public void name() {
		System.out.println(jLabel.getWidth() + "hahahah" + jLabel.getHeight());
		
		
	}

}

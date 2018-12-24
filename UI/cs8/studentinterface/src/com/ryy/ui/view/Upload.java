package com.ryy.ui.view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Upload extends JFrame {

	/**背景容器*/
	private JPanel bgContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upload frame = new Upload();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setBackground() {
		bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
		        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/img1.png"));
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
              }
	  };
	  bgContentPane.setBounds(0, 0, 100, 1000);
	  bgContentPane.setBorder(null);
	  this.setContentPane(bgContentPane);
		bgContentPane.setLayout(null);
	}
	public void init() {
		
	}
	/**
	 * Create the frame.
	 */
	public Upload() {
		//设置窗体大小
		this.setBounds(0, 0, 600, 450);
		//窗体大小不能改变
		this.setResizable(false);
		//居中显示
		this.setLocationRelativeTo(null);
		//设置图标
		this.setIconImage(new ImageIcon(this.getClass().getResource("/img/logo1.png")).getImage());
		//设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//窗体可见
		this.setVisible(true);
		bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
		        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/img1.png"));
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
              }
	  };
	  bgContentPane.setBounds(0, 0, 100, 1000);
	  bgContentPane.setBorder(null);
	  this.setContentPane(bgContentPane);
		bgContentPane.setLayout(null);
		JFileChooser jchooser=new JFileChooser();
		jchooser.setBounds(20, 24, 564, 367);
		//要求用户只选择文件
		jchooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		bgContentPane.add(jchooser);
		jchooser.showDialog(new JLabel(), "选择");
	}

}

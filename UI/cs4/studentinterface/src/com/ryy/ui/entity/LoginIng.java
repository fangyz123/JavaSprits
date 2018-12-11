package com.ryy.ui.entity;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class LoginIng extends JFrame {

	private JPanel bgContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginIng frame = new LoginIng();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginIng() {
		/**
		 * 窗体设置
		 * */
		bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("img/bg1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
//        /**logo图片*/
//		JLabel logo = new JLabel("");
//		logo.setIcon(new ImageIcon("img/logo3.jpg"));
//		logo.setBounds(59, 24, 200, 200);
//		bgContentPane.add(logo);		
		/**
		 * logo文字
		 * */
		JLabel logoword = new JLabel("*******");
		logoword.setForeground(SystemColor.activeCaption);
		logoword.setFont(new Font("宋体", Font.BOLD, 18));
		logoword.setHorizontalAlignment(SwingConstants.CENTER);
		logoword.setBounds(99, 242, 130, 22);
		bgContentPane.add(logoword);
        
        this.setContentPane(bgContentPane);
		//设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(99, 280, 130, 37);
		bgContentPane.add(cancel);
		this.setBounds(0, 0, 320, 382);
		//窗体大小不能改变
		this.setResizable(false);
		//居中显示
		this.setLocationRelativeTo(null);
		//设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置图标
		this.setIconImage(null);
		//窗体可见
		this.setVisible(true);
	}
}

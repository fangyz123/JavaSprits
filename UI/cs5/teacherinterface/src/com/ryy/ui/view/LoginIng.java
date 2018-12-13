package com.ryy.ui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class LoginIng extends JFrame {

	private JPanel bgContentPane;

	public void setBackground() {
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
        bgContentPane.setLayout(null);
        this.setContentPane(bgContentPane);
        //设置布局方式为绝对定位  
        this.getContentPane().setLayout(null);
	}
	public void setWord() {
		 JLabel word = new JLabel("登   录   中");
			word.setForeground(new Color(102, 153, 204));
			word.setFont(new Font("宋体", Font.PLAIN, 18));
			word.setHorizontalAlignment(SwingConstants.CENTER);
			word.setBounds(54, 230, 204, 60);
			getContentPane().add(word);
	}
	public void init() {
		this.setBackground();
		this.setWord();
	}
	/**
	 * Create the frame.
	 */
	public LoginIng() {
		//设置窗体大小
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

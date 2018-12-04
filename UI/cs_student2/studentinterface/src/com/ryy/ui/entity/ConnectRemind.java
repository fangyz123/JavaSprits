package com.ryy.ui.entity;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

public class ConnectRemind extends JFrame {

	private JPanel bgContentPane;

	/**
	 * Launch the application.
	 */
	
	public ConnectRemind getConnectRemind() {
		return this;
	}
	
	/**
	 * Create the frame.
	 */
	public ConnectRemind() {
		//设置背景图
		bgContentPane = new JPanel() {
		 public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/img1.png");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
		   };
		 bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(bgContentPane);
		bgContentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel(" 请选择您要连接的老师：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setBounds(10, 10, 155, 34);
		getContentPane().add(lblNewLabel);
		
		String[] teachers=new String[] {"aaa","nch","ssjd"};
		JComboBox boxes = new JComboBox();
		boxes.setBounds(172, 17, 84, 21);
		for(String s:teachers) {
			boxes.addItem(s);
		}
		getContentPane().add(boxes);
		
		JButton connect = new JButton("连接");
		connect.setBounds(284, 16, 84, 23);
		connect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                String str=e.getActionCommand();
//                if("登录".equals(str)){
//                    String getName =username.getText();
////          String getPwd =password.getText();
//                     JOptionPane.showConfirmDialog(null, "您输入的用户名是"+getName);
//                }
            	String teacher=(String)boxes.getSelectedItem();
            	JOptionPane.showConfirmDialog(null, "您要连接的老师是"+teacher);
            	
            }
        });
		bgContentPane.add(connect);
		//去掉标题栏
		this.setUndecorated(true);
		//设置为普通对话框形式
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG );
		//设置窗体大小
		this.setBounds(0, 0, 400, 200);
		//窗体大小不能改变
		this.setResizable(false);
		//居中显示
		this.setLocationRelativeTo(null);
		//窗体可见
		this.setVisible(true);
	}
}

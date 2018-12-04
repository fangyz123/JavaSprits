package com.ryy.ui.entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modify extends JFrame {

	private JPanel bgContentPane;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField conpassword;

	

	/**
	 * Create the frame.
	 */
	public Modify() {
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
				//设置布局方式为绝对定位
				bgContentPane.setLayout(null);
				//logo
				JLabel logo = new JLabel("");
				logo.setIcon(new ImageIcon("img/logo1.png"));
				logo.setBounds(102, 0, 110, 110);
				bgContentPane.add(logo);
				
				JLabel logoword = new JLabel("教学辅助系统");
				logoword.setForeground(SystemColor.activeCaption);
				logoword.setFont(new Font("宋体", Font.BOLD, 18));
				logoword.setHorizontalAlignment(SwingConstants.CENTER);
				logoword.setBounds(89, 120, 130, 22);
				bgContentPane.add(logoword);
				
				JLabel lblNewLabel = new JLabel("用 户 名");
				lblNewLabel.setForeground(Color.LIGHT_GRAY);
				lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
				lblNewLabel.setBounds(48, 164, 65, 20);
				bgContentPane.add(lblNewLabel);
//				
				JLabel lblNewLabel_1 = new JLabel("密    码");
				lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
				lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
				lblNewLabel_1.setBounds(48, 205, 65, 20);
				bgContentPane.add(lblNewLabel_1);
				
				JLabel label = new JLabel("确认密码");
				label.setForeground(Color.LIGHT_GRAY);
				label.setFont(new Font("宋体", Font.BOLD, 14));
				label.setBounds(48, 247, 65, 20);
				bgContentPane.add(label);
				
				username = new JTextField();
				username.setBounds(137, 164, 121, 21);
				bgContentPane.add(username);
				username.setColumns(10);
				
				password = new JPasswordField();
				password.setBounds(137, 205, 121, 21);
				bgContentPane.add(password);
				
				conpassword = new JPasswordField();
				conpassword.setBounds(137, 247, 121, 21);
				bgContentPane.add(conpassword);
				
				JButton confirm = new JButton("确  认");
				confirm.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		                String str=e.getActionCommand();
		                if("确  认".equals(str)){
		                    String getName =username.getText();
		                    String getPwd =password.getText();
		                    String getConPwd=conpassword.getText();
//		                    JOptionPane.showMessageDialog(parentComponent, message);
		                     JOptionPane.showConfirmDialog(null, "您输入的用户名是"+getName);
		                }
		            	
		            }

				});
				confirm.setForeground(SystemColor.textInactiveText);
				confirm.setBounds(102, 296, 93, 23);
				bgContentPane.add(confirm);
				
				//设置窗体大小
				this.setBounds(0, 0, 320, 382);
				//窗体大小不能改变
				this.setResizable(false);
				//居中显示
				this.setLocationRelativeTo(null);
				//设置图标
				this.setIconImage(null);
				//窗体可见
				this.setVisible(true);
				
	}
}

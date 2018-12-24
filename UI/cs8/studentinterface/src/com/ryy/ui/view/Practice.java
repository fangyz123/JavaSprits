package com.ryy.ui.view;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Practice extends JFrame {

	private JPanel bgContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practice frame = new Practice();
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
	public Practice() {
		//设置背景图
		bgContentPane = new JPanel() {
		 public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/img1.png"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
		   };
		 bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(bgContentPane);
		bgContentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("您要连接的老师是：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 13));
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setBounds(35, 37, 127, 34);
		getContentPane().add(lblNewLabel);
		
		//连接按钮
		JButton connect = new JButton("连   接");
		connect.setForeground(new Color(128, 128, 128));
		connect.setBackground(null);
		connect.setFont(new Font("宋体", Font.BOLD, 14));
		connect.setBounds(132, 95, 112, 34);
		connect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                String str=e.getActionCommand();
//                if("登录".equals(str)){
//                    String getName =username.getText();
////          String getPwd =password.getText();
//                     JOptionPane.showConfirmDialog(null, "您输入的用户名是"+getName);
//             
//            	ConnectRemind cr=getConnectRemind();
//            	cr.dispose();
            	
            }
        });
		bgContentPane.add(connect);
		
		JLabel connectTeacher = new JLabel("王伟");
		connectTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		connectTeacher.setFont(new Font("宋体", Font.BOLD, 14));
		connectTeacher.setForeground(new Color(128, 128, 128));
		connectTeacher.setBounds(154, 37, 62, 34);
		bgContentPane.add(connectTeacher);
		
		JLabel lblNewLabel_1 = new JLabel("第16周大数据设计课");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(257, 78, 120, 69);
		bgContentPane.add(lblNewLabel_1);
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
				//设置图标
				this.setIconImage(new ImageIcon(this.getClass().getResource("/img/logo1.png")).getImage());
				//窗体可见
				this.setVisible(true);
	}
}

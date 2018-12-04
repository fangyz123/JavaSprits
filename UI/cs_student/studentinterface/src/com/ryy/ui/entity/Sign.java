package com.ryy.ui.entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Sign extends JFrame {
	
	private JPanel bgContentPane;
	public Sign getSign() {
		return this;
	}

	/**
	 * Create the frame.
	 */
	public Sign() {
		//设置背景图
				bgContentPane = new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/img1.png");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
			  bgContentPane.setBounds(0, 0, 100, 1000);
			    bgContentPane.setBorder(null);
			    this.setContentPane(bgContentPane);
				//签到菜单
				JPanel menu1 = new JPanel() {
		            public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
		        };
				menu1.setBounds(45, 28, 88, 99);
				menu1.setBorder(null);
				menu1.setForeground(new Color(255, 255, 255));
				menu1.setLayout(null);
				JLabel lb1 = new JLabel("");
				lb1.setBounds(13, 10, 60, 60);
				menu1.add(lb1);
				lb1.setHorizontalAlignment(SwingConstants.CENTER);
				lb1.setVerticalAlignment(SwingConstants.TOP);
				lb1.setIcon(new ImageIcon("img/menu1.jpg"));
				
				JButton bt1 = new JButton("签到");
				bt1.setBounds(28, 70, 31, 17);
				menu1.add(bt1);
				bt1.setFont(new Font("宋体", Font.BOLD, 14));
				bt1.setForeground(new Color(100, 149, 237));
				bt1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				bt1.setBorder(null);
				bt1.setBackground(Color.WHITE);
				
				//远程监控菜单
				JPanel menu2 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu2.setBounds(166, 28, 88, 99);
				menu2.setBorder(null);
				menu2.setForeground(new Color(255, 255, 255));
				menu2.setLayout(null);
				
				JLabel lb2 = new JLabel("");
				lb2.setBounds(13, 10, 60, 60);
				menu2.add(lb2);
				lb2.setIcon(new ImageIcon("img/menu2.jpg"));
				JButton bt2 = new JButton("远程监控");
				bt2.setBounds(13, 70, 61, 17);
				bt2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				menu2.add(bt2);
				bt2.setForeground(new Color(100, 149, 237));
				bt2.setFont(new Font("宋体", Font.BOLD, 14));
				bt2.setBackground(Color.WHITE);
				bt2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				bt2.setBorder(null);
				bt2.setBackground(Color.WHITE);
				
				//录屏菜单
				JPanel menu3 =new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu3.setBounds(289, 28, 88, 99);
				menu3.setBorder(null);
				menu3.setForeground(Color.WHITE);
				menu3.setLayout(null);
				JLabel lb3 = new JLabel("");
				lb3.setBounds(13, 10, 60, 60);
				menu3.add(lb3);
				lb3.setIcon(new ImageIcon("img/menu3.jpg"));
				
				JButton bt3 = new JButton("录屏");
				bt3.setBounds(28, 70, 31, 17);
				bt3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				menu3.add(bt3);
				bt3.setForeground(new Color(100, 149, 237));
				bt3.setFont(new Font("宋体", Font.BOLD, 14));
				bt3.setBackground(Color.WHITE);bt3.setBorder(null);
				
				//广播菜单
				JPanel menu4 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu4.setBounds(411, 28, 88, 99);
				menu4.setBorder(null);
				menu4.setForeground(Color.WHITE);
				menu4.setLayout(null);
				
				JLabel lb4 = new JLabel("");
				lb4.setBounds(13, 10, 60, 60);
				menu4.add(lb4);
				lb4.setIcon(new ImageIcon("img/menu4.jpg"));
				
				JButton button = new JButton("广播");
				button.setBounds(28, 70, 31, 17);
				button.setForeground(new Color(100, 149, 237));
				button.setFont(new Font("宋体", Font.BOLD, 14));
				button.setBorder(null);
				button.setBackground(Color.WHITE);
				menu4.add(button);
				//作业菜单
				JPanel menu5 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu5.setBounds(531, 28, 88, 99);
				menu5.setBorder(null);
				menu5.setForeground(Color.WHITE);
				menu5.setLayout(null);
				
				JLabel lb5 = new JLabel("");
				lb5.setBounds(13, 10, 60, 60);
				menu5.add(lb5);
				lb5.setIcon(new ImageIcon("img/menu5.jpg"));
				
				JButton bt5 = new JButton("作业");
				bt5.setBounds(28, 69, 31, 17);
				bt5.setForeground(new Color(100, 149, 237));
				bt5.setFont(new Font("宋体", Font.BOLD, 14));
				bt5.setBorder(null);
				bt5.setBackground(Color.WHITE);
				menu5.add(bt5);
				//课堂小测菜单
				JPanel menu6 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu6.setBounds(661, 28, 88, 99);
				menu6.setBorder(null);
				menu6.setForeground(Color.WHITE);
				menu6.setLayout(null);
				
				JLabel lb6 = new JLabel("");
				lb6.setBounds(13, 10, 60, 60);
				menu6.add(lb6);
				lb6.setIcon(new ImageIcon("img/menu6.jpg"));
				
				JButton bt6 = new JButton("课堂小测");
				bt6.setBounds(13, 70, 61, 17);
				bt6.setForeground(new Color(100, 149, 237));
				bt6.setFont(new Font("宋体", Font.BOLD, 14));
				bt6.setBorder(null);
				bt6.setBackground(Color.WHITE);
				menu6.add(bt6);
				//资源共享菜单
				JPanel menu7 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon("img/menubg.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu7.setBounds(785, 28, 88, 99);
				menu7.setBorder(null);
				menu7.setForeground(Color.WHITE);
				menu7.setLayout(null);
				
				JLabel lb7 = new JLabel("");
				lb7.setBounds(13, 10, 60, 60);
				menu7.add(lb7);
				lb7.setIcon(new ImageIcon("img/menu7.jpg"));
				
				JButton bt7 = new JButton("资源共享");
				bt7.setBounds(13, 70, 61, 17);
				bt7.setForeground(new Color(100, 149, 237));
				bt7.setFont(new Font("宋体", Font.BOLD, 14));
				bt7.setBorder(null);
				bt7.setBackground(Color.WHITE);
				menu7.add(bt7);
				
				JLabel lblNewLabel = new JLabel("第*周*****课");
				lblNewLabel.setBounds(904, 49, 72, 47);
				
				JPanel centerpl = new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/img1.png");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				centerpl.setBounds(45, 160, 898, 399);
				centerpl.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
				centerpl.setBackground(null);
				centerpl.setLayout(null);
				bgContentPane.setLayout(null);
				bgContentPane.setLayout(null);
				
				JPanel menu9 =new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/menu9.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				menu9.setBounds(22, 166, 90, 80);
				centerpl.add(menu9);
				menu9.setLayout(null);
				
				JButton bt9 = new JButton("查询");
				bt9.setBackground(null);
				bt9.setBounds(10, 47, 70, 23);
				bt9.setBorder(null);
				menu9.add(bt9);
				
				JPanel menu10 = new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/menu10.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				menu10.setBounds(22, 269, 90, 80);
				centerpl.add(menu10);
				menu10.setLayout(null);
				
				JButton bt10 = new JButton("历史记录");
				bt10.setBounds(10, 47, 70, 23);
				bt10.setBorder(null);
				menu10.add(bt10);
				
				JPanel contentpl =  new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/img1.png");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				contentpl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
				contentpl.setBounds(113, 44, 793, 322);
				centerpl.add(contentpl);
				contentpl.setLayout(null);
				bgContentPane.add(centerpl);
				
				JPanel closepl = new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/btbackground.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
				closepl.setBounds(113, 14, 104, 30);
				centerpl.add(closepl);
				closepl.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("正在签到");
				lblNewLabel_1.setForeground(SystemColor.textInactiveText);
				lblNewLabel_1.setBounds(10, 5, 63, 23);
				closepl.add(lblNewLabel_1);
				
				JButton closebt = new JButton("×");
				closebt.setBounds(80, 5, 23, 23);
				closepl.add(closebt);
				closebt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Sign sign=getSign();
						sign.dispose();
					}
				});
				closebt.setBackground(null);
				closebt.setBorder(null);
				
				JPanel menu8 =new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/menu8.jpg");
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				menu8.setBounds(22, 55, 90, 80);
				centerpl.add(menu8);
				menu8.setLayout(null);
				
				JButton bt8 = new JButton("备忘录");
				bt8.setBounds(10, 47, 70, 23);
				menu8.add(bt8);
				bt8.setBackground(null);
				bt8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				bt8.setBorder(null);
				bgContentPane.add(menu1);
				bgContentPane.add(menu2);
				bgContentPane.add(menu3);
				bgContentPane.add(menu4);
				bgContentPane.add(menu5);
				bgContentPane.add(menu6);
				bgContentPane.add(menu7);
				bgContentPane.add(lblNewLabel);
				//设置窗体大小
				this.setBounds(0, 0, 1000, 600);
				//窗体大小不能改变
				this.setResizable(false);
				//居中显示
				this.setLocationRelativeTo(null);
				//设置图标
				this.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\课程项目\\img\\logo2.jpg"));
				//窗体可见
				this.setVisible(true);
		
	}
}

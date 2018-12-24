package com.ryy.ui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.ryy.ui.controller.IndexActionListener;
import com.ryy.ui.controller.RemoteMouseListener;
import com.ryy.ui.controller.SignMouseListener;
import com.ryy.ui.controller.UploadMouseListener;
import com.ryy.ui.entity.ShareResource;
import com.ryy.ui.shareresource.dao.ShareResourceDaoImpl;

import javax.swing.ScrollPaneConstants;

public class Resource extends JFrame {

	/**背景容器*/
	private JPanel bgContentPane;
	/**中间模块容器*/
	private JPanel centerpl;
	/**内容模块容器*/
	private JPanel contentpl; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resource frame = new Resource();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	public Resource() {
		//设置窗体大小
				this.setBounds(0, 0, 1000, 600);
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
			  
			//签到菜单容器
				JPanel menu1 = new JPanel() {
		            public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
		        };
				menu1.setBounds(45, 28, 88, 99);
				menu1.setBorder(null);
				menu1.setForeground(new Color(255, 255, 255));
				menu1.setLayout(null);
//				menu1.addMouseListener(new SignMouseListener(getIndex()));
				//签到图标
				JLabel lb1 = new JLabel("");
				lb1.setBounds(13, 10, 60, 60);
				menu1.add(lb1);
				lb1.setHorizontalAlignment(SwingConstants.CENTER);
				lb1.setVerticalAlignment(SwingConstants.TOP);
				lb1.setIcon(new ImageIcon(this.getClass().getResource("/img/menu1.jpg")));
				//签到按钮
				JButton bt1 = new JButton("签到");
				bt1.setBounds(28, 70, 31, 17);
				menu1.add(bt1);
				bt1.setFont(new Font("宋体", Font.BOLD, 14));
				bt1.setForeground(new Color(100, 149, 237));
//				bt1.addActionListener(new IndexActionListener(getIndex()));
				bt1.setBorder(null);
				bt1.setBackground(Color.WHITE);
				bgContentPane.add(menu1);
				
				
				//远程监控菜单容器
				JPanel menu2 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu2.setBounds(166, 28, 88, 99);
				menu2.setBorder(null);
				menu2.setForeground(new Color(255, 255, 255));
				menu2.setLayout(null);
//				menu2.addMouseListener(new RemoteMouseListener(getIndex()));
				//远程监控图标
				JLabel lb2 = new JLabel("");
				lb2.setBounds(13, 10, 60, 60);
				menu2.add(lb2);
				lb2.setIcon(new ImageIcon(this.getClass().getResource("/img/menu2.jpg")));
				//远程监控按钮
				JButton bt2 = new JButton("远程监控");
				bt2.setBounds(13, 70, 61, 17);
//				bt2.addActionListener(new IndexActionListener(getIndex()));
				menu2.add(bt2);
				bt2.setForeground(new Color(100, 149, 237));
				bt2.setFont(new Font("宋体", Font.BOLD, 14));
				bt2.setBackground(Color.WHITE);
				bt2.setBorder(null);
				bgContentPane.add(menu2);
				
				//录屏菜单容器
				JPanel menu3 =new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu3.setBounds(289, 28, 88, 99);
				menu3.setBorder(null);
				menu3.setForeground(Color.WHITE);
				menu3.setLayout(null);
				//录屏菜单图标
				JLabel lb3 = new JLabel("");
				lb3.setBounds(13, 10, 60, 60);
				menu3.add(lb3);
				lb3.setIcon(new ImageIcon(this.getClass().getResource("/img/menu3.jpg")));
				//录屏菜单按钮
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
				bgContentPane.add(menu3);			
				
				//广播菜单容器
				JPanel menu4 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu4.setBounds(411, 28, 88, 99);
				menu4.setBorder(null);
				menu4.setForeground(Color.WHITE);
				menu4.setLayout(null);
				//广播菜单图标
				JLabel lb4 = new JLabel("");
				lb4.setBounds(13, 10, 60, 60);
				menu4.add(lb4);
				lb4.setIcon(new ImageIcon(this.getClass().getResource("/img/menu4.jpg")));
				//广播菜单按钮
				JButton button = new JButton("广播");
				button.setBounds(28, 70, 31, 17);
				button.setForeground(new Color(100, 149, 237));
				button.setFont(new Font("宋体", Font.BOLD, 14));
				button.setBorder(null);
				button.setBackground(Color.WHITE);
				menu4.add(button);
				bgContentPane.add(menu4);
				
				//课堂小测菜单容器
				JPanel menu6 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu6.setBounds(661, 28, 88, 99);
				menu6.setBorder(null);
				menu6.setForeground(Color.WHITE);
				menu6.setLayout(null);
				//课堂小测菜单图标
				JLabel lb6 = new JLabel("");
				lb6.setBounds(13, 10, 60, 60);
				menu6.add(lb6);
				lb6.setIcon(new ImageIcon(this.getClass().getResource("/img/menu6.jpg")));
				//课堂小测菜单按钮
				JButton bt6 = new JButton("课堂小测");
				bt6.setBounds(13, 70, 61, 17);
				bt6.setForeground(new Color(100, 149, 237));
				bt6.setFont(new Font("宋体", Font.BOLD, 14));
				bt6.setBorder(null);
				bt6.setBackground(Color.WHITE);
				menu6.add(bt6);
				bgContentPane.add(menu6);
				
				//作业菜单容器
				JPanel menu5 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu5.setBounds(531, 28, 88, 99);
				menu5.setBorder(null);
				menu5.setForeground(Color.WHITE);
				menu5.setLayout(null);
				//作业菜单图标
				JLabel lb5 = new JLabel("");
				lb5.setBounds(13, 10, 60, 60);
				menu5.add(lb5);
				lb5.setIcon(new ImageIcon(this.getClass().getResource("/img/menu5.jpg")));
				//作业菜单按钮
				JButton bt5 = new JButton("作业");
				bt5.setBounds(28, 69, 31, 17);
				bt5.setForeground(new Color(100, 149, 237));
				bt5.setFont(new Font("宋体", Font.BOLD, 14));
				bt5.setBorder(null);
				bt5.setBackground(Color.WHITE);
				menu5.add(bt5);
				bgContentPane.add(menu5);
				
				//资源共享菜单容器
				JPanel menu7 = new JPanel() {
					public void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menubg.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		            }
				};
				menu7.setBounds(785, 28, 88, 99);
				menu7.setBorder(null);
				menu7.setForeground(Color.WHITE);
				menu7.setLayout(null);
				//资源共享菜单图标
				JLabel lb7 = new JLabel("");
				lb7.setBounds(13, 10, 60, 60);
				menu7.add(lb7);
				lb7.setIcon(new ImageIcon(this.getClass().getResource("/img/menu7.jpg")));
				//资源共享菜单按钮
				JButton bt7 = new JButton("资源共享");
				bt7.setBounds(13, 70, 61, 17);
				bt7.setForeground(new Color(100, 149, 237));
				bt7.setFont(new Font("宋体", Font.BOLD, 14));
				bt7.setBorder(null);
				bt7.setBackground(Color.WHITE);
				menu7.add(bt7);
				bgContentPane.add(menu7);
				//从数据库中查找
				JLabel time = new JLabel("<html>第17周<br>大数据设计课</html>");
				time.setBounds(880, 49, 120, 47);
				time.setHorizontalAlignment(SwingConstants.CENTER);
				time.setFont(new Font("宋体", Font.BOLD, 10));
				time.setForeground(SystemColor.textInactiveText);
				bgContentPane.add(time);
				
				centerpl = new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/img1.png"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				centerpl.setBounds(31, 137, 933, 407);
				centerpl.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
				centerpl.setBackground(null);
				centerpl.setLayout(null);
				bgContentPane.add(centerpl);
				bgContentPane.add(centerpl);
				//备忘录菜单
				JPanel menu8 =new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menu8.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				menu8.setBounds(22, 61, 90, 80);
				centerpl.add(menu8);
				menu8.setLayout(null);
				
				JButton bt8 = new JButton("备忘录");
				bt8.setBackground(null);
				bt8.setBounds(10, 47, 70, 23);
				menu8.add(bt8);
				bt8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				bt8.setBorder(null);
				//查询菜单
				JPanel menu9 =new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menu9.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				menu9.setBounds(22, 165, 90, 80);
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
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/menu10.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				menu10.setBounds(22, 269, 90, 80);
				centerpl.add(menu10);
				menu10.setLayout(null);
				//历史记录查询
				JButton bt10 = new JButton("历史记录");
				bt10.setBounds(10, 47, 70, 23);
				bt10.setBorder(null);
				menu10.add(bt10);	
				contentpl =  new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/img1.png"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				contentpl.setBounds(113, 44, 793, 322);
				contentpl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
				centerpl.add(contentpl);
				contentpl.setLayout(null);
				
				//向centerpl中添加控件
				JPanel closepl = new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/btbackground.jpg"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
				closepl.setBounds(113, 14, 104, 30);
				closepl.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("资源共享");
				lblNewLabel_1.setForeground(SystemColor.textInactiveText);
				lblNewLabel_1.setBounds(10, 5, 63, 23);
				closepl.add(lblNewLabel_1);
				
				JButton closebt = new JButton("×");
				closebt.setBounds(80, 5, 23, 23);
				closepl.add(closebt);
//				closebt.addActionListener(new IndexActionListener(getIndex()));
				closebt.setBackground(null);
				closebt.setBorder(null);
				centerpl.add(closepl);
//				JFileChooser jc=new JFileChooser();
//				jc.setBounds(204, 149, 473, 163);
//				contentpl.add(jc);
				
				JLabel title = new JLabel("历 史 资 源");
				title.setForeground(new Color(70, 130, 180));
				title.setFont(new Font("宋体", Font.BOLD, 16));
				title.setHorizontalAlignment(SwingConstants.CENTER);
				title.setBounds(161, 20, 395, 26);
				contentpl.add(title);
				
				JLabel uploads = new JLabel("");
				uploads.setIcon(new ImageIcon("F:\\课程项目\\img\\upload.jpg"));
				uploads.setBounds(659, 10, 124, 36);
				contentpl.add(uploads);
				uploads.addMouseListener(new UploadMouseListener());
				
				JScrollPane scrollPane=new JScrollPane();
				scrollPane.setLocation(47, 64);
				scrollPane.setSize(703, 232);
				scrollPane.setBorder(null);
				contentpl.add(scrollPane);
				
				JPanel text=new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/img1.png"));
		                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		              }
			  };
				text.setBackground(null);
				text.setForeground(new Color(173, 216, 230));
//				text.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				text.setPreferredSize(new Dimension(700, 1000));
				scrollPane.setViewportView(text);
				List<ShareResource> list=ShareResourceDaoImpl.getAllResources();
				for(ShareResource sr:list) {
					JLabel jl=new JLabel("题目："+sr.getOldfile()+"   上传者："+sr.getStu().getSid()+"    时间："+sr.getUploadtime());
					jl.setFont(new Font("宋体", Font.BOLD, 14));
//					jl.setForeground(new Color(119, 136, 153));
					jl.setPreferredSize(new Dimension(700, 45));
					jl.setHorizontalAlignment(SwingConstants.CENTER);
					text.add(jl);
				}
	}
}

package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
/**
 * 
* <p>Title: Index</p>
* <p>Description：登录后所有窗体的创建 </p>
* @author renyuyuan
* @date 2018年12月4日
 */
public class Index extends JFrame {
	/**背景容器*/
	private JPanel bgContentPane;
	/**中间模块容器*/
	private JPanel centerpl;
	/**内容模块容器*/
	private JPanel contentpl; 
	
	/**
	 * <p>Title: getIndex</p>
	 * <p>Description:获得基本窗体 </p>
	 * @return
	 */
	public Index getIndex() {
		return this;
	}
	/**
	 * 
	 * <p>Title: setBackground</p>
	 * <p>Description:设置背景图bgContentPane </p>
	 */
	public void setBackground() {
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
	}
	/**
	 * 
	 * <p>Title: setCenterpl</p>
	 * <p>Description:中间容器设置centerpl </p>
	 */
	public void setCenterpl() {
		centerpl = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
		        ImageIcon ii = new ImageIcon("img/img1.png");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
              }
	  };
		centerpl.setBounds(31, 137, 933, 407);
		centerpl.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		centerpl.setBackground(null);
		centerpl.setLayout(null);
		bgContentPane.add(centerpl);
	}
	/**
	 * 
	 * <p>Title: setContentpl</p>
	 * <p>Description:内容容器设置contentpl </p>
	 */
	public void setContentpl() {
		contentpl =  new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
		        ImageIcon ii = new ImageIcon("img/img1.png");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
              }
	  };
		contentpl.setBounds(113, 44, 793, 322);
		contentpl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		centerpl.add(contentpl);
		contentpl.setLayout(null);
	}
	/**
	 * 
	 * <p>Title: setMenu</p>
	 * <p>Description: 主菜单栏设置（签到 远程监控 录屏 广播 作业 课堂小测 资源共享模块）向bgcontentpl中添加组件</p>
	 */
	public void setMenu() {
		this.setSignMenu();
		this.setRemoteMenu();
		this.setVideoScreen();
		this.setBroadcastingMenu();
		this.setTestMenu();		
		this.setWorkMenu();
		this.setShareMenu();
	}
	
	/**
	 * 
	 * <p>Title: setSignMenu</p>
	 * <p>Description:设置签到菜单 </p>
	 */
	public void setSignMenu() {
		//签到菜单容器
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
		//签到图标
		JLabel lb1 = new JLabel("");
		lb1.setBounds(13, 10, 60, 60);
		menu1.add(lb1);
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setVerticalAlignment(SwingConstants.TOP);
		lb1.setIcon(new ImageIcon("img/menu1.jpg"));
		//签到按钮
		JButton bt1 = new JButton("签到");
		bt1.setBounds(28, 70, 31, 17);
		menu1.add(bt1);
		bt1.setFont(new Font("宋体", Font.BOLD, 14));
		bt1.setForeground(new Color(100, 149, 237));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "请在规定的时间内签到","警告",JOptionPane.ERROR_MESSAGE);
				jumpSign();
			}
		});
		bt1.setBorder(null);
		bt1.setBackground(Color.WHITE);
		bgContentPane.add(menu1);
	}
	
	/**
	 * 
	 * <p>Title: setShareMenu</p>
	 * <p>Description:设置资源共享菜单 </p>
	 */
	public void setShareMenu() {
		//资源共享菜单容器
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
		//资源共享菜单图标
		JLabel lb7 = new JLabel("");
		lb7.setBounds(13, 10, 60, 60);
		menu7.add(lb7);
		lb7.setIcon(new ImageIcon("img/menu7.jpg"));
		//资源共享菜单按钮
		JButton bt7 = new JButton("资源共享");
		bt7.setBounds(13, 70, 61, 17);
		bt7.setForeground(new Color(100, 149, 237));
		bt7.setFont(new Font("宋体", Font.BOLD, 14));
		bt7.setBorder(null);
		bt7.setBackground(Color.WHITE);
		menu7.add(bt7);
		bgContentPane.add(menu7);
	}
	
	
	/**
	 * 
	 * <p>Title: setVideoScreen</p>
	 * <p>Description: 设置录屏菜单</p>
	 */
	public void setVideoScreen() {
		//录屏菜单容器
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
		//录屏菜单图标
		JLabel lb3 = new JLabel("");
		lb3.setBounds(13, 10, 60, 60);
		menu3.add(lb3);
		lb3.setIcon(new ImageIcon("img/menu3.jpg"));
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
	}
	/**
	 * 
	 * <p>Title: setWorkMenu</p>
	 * <p>Description:设置作业菜单 </p>
	 */
	public void setWorkMenu() {
		//作业菜单容器
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
		//作业菜单图标
		JLabel lb5 = new JLabel("");
		lb5.setBounds(13, 10, 60, 60);
		menu5.add(lb5);
		lb5.setIcon(new ImageIcon("img/menu5.jpg"));
		//作业菜单按钮
		JButton bt5 = new JButton("作业");
		bt5.setBounds(28, 69, 31, 17);
		bt5.setForeground(new Color(100, 149, 237));
		bt5.setFont(new Font("宋体", Font.BOLD, 14));
		bt5.setBorder(null);
		bt5.setBackground(Color.WHITE);
		menu5.add(bt5);
		bgContentPane.add(menu5);
	}
	
	/**
	 * 
	 * <p>Title: setTestMenu</p>
	 * <p>Description:设置课堂小测菜单 </p>
	 */
	public void setTestMenu() {
		//课堂小测菜单容器
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
		//课堂小测菜单图标
		JLabel lb6 = new JLabel("");
		lb6.setBounds(13, 10, 60, 60);
		menu6.add(lb6);
		lb6.setIcon(new ImageIcon("img/menu6.jpg"));
		//课堂小测菜单按钮
		JButton bt6 = new JButton("课堂小测");
		bt6.setBounds(13, 70, 61, 17);
		bt6.setForeground(new Color(100, 149, 237));
		bt6.setFont(new Font("宋体", Font.BOLD, 14));
		bt6.setBorder(null);
		bt6.setBackground(Color.WHITE);
		menu6.add(bt6);
		bgContentPane.add(menu6);
	}
	
	
	/**
	 * 
	 * <p>Title: setBroadcastingMenu</p>
	 * <p>Description:设置广播菜单按钮 </p>
	 */
	public void setBroadcastingMenu() {
		//广播菜单容器
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
		//广播菜单图标
		JLabel lb4 = new JLabel("");
		lb4.setBounds(13, 10, 60, 60);
		menu4.add(lb4);
		lb4.setIcon(new ImageIcon("img/menu4.jpg"));
		//广播菜单按钮
		JButton button = new JButton("广播");
		button.setBounds(28, 70, 31, 17);
		button.setForeground(new Color(100, 149, 237));
		button.setFont(new Font("宋体", Font.BOLD, 14));
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		menu4.add(button);
		bgContentPane.add(menu4);
	}
	
	/**
	 * 
	 * <p>Title: setRemoteMenu</p>
	 * <p>Description:设置远程监控菜单 </p>
	 */
	public void setRemoteMenu() {
		//远程监控菜单容器
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
		//远程监控图标
		JLabel lb2 = new JLabel("");
		lb2.setBounds(13, 10, 60, 60);
		menu2.add(lb2);
		lb2.setIcon(new ImageIcon("img/menu2.jpg"));
		//远程监控按钮
		JButton bt2 = new JButton("远程监控");
		bt2.setBounds(13, 70, 61, 17);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpRemote();
			}
		});
		menu2.add(bt2);
		bt2.setForeground(new Color(100, 149, 237));
		bt2.setFont(new Font("宋体", Font.BOLD, 14));
		bt2.setBackground(Color.WHITE);
		bt2.setBorder(null);
		bgContentPane.add(menu2);
	}
	/**
	 * 
	 * <p>Title: setAuxiliaryMenu</p>
	 * <p>Description: 辅助菜单设置（备忘录 查询 历史记录模块）向centerpl中添加组件</p>
	 */
	public void setAuxiliaryMenu() {
		//备忘录菜单
				JPanel menu8 =new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/menu8.jpg");
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
				bgContentPane.setLayout(null);
				bt8.setBorder(null);
				//查询菜单
				JPanel menu9 =new JPanel() {
		            public void paintComponent(Graphics g) {
		            	super.paintComponent(g);
				        ImageIcon ii = new ImageIcon("img/menu9.jpg");
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
				        ImageIcon ii = new ImageIcon("img/menu10.jpg");
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
	}
	/**
	 * 
	 * <p>Title: setTime</p>
	 * <p>Description:时间标志，在数据库中查找第几周***课 </p>
	 */
	public void setTime() {
		//从数据库中查找
		JLabel time = new JLabel("第*周*****课");
		time.setBounds(904, 49, 72, 47);
		bgContentPane.add(time);
	}
	/**
	 * 
	 * <p>Title: init</p>
	 * <p>Description:  初始化基本窗体</p>
	 */
	public void init() {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
	}
	/**
	 * 
	 * <p>Title: setSign</p>
	 * <p>Description: 设置签到界面，向centerpl中添加控件 </p>
	 */
	public void setSign() {
		//向centerpl中添加控件
		JPanel closepl = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
		        ImageIcon ii = new ImageIcon("img/btbackground.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
              }
	  };
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
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
					init();
			}
		});
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);
	}
	/**
	 * 
	 * <p>Title: setRemote</p>
	 * <p>Description:设置远程监控页面，向centerpl中添加控件，向contentpl中添加控件 </p>
	 */
	public void setRemote() {
		//向centerpl中添加控件
		JPanel closepl = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
		        ImageIcon ii = new ImageIcon("img/btbackground.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
              }
	  };
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
		closepl.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("远程监控");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 5, 63, 23);
		closepl.add(lblNewLabel_1);
		
		JButton closebt = new JButton("×");
		closebt.setBounds(80, 5, 23, 23);
		closepl.add(closebt);
		closebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init();
			}
		});
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);
		//向contentpl中添加控件
		JButton remortbt = new JButton("开启远程监控");
		remortbt.setForeground(SystemColor.textInactiveText);
		remortbt.setFont(new Font("宋体", Font.PLAIN, 14));
		remortbt.setBounds(66, 93, 129, 31);
		remortbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "请在规定的时间内开启远程监控","警告",JOptionPane.ERROR_MESSAGE);
				ConnectRemind cr=new ConnectRemind();
				cr.init();
			}
		});
		contentpl.add(remortbt);
		
		JButton sharebt = new JButton("共享屏幕");
		sharebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sharebt.setForeground(SystemColor.textInactiveText);
		sharebt.setFont(new Font("宋体", Font.PLAIN, 14));
		sharebt.setBounds(66, 186, 129, 31);
		contentpl.add(sharebt);
		

		JPanel chatpl = new JPanel();
		chatpl.setBackground(SystemColor.inactiveCaption);
		chatpl.setBounds(227, 39, 499, 258);
		contentpl.add(chatpl);
		chatpl.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setBounds(278, 225, 115, 22);
		chatpl.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("发送");
		btnNewButton.setBounds(397, 224, 74, 22);
		chatpl.add(btnNewButton);
		
		JLabel chatlog2 = new JLabel("11111");
		chatlog2.setBackground(SystemColor.textInactiveText);
		chatlog2.setBounds(90, 34, 54, 15);
		chatpl.add(chatlog2);
		
		JLabel chatlog1 = new JLabel("2222");
		chatlog1.setBackground(SystemColor.textInactiveText);
		chatlog1.setBounds(291, 34, 54, 15);
		chatpl.add(chatlog1);
//		bgContentPane.add(centerpl);
	}
	/**
	 * 
	 * <p>Title: jumpSign</p>
	 * <p>Description:转到签到界面 </p>
	 */
	public void jumpSign() {
		this.setBackground();
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setSign();
	}
	/**
	 * 
	 * <p>Title: jumpRemote</p>
	 * <p>Description:转到远程监控界面 </p>
	 */
	public void jumpRemote() {
		this.setBackground();
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setRemote();
	}
	/**
	 * 主窗体创建
	 */
	public Index() {
		/**
		 * 窗体设置
		 * */
		//设置窗体大小
		this.setBounds(0, 0, 1000, 600);
		//窗体大小不能改变
		this.setResizable(false);
		//居中显示
		this.setLocationRelativeTo(null);
		//设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\课程项目\\img\\logo2.jpg"));
		//设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//窗体可见
		this.setVisible(true);
	}
}

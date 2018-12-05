package com.entity;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JComboBox;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Component;

/**
 * 
* <p>Title: Index</p>
* <p>Description:教师端主页面，显示学生签到请假信息 </p>
* @author Luan Xiaoyue
* @date 2018年12月5日
 */
public class Index extends JFrame {

	private JPanel bgContentPane;
	private JTable table_1;
	private JTable table_2;
	private JPanel menu1;
	private JPanel menu2;
	private JPanel menu3;
	private JPanel menu4;
	private JPanel menu5;
	private JPanel menu6;
	private JPanel menu7;
	private JPanel menu8;
	private JPanel menu9;
	private JPanel menu10;
	private JPanel lmenu1;
	private JPanel lmenu2;
	private JPanel lmenu3;
	private JPanel lmenu4;
	private JPanel lmenu5;
	private JLabel lblNewLabel;
	private JPanel centerpl;
	private JPanel panel_5;
	private GroupLayout gl_bgContentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 设置背景图
	 */
	public void setBackground() {
		bgContentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("img/background.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		bgContentPane.setBackground(Color.WHITE);
		bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(bgContentPane);
	}
	
	/**
	 * 中间容器设置
	 */
	public void centerPanel() {
		centerpl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// ImageIcon ii = new ImageIcon("img/img1.png");
				// g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(),
				// ii.getImageObserver());
			}
		};
		centerpl.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		centerpl.setBackground(null);
		centerpl.setLayout(null);
	}
	/**
	 * 
	 * <p>Title: centerContent</p>
	 * <p>Description:中间内容页，显示学生签到请假情况 </p>
	 */
	public void centerContent() {
		final Object[] columnNames = { "姓名", "学号", "签到", "迟到", "旷课", "请假" };
		Object[][] rowData = { { "ddd", "男", "江苏南京", "1378313210", "03/24/1985", "" },
				{ "eee", "女", "江苏南京", "13645181705", "xx/xx/1985", "家教" },
				{ "fff", "男", "江苏南京", "13585331486", "12/08/1985", "汽车推销员" },
				{ "ggg", "女", "江苏南京", "81513779", "xx/xx/1986", "宾馆服务员" },
				{ "hhh", "男", "江苏南京", "13651545936", "xx/xx/1985", "学生", "流放中" } };
		table_1 = new JTable(rowData, columnNames);
		table_1.setBounds(1, 32, 907, 150);
		table_1.setFont(new Font("宋体", Font.PLAIN, 16));
		table_1.setRowHeight(30);// 设置每行的高度
		table_1.setRowMargin(5);// 设置相邻两行单元格的距离
		table_1.setShowHorizontalLines(true);// 是否显示水平的网格线
		table_1.setRowHeight(0, 50);
		centerpl.setLayout(null);
		centerpl.add(table_1);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(0, 0, 909, 338);
		scrollPane.setEnabled(false);
		centerpl.add(scrollPane);

		// 请假条滚动表格设置
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(0, 338, 907, 238);
		centerpl.add(scrollPane_1);

		final Object[] columnNames2 = { "姓名", "学号", "时间", "请假条" };
		Object[][] rowData2 = { { "ddd", "男", "江苏南京", "1378313210" }, { "eee", "女", "江苏南京", "13645181705" },
				{ "fff", "男", "江苏南京", "13585331486" }, { "ggg", "女", "江苏南京", "81513779" },
				{ "hhh", "男", "江苏南京", "13651545936" } };

		table_2 = new JTable(rowData2, columnNames2);
		table_2.setFont(new Font("宋体", Font.PLAIN, 16));
		table_2.setRowHeight(100);// 设置每行的高度
		table_2.setRowMargin(5);// 设置相邻两行单元格的距离
		table_2.setShowHorizontalLines(true);// 是否显示水平的网格线
		scrollPane_1.setViewportView(table_2);
		bgContentPane.setLayout(gl_bgContentPane);
		// 设置窗体大小
		this.setBounds(0, 0, 1282, 771);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\logo1.png"));
		// 窗体可见
		this.setVisible(true);
	}
	
	/**
	 * 
	 * <p>Title: topMenu</p>
	 * <p>Description:顶部菜单栏函数（远程控制、录屏、广播、学生演示、随机点名、分组教学、课堂小测、发布作业、课堂反馈、资源共享） </p>
	 */
	public void topMenu() {
		// 远程控制菜单
				menu1 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu1.setLayout(null);
				menu1.setForeground(Color.WHITE);
				menu1.setBorder(null);
				JLabel label = new JLabel("");
				label.setIcon(
						new ImageIcon("E:\\\\eclipse-jee-oxygen-2-win32-x86_64\\\\eclipse-workspace\\\\jxfz\\\\img\\yckz.png"));
				label.setBounds(13, 10, 60, 60);
				menu1.add(label);
				// 按钮
				JButton button_1 = new JButton("\u8FDC\u7A0B\u76D1\u63A7");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_1.setForeground(new Color(100, 149, 237));
				button_1.setFont(new Font("宋体", Font.BOLD, 18));
				button_1.setBorder(null);
				button_1.setBackground(Color.WHITE);
				button_1.setBounds(0, 70, 88, 16);
				menu1.add(button_1);
				// 下拉菜单
				JComboBox comboBox = new JComboBox();
				comboBox.setName("");
				comboBox.setBounds(0, 94, 88, 16);

				comboBox.setEditable(true);

				comboBox.setEnabled(true);
				comboBox.addItem("");
				comboBox.addItem("开启");
				comboBox.addItem("关闭");
				comboBox.addItem("开启共享");
				comboBox.addItem("关闭共享");

				comboBox.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == e.SELECTED) {
							while (comboBox.getSelectedItem() == "开启") {
								// 事件
							}

						}
					}

				});
				menu1.add(comboBox);
				// 录屏菜单
				menu2 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu2.setLayout(null);
				menu2.setForeground(Color.WHITE);
				menu2.setBorder(null);

				JLabel label_4 = new JLabel("");
				label_4.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\lp.png"));
				label_4.setBounds(14, 13, 61, 58);
				menu2.add(label_4);
				// 录屏按钮
				JButton button_7 = new JButton("\u5F55\u5C4F");
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_7.setForeground(new Color(100, 149, 237));
				button_7.setFont(new Font("宋体", Font.BOLD, 18));
				button_7.setBorder(null);
				button_7.setBackground(Color.WHITE);
				button_7.setBounds(0, 70, 88, 16);
				menu2.add(button_7);
				// 录屏下拉菜单
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setName("");
				comboBox_1.setEnabled(true);
				comboBox_1.setEditable(true);
				comboBox_1.setBounds(10, 94, 64, 16);
				comboBox_1.addItem("");
				comboBox_1.addItem("开启");
				comboBox_1.addItem("关闭");
				menu2.add(comboBox_1);
				// 广播菜单
				menu3 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu3.setLayout(null);
				menu3.setForeground(Color.WHITE);
				menu3.setBorder(null);

				JLabel label_5 = new JLabel("");
				label_5.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\gb.png"));
				label_5.setBounds(14, 0, 60, 67);
				menu3.add(label_5);
				// 广播按钮
				JButton button_8 = new JButton("\u5E7F\u64AD");
				button_8.setForeground(new Color(100, 149, 237));
				button_8.setFont(new Font("宋体", Font.BOLD, 18));
				button_8.setBorder(null);
				button_8.setBackground(Color.WHITE);
				button_8.setBounds(0, 70, 88, 16);
				menu3.add(button_8);
				// 广播下拉菜单
				JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setName("");
				comboBox_2.setEnabled(true);
				comboBox_2.setEditable(true);
				comboBox_2.setBounds(10, 94, 64, 16);
				comboBox_2.addItem("");
				comboBox_2.addItem("开启");
				comboBox_2.addItem("关闭");
				menu3.add(comboBox_2);
				// 学生演示菜单
				menu4 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu4.setLayout(null);
				menu4.setForeground(Color.WHITE);
				menu4.setBorder(null);

				JLabel label_6 = new JLabel("");
				label_6.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\xsys.png"));
				label_6.setBounds(13, 10, 60, 60);
				menu4.add(label_6);
				// 学生演示按钮
				JButton button = new JButton("\u5B66\u751F\u6F14\u793A");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jumpSelectstu();
					}
				});
				button.setForeground(new Color(100, 149, 237));
				button.setFont(new Font("宋体", Font.BOLD, 18));
				button.setBorder(null);
				button.setBackground(Color.WHITE);
				button.setBounds(0, 70, 88, 16);
				menu4.add(button);
				// 随机点名菜单
				menu5 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu5.setLayout(null);
				menu5.setForeground(Color.WHITE);
				menu5.setBorder(null);

				JLabel label_7 = new JLabel("");
				label_7.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\sjdm.png"));
				label_7.setBounds(13, 10, 60, 60);
				menu5.add(label_7);
				// 随机点名按钮
				JButton button_9 = new JButton("\u968F\u673A\u70B9\u540D");
				button_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_9.setForeground(new Color(100, 149, 237));
				button_9.setFont(new Font("宋体", Font.BOLD, 18));
				button_9.setBorder(null);
				button_9.setBackground(Color.WHITE);
				button_9.setBounds(0, 70, 88, 16);
				menu5.add(button_9);
				// 分组教学菜单
				menu6 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu6.setLayout(null);
				menu6.setForeground(Color.WHITE);
				menu6.setBorder(null);

				JLabel label_8 = new JLabel("");
				label_8.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\fzjx.png"));
				label_8.setBounds(13, 10, 60, 60);
				menu6.add(label_8);
				// 分组教学按钮
				JButton button_10 = new JButton("\u5206\u7EC4\u6559\u5B66");
				button_10.setForeground(new Color(100, 149, 237));
				button_10.setFont(new Font("宋体", Font.BOLD, 18));
				button_10.setBorder(null);
				button_10.setBackground(Color.WHITE);
				button_10.setBounds(0, 70, 88, 16);
				menu6.add(button_10);
				// 课堂小测菜单
				menu7 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu7.setLayout(null);
				menu7.setForeground(Color.WHITE);
				menu7.setBorder(null);

				JLabel label_9 = new JLabel("");
				label_9.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\ktxc.png"));
				label_9.setBounds(13, 10, 60, 60);
				menu7.add(label_9);
				// 课堂小测按钮
				JButton button_11 = new JButton("\u8BFE\u5802\u5C0F\u6D4B");
				button_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_11.setForeground(new Color(100, 149, 237));
				button_11.setFont(new Font("宋体", Font.BOLD, 18));
				button_11.setBorder(null);
				button_11.setBackground(Color.WHITE);
				button_11.setBounds(0, 70, 88, 16);
				menu7.add(button_11);
				// 发布作业菜单
				menu8 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu8.setLayout(null);
				menu8.setForeground(Color.WHITE);
				menu8.setBorder(null);

				JLabel label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\fbzy.png"));
				label_1.setBounds(13, 10, 60, 60);
				menu8.add(label_1);
				// 发布作业按钮
				JButton button_2 = new JButton("\u53D1\u5E03\u4F5C\u4E1A");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_2.setForeground(new Color(100, 149, 237));
				button_2.setFont(new Font("宋体", Font.BOLD, 18));
				button_2.setBorder(null);
				button_2.setBackground(Color.WHITE);
				button_2.setBounds(0, 70, 88, 16);
				menu8.add(button_2);
				// 课堂反馈菜单
				 menu9 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu9.setLayout(null);
				menu9.setForeground(Color.WHITE);
				menu9.setBorder(null);

				JLabel label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\ktfk.png"));
				label_2.setBounds(13, 10, 60, 60);
				menu9.add(label_2);
				// 课堂反馈按钮
				JButton button_3 = new JButton("\u8BFE\u5802\u53CD\u9988");
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_3.setForeground(new Color(100, 149, 237));
				button_3.setFont(new Font("宋体", Font.BOLD, 18));
				button_3.setBorder(null);
				button_3.setBackground(Color.WHITE);
				button_3.setBounds(0, 70, 88, 16);
				menu9.add(button_3);
				// 资源共享菜单
				menu10 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				menu10.setLayout(null);
				menu10.setForeground(Color.WHITE);
				menu10.setBorder(null);

				JLabel label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\zygx.png"));
				label_3.setBounds(13, 10, 60, 60);
				menu10.add(label_3);
				// 资源共享按钮
				JButton button_4 = new JButton("\u8D44\u6E90\u5171\u4EAB");
				button_4.setForeground(new Color(100, 149, 237));
				button_4.setFont(new Font("宋体", Font.BOLD, 18));
				button_4.setBorder(null);
				button_4.setBackground(Color.WHITE);
				button_4.setBounds(0, 70, 88, 16);
				menu10.add(button_4);
	}
	/**
	 * 
	 * <p>Title: leftMenu</p>
	 * <p>Description:左侧菜单栏函数（学生签到、小测成绩、学生作业、备忘录） </p>
	 */
	public void leftMenu() {
		// 学生签到信息
				lmenu1 = new JPanel() {
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						ImageIcon ii = new ImageIcon("img/menu8.jpg");
						g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
					}
				};
				lmenu1.setBackground(new Color(176, 196, 222));
				lmenu1.setLayout(null);
				// 按钮
				JButton bt8 = new JButton("\u7B7E\u5230\u4FE1\u606F");
				bt8.setBackground(null);
				bt8.setBounds(0, 57, 90, 23);
				lmenu1.add(bt8);
				bt8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jumpIndex();		
					}
				});
				bt8.setBorder(null);

				JLabel label_11 = new JLabel("");
				label_11.setIcon(
						new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\left.png"));
				label_11.setBounds(28, 0, 62, 55);
				lmenu1.add(label_11);
				lmenu1.setLayout(null);
				// 课堂加分
				lmenu2 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				lmenu2.setLayout(null);
				// 按钮
				JButton button_12 = new JButton("\u8BFE\u5802\u52A0\u5206");
				button_12.setBorder(null);
				button_12.setBounds(0, 57, 90, 23);
				lmenu2.add(button_12);
				// 小测成绩
				lmenu3 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				lmenu3.setLayout(null);
				// 按钮
				JButton button_13 = new JButton("\u5C0F\u6D4B\u6210\u7EE9");
				button_13.setBorder(null);
				button_13.setBounds(0, 57, 90, 23);
				lmenu3.add(button_13);

				JLabel label_10 = new JLabel("");
				label_10.setIcon(
						new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\left.png"));
				label_10.setBounds(28, 0, 62, 55);
				lmenu2.add(label_10);

				JLabel label_12 = new JLabel("");
				label_12.setIcon(
						new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\left.png"));
				label_12.setBounds(28, 0, 62, 55);
				lmenu3.add(label_12);
				// 学生作业
				lmenu4 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				lmenu4.setLayout(null);
				// 按钮
				JButton button_5 = new JButton("\u5B66\u751F\u4F5C\u4E1A");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				button_5.setBorder(null);
				button_5.setBounds(0, 57, 90, 23);
				lmenu4.add(button_5);

				JLabel label_13 = new JLabel("");
				label_13.setIcon(
						new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\left.png"));
				label_13.setBounds(28, 0, 62, 55);
				lmenu4.add(label_13);
				// 备忘录
				lmenu5 = new JPanel() {
					public void paintComponent(Graphics g) {
					}
				};
				lmenu5.setLayout(null);
				// 按钮
				JButton button_6 = new JButton("\u5907\u5FD8\u5F55");
				button_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button_6.setBorder(null);
				button_6.setBounds(0, 57, 90, 23);
				lmenu5.add(button_6);

				JLabel label_14 = new JLabel("");
				label_14.setIcon(
						new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\left.png"));
				label_14.setBounds(28, 0, 62, 55);
				lmenu5.add(label_14);
	}
	/**
	 * 
	 * <p>Title: chatView</p>
	 * <p>Description:师生聊天窗口 </p>
	 */
	public void chatView() {
		panel_5 = new JPanel() {
			public void paintComponent(Graphics g) {
			}
		};
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		panel_5.setBackground((Color) null);
		// 师生对话框
		Label label_15 = new Label("\u804A\u5929\u6846");
		label_15.setBackground(new Color(173, 216, 230));
		label_15.setBounds(10, 10, 217, 387);
		panel_5.add(label_15);
		// 音量调节框
		Label label_16 = new Label("\u97F3\u91CF\u8C03\u8282\u6846");
		label_16.setBackground(new Color(245, 255, 250));
		label_16.setBounds(10, 441, 217, 125);
		panel_5.add(label_16);
		
		textField = new JTextField();
		textField.setText("\u4E0A\u8BFE\u8282\u594F\u662F\u5426\u592A\u5FEB");
		textField.setBounds(10, 411, 156, 24);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u53D1\u9001");
		button.setBounds(168, 410, 69, 27);
		panel_5.add(button);
	}
	/**
	 * 
	 * <p>Title: setTime</p>
	 * <p>Description:时间标志 </p>
	 */
	public void setTime() {
		 lblNewLabel = new JLabel("第*周*****课");
	}
	/**
	 * 
	 * <p>Title: setGroupLayout</p>
	 * <p>Description:整体布局设置 </p>
	 */
	public void setGroupLayout() {
		 gl_bgContentPane = new GroupLayout(bgContentPane);
			gl_bgContentPane.setHorizontalGroup(gl_bgContentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_bgContentPane.createSequentialGroup().addContainerGap()
							.addGroup(gl_bgContentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lmenu1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lmenu4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lmenu5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lmenu3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lmenu2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(
									ComponentPlacement.RELATED)
							.addGroup(gl_bgContentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_bgContentPane.createSequentialGroup()
											.addComponent(menu2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menu3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menu4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menu5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menu6, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(menu7, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menu8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(menu9, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(menu10,
													GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
									.addComponent(centerpl, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE))
							.addGroup(
									gl_bgContentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_bgContentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
													.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 123,
															Short.MAX_VALUE)
													.addGap(34))
											.addGroup(gl_bgContentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_5,
															GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))));
			gl_bgContentPane.setVerticalGroup(gl_bgContentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_bgContentPane.createSequentialGroup().addGroup(gl_bgContentPane
							.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_bgContentPane.createSequentialGroup().addGap(58).addComponent(lblNewLabel,
									GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_bgContentPane.createSequentialGroup().addContainerGap().addGroup(gl_bgContentPane
									.createParallelGroup(Alignment.LEADING, false)
									.addComponent(menu4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu5, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu7, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu6, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu8, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu9, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu10, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(menu1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
									.addComponent(menu2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(menu3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addGroup(
									gl_bgContentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_bgContentPane.createSequentialGroup()
													.addComponent(lmenu1, GroupLayout.PREFERRED_SIZE, 80,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lmenu2, GroupLayout.PREFERRED_SIZE, 80,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lmenu3, GroupLayout.PREFERRED_SIZE, 80,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lmenu4, GroupLayout.PREFERRED_SIZE, 80,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED).addComponent(lmenu5,
															GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
											.addComponent(centerpl, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
											.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE))
							.addContainerGap()));
	}

	/**
	 * 
	 * <p>Title: jumpIndex</p>
	 * <p>Description: 跳转学生签到主页面</p>
	 */
	public void jumpIndex() {
		topMenu();
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		//时间标志
		setTime();
		//中间容器
		centerPanel();	
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 内容设置
		centerContent();
	}
	/**
	 * 跳转学生演示界面
	 */
	//学生演示内容页
	public void selectstuContent() {
		JButton button = new JButton("\u59D3\u540D");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpStuPre();

			}
		});
		button.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\stu.png"));
		button.setForeground(new Color(100, 149, 237));
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBorder(UIManager.getBorder("Button.border"));
		button.setBackground(Color.WHITE);
		button.setBounds(14, 13, 151, 75);
		centerpl.add(button);
		
		JButton button_1 = new JButton("\u59D3\u540D");
		button_1.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\stu.png"));
		button_1.setHorizontalAlignment(SwingConstants.LEADING);
		button_1.setForeground(new Color(100, 149, 237));
		button_1.setFont(new Font("宋体", Font.BOLD, 18));
		button_1.setBorder(UIManager.getBorder("Button.border"));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(179, 13, 151, 75);
		centerpl.add(button_1);
		
		JButton button_2 = new JButton("\u59D3\u540D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\stu.png"));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(new Color(100, 149, 237));
		button_2.setFont(new Font("宋体", Font.BOLD, 18));
		button_2.setBorder(UIManager.getBorder("Button.border"));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(344, 13, 159, 75);
		centerpl.add(button_2);
		
		JButton button_3 = new JButton("\u59D3\u540D");
		button_3.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\stu.png"));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setForeground(new Color(100, 149, 237));
		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		button_3.setBorder(UIManager.getBorder("Button.border"));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(517, 13, 159, 75);
		centerpl.add(button_3);
		
		JButton button_4 = new JButton("\u59D3\u540D");
		button_4.setIcon(new ImageIcon("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\stu.png"));
		button_4.setHorizontalAlignment(SwingConstants.LEFT);
		button_4.setForeground(new Color(100, 149, 237));
		button_4.setFont(new Font("宋体", Font.BOLD, 18));
		button_4.setBorder(UIManager.getBorder("Button.border"));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(690, 13, 159, 75);
		centerpl.add(button_4);
		
		bgContentPane.setLayout(gl_bgContentPane);
		// 设置窗体大小
		this.setBounds(0, 0, 1282, 771);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\logo1.png"));
		// 窗体可见
		this.setVisible(true);
	
	}
	public void jumpSelectstu() {
		topMenu();
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		//时间标志
		setTime();
		//中间容器
		centerPanel();	
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 内容设置
		selectstuContent();
	}
	/**
	 * 跳转选中学生桌面
	 */
	//选中学生桌面内容页
	public void stuPreContent() {
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpSelectstu();
			}
		});
		button.setForeground(new Color(100, 149, 237));
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBorder(null);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(852, 0, 57, 21);
		
		centerpl.add(button);
		
		bgContentPane.setLayout(gl_bgContentPane);
		// 设置窗体大小
		this.setBounds(0, 0, 1282, 771);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse-workspace\\jxfz\\img\\logo1.png"));
		// 窗体可见
		this.setVisible(true);
	}
	public void jumpStuPre() {
		topMenu();
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		//时间标志
		setTime();
		//中间容器
		centerPanel();	
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 内容设置
		stuPreContent();
	}
	
	/**
	 * Create the frame.
	 */
	public Index() {
		topMenu();
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		//时间标志
		setTime();
		//中间容器
		centerPanel();	
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 学生信息滚动表格设置
		centerContent();

	}
}

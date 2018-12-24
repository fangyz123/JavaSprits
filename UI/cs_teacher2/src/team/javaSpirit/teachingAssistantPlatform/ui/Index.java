package team.javaSpirit.teachingAssistantPlatform.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import team.javaSpirit.teachingAssistantPlatform.ui.event.MyItemListener;

/**
 * 
 * <p>
 * Title: Index
 * </p>
 * <p>
 * Description:教师端主页面，显示学生签到请假信息
 * </p>
 * 
 * @author Luan Xiaoyue，Fang Yuzhen
 * @date 2018年12月5日
 */
public class Index extends JFrame {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/* 背景面板 */
	private JPanel bgContentPane;
	/* 显示学生签到情况的标签 */
	private JTable table_1;
	/* 显示学生请假情况的标签 */
	private JTable table_2;
	/* 远程控制菜单 */
	private JPanel menu1;
	/* 录屏菜单 */
	private JPanel menu2;
	/* 广播菜单 */
	private JPanel menu3;
	/* 学生演示菜单 */
	private JPanel menu4;
	/* 随机点名菜单 */
	private JPanel menu5;
	/* 分组教学菜单 */
	private JPanel menu6;
	/* 课堂小测菜单 */
	private JPanel menu7;
	/* 发布作业菜单 */
	private JPanel menu8;
	/* 课堂反馈菜单 */
	private JPanel menu9;
	/* 资源共享菜单 */
	private JPanel menu10;
	/* 学生签到信息菜单 */
	private JPanel lmenu1;
	/* 课堂加分菜单 */
	private JPanel lmenu2;
	/* 小测成绩菜单 */
	private JPanel lmenu3;
	/* 学生作业菜单 */
	private JPanel lmenu4;
	/* 备忘录菜单 */
	private JPanel lmenu5;
	/* 显示当前是第几周是什么课的文本标签 */
	private JLabel lblNewLabel;
	/* 中间内容页容器 */
	private JPanel centerpl;
	/* 左侧聊天窗口面板 */
	private JPanel panel_5;
	/* 界面总的容器 */
	private GroupLayout gl_bgContentPane;
	/* 左侧聊天文本编辑框 */
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * <p>
	 * Title: setBackground
	 * </p>
	 * <p>
	 * Description: 设置背景图的位置，宽和高。
	 * </p>
	 */
	public void setBackground() {
		
			bgContentPane = new JPanel() {
	            public void paintComponent(Graphics g) {
	            	super.paintComponent(g);
			        ImageIcon ii = new ImageIcon("image/background.png");
	                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
	              }
		  };
		  bgContentPane.setBounds(0, 0, 100, 1000);
		  bgContentPane.setBorder(null);
		  this.setContentPane(bgContentPane);
	}

	/**
	 * <p>
	 * Title: setRemotecontrol
	 * </p>
	 * <p>
	 * Description: 设置远程控制菜单面板，有标记图和下拉菜单。
	 * </p>
	 */
	public void setRemotecontrol() {
		// 创建一个远程控制面板对象
		menu1 = new JPanel();
		menu1.setLayout(null);
		menu1.setForeground(Color.WHITE);
		menu1.setBorder(null);
		menu1.setOpaque(false);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("image\\yckz.png"));
		label.setBounds(13, 10, 60, 60);
		// 面板添加图片标签label
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
		// 下拉菜单，里面的值是String类型
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(0, 94, 88, 16);
		comboBox.setEditable(true);
		comboBox.setEnabled(true);
		// 为下拉菜单添加选项
		comboBox.addItem("请选择......");
		comboBox.addItem("开启");
		comboBox.addItem("关闭");
		comboBox.addItem("开启共享");
		comboBox.addItem("关闭共享");
		// 监听下拉框的选择事件
		comboBox.addItemListener(new MyItemListener(comboBox) {
		});
		// 面板添加下拉菜单comboBox
		menu1.add(comboBox);
	}

	/**
	 * <p>
	 * Title: setRecordScreen
	 * </p>
	 * <p>
	 * Description: 设置录屏菜单面板，有标记图和下拉菜单。
	 * </p>
	 */
	public void setRecordScreen() {
		// 录屏菜单
		menu2 = new JPanel();
		menu2.setLayout(null);
		menu2.setForeground(Color.WHITE);
		menu2.setBorder(null);
		menu2.setOpaque(false);
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("image\\lp.png"));
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
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(true);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(10, 94, 64, 16);
		comboBox_1.addItem("请选择");
		comboBox_1.addItem("开启");
		comboBox_1.addItem("关闭");
		menu2.add(comboBox_1);
	}

	/**
	 * <p>
	 * Title: setBroadcast
	 * </p>
	 * <p>
	 * Description: 设置广播菜单面板，有标记图和下拉菜单。
	 * </p>
	 */
	public void setBroadcast() {
		menu3 = new JPanel();
		menu3.setLayout(null);
		menu3.setForeground(Color.WHITE);
		menu3.setBorder(null);
		menu3.setOpaque(false);
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("image\\gb.png"));
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
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setEnabled(true);
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(10, 94, 64, 16);
		comboBox_2.addItem("请选择");
		comboBox_2.addItem("开启");
		comboBox_2.addItem("关闭");
		menu3.add(comboBox_2);
	}

	/**
	 * <p>
	 * Title: setStuzs
	 * </p>
	 * <p>
	 * Description: 设置学生演示菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setStuzs() {
		// 学生演示菜单
		menu4 = new JPanel();
		menu4.setLayout(null);
		menu4.setForeground(Color.WHITE);
		menu4.setBorder(null);
		menu4.setOpaque(false);
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("image\\xsys.png"));
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
	}

	/**
	 * <p>
	 * Title: setRandomcall
	 * </p>
	 * <p>
	 * Description: 设置随机点名菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setRandomcall() {
		// 随机点名菜单
		menu5 = new JPanel();
		menu5.setLayout(null);
		menu5.setForeground(Color.WHITE);
		menu5.setBorder(null);
		menu5.setOpaque(false);
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("image\\sjdm.png"));
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
	}

	/**
	 * <p>
	 * Title: setGroup
	 * </p>
	 * <p>
	 * Description: 设置分组教学菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setGroup() {
		// 分组教学菜单
		menu6 = new JPanel();
		menu6.setLayout(null);
		menu6.setForeground(Color.WHITE);
		menu6.setBorder(null);
		menu6.setOpaque(false);
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("image\\fzjx.png"));
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
	}

	/**
	 * <p>
	 * Title: setClasstest
	 * </p>
	 * <p>
	 * Description: 设置课堂小测菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setClasstest() {
		// 课堂小测菜单
		menu7 = new JPanel();
		menu7.setLayout(null);
		menu7.setForeground(Color.WHITE);
		menu7.setBorder(null);
		menu7.setOpaque(false);
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("image\\ktxc.png"));
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
	}

	/**
	 * <p>
	 * Title: setReleasejob
	 * </p>
	 * <p>
	 * Description: 设置发布作业菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setReleasejob() {
		// 发布作业菜单
		menu8 = new JPanel();
		menu8.setLayout(null);
		menu8.setForeground(Color.WHITE);
		menu8.setBorder(null);
		menu8.setOpaque(false);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("image\\fbzy.png"));
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
	}

	/**
	 * <p>
	 * Title: setReleasejob
	 * </p>
	 * <p>
	 * Description: 设置教学反馈菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setTeachback() {
		// 课堂反馈菜单
		menu9 = new JPanel();
		menu9.setLayout(null);
		menu9.setForeground(Color.WHITE);
		menu9.setBorder(null);
		menu9.setOpaque(false);
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("image\\ktfk.png"));
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
	}

	/**
	 * <p>
	 * Title: setReleasejob
	 * </p>
	 * <p>
	 * Description: 设置资源分享菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setResourcesharing() {
		// 资源共享菜单
		menu10 = new JPanel();
		menu10.setLayout(null);
		menu10.setForeground(Color.WHITE);
		menu10.setBorder(null);
		menu10.setOpaque(false);
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("image\\zygx.png"));
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
	 * 中间内容底部容器设置
	 */
	public void centerPanel() {
		centerpl = new JPanel();
		centerpl.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		centerpl.setBackground(null);
		centerpl.setLayout(null);
	}

	/**
	 * 
	 * <p>
	 * Title: centerContent
	 * </p>
	 * <p>
	 * Description:中间内容页，显示学生签到请假情况
	 * </p>
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
		this.setBounds(0, 0, 1282, 700);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		// 窗体可见
		this.setVisible(true);
	}

	/**
	 * 
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description: 初始所有的标签、容器、内容
	 * </p>
	 */
	public void init() {
		topMenu();
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		// 时间标志
		setTime();
		// 中间容器
		centerPanel();
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 学生信息滚动表格设置
		centerContent();
	}

	/**
	 * <p>
	 * Title: topMenu
	 * </p>
	 * <p>
	 * Description: 顶部菜单栏函数。 调用远程控制、录屏、广播、学生演示、随机点名、分组教学、 课堂小测、发布作业、课堂反馈、资源共享的设置函数。
	 * </p>
	 */
	public void topMenu() {
		// 添加远程控制面板
		this.setRemotecontrol();
		// 广播菜单
		this.setBroadcast();
		// 添加录屏面板
		this.setRecordScreen();
		// 添加学生演示菜单
		this.setStuzs();
		// 添加随机点名菜单
		this.setRandomcall();
		// 添加分组教学菜单
		this.setGroup();
		// 添加课堂小测菜单
		this.setClasstest();
		// 添加发布作业菜单
		this.setReleasejob();
		// 添加课堂反馈菜单
		this.setTeachback();
		// 添加资源共享菜单
		this.setResourcesharing();
	}

	/**
	 * <p>
	 * Title: setStusign
	 * </p>
	 * <p>
	 * Description: 设置学生签到菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setStusign() {
		// 学生签到信息
		lmenu1 = new JPanel();
		lmenu1.setBackground(new Color(176, 196, 222));
		lmenu1.setLayout(null);
		lmenu1.setOpaque(false);
		// 按钮
		JButton bt8 = new JButton("\u7B7E\u5230\u4FE1\u606F");
		
		//bt8.setBackground(null);
		bt8.setBounds(0, 57, 90, 23);
		lmenu1.add(bt8);
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpIndex();
			}
		});
		bt8.setBorder(null);

		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("image\\left.png"));
		label_11.setBounds(28, 0, 62, 55);
		lmenu1.add(label_11);
		lmenu1.setLayout(null);
	}

	/**
	 * <p>
	 * Title: setClassbonus
	 * </p>
	 * <p>
	 * Description: 设置课堂加分菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setClassbonus() {
		// 课堂加分
		lmenu2 = new JPanel();
		lmenu2.setLayout(null);
		lmenu2.setOpaque(false);
		// 按钮
		JButton button_12 = new JButton("\u8BFE\u5802\u52A0\u5206");
		button_12.setBorder(null);
		button_12.setBounds(0, 57, 90, 23);
		lmenu2.add(button_12);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("image\\left.png"));
		label_10.setBounds(28, 0, 62, 55);
		lmenu2.add(label_10);
	}

	/**
	 * <p>
	 * Title: setTestscore
	 * </p>
	 * <p>
	 * Description: 设置小测成绩菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setTestscore() {
		// 小测成绩
		lmenu3 = new JPanel();
		lmenu3.setLayout(null);
		lmenu3.setOpaque(false);
		// 按钮
		JButton button_13 = new JButton("\u5C0F\u6D4B\u6210\u7EE9");
		button_13.setBorder(null);
		button_13.setBounds(0, 57, 90, 23);
		lmenu3.add(button_13);

		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("image\\left.png"));
		label_12.setBounds(28, 0, 62, 55);
		lmenu3.add(label_12);
	}

	/**
	 * <p>
	 * Title: setStujob
	 * </p>
	 * <p>
	 * Description: 设置学生作业菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setStujob() {
		// 学生作业
		lmenu4 = new JPanel();
		lmenu4.setLayout(null);
		lmenu4.setOpaque(false);
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
		label_13.setIcon(new ImageIcon("image\\left.png"));
		label_13.setBounds(28, 0, 62, 55);
		lmenu4.add(label_13);
	}

	/**
	 * <p>
	 * Title: setMemorandum
	 * </p>
	 * <p>
	 * Description: 设置备忘录菜单面板，有标记图和按钮
	 * </p>
	 */
	public void setMemorandum() {
		// 备忘录
		lmenu5 = new JPanel();
		lmenu5.setLayout(null);
		lmenu5.setOpaque(false);
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
		label_14.setIcon(new ImageIcon("image\\left.png"));
		label_14.setBounds(28, 0, 62, 55);
		lmenu5.add(label_14);
	}

	/**
	 * 
	 * <p>
	 * Title: leftMenu
	 * </p>
	 * <p>
	 * Description:左侧菜单栏函数（学生签到、小测成绩、学生作业、备忘录）
	 * </p>
	 */
	public void leftMenu() {
		// 添加学生签到菜单
		this.setStusign();
		// 添加课堂加分菜单
		this.setClassbonus();
		// 添加小测成绩菜单
		this.setTestscore();
		// 添加学生作业菜单
		this.setStujob();
		// 添加备忘录菜单
		this.setMemorandum();

	}

	/**
	 * 
	 * <p>
	 * Title: chatView
	 * </p>
	 * <p>
	 * Description:师生聊天窗口
	 * </p>
	 */
	public void chatView() {
		panel_5 = new JPanel();
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
	 * <p>
	 * Title: setTime
	 * </p>
	 * <p>
	 * Description:时间标志
	 * </p>
	 */
	public void setTime() {
		lblNewLabel = new JLabel("第*周*****课");
	}

	/**
	 * 
	 * <p>
	 * Title: setGroupLayout
	 * </p>
	 * <p>
	 * Description:整体布局设置
	 * </p>
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
	 * <p>
	 * Title: jumpIndex
	 * </p>
	 * <p>
	 * Description: 跳转学生签到主页面
	 * </p>
	 */
	public void jumpIndex() {
		// 顶部菜单栏
		topMenu();
		// 左侧菜单栏
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		// 时间标志
		setTime();
		// 中间容器
		centerPanel();
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 内容设置
		centerContent();
	}

	/**
	 * 
	 * <p>
	 * Title: selectstuContent
	 * </p>
	 * <p>
	 * Description:学生演示内容页（学生按钮）
	 * </p>
	 */
	public void selectstuContent() {
		
		centerpl.setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 0, 906, 572);
		centerpl.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new GridLayout(20, 5, 2, 2));
		
		
		for( int b = 0 ; b <5; b++) {
			JButton j=new JButton("名字");
			j.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//事件
					jumpStuPre();
				}
			});
			j.setIcon(new ImageIcon("image\\stu.png"));
			j.setHorizontalAlignment(SwingConstants.LEFT);
			j.setForeground(new Color(100, 149, 237));
			j.setFont(new Font("宋体", Font.BOLD, 18));				
			j.setBorder(UIManager.getBorder("Button.border"));
			j.setBackground(Color.WHITE);
			panel.add(j);
		}
		

		bgContentPane.setLayout(gl_bgContentPane);
		// 设置窗体大小
		this.setBounds(0, 0, 1282, 771);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		// 窗体可见
		this.setVisible(true);

	}

	/**
	 * 
	 * <p>
	 * Title: jumpSelectstu
	 * </p>
	 * <p>
	 * Description:跳转到学生演示界面
	 * </p>
	 */
	public void jumpSelectstu() {
		// 顶部菜单栏
		topMenu();
		// 左侧菜单栏
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		// 时间标志
		setTime();
		// 中间容器
		centerPanel();
		// 聊天窗口
		chatView();
		// 布局设置
		setGroupLayout();
		// 内容设置
		selectstuContent();
	}

	/**
	 * 
	 * <p>
	 * Title: stuPreContent
	 * </p>
	 * <p>
	 * Description: 选中某个学生桌面的内容页
	 * </p>
	 */
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		// 窗体可见
		this.setVisible(true);
	}

	/**
	 * 
	 * <p>
	 * Title: jumpStuPre
	 * </p>
	 * <p>
	 * Description:跳转到选中学生桌面的内容页
	 * </p>
	 */
	public void jumpStuPre() {
		// 顶部菜单栏
		topMenu();
		// 左侧菜单栏
		leftMenu();
		// 设置背景图
		setBackground();
		// 设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
		// 时间标志
		setTime();
		// 中间容器
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
		// 设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

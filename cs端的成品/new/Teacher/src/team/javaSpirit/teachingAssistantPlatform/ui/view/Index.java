package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.course.service.CourseServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service.MyServiceThread;
import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service.StudentServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Service;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.StudentSignServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.studentSignIn.service.StudentSignInServiceImpl;
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
	/* 服务对象 */
	Service service = new Service();
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
		menu1.setBounds(19, 18, 90, 110);
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
		comboBox.addItemListener(new MyItemListener(comboBox, service) {
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
		menu2.setBounds(117, 18, 88, 110);
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
		menu3.setBounds(219, 18, 88, 110);
		menu3.setBorder(null);
		menu3.setOpaque(false);
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("image\\gb.png"));
		label_5.setBounds(10, 13, 60, 67);
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
		menu4.setBounds(321, 18, 88, 99);
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
		button.setBackground(null);
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
		menu5.setBounds(423, 18, 88, 99);
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
				jumpRandomcall();
			}
		});
		button_9.setForeground(new Color(100, 149, 237));
		button_9.setFont(new Font("宋体", Font.BOLD, 18));
		button_9.setBorder(null);
		button_9.setBackground(null);
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
		menu6.setBounds(525, 18, 88, 99);
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
		button_10.setBackground(null);
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
		menu7.setBounds(631, 18, 88, 99);
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
		button_11.setBackground(null);
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
		menu8.setBounds(733, 18, 88, 99);
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
		button_2.setBackground(null);
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
		menu9.setBounds(835, 18, 88, 99);
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
		button_3.setBackground(null);
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
		menu10.setBounds(937, 18, 88, 99);
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
		button_4.setBackground(null);
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
		centerpl.setBounds(117, 135, 908, 523);
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
		// 签到情况的服务
		StudentSignInServiceImpl ss = new StudentSignInServiceImpl();
		// 正常签到
		List<Students> normalStu = ss.SignInStudent();
		// 迟到签到
		List<Students> LateStu = ss.LateStudent();
		final Object[] columnNames = { "签到", "迟到", "旷课", "请假" };
		int row = normalStu.size() + LateStu.size();
		Object[][] rowData = new Object[row][6];
		// 正常签到的
		int i;
		for (i = 0; i < normalStu.size(); i++) {
			Students s = normalStu.get(i);
			rowData[i][0] = s.getSid() + "-" + s.getName();
		}
		// 迟到的
		for (int j = 0; j < LateStu.size(); j++) {
			Students s = LateStu.get(j);
			rowData[j][1] = s.getSid() + "-" + s.getName();
		}
		table_1 = new JTable(rowData, columnNames);
		table_1.setBounds(1, 32, 907, 150);
		table_1.setFont(new Font("宋体", Font.PLAIN, 16));
		table_1.setRowHeight(50);// 设置每行的高度
		table_1.setRowMargin(5);// 设置相邻两行单元格的距离
		table_1.setShowHorizontalLines(true);// 是否显示水平的网格线
		centerpl.setLayout(null);
		centerpl.add(table_1);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(1, 1, 909, 355);
		scrollPane.setEnabled(false);
		centerpl.add(scrollPane);

		// 请假条滚动表格设置
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(1, 355, 908, 185);
		centerpl.add(scrollPane_1);

		final Object[] columnNames2 = { "姓名", "学号", "时间", "请假条" };
		Object[][] rowData2 = { { "啦啦啦", "2016011352", "2018/12/17", "图片" } };

		table_2 = new JTable(rowData2, columnNames2);
		table_2.setFont(new Font("宋体", Font.PLAIN, 16));
		table_2.setRowHeight(150);// 设置每行的高度
		table_2.setRowMargin(5);// 设置相邻两行单元格的距离
		table_2.setShowHorizontalLines(true);// 是否显示水平的网格线
		scrollPane_1.setViewportView(table_2);
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
		lmenu1.setBounds(19, 135, 90, 80);
		lmenu1.setLayout(null);
		lmenu1.setOpaque(false);
		// 按钮
		JButton bt8 = new JButton("\u7B7E\u5230\u4FE1\u606F");

		// bt8.setBackground(null);
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
		lmenu2.setBounds(19, 222, 90, 80);
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
		lmenu3.setBounds(19, 309, 90, 80);
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
		lmenu4.setBounds(19, 396, 90, 80);
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
		lmenu5.setBounds(19, 483, 90, 80);
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
		panel_5.setBounds(1039, 135, 234, 523);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		panel_5.setBackground((Color) null);
		// 师生对话框
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(5, 5, 223, 405);
		scrollPane_1.setBackground(Color.WHITE);
		panel_5.add(scrollPane_1);

		// 音量调节框

		textField = new JTextField();
		textField.setText("\u4E0A\u8BFE\u8282\u594F\u662F\u5426\u592A\u5FEB");
		textField.setBounds(5, 411, 156, 24);
		panel_5.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u53D1\u9001");
		button.setBounds(165, 410, 69, 27);
		panel_5.add(button);
	}

	/**
	 * 
	 * <p>
	 * Title: setTime
	 * </p>
	 * <p>
	 * Description:时间标志，上课标志。
	 * </p>
	 */
	public void setTime() {
		CourseServiceImpl cs = new CourseServiceImpl();
		long week = CourseServiceImpl.week;
		if (cs.findCurrentCourse(Constant.myTeacher.getTid())) {
			String cname = cs.findCname(Constant.cid);
			lblNewLabel = new JLabel("第" + week + "周:" + cname + "课");
			// time = new JLabel("<html>第" + w + "周<br><br>" + cname + "课</html>");
		} else {
			lblNewLabel = new JLabel("第" + week + "周:目前没课");
			// time = new JLabel("<html>第" + w + "周<br><br>目前没课</html>");
		}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(1039, 48, 237, 61);
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
		bgContentPane.setLayout(null);
		bgContentPane.add(lmenu1);
		bgContentPane.add(lmenu4);
		bgContentPane.add(lmenu5);
		bgContentPane.add(lmenu3);
		bgContentPane.add(lmenu2);
		bgContentPane.add(menu1);
		bgContentPane.add(menu2);
		bgContentPane.add(menu3);
		bgContentPane.add(menu4);
		bgContentPane.add(menu5);
		bgContentPane.add(menu6);
		bgContentPane.add(menu7);
		bgContentPane.add(menu8);
		bgContentPane.add(menu9);
		bgContentPane.add(menu10);
		bgContentPane.add(centerpl);
		bgContentPane.add(lblNewLabel);
		bgContentPane.add(panel_5);
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
		scrollPane_1.setBounds(1, 0, 909, 546);
		centerpl.add(scrollPane_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		scrollPane_1.setViewportView(panel);
		panel.setPreferredSize(new Dimension(908, 2500));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// 所有签到的学生
		StudentSignServiceImpl ss = new StudentSignServiceImpl();
		List<Students> listStu = ss.allSignStudent();
		for (Students s : listStu) {
			JButton j = new JButton(s.getName());
			j.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// 事件
					// 老师新开服务
					try {
						System.out.println("qqqqqqqq======");
//						ConnectStudent.setupServer(Communication.sPort);
						new MyServiceThread().start();
						System.out.println("jijijj");
						// 学生名字
						String sname = j.getText();
						// TODO
						// 获得IP
						StudentServiceImpl ss = new StudentServiceImpl();
						String ip = ss.findIp(sname);
						service.sendCommand(ip);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "已经开过服务了。");
					}

				}
			});
			j.setPreferredSize(new Dimension(170, 80));
			j.setIcon(new ImageIcon("image\\stu.png"));
			j.setHorizontalAlignment(SwingConstants.LEFT);
			j.setForeground(new Color(100, 149, 237));
			j.setFont(new Font("宋体", Font.BOLD, 18));
			j.setBorder(UIManager.getBorder("Button.border"));
			j.setBackground(Color.WHITE);
			panel.add(j);
		}

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
	 * 
	 * <p>
	 * Title: randomCallContent
	 * </p>
	 * <p>
	 * Description:随机点名内容页
	 * </p>
	 */
	public void randomCallContent() {
		centerpl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7  \u59D3\u540D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(184, 102, 522, 231);
		centerpl.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setText("");
			}
		});
		btnNewButton.setBounds(313, 346, 120, 41);
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setBackground(new Color(230, 230, 250));
		centerpl.add(btnNewButton);

		JButton button = new JButton("\u6682\u505C");
		button.setBackground(new Color(230, 230, 250));
		button.setFont(new Font("幼圆", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(470, 346, 120, 41);
		centerpl.add(button);
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
	 * Title: jumpRandomcall
	 * </p>
	 * <p>
	 * Description:跳转到随机点名界面
	 * </p>
	 */
	public void jumpRandomcall() {
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
		randomCallContent();
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		// 设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

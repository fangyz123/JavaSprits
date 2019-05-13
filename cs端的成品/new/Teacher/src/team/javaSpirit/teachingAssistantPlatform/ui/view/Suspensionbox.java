package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Service;
import team.javaSpirit.teachingAssistantPlatform.ui.event.MyItemListener;

public class Suspensionbox extends JFrame implements ActionListener {

	/* 窗体的轮廓 */
	private Rectangle rect;
	/* 窗体离屏幕左边的距离 */
	private int frameLeft;
	/* 窗体离屏幕右边的距离 */
	private int frameRight;
	/* 窗体离屏幕顶部的距离 */
	private int frameTop;
	/* 屏幕的宽度 */
	private int screenXX;
	/* 鼠标在窗体的位置 */
	private Point point;
	/* 窗体的宽 */
	private int frameWidth;
	/* 窗体的高 */
	private int frameHeight;
	/* 定时器 */
	private Timer timer = new Timer(10, this);
	/* 窗体坐标 */
	private int xx, yy;
	/* 指定当前是否为正在拖动 */
	private boolean isDraging = false;
	/* 底部容器 */
	private JPanel contentPane;
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
	/* 服务对象 */
	Service service;
	/* 要最小化的那个页面 */
	private Index index;
	/* 是否调用回调事件，得到位置坐标 */
	private boolean isdisplay = true;

	/**
	 * <p>
	 * Title: setIsdisplay
	 * </p>
	 * <p>
	 * Description: 设置窗体是否可见。
	 * </p>
	 * 
	 * @param isdisplay
	 */
	public void setIsdisplay(boolean isdisplay) {
		this.isdisplay = isdisplay;
		setVisible(isdisplay);
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
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/background.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		setBounds(300, 0, 757, 136);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		menu1 = new JPanel();
		menu1.setBounds(14, 13, 120, 123);
		menu1.setOpaque(false);
		contentPane.add(menu1);
		menu1.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\yckz.png"));
		lblNewLabel.setBounds(24, 0, 71, 67);
		menu1.add(lblNewLabel);

		JButton btnNewButton = new JButton("远程控制");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(0, 65, 120, 27);
		btnNewButton.setForeground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		menu1.add(btnNewButton);
		// 下拉菜单，里面的值是String类型
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 94, 96, 16);
		comboBox.setEditable(true);
		comboBox.setEnabled(true);
		// 为下拉菜单添加选项
		comboBox.addItem("请选择......");
		comboBox.addItem("开启");
		comboBox.addItem("关闭");
		comboBox.addItem("开启共享");
		comboBox.addItem("关闭共享");
		// 监听下拉框的选择事件
		comboBox.addItemListener(new MyItemListener(service) {
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
		menu2.setBounds(148, 13, 120, 123);
		menu2.setOpaque(false);
		contentPane.add(menu2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\lp.png"));
		label.setBounds(24, 0, 71, 67);
		menu2.add(label);

		JButton button = new JButton("录屏");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setOpaque(false);
		button.setBounds(0, 65, 120, 27);
		button.setForeground(new Color(100, 149, 237));
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		menu2.add(button);
		// 录屏下拉菜单
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(true);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(10, 94, 96, 16);
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

		JPanel menu3 = new JPanel();
		menu3.setLayout(null);
		menu3.setBounds(282, 13, 120, 123);
		menu3.setOpaque(false);
		contentPane.add(menu3);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("image\\gb.png"));
		label_1.setBounds(24, 0, 71, 67);
		menu3.add(label_1);

		JButton button_1 = new JButton("广播");
		button_1.setBounds(0, 65, 120, 27);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setOpaque(false);
		button_1.setForeground(new Color(100, 149, 237));
		button_1.setFont(new Font("宋体", Font.BOLD, 18));
		button_1.setBorder(null);
		button_1.setBackground(Color.WHITE);
		menu3.add(button_1);
		// 广播下拉菜单
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setEnabled(true);
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(14, 94, 85, 16);
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
		JPanel menu4 = new JPanel();
		menu4.setLayout(null);
		menu4.setBounds(416, 13, 120, 123);
		menu4.setBorder(null);
		menu4.setOpaque(false);
		contentPane.add(menu4);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(24, 0, 71, 67);
		label_2.setIcon(new ImageIcon("image\\xsys.png"));
		menu4.add(label_2);

		JButton button_2 = new JButton("学生演示");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 窗体不可见
				isdisplay = false;
				setVisible(isdisplay);
				dispose();
				// 回到原页面
				index.init();
			}
		});
		button_2.setForeground(new Color(100, 149, 237));
		button_2.setFont(new Font("宋体", Font.BOLD, 18));
		button_2.setBorder(null);
		button_2.setBackground(null);
		button_2.setBounds(0, 65, 120, 34);
		menu4.add(button_2);

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
		menu5.setBounds(550, 13, 120, 123);
		menu5.setForeground(Color.WHITE);
		menu5.setBorder(null);
		menu5.setOpaque(false);
		contentPane.add(menu5);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(24, 0, 71, 67);
		label_3.setIcon(new ImageIcon("image\\sjdm.png"));
		menu5.add(label_3);

		JButton button_3 = new JButton("随机点名");
		button_3.setBounds(0, 65, 120, 32);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 窗体不可见
				isdisplay = false;
				setVisible(isdisplay);
				dispose();
				// 回到原页面
				index.jumpRandomcall();
			}
		});
		button_3.setForeground(new Color(100, 149, 237));
		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		button_3.setBorder(null);
		button_3.setBackground(null);
		menu5.add(button_3);

	}

	/**
	 * <p>
	 * Title: setWindow
	 * </p>
	 * <p>
	 * Description: 窗口的设置。有上隐藏窗口、返回主界面、向下固定窗口。
	 * </p>
	 */
	public void setWindow() {
		// 向上隐藏窗口
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image\\sq.png"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setLocation(frameLeft, frameTop - 5);
			}
		});
		lblNewLabel_1.setBounds(684, 13, 58, 41);
		contentPane.add(lblNewLabel_1);
		// 返回主界面
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\return.png"));
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 窗体不可见
				isdisplay = false;
				setVisible(isdisplay);
				dispose();
				// 回到原页面
				index.init();
			}
		});
		label.setBounds(684, 50, 58, 41);
		contentPane.add(label);
		// 向下固定窗口
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("image\\gd.png"));
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setLocation(frameLeft, frameTop + 5);
			}
		});
		label_1.setBounds(684, 95, 58, 41);
		contentPane.add(label_1);
	}

	/**
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description: 窗体的初始化
	 * </p>
	 */
	public void init() {
		this.locationListener();
		this.setBackground();
		this.setRemotecontrol();
		this.setRecordScreen();
		this.setBroadcast();
		this.setStuzs();
		this.setRandomcall();
		this.setWindow();
	}

	/**
	 * <p>
	 * Title: locationListener
	 * </p>
	 * <p>
	 * Description: 设置位置监听
	 * </p>
	 */
	public void locationListener() {
		timer.start();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				xx = e.getX();
				yy = e.getY();
			}

			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) {
					int left = getLocation().x;
					int top = getLocation().y;
					setLocation(left + e.getX() - xx, top + e.getY() - yy);
					repaint();
				}
			}
		});
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 有参构造函数
	 * </p>
	 * 
	 * @param service
	 * @param index
	 */
	public Suspensionbox(Service service, Index index) {
		this.service = service;
		this.index = index;
		setUndecorated(true);
		setType(Type.UTILITY);
		// 窗口置顶
		this.setAlwaysOnTop(true);
//		setVisible(isdisplay);
	}

	/**
	 * <p>
	 * Title: actionPerformed
	 * </p>
	 * <p>
	 * Description:实现窗体靠边隐藏
	 * </p>
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// 如果隐藏或销毁了窗体，不执行
		if (isdisplay) {
			frameLeft = getLocationOnScreen().x;
			frameTop = getLocationOnScreen().y;
		}
		frameWidth = getWidth();
		frameHeight = getHeight();
		screenXX = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		frameRight = screenXX - frameLeft - frameWidth;

		// 获取窗体的轮廓
		rect = new Rectangle(0, 0, frameWidth, frameHeight);
		// 获取鼠标在窗体的位置
		point = getMousePosition();

		if (frameLeft < 0 && isPtInRect(rect, point)) {
			setLocation(0, frameTop); // 隐藏在左边，鼠标指到后显示窗体；
		} else if (frameLeft > -5 && frameLeft < 5 && !(isPtInRect(rect, point))) {
			setLocation(frameLeft - frameWidth + 1, frameTop); // 窗体移到左边边缘隐藏到左边；
		} else if ((frameTop < 0 && frameLeft < 0) && isPtInRect(rect, point)) {// 窗体在左上角；
			setLocation(0, 0);// 窗口隐藏了，鼠标指到他，就显示出来；
		} else if ((frameTop > -5 && frameTop < 5) && (frameLeft > -5 && frameLeft < 5) && !(isPtInRect(rect, point))) {
			// 当窗体的上边框与屏幕的顶端的距离小于5时 ，
			// 并且鼠标不再窗体上将窗体隐藏到屏幕的顶端
			setLocation(frameLeft - frameWidth + 1, 1);
		} else if ((frameTop < 0) && isPtInRect(rect, point)) {
			setLocation(frameLeft, 0);// 窗口隐藏了，鼠标指到他，就显示出来；
		} else if (frameTop > -5 && frameTop < 5 && !(isPtInRect(rect, point))) {
			// 当窗体的上边框与屏幕的顶端的距离小于5时 ，
			// 并且鼠标不再窗体上将窗体隐藏到屏幕的顶端
			setLocation(frameLeft, 1 - frameHeight);
		} else if (frameRight < 0 && isPtInRect(rect, point)) {
			setLocation(screenXX - frameWidth + 1, frameTop);// 隐藏在右边，鼠标指到后显示；
		} else if (frameRight > -5 && frameRight < 5 && !(isPtInRect(rect, point))) {
			setLocation(screenXX - 1, frameTop); // 窗体移到屏幕右边边缘隐藏到右边；
		} else if (frameRight < 0 && frameTop < 0 && isPtInRect(rect, point)) {// 窗体在右上角；
			setLocation(screenXX - frameWidth + 1, 0);// 隐藏在右边，鼠标指到后显示；
		} else if ((frameRight > -5 && frameRight < 5) && (frameTop > -5 && frameTop < 5)
				&& !(isPtInRect(rect, point))) {
			setLocation(screenXX - 1, 1); // 窗体移到屏幕右边边缘隐藏到右边；
		}
	}

	/**
	 * <p>
	 * Title: isPtInRect
	 * </p>
	 * <p>
	 * Description: 检测是否在矩形框内
	 * </p>
	 */
	public boolean isPtInRect(Rectangle rect, Point point) {
		if (rect != null && point != null) {
			int x0 = rect.x;
			int y0 = rect.y;
			int x1 = rect.width;
			int y1 = rect.height;
			int x = point.x;
			int y = point.y;

			return x >= x0 && x < x1 && y >= y0 && y < y1;
		}
		return false;
	}
}

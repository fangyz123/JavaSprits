package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import team.javaSpirit.teachingAssistantPlatform.common.Communication;
import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.entity.ShareResource;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentClass;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.quiz.dao.QuizDao;
import team.javaSpirit.teachingAssistantPlatform.quiz.service.QuizService;
import team.javaSpirit.teachingAssistantPlatform.signIn.dao.StudentCourseDao;
import team.javaSpirit.teachingAssistantPlatform.signIn.service.SignRankService;
import team.javaSpirit.teachingAssistantPlatform.signIn.service.SignTimerTask;
import team.javaSpirit.teachingAssistantPlatform.signIn.service.StudentCourseService;
import team.javaSpirit.teachingAssistantPlatform.ui.event.AnalysisScoreActionListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.AnalysisScoreMenuMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.IndexActionListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.QuizMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.RemoteMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.ResourceMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.ShareResourceMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.SignMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.StartQuizMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.StudentQuizMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.UploadMouseListener;
import team.javaSpirit.teachingAssistantPlatform.ui.event.VideoScreenMouseListener;
import team.javaSpirit.teachingAssistantPlatform.upload.service.ShareResourceServiceImpl;

/**
 * 
 * <p>
 * Title: Index
 * </p>
 * <p>
 * Description：登录后所有窗体的创建
 * </p>
 * 
 * @author renyuyuano
 * @date 2018年12月4日
 */
public class Index extends JFrame {
	/* 为学生找课程的对象 */
	private StudentCourseService scs = new StudentCourseService();
	/*录屏监听*/
	private IndexActionListener indexActionListener;
	/** 背景容器 */
	private JPanel bgContentPane;
	/** 中间模块容器 */
	private JPanel centerpl;
	/** 内容模块容器 */
	private JPanel contentpl;
	private IndexActionListener event;

	public StudentCourseService getScs() {
		return scs;
	}

	public JPanel getBgContentPane() {
		return bgContentPane;
	}

	public JPanel getCenterpl() {
		return centerpl;
	}

	public JPanel getContentpl() {
		return contentpl;
	}

	/**
	 * 
	 * <p>
	 * Title: setBackground
	 * </p>
	 * <p>
	 * Description:设置背景图bgContentPane
	 * </p>
	 */
	public void setBackground() {
		bgContentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		bgContentPane.setBounds(0, 0, 100, 1000);
		bgContentPane.setBorder(null);
		this.setContentPane(bgContentPane);
	}

	/**
	 * 
	 * <p>
	 * Title: setCenterpl
	 * </p>
	 * <p>
	 * Description:中间容器设置centerpl
	 * </p>
	 */
	public void setCenterpl() {
		centerpl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
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
	 * <p>
	 * Title: setContentpl
	 * </p>
	 * <p>
	 * Description:内容容器设置contentpl
	 * </p>
	 */
	public void setContentpl() {
		contentpl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
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
	 * <p>
	 * Title: setMenu
	 * </p>
	 * <p>
	 * Description: 主菜单栏设置（签到 远程监控 录屏 广播 作业 课堂小测 资源共享模块）向bgcontentpl中添加组件
	 * </p>
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
	 * <p>
	 * Title: setSignMenu
	 * </p>
	 * <p>
	 * Description:设置签到菜单
	 * </p>
	 */
	public void setSignMenu() {
		// 签到菜单容器
		JPanel menu1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu1.setBounds(45, 28, 88, 99);
		menu1.setBorder(null);
		menu1.setForeground(new Color(255, 255, 255));
		menu1.setLayout(null);

		// 签到图标
		JLabel lb1 = new JLabel("");
		lb1.setBounds(13, 10, 60, 60);
		menu1.add(lb1);
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setVerticalAlignment(SwingConstants.TOP);
		lb1.setIcon(new ImageIcon("image/menu1.jpg"));
		// 签到按钮
		JButton bt1 = new JButton("签到");
		bt1.setBounds(28, 70, 31, 17);
		menu1.add(bt1);
		bt1.setFont(new Font("宋体", Font.BOLD, 14));
		bt1.setForeground(new Color(100, 149, 237));

		bt1.setBorder(null);
		bt1.setBackground(Color.WHITE);
		bgContentPane.add(menu1);

		// 事件对象
		SignMouseListener signEvent = new SignMouseListener(this);
		// 事件监听
		menu1.addMouseListener(signEvent);
		bt1.addMouseListener(signEvent);
	}

	/**
	 * 
	 * <p>
	 * Title: setShareMenu
	 * </p>
	 * <p>
	 * Description:设置资源共享菜单
	 * </p>
	 */
	public void setShareMenu() {
		// 资源共享菜单容器
		JPanel menu7 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		// 事件对象
		ShareResourceMouseListener shareEvent = new ShareResourceMouseListener(this);
		// 添加事件
		menu7.addMouseListener(shareEvent);
		menu7.setBounds(785, 28, 88, 99);
		menu7.setBorder(null);
		menu7.setForeground(Color.WHITE);
		menu7.setLayout(null);

		// 资源共享菜单图标
		JLabel lb7 = new JLabel("");
		lb7.setBounds(13, 10, 60, 60);
		menu7.add(lb7);
		lb7.setIcon(new ImageIcon("image/menu7.jpg"));
		// 资源共享菜单按钮
		JButton bt7 = new JButton("资源共享");
		// 添加事件
		bt7.addMouseListener(shareEvent);
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
	 * <p>
	 * Title: setVideoScreen
	 * </p>
	 * <p>
	 * Description: 设置录屏菜单
	 * </p>
	 */
	public void setVideoScreen() {
		// 录屏菜单容器
		JPanel menu3 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu3.setBounds(289, 28, 88, 99);
		menu3.setBorder(null);
		menu3.setForeground(Color.WHITE);
		menu3.setLayout(null);
		// 录屏菜单图标
		JLabel lb3 = new JLabel("");
		lb3.setBounds(13, 10, 60, 60);
		menu3.add(lb3);
		lb3.setIcon(new ImageIcon("image/menu3.jpg"));
		// 录屏菜单按钮
		JButton bt3 = new JButton("录屏");
		bt3.setBounds(28, 70, 31, 17);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu3.add(bt3);
		bt3.setForeground(new Color(100, 149, 237));
		bt3.setFont(new Font("宋体", Font.BOLD, 14));
		bt3.setBackground(Color.WHITE);
		bt3.setBorder(null);
		bgContentPane.add(menu3);
		VideoScreenMouseListener asm=new VideoScreenMouseListener(this);
		menu3.addMouseListener(asm);bt3.addMouseListener(asm);
	}

	/**
	 * 
	 * <p>
	 * Title: setWorkMenu
	 * </p>
	 * <p>
	 * Description:设置成绩分析菜单
	 * </p>
	 */
	public void setWorkMenu() {
		// 作业菜单容器
		JPanel menu5 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu5.setBounds(531, 28, 88, 99);
		menu5.setBorder(null);
		menu5.setForeground(Color.WHITE);
		menu5.setLayout(null);
		// 作业菜单图标
		JLabel lb5 = new JLabel("");
		lb5.setBounds(13, 10, 60, 60);
		menu5.add(lb5);
		lb5.setIcon(new ImageIcon("image/menu5.jpg"));
		// 作业菜单按钮
		JButton bt5 = new JButton("成绩分析");
		bt5.setBounds(13, 70, 61, 17);
		bt5.setForeground(new Color(100, 149, 237));
		bt5.setFont(new Font("宋体", Font.BOLD, 14));
		bt5.setBorder(null);
		bt5.setBackground(Color.WHITE);
		menu5.add(bt5);
		bgContentPane.add(menu5);
		AnalysisScoreMenuMouseListener asm=new AnalysisScoreMenuMouseListener(this);
		menu5.addMouseListener(asm);bt5.addMouseListener(asm);
	}

	/**
	 * 
	 * <p>
	 * Title: setTestMenu
	 * </p>
	 * <p>
	 * Description:设置课堂小测菜单
	 * </p>
	 */
	public void setTestMenu() {
		// 课堂小测菜单容器
		JPanel menu6 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu6.setBounds(661, 28, 88, 99);
		menu6.setBorder(null);
		menu6.setForeground(Color.WHITE);
		menu6.setLayout(null);
		// 课堂小测菜单图标
		JLabel lb6 = new JLabel("");
		lb6.setBounds(13, 10, 60, 60);
		menu6.add(lb6);
		lb6.setIcon(new ImageIcon("image/menu6.jpg"));
		// 课堂小测菜单按钮
		JButton bt6 = new JButton("课堂小测");
		bt6.setBounds(13, 70, 61, 17);
		bt6.setForeground(new Color(100, 149, 237));
		bt6.setFont(new Font("宋体", Font.BOLD, 14));
		bt6.setBorder(null);
		bt6.setBackground(Color.WHITE);
		menu6.add(bt6);
		bgContentPane.add(menu6);
		// 事件对象
		QuizMouseListener quiz=new QuizMouseListener(this);
		// 添加事件
		menu6.addMouseListener(quiz);
		bt6.addMouseListener(quiz);
	}

	/**
	 * 
	 * <p>
	 * Title: setBroadcastingMenu
	 * </p>
	 * <p>
	 * Description:设置广播菜单按钮
	 * </p>
	 */
	public void setBroadcastingMenu() {
		// 广播菜单容器
		JPanel menu4 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu4.setBounds(411, 28, 88, 99);
		menu4.setBorder(null);
		menu4.setForeground(Color.WHITE);
		menu4.setLayout(null);
		// 广播菜单图标
		JLabel lb4 = new JLabel("");
		lb4.setBounds(13, 10, 60, 60);
		menu4.add(lb4);
		lb4.setIcon(new ImageIcon("image/menu4.jpg"));
		// 广播菜单按钮
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
	 * <p>
	 * Title: setRemoteMenu
	 * </p>
	 * <p>
	 * Description:设置远程监控菜单
	 * </p>
	 */
	public void setRemoteMenu() {
		// 远程监控菜单容器
		JPanel menu2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menubg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu2.setBounds(166, 28, 88, 99);
		menu2.setBorder(null);
		menu2.setForeground(new Color(255, 255, 255));
		menu2.setLayout(null);

		// 远程监控图标
		JLabel lb2 = new JLabel("");
		lb2.setBounds(13, 10, 60, 60);
		menu2.add(lb2);
		lb2.setIcon(new ImageIcon("image/menu2.jpg"));
		// 远程监控按钮
		JButton bt2 = new JButton("远程监控");
		bt2.setBounds(13, 70, 61, 17);

		menu2.add(bt2);
		bt2.setForeground(new Color(100, 149, 237));
		bt2.setFont(new Font("宋体", Font.BOLD, 14));
		bt2.setBackground(Color.WHITE);
		bt2.setBorder(null);
		bgContentPane.add(menu2);
		// 事件对象
		RemoteMouseListener remote = new RemoteMouseListener(this);
		// 添加事件
		menu2.addMouseListener(remote);
		bt2.addMouseListener(remote);

	}

	/**
	 * 
	 * <p>
	 * Title: setAuxiliaryMenu
	 * </p>
	 * <p>
	 * Description: 辅助菜单设置（备忘录 查询 历史记录模块）向centerpl中添加组件
	 * </p>
	 */
	public void setAuxiliaryMenu() {
		// 备忘录菜单
		JPanel menu8 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menu8.jpg");
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
		// 签到排名菜单
		JPanel menu9 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menu9.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu9.setBounds(22, 165, 90, 80);
		centerpl.add(menu9);
		menu9.setLayout(null);

		JButton bt9 = new JButton("签到排名");
		bt9.setBackground(null);
		bt9.setBounds(10, 47, 70, 23);
		bt9.setBorder(null);
		menu9.add(bt9);
		bt9.addActionListener(new IndexActionListener(this));
		
		JPanel menu10 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/menu10.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		menu10.setBounds(22, 269, 90, 80);
		centerpl.add(menu10);
		menu10.setLayout(null);
		// 历史记录查询
		JButton bt10 = new JButton("历史记录");
		bt10.setBounds(10, 47, 70, 23);
		bt10.setBorder(null);
		menu10.add(bt10);
	}

	/**
	 * 
	 * <p>
	 * Title: setTime
	 * </p>
	 * <p>
	 * Description:时间标志，在数据库中查找第几周***课
	 * </p>
	 */
	public void setTime() {
		long w = StudentCourseService.week;
		JLabel time = null;
		if (scs.findCurrentCourse(Constant.myStudent.getSid())) {
			String cname = scs.findCname(Constant.cid);
			time = new JLabel("<html>第" + w + "周<br><br>" + cname + "课</html>");
			// 启动定时任务
			new SignTimerTask();
		} else {
			time = new JLabel("<html>第" + w + "周<br><br>目前没课</html>");

		}
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setBounds(870, 49, 120, 47);
		time.setFont(new Font("宋体", Font.BOLD, 12));
		time.setForeground(new Color(128, 128, 128));
		bgContentPane.add(time);

	}

	/**
	 * 
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description: 初始化基本窗体
	 * </p>
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
	 * <p>
	 * Title: setSign
	 * </p>
	 * <p>
	 * Description: 设置签到界面，向centerpl中添加控件
	 * </p>
	 */
	public void setSign() {
		// 向centerpl中添加控件
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
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
	 * <p>
	 * Title: setRemote
	 * </p>
	 * <p>
	 * Description:设置远程监控页面，向centerpl中添加控件，向contentpl中添加控件
	 * </p>
	 */
	public void setRemote() {
		// 向centerpl中添加控件
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
		closepl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("远程共享");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 5, 63, 23);
		closepl.add(lblNewLabel_1);

		JButton closebt = new JButton("×");
		closebt.setBounds(80, 5, 23, 23);
		closepl.add(closebt);
		closebt.addActionListener(event);
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);
		// 向contentpl中添加控件
		JButton remortbt = new JButton("开启远程连接");
		remortbt.setForeground(SystemColor.textInactiveText);
		remortbt.setFont(new Font("宋体", Font.PLAIN, 14));
		remortbt.setBounds(66, 130, 129, 31);
		// 添加事件监听
		remortbt.addActionListener(event);
		contentpl.add(remortbt);

		JPanel chatpl = new JPanel();
		chatpl.setBackground(SystemColor.inactiveCaption);
		chatpl.setBounds(227, 39, 499, 258);
		contentpl.add(chatpl);
		chatpl.setLayout(null);

		JTextArea textField = new JTextArea("  请发表您的问题");
		textField.setBounds(14, 13, 471, 200);
		textField.setFont(new Font("宋体", Font.PLAIN, 22));
		textField.setForeground(SystemColor.textHighlight);
		chatpl.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("发送");
		btnNewButton.setBounds(397, 217, 74, 35);
		chatpl.add(btnNewButton);
		// 事件对象
		IndexActionListener il=new IndexActionListener(this,textField);
		// 添加事件
		btnNewButton.addActionListener(il);
	}

	/**
	 * 
	 * <p>
	 * Title: setShareResource
	 * </p>
	 * <p>
	 * Description:设置共享资源页面，向centerpl中添加控件，向contentpl中添加控件
	 * </p>
	 */
	public void setShareResource() {
		// 向centerpl中添加控件
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
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
		closebt.addActionListener(new IndexActionListener(this));
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);

		// 内容展示标题
		JLabel title = new JLabel("历 史 资 源");
		title.setForeground(new Color(119, 136, 153));
		title.setFont(new Font("宋体", Font.BOLD, 16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(341, 20, 105, 26);
		// 上传文件图片
		contentpl.add(title);
		JLabel uploads = new JLabel("");
		uploads.setIcon(new ImageIcon("image/upload.jpg"));
		uploads.setBounds(659, 10, 124, 36);
		contentpl.add(uploads);
		uploads.addMouseListener(new UploadMouseListener(this));
		// 滚动条
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(47, 64);
		scrollPane.setSize(703, 232);
		scrollPane.setBorder(null);
		contentpl.add(scrollPane);
		// 资源列表容器
		JPanel text = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		text.setBackground(null);
		text.setForeground(new Color(173, 216, 230));
		text.setPreferredSize(new Dimension(700, 1000));
		scrollPane.setViewportView(text);
		// 获取所有资源
		List<ShareResource> list = new ShareResourceServiceImpl().getResources();
		// 遍历所有已上传的资源
		for (ShareResource sr : list) {
			if (sr.getOldfile() != null && sr.getUploadtime() != null) {
				Students s = sr.getStu();
				Teacher t = sr.getTeacher();
				JLabel jl = null;
				if (t == null) {
					jl = new JLabel("题目：" + sr.getOldfile() + "   上传者：" + s.getName() + "    时间：" + sr.getUploadtime());
				} else if (s == null) {
					jl = new JLabel(
							"题目：" + sr.getOldfile() + "   上传者：" + t.getTname() + "    时间：" + sr.getUploadtime());
				}
				jl.setFont(new Font("宋体", Font.BOLD, 14));
				jl.setForeground(new Color(100, 149, 237));
				jl.setPreferredSize(new Dimension(700, 45));
				jl.setHorizontalAlignment(SwingConstants.CENTER);
				jl.addMouseListener(new ResourceMouseListener(this, sr));
				text.add(jl);
			}
		}
	}
	/**
	 * 
	 * <p>Title: setQuiz</p>
	 * <p>Description:设置小测页面 </p>
	 */
	public void setQuiz() {
		// 向centerpl中添加控件
				JPanel closepl = new JPanel() {
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						ImageIcon ii = new ImageIcon("image/btbackground.jpg");
						g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
					}
				};
				closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
				closepl.setBounds(113, 14, 104, 30);
				closepl.setLayout(null);

				JLabel lblNewLabel_1 = new JLabel("课堂小测");
				lblNewLabel_1.setForeground(SystemColor.textInactiveText);
				lblNewLabel_1.setBounds(10, 5, 63, 23);
				closepl.add(lblNewLabel_1);

				JButton closebt = new JButton("×");
				closebt.setBounds(80, 5, 23, 23);
				closepl.add(closebt);
				closebt.addActionListener(new IndexActionListener(this));
				closebt.setBackground(null);
				closebt.setBorder(null);
				centerpl.add(closepl);

				// 内容展示标题
				JLabel title = new JLabel("小测列表");
				title.setForeground(new Color(119, 136, 153));
				title.setFont(new Font("宋体", Font.BOLD, 16));
				title.setHorizontalAlignment(SwingConstants.CENTER);
				title.setBounds(341, 20, 105, 26);
				contentpl.add(title);
				// 滚动条
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setLocation(30, 64);
				scrollPane.setSize(740, 200);
				scrollPane.setBorder(null);
				contentpl.add(scrollPane);
				// 资源列表容器
				JPanel text = new JPanel(){
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						ImageIcon ii = new ImageIcon("image/btbackground.jpg");
						g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
					}
				};
				text.setBackground(null);
				text.setForeground(new Color(173, 216, 230));
				text.setPreferredSize(new Dimension(740, 1000));
				scrollPane.setViewportView(text);
				//按课本展示篇章
				List<StudentClass> classs=new QuizDao().searchClasses();
				for(StudentClass class1:classs) {
					JLabel jl = new JLabel(class1.getClassin().getClass_name());
					jl.setFont(new Font("宋体", Font.BOLD, 18));
					jl.setForeground(new Color(100, 149, 237));
					jl.setPreferredSize(new Dimension(700, 30));
					text.add(jl);
					Map<String,List<StudentQuiz>> map=QuizService.getClassChapters(class1);
					for(String s:map.keySet()) {
						List<StudentQuiz> list=map.get(s);
						for(StudentQuiz sq:list) {
							if(sq.getState()==0) {
								JLabel jl1 = new JLabel("  "+s+"   小测："+sq.getQuiz().getOldname()+"   "+"开始答题");
								jl1.setFont(new Font("宋体", Font.BOLD, 14));
								jl1.setForeground(new Color(100, 149, 237));
								jl1.setPreferredSize(new Dimension(700, 30));
								jl1.setHorizontalAlignment(SwingConstants.LEFT);
								text.add(jl1);
								StartQuizMouseListener sqlistener=new StartQuizMouseListener(this,sq);
								jl1.addMouseListener(sqlistener);
							}else if(sq.getState()==1) {
								JLabel jl1 = new JLabel("  "+s+"   小测："+sq.getQuiz().getOldname()+"   正确率："+sq.getAcc()+"   答题时间："+sq.getTime()+"\n"+"   答案解析");
								jl1.setFont(new Font("宋体", Font.BOLD, 14));
								jl1.setForeground(new Color(100, 149, 237));
								jl1.setPreferredSize(new Dimension(700, 30));
								jl1.setHorizontalAlignment(SwingConstants.LEFT);
								text.add(jl1);
								StudentQuizMouseListener sqm=new StudentQuizMouseListener(this, sq);
								jl1.addMouseListener(sqm);
							}
						}
					}
				}
						
	}
	public void setStudentQuiz(String cont,StudentQuiz sq) {
		// 向centerpl中添加控件
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
		closepl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("课堂小测");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 5, 63, 23);
		closepl.add(lblNewLabel_1);

		JButton closebt = new JButton("×");
		closebt.setBounds(80, 5, 23, 23);
		closepl.add(closebt);
		closebt.addActionListener(new IndexActionListener(this));
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);

		// 内容展示标题
		JLabel title = new JLabel(sq.getQuiz().getOldname());
		title.setForeground(new Color(119, 136, 153));
		title.setFont(new Font("宋体", Font.BOLD, 16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(341, 20, 105, 26);
		contentpl.add(title);
		
		// 成绩分析按钮
		JButton analysis1 = new JButton("分   析   成   绩");
		analysis1.setBounds(650, 20, 120, 30);
		contentpl.add(analysis1);
		analysis1.addActionListener(new AnalysisScoreActionListener(sq));
		
		// 滚动条
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(30, 64);
		scrollPane.setSize(740, 200);
		scrollPane.setBorder(null);
		contentpl.add(scrollPane);
		// 资源列表容器
		JTextArea jta=new JTextArea(cont);
		jta.setFont(new Font("宋体", Font.BOLD, 16));
		jta.setForeground(SystemColor.textHighlight);
		scrollPane.setViewportView(jta);		
	}
	public void setScoreAnalysis() {// 向centerpl中添加控件
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
		closepl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("成绩分析");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 5, 63, 23);
		closepl.add(lblNewLabel_1);

		JButton closebt = new JButton("×");
		closebt.setBounds(80, 5, 23, 23);
		closepl.add(closebt);
		closebt.addActionListener(event);
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);//793, 322

		
		JPanel panel = new JPanel();
		panel.setBounds(360, 28, 386, 266);
		contentpl.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("image/11.png"));
		lblNewLabel_2.setBounds(0, 0, 386, 200);
		
		JButton jb1 = new JButton("复    习    计    划");
		panel.add(jb1);
		jb1.setBounds(0, 208, 386, 58);
		jb1.setForeground(SystemColor.textHighlight);
		jb1.setFont(new Font("黑体", Font.BOLD, 30));
		jb1.addActionListener(new AnalysisScoreActionListener());
		
		JPanel panel_1 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		panel_1.setBounds(14, 30, 340, 250);
		contentpl.add(panel_1);
		panel_1.setLayout(null);
		
		
		int i=0;
		List<StudentClass> list=new QuizDao().searchClasses();
		for(StudentClass sc:list)  {
		JButton bt3 = new JButton(sc.getClassin().getCourse().getCname()+"成绩分析");
		bt3.setForeground(SystemColor.textHighlight);
		bt3.setFont(new Font("宋体", Font.BOLD, 18));
		bt3.setBounds(60, 20+i*70, 200, 45);
		bt3.setPreferredSize(new Dimension(166,44));
		bt3.addActionListener(new AnalysisScoreActionListener(sc));
		panel_1.add(bt3);
		i++;
		}
	}
	public void setVideoScreenContent() {
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
		closepl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("录 屏");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 5, 63, 23);
		closepl.add(lblNewLabel_1);

		JButton closebt = new JButton("×");
		closebt.setBounds(80, 5, 23, 23);
		closepl.add(closebt);
		closebt.addActionListener(event);
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);//793, 322

		
		JPanel panel = new JPanel();
		panel.setBounds(377, 30, 386, 250);
		contentpl.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("image/1.png"));
		lblNewLabel_2.setBounds(0, 0, 386, 250);
		
		
		JPanel panel_1 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		panel_1.setBounds(14, 30, 340, 250);
		contentpl.add(panel_1);
		panel_1.setLayout(null);
		
		
		int i=0;
		List<String> list=new ArrayList<String>();
		list.add("开 启 录 屏");
		list.add("暂 停 录 屏");
		list.add("关 闭 录 屏");
		for(String s:list)  {
		JButton bt3 = new JButton(s);
		bt3.setForeground(SystemColor.textHighlight);
		bt3.setFont(new Font("宋体", Font.BOLD, 18));
		bt3.setBounds(60, 20+i*70, 200, 45);
		bt3.setPreferredSize(new Dimension(166,44));
		bt3.addActionListener(this.indexActionListener);
		panel_1.add(bt3);
		i++;
		}
	}
	public void jumpVideoScreen() {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setVideoScreenContent();
	}
	public void setSignRank() {
		// 向centerpl中添加控件
		JPanel closepl = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		closepl.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		closepl.setBounds(113, 14, 104, 30);
		closepl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("签到排名");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 5, 63, 23);
		closepl.add(lblNewLabel_1);

		JButton closebt = new JButton("×");
		closebt.setBounds(80, 5, 23, 23);
		closepl.add(closebt);
		closebt.addActionListener(new IndexActionListener(this));
		closebt.setBackground(null);
		closebt.setBorder(null);
		centerpl.add(closepl);

		// 内容展示标题
		JLabel title = new JLabel("签到排名");
		title.setForeground(new Color(119, 136, 153));
		title.setFont(new Font("宋体", Font.BOLD, 16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(341, 20, 105, 26);
		contentpl.add(title);
		// 滚动条
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(30, 64);
		scrollPane.setSize(740, 200);
		scrollPane.setBorder(null);
		contentpl.add(scrollPane);
		// 资源列表容器
		JPanel text = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/btbackground.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		text.setBackground(null);
		text.setForeground(new Color(173, 216, 230));
		text.setPreferredSize(new Dimension(720, 1000));
		scrollPane.setViewportView(text);
		//签到排名
		List<Students> list=new SignRankService().getEveSignRank();
		System.out.println(list.size());
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				System.out.print(i);
				JLabel jl=null;
				if((i+1)==list.size()) {
					 jl= new JLabel("      姓名："+list.get(i).getName()+"      班级："+list.get(i).getClassAdministrantion().getC_a_id());
				}else
					jl = new JLabel("      姓名："+list.get(i).getName()+"      班级："+list.get(i).getClassAdministrantion().getC_a_id()+"            姓名:"+list.get(i+1).getName()+"      班级："+list.get(i+1).getClassAdministrantion().getC_a_id());
				jl.setFont(new Font("宋体", Font.BOLD, 16));
				jl.setForeground(new Color(100, 149, 237));
				jl.setPreferredSize(new Dimension(720, 30));
				text.add(jl);
				i++;
			}
		}
	}
	public void jumpSingRank() {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setSignRank();
	}
	public void jumpScoreAnalysis() {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setScoreAnalysis();
	}
	public void jumpStudentQuiz(String cont,StudentQuiz sq) {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setStudentQuiz(cont,sq);
	}
	/**
	 * 
	 * <p>
	 * Title: jumpShareResource
	 * </p>
	 * <p>
	 * Description: 转到共享资源界面
	 * </p>
	 */
	public void jumpShareResource() {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setShareResource();
	}
	/**
	 * 
	 * <p>Title: jumpQuiz</p>
	 * <p>Description:跳转到小测页面 </p>
	 */
	public void jumpQuiz() {
		this.setBackground();
		this.setCenterpl();
		this.setContentpl();
		this.setMenu();
		this.setAuxiliaryMenu();
		this.setTime();
		this.setQuiz();
	}
	/**
	 * 
	 * <p>
	 * Title: jumpSign
	 * </p>
	 * <p>
	 * Description:转到签到界面
	 * </p>
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
	 * <p>
	 * Title: jumpRemote
	 * </p>
	 * <p>
	 * Description:转到远程监控界面
	 * </p>
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
		// 设置窗体大小
		this.setBounds(0, 0, 1000, 600);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		// 设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 窗体可见
		this.setVisible(true);
		//录屏之间监听
		this.indexActionListener=new IndexActionListener();
		// 事件监听
		event = new IndexActionListener(this);
		// 关闭窗体的事件监听
		this.addWindowListener(new WindowAdapter() {
			// 关闭窗口时，更改数据的teacherstatus状态
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 更改状态
				StudentCourseDao scs = new StudentCourseDao();
				scs.changeStudentStatus(Constant.myStudent.getSid(), 0);
				// 给老师发送命令，告诉他关闭了连接
				if (Constant.session != null) {
					FileContent f = new FileContent();
					f.setCommand(Communication.closeCommand);
					Constant.session.write(f);
				}
			}
		});
	}
}

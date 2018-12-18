package team.javaSpirit.teachingAssistantPlatform.ui.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Client;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.TeacherClassServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.event.ConnectRemindActionListener;

/**
 * 
 * <p>
 * Title: ConnectRemind
 * </p>
 * <p>
 * Description: 远程监控老师连接提醒
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月10日
 */
public class ConnectRemind extends JFrame {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private JPanel bgContentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * 
	 * <p>
	 * Title: getConnectRemind
	 * </p>
	 * <p>
	 * Description: 获得当前窗体
	 * </p>
	 * 
	 * @return
	 */
	public ConnectRemind getConnectRemind() {
		return this;
	}

	/**
	 * 
	 * <p>
	 * Title: setBackground
	 * </p>
	 * <p>
	 * Description:设置窗体背景
	 * </p>
	 */
	public void setBackground() {
		// 设置背景图
		bgContentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("img/img1.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(bgContentPane);
		bgContentPane.setLayout(null);
	}

	/**
	 * 
	 * <p>
	 * Title: setContent
	 * </p>
	 * <p>
	 * Description:设置窗体内容
	 * </p>
	 */
	public void setContent() {
		JLabel lblNewLabel = new JLabel("您要连接的老师是：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 13));
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setBounds(35, 37, 127, 34);
		getContentPane().add(lblNewLabel);
		
		//连接的老师
		TeacherClassServiceImpl tcs = new TeacherClassServiceImpl();
		JLabel connectTeacher = new JLabel(Constant.teacher.getTname());
		connectTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		connectTeacher.setFont(new Font("宋体", Font.BOLD, 14));				connectTeacher.setForeground(new Color(128, 128, 128));
		connectTeacher.setBounds(154, 37, 62, 34);
		bgContentPane.add(connectTeacher);
		// 连接按钮
		JButton connect = new JButton("连   接");
		connect.setForeground(new Color(128, 128, 128));
		connect.setBackground(null);
		connect.setFont(new Font("宋体", Font.BOLD, 14));
		connect.setBounds(132, 95, 112, 34);
		connect.addActionListener(new ConnectRemindActionListener(getConnectRemind()));
		bgContentPane.add(connect);
	}

	/**
	 * 
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description:初始化窗体
	 * </p>
	 */
	public void init() {
		this.setBackground();
		this.setContent();
	}

	public ConnectRemind() {
		// 去掉标题栏
		this.setUndecorated(true);
		// 设置为普通对话框形式
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		// 设置窗体大小
		this.setBounds(0, 0, 400, 200);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 窗体可见
		this.setVisible(true);
	}
}

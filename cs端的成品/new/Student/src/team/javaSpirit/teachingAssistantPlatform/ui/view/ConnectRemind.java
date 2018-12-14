package team.javaSpirit.teachingAssistantPlatform.ui.view;

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

import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Client;

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
		JLabel lblNewLabel = new JLabel(" 请选择您要连接的老师：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setBounds(10, 10, 155, 34);
		getContentPane().add(lblNewLabel);
		// 多选框设置
		String[] teachers = new String[] { "aaa", "nch", "ssjd" };
		JComboBox<String> boxes = new JComboBox<String>(teachers);
		boxes.setBounds(172, 17, 84, 21);
		getContentPane().add(boxes);
		// 连接按钮
		JButton connect = new JButton("连接");
		connect.setBounds(284, 16, 84, 23);
		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectRemind cr = getConnectRemind();
				cr.dispose();
				Client client = new Client();
				client.connet("localhost", 8080);
			}
		});
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

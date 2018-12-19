package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import team.javaSpirit.teachingAssistantPlatform.ui.event.LoginActionListener;

/**
 * 
* <p>Title: LoginIng</p>
* <p>Description:登录中窗体LoginIng </p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class LoginIng extends JFrame {

	private JPanel bgContentPane;

	/**
	 * Launch the application.
	 */
	public LoginIng getLoginIng() {
		return this;
	}
	/**
	 * 
	 * <p>Title: setBackground</p>
	 * <p>Description: 背景设置bgContentPane</p>
	 */
	public void setBackground() {
		/**
		 * 窗体设置
		 * */
		bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("image/bg1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        bgContentPane.setLayout(null);
        this.setContentPane(bgContentPane);
        //设置布局方式为绝对定位  
        this.getContentPane().setLayout(null);
	}
	/**
	 * 
	 * <p>Title: setCancel</p>
	 * <p>Description:取消按钮设置 </p>
	 */
	public void setCancel() {
		JButton cancel = new JButton("取消");
		cancel.setBounds(99, 280, 130, 37);
		bgContentPane.add(cancel);
		LoginActionListener la=new LoginActionListener();
		//为cancel按钮添加监听事件
		cancel.addActionListener(la);
	}
	/**
	 * 
	 * <p>Title: init</p>
	 * <p>Description:登录中界面的初始化方法 </p>
	 */
	public void init() {
		this.setBackground();
		this.setCancel();
	}

	/**
	 * Create the frame.
	 * 窗体的无参构造方法
	 */
	public LoginIng() {
		//设置窗体大小
		this.setBounds(0, 0, 320, 382);
		//窗体大小不能改变
		this.setResizable(false);
		//居中显示
		this.setLocationRelativeTo(null);
		//设置关闭状态
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置图标
		this.setIconImage(null);
		//窗体可见
		this.setVisible(true);
	}
}

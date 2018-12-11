package com.ryy.ui.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ryy.ui.student.service.StudentsServiceImpl;
import com.ryy.util.DlPropertiesUtil;
/**
 * 
* <p>Title: Login</p>
* <p>Description:CS学生端登录界面 </p>
* @author renyuyuan
* @date 2018年12月4日
 */
public class Login extends JFrame {
	/**背景容器*/
	private JPanel bgContentPane;
	/**用户名*/
	private JTextField username;
	/**密码*/
	private JPasswordField password;
	private StudentsServiceImpl studentsServiceImpl;
	private String path;
	/**
	 * 
	 * <p>Title: getLogin</p>
	 * <p>Description:获得登录窗体 </p>
	 * @return
	 */
	public Login getLogin() {
		return this;
	}
	/**
	 * 
	 * <p>Title: setBackground</p>
	 * <p>Description:设置背景bgContentPane </p>
	 */
	public void setBackground() {
		bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("img/img1.png");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(bgContentPane);
		//设置布局方式为绝对定位
		this.getContentPane().setLayout(null);
	}
	/**
	 * 
	 * <p>Title: setLogo</p>
	 * <p>Description: 设置logo</p>
	 * 
	 */
	public void setLogo() {
		/**logo图片*/
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("img/logo1.png"));
		logo.setBounds(102, 0, 110, 110);
		bgContentPane.add(logo);		
		/**
		 * logo文字
		 * */
		JLabel logoword = new JLabel("教学辅助系统");
		logoword.setForeground(SystemColor.activeCaption);
		logoword.setFont(new Font("宋体", Font.BOLD, 18));
		logoword.setHorizontalAlignment(SwingConstants.CENTER);
		logoword.setBounds(89, 120, 130, 22);
		bgContentPane.add(logoword);
	}
	/**
	 * 
	 * <p>Title: setUsername</p>
	 * <p>Description: 设置用户名</p>
	 */
	public void setUsername() {
		JLabel usernamelb = new JLabel("用户名");
		usernamelb.setForeground(Color.LIGHT_GRAY);
		usernamelb.setFont(new Font("宋体", Font.BOLD, 14));
		usernamelb.setBounds(38, 164, 54, 22);
		bgContentPane.add(usernamelb);
		String s=DlPropertiesUtil.getUsername(this.path);
		username = new JTextField(s);
		username.setBackground(new Color(240, 248, 255));
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(SystemColor.activeCaptionBorder);
		username.setFont(new Font("宋体", Font.BOLD, 14));
		username.setBounds(102, 160, 187, 30);
		username.setColumns(15);
		bgContentPane.add(username);
	}
	/**
	 * 
	 * <p>Title: setPassword</p>
	 * <p>Description:设置密码框 </p>
	 */
	public void setPassword() {
		JLabel passwordlb = new JLabel("密 码");
		passwordlb.setForeground(Color.LIGHT_GRAY);
		passwordlb.setFont(new Font("宋体", Font.BOLD, 14));
		passwordlb.setBounds(38, 219, 54, 15);
		bgContentPane.add(passwordlb);
		String s=DlPropertiesUtil.getPassword(this.path);
		password = new JPasswordField(s);
		password.setToolTipText("密码");
		password.setBackground(new Color(240, 248, 255));
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(SystemColor.activeCaptionBorder);
		password.setFont(new Font("宋体", Font.BOLD, 14));
		password.setBounds(102, 211, 187, 30);
		bgContentPane.add(password);
	}
	/**
	 * 
	 * <p>Title: setLoginButton</p>
	 * <p>Description:设置登录按钮并添加时间 </p>
	 */
	public void setLoginButton() {
		JButton loginButton = new JButton("登  录");
		loginButton.setForeground(new Color(169, 169, 169));
		loginButton.setFont(new Font("宋体", Font.BOLD, 18));
		loginButton.setBackground(null);
		loginButton.setBounds(102, 300, 130, 43);
		bgContentPane.add(loginButton);
		 // 给登录按钮添加事件
		loginButton.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                String str=e.getActionCommand();
	                if("登  录".equals(str)){
	                    String getName =username.getText();
	                    String getPwd =password.getText();
	                    if(getName==null||getName.equals("")) {
	                    	JOptionPane.showMessageDialog(null,"用户不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	                    }else if(getPwd==null||getPwd.equals("")){
	                    	JOptionPane.showMessageDialog(null,"密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	                    }else {
	                    	 int i=studentsServiceImpl.checkLoginStudent(getName, getPwd);
	                         if(i==4) {
	                        	 Login login=getLogin();
	                         	login.dispose();
	                         	Index index=new Index();
	                         	index.init();
	                         }else if(i==1) {
	                           JOptionPane.showMessageDialog(null,"用户不存在","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	                         }else if(i==2) {
	                        	 JOptionPane.showMessageDialog(null,"该用户不能登录","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	                         }else if(i==3) {
	                        	 JOptionPane.showMessageDialog(null,"密码不正确","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	                         }
	                    }
	                }
	            }
           
        });
	}
	/**
	 * 
	 * <p>Title: setRememberPassword</p>
	 * <p>Description:记住密码模块 </p>
	 */
	public void setRememberPassword() {
		boolean b=DlPropertiesUtil.getRemberPassword(this.path);
		JRadioButton rememberPassword = new JRadioButton("记住密码",b);
		rememberPassword.setForeground(SystemColor.textInactiveText);
		rememberPassword.setBounds(102, 260, 121, 23);
		rememberPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rememberPassword.isSelected()) {
					DlPropertiesUtil.setDlProperties(true, username.getText(), password.getText(),path);
				}else {
					DlPropertiesUtil.setDlProperties(false, "", "",path);
				}
			}
			
		});
		bgContentPane.add(rememberPassword);
	}
	/**
	 * <p>Title: setModifyPassword</p>
	 * <p>Description:修改密码模块 </p>
	 */
	public void setModifyPassword() {
		JLabel modifyPassword = new JLabel("修改密码");
		modifyPassword.setForeground(SystemColor.textInactiveText);
		modifyPassword.setBounds(235, 264, 54, 15);
		modifyPassword.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Modify modify=new Modify();
				modify.init();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		bgContentPane.add(modifyPassword);
	}
	/**
	 * 
	 * <p>Title: init</p>
	 * <p>Description:初始化登录窗体并加入相关组件 </p>
	 */
	
	public void setLoginIng() {
		this.invalidate();
		this.repaint();
		this.setVisible(true);
		this.bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("img/bg1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        username=null;
        password=null;
        JLabel logoword = new JLabel("*******");
		logoword.setForeground(SystemColor.activeCaption);
		logoword.setFont(new Font("宋体", Font.BOLD, 18));
		logoword.setHorizontalAlignment(SwingConstants.CENTER);
		logoword.setBounds(99, 242, 130, 22);
		bgContentPane.add(logoword);
		JButton cancel = new JButton("取消");
		cancel.setBounds(99, 280, 130, 37);
		bgContentPane.add(cancel);
		bgContentPane.repaint();
		
	}
	public void init() {
		this.studentsServiceImpl=new StudentsServiceImpl();
		path=this.getClass().getResource("/dl.properties").getPath();
		this.setBackground();
		this.setLogo();
		this.setUsername();
		this.setPassword();
		this.setLoginButton();
		this.setRememberPassword();
		this.setModifyPassword();
	}
	
	/***
	 * 创建登录窗体
	 */
	public Login() {
		/**
		 * 窗体设置
		 * */
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

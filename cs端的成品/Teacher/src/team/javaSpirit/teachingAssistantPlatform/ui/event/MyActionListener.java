package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import team.javaSpirit.teachingAssistantPlatform.ui.Index;
import team.javaSpirit.teachingAssistantPlatform.ui.Login;

/**
 * <p>
 * Title: MyActionListener
 * </p>
 * <p>
 * Description: 监听按钮的相关事件。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月6日
 */
public class MyActionListener implements ActionListener {

	/* 用户名的文本框 */
	private JTextField username;
	/* 登录界面对应的对象 */
	private Login login;

	/**
	* <p>Title: </p>  
	* <p>Description: 无参构造函数</p>
	 */
	public MyActionListener() {
		super();
	}

	/**
	* <p>Title: </p>  
	* <p>Description: 有参构造函数，对login和username对象进行赋值。</p>  
	* @param login
	* @param username
	 */
	public MyActionListener(Login login, JTextField username) {
		this.login = login;
		this.username = username;
	}

	/**
	 * 点击登录按钮，提示输入的用户名，老师根据提示，进行相对应的选择。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if ("登  录".equals(str)) {
			String getName = username.getText();
			JOptionPane.showConfirmDialog(null, "您输入的用户名是" + getName);
		}
		login.dispose();
		Index index = new Index();
		index.init();

	}

}

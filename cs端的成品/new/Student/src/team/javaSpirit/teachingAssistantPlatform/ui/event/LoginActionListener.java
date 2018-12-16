package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;

import team.javaSpirit.teachingAssistantPlatform.login.service.LoadStudentServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Login;
import team.javaSpirit.teachingAssistantPlatform.ui.view.LoginIng;
import team.javaSpirit.teachingAssistantPlatform.util.DlPropertiesUtil;



/**
 * 
* <p>Title: LoginActionListener</p>
* <p>Description: 为Login界面添加事件监听事件</p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class LoginActionListener implements ActionListener {

	private Login login;
	private static LoginIng loginIng;
	private static boolean isCancel=false;
	/**
	 * 当触发事件时自动调用此方法实现业务逻辑
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if(str.equals("登  录")) {
			this.setLoginButton();
		}else if("记住密码".equals(str)) {
			JRadioButton s=(JRadioButton)e.getSource();
			this.setRemberPassword(s);
		}else if("取消".equals(str)) {
			JButton jb=(JButton)e.getSource();
			this.setCancelButton(jb);
		}
		
	}
	/**
	 * 有参构造方法
	 * @param login
	 */
	public LoginActionListener(Login login) {
		this.login=login;
	}
	/**
	 * 无参构造方法
	 */
	public LoginActionListener() {
	}
	/**
	 * 
	 * <p>Title: setRemberPassword</p>
	 * <p>Description:单击“记得密码”时触发此业务逻辑 </p>
	 * @param s
	 */
	public void setRemberPassword(JRadioButton s) {
		String path=this.login.getPath();
		if(true==s.isSelected()) {
			//一旦“记住密码”被选中就把dl.properties文件中“remberpassword"标志改为true
			DlPropertiesUtil.setRemberword(path, true);
		}else {
			//“记住密码”没被选中时"remberpassword"标志设为false，"username"和"password"设为“”
			DlPropertiesUtil.setDlProperties(false, "", "",path);
		}
	}
	/**
	 * 
	 * <p>Title: setLoginButton</p>
	 * <p>Description: 登录按钮点击时触发此业务逻辑</p>
	 */
	public void setLoginButton() {
		String getName=login.getUsername().getText();
		String getPwd=login.getPassword().getText();
		//username和password框为空时直接给出提醒
		if(getName==null||getName.equals("")) {
        	JOptionPane.showMessageDialog(null,"用户不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else if(getPwd==null||getPwd.equals("")){
        	JOptionPane.showMessageDialog(null,"密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else {
        	//跳转到登录中的界面，关闭Login界面
        	 String path=login.getPath();
             this.login.dispose();
             this.loginIng=new LoginIng();
             this.loginIng.init();
             //开启一个新线程取数据库查询验证用户信息
             new SwingWorker<String, String>() {
            	 /**
            	  * 在数据中查询验证用户信息并给出相应提示
            	  */
				@Override
				protected String doInBackground() throws Exception {
					LoadStudentServiceImpl studentsServiceImpl=new LoadStudentServiceImpl();
			        int i=studentsServiceImpl.checkLoginStudent(getName, getPwd);
			          if(i==4) {
			        	  //登录成功后判断是否记得密码，如果rememberpassword标志为true重新加载设立用户存储信息
			            if(DlPropertiesUtil.getRemberPassword(path)==true) 
			              	DlPropertiesUtil.setDlProperties(true, getName, getPwd, path);
			            return "1";
			          }else if(i==1) {
			            	 if(isCancel==false) 
			            		 JOptionPane.showMessageDialog(null,"用户不存在","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
			         }else if(i==2) {
			            	 if(isCancel==false) 
			            		 JOptionPane.showMessageDialog(null,"该用户不能登录","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
		             }else if(i==3) {
			            	 if(isCancel==false) 
			            		 JOptionPane.showMessageDialog(null,"密码不正确","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
		             }
			             return "2";
				}
				/**
				 * 从数据中查询完信息后操作窗体
				 */
				protected void done() {
					try {
						String s=get();
						if(isCancel==false) {
							loginIng.dispose();
							if("1".equals(s)) {
								Index index=new Index();
								index.init();
							}else {
								Login login=new Login();
								login.init();
							}
						}
						isCancel=false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
			    }
              }.execute();
        }
       }
		
	/**
	 * 
	 * <p>Title: setCancelButton</p>
	 * <p>Description:登录中窗体取消按钮点击后触发次业务逻辑 </p>
	 * @param jb
	 */
	public void setCancelButton(JButton jb) {
		this.isCancel=true;
		if(this.loginIng!=null) {
			this.loginIng.dispose();
		}
		Login login=new Login();
		login.init();
	}
}

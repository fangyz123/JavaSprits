package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;


public class LoginActionListener implements ActionListener {

	private Login login;
	private static LoginIng loginIng;
	private static boolean isCancel=false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
	public LoginActionListener(Login login) {
		this.login=login;
	}
	public LoginActionListener() {
	}
	public void setRemberPassword(JRadioButton s) {
		String path=this.login.getPath();
		if(true==s.isSelected()) {
			DlPropertiesUtil.setRemberword(path, true);
//			DlPropertiesUtil.setDlProperties(true, username.getText(), password.getText(),path);
		}else {
			DlPropertiesUtil.setDlProperties(false, "", "",path);
		}
	}
	public void setLoginButton() {
		String getName=login.getUsername().getText();
		String getPwd=login.getPassword().getText();
		if(getName==null||getName.equals("")) {
        	JOptionPane.showMessageDialog(null,"用户不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else if(getPwd==null||getPwd.equals("")){
        	JOptionPane.showMessageDialog(null,"密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else {
        	 String path=login.getPath();
             this.login.dispose();
             this.loginIng=new LoginIng();
             this.loginIng.init();
             new SwingWorker<String, String>() {
				@Override
				protected String doInBackground() throws Exception {
					StudentsServiceImpl studentsServiceImpl=new StudentsServiceImpl();
			        int i=studentsServiceImpl.checkLoginStudent(getName, getPwd);
			          if(i==4) {
			            if(DlPropertiesUtil.getRemberPassword(path)==true) {
			              	DlPropertiesUtil.setDlProperties(true, getName, getPwd, path);
			            }
			            return "1";
			             }else if(i==1) {
			            	 if(isCancel==false) {
			            		 JOptionPane.showMessageDialog(null,"用户不存在","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
			            	 }
			               return "2";
			             }else if(i==2) {
			            	 if(isCancel==false) {
			            		 JOptionPane.showMessageDialog(null,"该用户不能登录","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
			            	 }
			                 return "2";
			             }else if(i==3) {
			            	 if(isCancel==false) {
			            		 JOptionPane.showMessageDialog(null,"密码不正确","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
			            	 }
			                 return "2";
			             }
			             return "2";
				}
			
				protected void done() {
					try {
						String s=get();
						System.out.println(isCancel);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
              }.execute();
        }
		System.out.println(isCancel);
    }

	public void setCancelButton(JButton jb) {
		System.out.println(111111);
		this.isCancel=true;
		System.out.println(this.isCancel);
		if(this.loginIng!=null) {
			this.loginIng.dispose();
		}
		Login login=new Login();
		login.init();
	}
}

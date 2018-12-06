package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.ConnectStudent;
/**
 * 
* <p>Title: Client</p>
* <p>Description:这是教师端（客户端）与学生端建立连接后进行相关数据的交互 </p>
* @author 何慧霞
* @date 2018年12月4日
 */
public class Client {

	public static void main(String[] args) throws Exception {
		ConnectStudent cn = new ConnectStudent();

		cn.conn2Server("10.7.84.43", 9090);

		// "10.7.89.22""localhost" "10.7.84.42" 10.7.84.78 10.7.84.37

	}

}

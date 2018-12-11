package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.OpenConnection;
/**
 * 
* <p>Title: Client</p>
* <p>Description:学生端，被控制端，客户端。教师端开启端口后，学生端连接。 </p>
* @author 何慧霞
* @date 2018年12月11日
 */
public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// 开启服务
		try {
			new OpenConnection().conn2Server("localhost", 9090);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// "10.7.89.22""localhost" "10.7.84.42" 10.7.84.78 10.7.84.37
	}

}

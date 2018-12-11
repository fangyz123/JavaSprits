package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.ConnectStudent;
/**
 * 
* <p>Title: Service</p>
* <p>Description:这是教师端，同时是服务器端，先开启这个。 </p>
* @author 何慧霞
* @date 2018年12月11日
 */
public class Service {

	public Service() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		ConnectStudent cn = new ConnectStudent();

		cn.setupServer(9090);

		

	}
}

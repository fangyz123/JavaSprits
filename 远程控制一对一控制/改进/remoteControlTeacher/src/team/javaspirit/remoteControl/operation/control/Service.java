package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.ConnectStudent;
/**
 * 
* <p>Title: Service</p>
* <p>Description:���ǽ�ʦ�ˣ�ͬʱ�Ƿ������ˣ��ȿ�������� </p>
* @author �λ�ϼ
* @date 2018��12��11��
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

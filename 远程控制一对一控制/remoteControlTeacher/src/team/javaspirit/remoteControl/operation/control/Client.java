package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.ConnectStudent;
/**
 * 
* <p>Title: Client</p>
* <p>Description:���ǽ�ʦ�ˣ��ͻ��ˣ���ѧ���˽������Ӻ����������ݵĽ��� </p>
* @author �λ�ϼ
* @date 2018��12��4��
 */
public class Client {

	public static void main(String[] args) throws Exception {
		ConnectStudent cn = new ConnectStudent();

		cn.conn2Server("10.7.84.43", 9090);

		// "10.7.89.22""localhost" "10.7.84.42" 10.7.84.78 10.7.84.37

	}

}

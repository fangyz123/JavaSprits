package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.OpenConnection;
/**
 * 
* <p>Title: Client</p>
* <p>Description:ѧ���ˣ������ƶˣ��ͻ��ˡ���ʦ�˿����˿ں�ѧ�������ӡ� </p>
* @author �λ�ϼ
* @date 2018��12��11��
 */
public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// ��������
		try {
			new OpenConnection().conn2Server("localhost", 9090);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// "10.7.89.22""localhost" "10.7.84.42" 10.7.84.78 10.7.84.37
	}

}

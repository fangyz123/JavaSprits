package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.OpenConnection;

/**
 * 
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description:ѧ����ͬ�⿪��������ʦ�˿��ơ�������Ҫд��ѧ���ˣ����������ȿ����˿ڷ��񣬵ȴ�
 * ��ʦ�ˣ��ͻ��ˣ������ӡ�
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��12��3��
 */
public class Service {

	public static void main(String[] args) {
		// ��������
		try {
			new OpenConnection().setupServer(9090);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

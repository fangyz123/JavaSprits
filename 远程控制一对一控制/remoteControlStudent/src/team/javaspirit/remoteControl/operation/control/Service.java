package team.javaspirit.remoteControl.operation.control;

import team.javaspirit.remoteControl.operation.service.OpenConnection;

/**
 * 
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description:学生端同意开启，被教师端控制。这里主要写上学生端（服务器）先开启端口服务，等待
 * 教师端（客户端）的连接。
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年12月3日
 */
public class Service {

	public static void main(String[] args) {
		// 开启服务
		try {
			new OpenConnection().setupServer(9090);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

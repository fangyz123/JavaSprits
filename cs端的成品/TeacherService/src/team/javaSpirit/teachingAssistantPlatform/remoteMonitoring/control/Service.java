package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.control;

import java.io.IOException;

import team.javaSpirit.teachingAssistantPlatform.mina.Configure;

/**
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description: 服务器实现主类。主要实现客户端与服务器的连接，达到两机通信的功能
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年11月28日
 */
public class Service {
	private Configure configure;

	public void openService() {
		// new一个mina框架配置基本信息的对象
		configure = new Configure();
		// 对连接的对象的基本信息进行初始化
		configure.init();
		try {
			// 开启服务，端口是8080
			configure.service(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeServise() {
		configure.getAccept().dispose();
		if (configure.getAccept().isDisposed()) {
			System.out.println("cheng");
		}
	}

	/**
	 * <p>Title: getConfigure</p>
	 * <p>Description: 获得Configure对象</p>
	 * @return
	 */
	public Configure getConfigure() {
		return configure;
	}

	public void setConfigure(Configure configure) {
		this.configure = configure;
	}

}

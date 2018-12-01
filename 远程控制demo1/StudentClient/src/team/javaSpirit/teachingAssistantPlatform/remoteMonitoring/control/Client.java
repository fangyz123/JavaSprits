package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.control;

import java.io.IOException;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import team.javaSpirit.teachingAssistantPlatform.mina.Configure;
import team.javaSpirit.teachingAssistantPlatform.mina.SessionListener;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.SendMessage;

/**
* <p>Title: Client</p>
* <p>Description: 客户端开启的接口。</p>
* @author Fang Yuzhen
* @date 2018年11月28日
 */
public class Client {

	public static void main(String[] args) {
		//new一个mina框架配置基本信息的对象
		Configure configure=new Configure();
		//对连接的对象的基本信息进行初始化
		configure.init();
		try {
			//连接
			//10.7.84.42  10.7.89.163
			configure.connect("10.7.84.42", 8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获得连接对象
		NioSocketConnector connector=configure.getConnector();
		//监听连接对象的会话session的状态，以进行重连
<<<<<<< HEAD
		connector.addListener(new SessionListener(connector));
=======
		connector.addListener(new SessionListener());
>>>>>>> f53d67d4cab128083b7fc5ceedb1255838cadeb9
		//得到session
		IoSession session=configure.getSession();
		//发送命令为1的对象
		SendMessage sendMessage=new SendMessage();
		byte comand=1;
		sendMessage.sendComand(session, comand);
	}

}

package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.mina.transport.socket.nio.NioSocketConnector;

import team.javaSpirit.teachingAssistantPlatform.mina.Configure;
import team.javaSpirit.teachingAssistantPlatform.mina.SessionListener;

/**
 * <p>
 * Title: Client
 * </p>
 * <p>
 * Description: 客户端开启的接口。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年11月28日
 */
public class Client {

	public void connet(String ip, int port) {
		// new一个mina框架配置基本信息的对象
		Configure configure = new Configure();
		// 对连接的对象的基本信息进行初始化
		configure.init();
		// 连接
		configure.connect(ip, port);
		// 获得连接对象
		NioSocketConnector connector = configure.getConnector();
		// 监听连接对象的会话session的状态，以进行重连
		connector.addListener(new SessionListener(connector));
		
	}
}

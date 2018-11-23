package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.control;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.TCommunicaIoHandle;

/**
 * 
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description: 服务器实现主类。主要实现客户端与服务器的连接，达到两机通信的功能
 * </p>
 * 
 * @author fang yuzhen
 * @date 2018年11月19日
 */
public class Service {

	public static void main(String[] args) {
		// 编码和解码工厂,可以传大数据量
		ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();

		objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);

		objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);

		NioSocketAcceptor accept = new NioSocketAcceptor();

		// 设置读取数据的缓冲区大小
		accept.getSessionConfig().setReadBufferSize(2048);
		
		// 设置编码过滤器
		accept.getFilterChain().addLast("codec",

				new ProtocolCodecFilter(objectSerializationCodecFactory));
		// 添加内置日志
		accept.getFilterChain().addLast("logging", new LoggingFilter());
		// 设置适配器（监听）
		accept.setHandler(new TCommunicaIoHandle());

		try {
			accept.bind(new InetSocketAddress(8999));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			// 获得IP
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();
//			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

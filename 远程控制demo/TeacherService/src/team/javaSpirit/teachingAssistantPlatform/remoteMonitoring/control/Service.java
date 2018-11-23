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
 * Description: ������ʵ�����ࡣ��Ҫʵ�ֿͻ���������������ӣ��ﵽ����ͨ�ŵĹ���
 * </p>
 * 
 * @author fang yuzhen
 * @date 2018��11��19��
 */
public class Service {

	public static void main(String[] args) {
		// ����ͽ��빤��,���Դ���������
		ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();

		objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);

		objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);

		NioSocketAcceptor accept = new NioSocketAcceptor();

		// ���ö�ȡ���ݵĻ�������С
		accept.getSessionConfig().setReadBufferSize(2048);
		
		// ���ñ��������
		accept.getFilterChain().addLast("codec",

				new ProtocolCodecFilter(objectSerializationCodecFactory));
		// ���������־
		accept.getFilterChain().addLast("logging", new LoggingFilter());
		// ������������������
		accept.setHandler(new TCommunicaIoHandle());

		try {
			accept.bind(new InetSocketAddress(8999));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			// ���IP
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();
//			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

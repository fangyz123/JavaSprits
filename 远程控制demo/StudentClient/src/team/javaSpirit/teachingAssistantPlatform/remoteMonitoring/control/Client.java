package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.control;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.SCommunicaIoHandle;

/**
 * <p>
 * Title: Client
 * </p>
 * <p>
 * Description: �ͻ���ʵ�����ࡣ��Ҫʵ�ֿͻ���������������ӣ��ﵽ����ͨ�ŵĹ���
 * </p>
 * 
 * @author fang yuzhen
 * @date 2018��11��19��
 */
public class Client {

	public static void main(String[] args) {
		// ����ͽ��빤��,���Դ���������
		ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();

		objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);

		objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);

		// �ͻ��˵�ʵ��
		// ����һ���׽�������
		NioSocketConnector connector = new NioSocketConnector();
		// �������ӳ�ʱ
		connector.setConnectTimeoutMillis(3000);

		// ���ñ��������
		connector.getFilterChain().addLast("codec",

				new ProtocolCodecFilter(objectSerializationCodecFactory));
		// ���������־
		connector.getFilterChain().addLast("logging", new LoggingFilter());

		// ��д������ʱ��:5��
//		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
		// ��(����ͨ��)����ʱ��:5��
		connector.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, 3);
		// д(����ͨ��)����ʱ��:5��
//		connector.getSessionConfig().setIdleTime(IdleStatus.WRITER_IDLE, 5);

		// ������������������
		connector.setHandler(new SCommunicaIoHandle());

		connector.getSessionConfig().setUseReadOperation(true);

		// ����Ĭ�Ϸ��ʵ�ַlocalhost
		connector.setDefaultRemoteAddress(new InetSocketAddress("10.7.84.42", 8999));
//		connector.setDefaultRemoteAddress(new InetSocketAddress("localhost", 8999));
		ConnectFuture connectFuture = connector.connect();

		// д�����Ϊ�˵õ������session ��˼�ǵȴ����Ӵ������ �ô����������첽��ͬ��
		FileContent fc = new FileContent();
		byte b = 1;
		fc.setCommand(b);
		connectFuture.awaitUninterruptibly();
		IoSession session = connectFuture.getSession();
		session.getConfig().setUseReadOperation(true);
		session.write(fc);

		connector.addListener(new IoServiceListener() {

			@Override
			public void sessionDestroyed(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("aaa");
				int waitTime=0;
				for (int i = 0; i < 3; i++) {

					try {
						waitTime = waitTime + 2000 * (i + 1);
						Thread.sleep(waitTime);
						
						ConnectFuture connectFuture = connector.connect();

						connectFuture.awaitUninterruptibly();// �ȴ����Ӵ����ɹ�

						session = connectFuture.getSession();// ��ȡ�Ự
						
						if (session.isConnected()) {
							System.out.println("���ӳɹ�");

							break;

						}

					} catch (Exception ex) {

						System.out.println("������������¼ʧ��,5��������һ��:" + ex.getMessage());

					}
				}
			}

			@Override
			public void sessionCreated(IoSession session) throws Exception {
				System.out.println("sessionCreated");
				FileContent fc = new FileContent();
				byte b = 1;
				fc.setCommand(b);
				session.write(fc);
			}

			@Override
			public void sessionClosed(IoSession arg0) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("111");

			}

			@Override
			public void serviceIdle(IoService arg0, IdleStatus arg1) throws Exception {
				System.out.println("serviceIdle");

			}

			@Override
			public void serviceDeactivated(IoService arg0) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void serviceActivated(IoService arg0) throws Exception {
				// TODO Auto-generated method stub

			}
		});

		session.getCloseFuture().awaitUninterruptibly();

	}

}

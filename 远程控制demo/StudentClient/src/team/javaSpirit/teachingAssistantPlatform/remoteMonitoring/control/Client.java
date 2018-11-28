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
 * Description: 客户端实现主类。主要实现客户端与服务器的连接，达到两机通信的功能
 * </p>
 * 
 * @author fang yuzhen
 * @date 2018年11月19日
 */
public class Client {

	public static void main(String[] args) {
		// 编码和解码工厂,可以传大数据量
		ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();

		objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);

		objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);

		// 客户端的实现
		// 创建一个套接字连接
		NioSocketConnector connector = new NioSocketConnector();
		// 设置连接超时
		connector.setConnectTimeoutMillis(3000);

		// 设置编码过滤器
		connector.getFilterChain().addLast("codec",

				new ProtocolCodecFilter(objectSerializationCodecFactory));
		// 添加内置日志
		connector.getFilterChain().addLast("logging", new LoggingFilter());

		// 读写都空闲时间:5秒
//		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
		// 读(接收通道)空闲时间:5秒
		connector.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, 3);
		// 写(发送通道)空闲时间:5秒
//		connector.getSessionConfig().setIdleTime(IdleStatus.WRITER_IDLE, 5);

		// 设置适配器（监听）
		connector.setHandler(new SCommunicaIoHandle());

		connector.getSessionConfig().setUseReadOperation(true);

		// 设置默认访问地址localhost
		connector.setDefaultRemoteAddress(new InetSocketAddress("10.7.84.42", 8999));
//		connector.setDefaultRemoteAddress(new InetSocketAddress("localhost", 8999));
		ConnectFuture connectFuture = connector.connect();

		// 写上这句为了得到下面的session 意思是等待连接创建完成 让创建连接由异步变同步
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

						connectFuture.awaitUninterruptibly();// 等待连接创建成功

						session = connectFuture.getSession();// 获取会话
						
						if (session.isConnected()) {
							System.out.println("连接成功");

							break;

						}

					} catch (Exception ex) {

						System.out.println("重连服务器登录失败,5秒再连接一次:" + ex.getMessage());

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

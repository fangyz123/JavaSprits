/**  
* <p>Title: Configure.java</p>  
* <p>Description: </p>
* <p>Copyright: javaSpirit</p>
* @author fang yuzhen
* @date 2018年11月28日  
* @version 1.0  
*/
package team.javaSpirit.teachingAssistantPlatform.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.swing.JOptionPane;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * <p>
 * Title: Configure
 * </p>
 * <p>
 * Description: mina框架使用的基本配置类。为连接对象设置传输的对象序列化工厂、监听器，日志等信息。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年11月28日
 */
public class Configure {
	/* 连接对象 */
	private NioSocketConnector connector = null;
	/* 设置传输方式的对象 */
	private ConnectFuture connectFuture = null;
	/* 通信的会话 */
	private IoSession session = null;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 无参构造函数
	 * </p>
	 */
	public Configure() {

	}

	/**
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description: 初始化函数。 为连接new一个对象，设置连接超时时间、编码过滤器、日志。 设置监听处理类，处理消息的接收情况、读空闲时间。
	 * </p>
	 */
	public void init() {
		// 客户端的实现
		// 创建一个连接对象
		connector = new NioSocketConnector();
		// 设置连接超时
		connector.setConnectTimeoutMillis(3000);

		// 编码和解码工厂,可以传大数据量
		ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();

		objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);

		objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);
		// 设置编码过滤器
		connector.getFilterChain().addLast("codec",

				new ProtocolCodecFilter(objectSerializationCodecFactory));
		// 添加内置日志
		connector.getFilterChain().addLast("logging", new LoggingFilter());

		// 读(接收通道)空闲时间:3秒
		connector.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, 30);

		// 设置适配器（监听）
		connector.setHandler(new SCommunicaIoHandle());

		connector.getSessionConfig().setUseReadOperation(true);
	}

	/**
	 * <p>
	 * Title: connect
	 * </p>
	 * <p>
	 * Description: 连接函数。设置连接的IP和端口号。 设置传输的方式是同步；得到一个网络通信的会话。
	 * </p>
	 * 
	 * @param ip   服务器的IP地址
	 * @param port 开启服务的端口号
	 * @throws IOException
	 */
	public void connect(String ip, int port){
		// 设置默认访问地址localhost
		connector.setDefaultRemoteAddress(new InetSocketAddress(ip, port));
		connectFuture = connector.connect();
		connectFuture.awaitUninterruptibly();
		try {
			session = connectFuture.getSession();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "没开网络或没网络");
		}
		
	}

	/**
	 * <p>
	 * Title: getConnector
	 * </p>
	 * <p>
	 * Description: 返回连接的对象
	 * </p>
	 * 
	 * @return NioSocketConnector类型的对象
	 */
	public NioSocketConnector getConnector() {
		return connector;
	}

	/**
	 * <p>
	 * Title: setConnector
	 * </p>
	 * <p>
	 * Description: 设置连接的对象
	 * </p>
	 * 
	 * @param connector 传进来的NioSocketConnector类型的对象
	 */
	public void setConnector(NioSocketConnector connector) {
		this.connector = connector;
	}

	/**
	 * <p>
	 * Title: getConnectFuture
	 * </p>
	 * <p>
	 * Description: 返回设置传输方式的对象
	 * </p>
	 * 
	 * @return ConnectFuture类型的对象
	 */
	public ConnectFuture getConnectFuture() {
		return connectFuture;
	}

	/**
	 * <p>
	 * Title: setConnectFuture
	 * </p>
	 * <p>
	 * Description: 设置传输方式的对象
	 * </p>
	 * 
	 * @param connectFuture 传进来的ConnectFuture类型的对象
	 */
	public void setConnectFuture(ConnectFuture connectFuture) {
		this.connectFuture = connectFuture;
	}

	/**
	 * <p>
	 * Title: getSession
	 * </p>
	 * <p>
	 * Description: 得到一个网络通信的会话
	 * </p>
	 * 
	 * @return IoSession类型的对象
	 */
	public IoSession getSession() {
		return session;
	}

	/**
	 * <p>
	 * Title: setSession
	 * </p>
	 * <p>
	 * Description: 设置网络通信的会话
	 * </p>
	 * 
	 * @param session 传进来的IoSession类型的对象
	 */
	public void setSession(IoSession session) {
		this.session = session;
	}

}

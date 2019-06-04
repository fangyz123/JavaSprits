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

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

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
	private NioSocketAcceptor accept = null;

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
	public void init(Index index) {
		// 创建一个连接对象
		accept = new NioSocketAcceptor();
		// 编码和解码工厂,可以传大数据量
		ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();
		objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);
		objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);
		// 设置编码过滤器
		accept.getFilterChain().addLast("codec",

				new ProtocolCodecFilter(objectSerializationCodecFactory));
		// 添加内置日志
		accept.getFilterChain().addLast("logging", new LoggingFilter());
		// 设置适配器（监听）
		accept.setHandler(new TCommunicaIoHandle(index));
	}

	/**
	 * <p>
	 * Title: service
	 * </p>
	 * <p>
	 * Description: 开启服务的函数。
	 * </p>
	 * 
	 * @param port 传进来的端口号
	 * @throws IOException
	 */
	public void service(int port) throws IOException {
		accept.bind(new InetSocketAddress(port));
	}

	public NioSocketAcceptor getAccept() {
		return accept;
	}

	public void setAccept(NioSocketAcceptor accept) {
		this.accept = accept;
	}

}

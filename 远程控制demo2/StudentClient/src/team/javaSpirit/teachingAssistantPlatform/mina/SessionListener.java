package team.javaSpirit.teachingAssistantPlatform.mina;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import org.apache.mina.transport.socket.nio.NioSocketConnector;


import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.SendMessage;

/**
 * <p>
 * Title: SessionListener
 * </p>
 * <p>
 * Description: 实现IoServiceListener接口。 对会话session的状态进行监听，对相应的session状态进行不同的操作。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年11月28日
 */
public class SessionListener implements IoServiceListener {
	/* mina框架的基本配置对象 */
	private NioSocketConnector connector;

	public SessionListener(NioSocketConnector connector) {
		this.connector=connector;
	}

	@Override
	public void serviceActivated(IoService arg0) throws Exception {
		System.out.println("SessionListener  serviceActivated");
	}

	@Override
	public void serviceDeactivated(IoService arg0) throws Exception {
		System.out.println("SessionListener  serviceDeactivated");
	}

	@Override
	public void serviceIdle(IoService arg0, IdleStatus arg1) throws Exception {
		System.out.println("SessionListener  serviceIdle");
	}

	@Override
	public void sessionClosed(IoSession arg0) throws Exception {
		System.out.println("SessionListener  sessionCloseds");
	}

	/**
	 * 当重连成功时，对服务器发送命令。让服务器知道当前客户端的存在， 服务器返回命令对应的信息。
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		SendMessage sendMessage = new SendMessage();
		byte comand = 1;
		sendMessage.sendComand(session, comand);
	}

	/**
	 * 当session销毁时，进行3次的重连操作。一个10秒的时间。 以1s,3s,6s的机制重连一次。
	 * 
	 * @throws InterruptedException
	  */
	@Override
	public void sessionDestroyed(IoSession session) throws InterruptedException {
		int waitTime = 0;
		for (int i = 1; i <= 3; i++) {
			waitTime = waitTime + 1000 * i;
			Thread.sleep(waitTime);
			ConnectFuture connectFuture = connector.connect();
			// 等待连接创建成功，同步的方式发送信息
			connectFuture.awaitUninterruptibly();
			// 获取会话
			session = connectFuture.getSession();
			if (session.isConnected()) {
				System.out.println("连接成功");
				break;
			}
		}
		if (!session.isConnected()) {
			System.out.println("10s重连失败，请检查网络后，手动重连！");
		}
	}

}

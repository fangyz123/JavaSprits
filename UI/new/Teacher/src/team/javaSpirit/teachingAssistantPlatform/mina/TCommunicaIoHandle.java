package team.javaSpirit.teachingAssistantPlatform.mina;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service.StudentServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

/**
 * <p>
 * Title: SCommunicaIoHandle
 * </p>
 * <p>
 * Description: 老师服务端处理器。接收客户端传递的信息，对其进行相对应的处理。 判断session的不同状态，
 * 进行相对应的操作。当有学生连接时，重置学生演示页面。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年11月28日
 */
public class TCommunicaIoHandle extends IoHandlerAdapter {
	/* 页面对象 */
	private Index index;
	/* 通过IP查找名字的服务对象 */
	private StudentServiceImpl ss;

	/**
	 * 监听学生端写过来的信息，将其接收并对其内容进行相对应的回复。
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {

	}

	/**
	 * 监听服务器 写客户端给的信息，在其进行相对应的处理
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
	}

	public TCommunicaIoHandle(Index index) {
		ss = new StudentServiceImpl();
		this.index = index;
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		if (session != null) {
			session.getCloseFuture();
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		String clientIP = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
		String name = ss.findName(clientIP);
		Constant.studentSession.put(name, session);
		this.index.getSuspensionbox().setIsdisplay(false);
		this.index.getSuspensionbox().dispose();
		this.index.dispose();
		this.index.init();
	}

}

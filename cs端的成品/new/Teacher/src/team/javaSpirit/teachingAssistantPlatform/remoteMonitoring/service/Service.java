package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.common.Communication;
import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.entity.FileShare;
import team.javaSpirit.teachingAssistantPlatform.mina.Configure;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

/**
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description: 服务器实现主类。主要实现客户端与服务器的连接，达到两机通信的功能
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年11月28日
 */
public class Service {
	/* 初始化类的对象 */
	private Configure configure;
	/* 设置图片的线程 */
	private SetMessageThread setMessage = null;
	private List<SendMessageThread> sendMessageThreads = new ArrayList<SendMessageThread>();
	// new一个图片设置和获得图片的对象
	private FileShare fileShare = null;
	// 服务开启成功，对数据库的操作对象
	ServiceOperationServiceImpl serviceOpen = new ServiceOperationServiceImpl();
	/* 页面对象 */
	private Index index;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 有参构造函数。
	 * </p>
	 * 
	 * @param index index页面
	 */
	public Service(Index index) {
		super();
		this.index = index;
	}

	/**
	 * <p>
	 * Title: openService
	 * </p>
	 * <p>
	 * Description: 进行mina框架的基本配置，开启8080端口的服务
	 * </p>
	 */
	public void openService(int port) {
		// new一个mina框架配置基本信息的对象
		configure = new Configure();
		// 对连接的对象的基本信息进行初始化
		configure.init(index);
		try {
			// 开启服务，端口是8080
			configure.service(port);
			// 开启服务，把老师的状态改为1
			serviceOpen.updateStatus(1);
			// 服务开启成功，给出提示
			JOptionPane.showMessageDialog(null, "开启服务成功。");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "已经开启过服务了。");
		}
	}

	/**
	 * <p>
	 * Title: closeServise
	 * </p>
	 * <p>
	 * Description: 关闭连接服务
	 * </p>
	 */
	public void closeServise() {
		configure.getAccept().dispose();
		// 如果关闭成功，给出提示
		if (configure.getAccept().isDisposed()) {
			// 关闭服务，把老师的状态改为0
			serviceOpen.updateStatus(0);
			JOptionPane.showMessageDialog(null, "服务关闭成功。", "提示", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * <p>
	 * Title: openScreenShare
	 * </p>
	 * <p>
	 * Description: 老师开启屏幕共享，自动设置设置图片的线程和写线程。
	 * </p>
	 */
	public void openScreenShare() {
		// 前面只有是空的（也就是第一次点开启共享）
		if (sendMessageThreads.size() == 0) {
			// new一个图片设置和获得图片的对象
			if (fileShare == null) {
				fileShare = new FileShare();
			}
			// 开启设置图片的线程
			setMessage = new SetMessageThread(fileShare);
			SetMessageThread.index = 0;
			setMessage.start();
			// 给每个学生发送屏幕截图
			FileContent f = new FileContent();
			f.setCommand(Communication.openScreen);
			// 遍历hashMap
			Iterator<ConcurrentHashMap.Entry<String, IoSession>> entries = Constant.studentSession.entrySet()
					.iterator();
			while (entries.hasNext()) {
				ConcurrentHashMap.Entry<String, IoSession> entry = entries.next();
				IoSession session = entry.getValue();
				session.write(f);
				SendMessageThread sendMessage = new SendMessageThread(session, fileShare);
				sendMessageThreads.add(sendMessage);
				sendMessage.start();
			}
		}
	}

	/**
	 * <p>
	 * Title: closeScreenShare
	 * </p>
	 * <p>
	 * Description: 关闭屏幕共享。发生的命令为2告诉学生，关闭屏幕展示 控制台。
	 * </p>
	 */
	public void closeScreenShare() {
		//必须先开启再关闭才有效
		if (sendMessageThreads.size() > 0) {
			FileContent f = new FileContent();
			f.setCommand(Communication.closeScreen);
			// 给所有的学生发送的命令为2，关闭展示
			Iterator<ConcurrentHashMap.Entry<String, IoSession>> entries = Constant.studentSession.entrySet()
					.iterator();
			while (entries.hasNext()) {
				ConcurrentHashMap.Entry<String, IoSession> entry = entries.next();
				IoSession session = entry.getValue();
				session.write(f);
			}
			// 退出所有的线程
			setMessage.setRun(false);
			for (SendMessageThread sendMessageThread : sendMessageThreads) {
				sendMessageThread.setRun(false);
			}
			// 清除ArrayList所有的发送线程
			sendMessageThreads.clear();
		}
	}

	/**
	 * <p>
	 * Title: sendCommand
	 * </p>
	 * <p>
	 * Description: 点击学生的小电脑，给学生发送连接的命令。
	 * </p>
	 * 
	 * @param ip 学生的IP
	 */
	public void sendCommand(IoSession session) {
		// 获得所有的session
		FileContent f = new FileContent();
		// 发送打开服务的命令
		f.setCommand(Communication.connectCommand);
		session.write(f);
	}
	
	/**
	 * <p>Title: getSendMessageThreads</p>
	 * <p>Description: 得到发送线程。由于后续的发送。</p>
	 * @return List<SendMessageThread>线程发送对象
	 */
	public List<SendMessageThread> getSendMessageThreads() {
		return sendMessageThreads;
	}

	/**
	 * <p>
	 * Title: getConfigure
	 * </p>
	 * <p>
	 * Description: 获得Configure对象
	 * </p>
	 * 
	 * @return
	 */
	public Configure getConfigure() {
		return configure;
	}

	public void setConfigure(Configure configure) {
		this.configure = configure;
	}

}

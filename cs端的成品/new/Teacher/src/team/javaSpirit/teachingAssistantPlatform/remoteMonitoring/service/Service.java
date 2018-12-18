package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.entity.FileShare;
import team.javaSpirit.teachingAssistantPlatform.mina.Configure;

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
	private List<SendMessageThread> SendMessageThreads = new ArrayList<SendMessageThread>();
	// new一个图片设置和获得图片的对象
	private FileShare fileShare = null;
	// 服务开启成功，对数据库的操作对象
	ServiceOpenServiceImpl serviceOpen = new ServiceOpenServiceImpl();

	/**
	 * <p>
	 * Title: openService
	 * </p>
	 * <p>
	 * Description: 进行mina框架的基本配置，开启8080端口的服务
	 * </p>
	 */
	public void openService() {
		System.out.println("kaiqi");
		// new一个mina框架配置基本信息的对象
		configure = new Configure();
		// 对连接的对象的基本信息进行初始化
		configure.init();
		try {
			// 开启服务，端口是8080
			configure.service(8080);
			// 把老师的状态改为1
			serviceOpen.updateStatus();
			// 服务开启成功，给出提示
			JOptionPane.showMessageDialog(null, "开启服务成功。");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "已经开启过服务了。");
			e.printStackTrace();
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
		System.out.println("屏幕共享");
		// 获得所有的session
		Collection<IoSession> sessions = configure.getAllSession();
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
		byte comand = 1;
		f.setCommand(comand);
		for (IoSession ioSession : sessions) {
			ioSession.write(f);
			SendMessageThread sendMessage = new SendMessageThread(ioSession, fileShare);
			SendMessageThreads.add(sendMessage);
			sendMessage.start();
		}
		System.out.println(SendMessageThreads.size());
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
		System.out.println("屏幕关闭");
		// 获得所有的session
		Collection<IoSession> sessions = configure.getAllSession();
		FileContent f = new FileContent();
		byte comand = 2;
		f.setCommand(comand);
		// 给所有的学生发送的命令为2，关闭展示
		for (IoSession ioSession : sessions) {
			ioSession.write(f);
		}
		// 退出所有的线程
		setMessage.setRun(false);
		for (SendMessageThread sendMessageThread : SendMessageThreads) {
			sendMessageThread.setRun(false);
		}
		// 清除ArrayList所有的发送线程
		SendMessageThreads.clear();
		System.out.println(SendMessageThreads.size());

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

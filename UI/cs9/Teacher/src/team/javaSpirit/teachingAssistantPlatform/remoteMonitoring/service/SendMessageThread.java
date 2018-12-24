package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.entity.FileShare;

/**
 * 继承线程类，实现每200毫秒跟客户端进行通信。
 * 
 * @author fangyuzhen
 *
 */
public class SendMessageThread extends Thread {
	/* 服务器与客户端通信的会话 */
	private IoSession session = null;
	/* 图片的获取和设置字节数组 */
	private FileShare fileShare;
	private int index;
	private FileContent fileContent;

	/* 是否继续执行的条件 */
	private boolean isRun = true;

	/**
	 * 每隔100毫秒给客户端写一张图片。
	 */
	@Override
	public void run() {
		while (isRun) {
			try {
				// 将图片写给客户端
				fileContent = fileShare.getFileContent(index);
				// 将相对应的信息赋给fileContent对象，写给客户端
				if (fileContent != null) {
					session.write(fileContent);
				}
				index++;
				if (index % 10 == 0) {
					index = 0;
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public SendMessageThread(IoSession session, FileShare fileShare) {
		this.session = session;
		this.fileShare = fileShare;
		this.index = SetMessageThread.index;
	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

}

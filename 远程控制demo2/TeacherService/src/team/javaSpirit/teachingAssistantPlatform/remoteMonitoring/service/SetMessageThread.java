package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import team.javaSpirit.teachingAssistantPlatform.entity.FileShare;

/**
 * <p>
 * Title: SetMessage
 * </p>
 * <p>
 * Description: 实现每200毫秒把一张图片写成字节数组。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月1日
 */
public class SetMessageThread extends Thread {
	/*数据共享类*/
	private FileShare fileShare;
	/*表面意义上HashMap的下标*/
	public static int index = 0;

	/**
	 * 每隔200毫秒给客户端写一张图片。
	 */
	@Override
	public void run() {
		while (true) {
			try {
				// 设置传输对象
				fileShare.setFileContent(index);
				index++;
				if (index % 10 == 0) {
					index = 0;
				}
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public SetMessageThread(FileShare fileShare) {
		this.fileShare = fileShare;
	}

}

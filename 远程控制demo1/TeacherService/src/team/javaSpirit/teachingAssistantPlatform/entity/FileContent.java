package team.javaSpirit.teachingAssistantPlatform.entity;

import java.io.Serializable;

/**
* <p>Title: FileContent</p>
* <p>Description: 实现序列化接口。在网络通信中传输。
* 传输的文件有操作的命令、图片的字节数组。</p>
* @author Fang Yuzhen
* @date 2018年11月28日
 */
@SuppressWarnings("serial")
public class FileContent implements Serializable {
	/* 保存图片字节数组 */
	private byte[] bytes;
	/* 保存命令 */
	private byte command;

	/** 
	 * <p>Title: getCommand</p>
	 * <p>Description: 得到命令的值</p>
	 * @return byte类型的值
	 */
	public byte getCommand() {
		return command;
	}

	/**
	 * <p>Title: setCommand</p>
	 * <p>Description: 设置命令的值</p>
	 * @param command 传进来的byte类型的值
	 */
	public void setCommand(byte command) {
		this.command = command;
	}

	/**
	 * <p>Title: getBytes</p>
	 * <p>Description: 获得图片的字节数组</p>
	 * @return byte[]的字节数组
	 */
	public byte[] getBytes() {
		return bytes;
	}

	/**
	 * <p>Title: setBytes</p>
	 * <p>Description: 设置图片的字节数组</p>
	 * @param bytes 传进来的图片的字节数组
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}

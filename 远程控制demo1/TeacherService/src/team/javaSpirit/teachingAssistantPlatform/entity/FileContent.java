package team.javaSpirit.teachingAssistantPlatform.entity;

import java.io.Serializable;

/**
 * 保存通信相对应的信息。
 * @author fangyuzhen
 *
 */
@SuppressWarnings("serial")
public class FileContent implements Serializable {
	/*保存图片字节数组*/
	private byte[] bytes;
	/*保存命令*/
	private byte command;

	public byte getCommand() {
		return command;
	}

	public void setCommand(byte command) {
		this.command = command;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}

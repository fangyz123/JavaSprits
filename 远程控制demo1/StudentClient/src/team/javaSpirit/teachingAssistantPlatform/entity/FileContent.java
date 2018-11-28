package team.javaSpirit.teachingAssistantPlatform.entity;

import java.io.Serializable;

/**
 * 保存通信相对应的信息。
 * 
 * @author fangyuzhen
 *
 */
@SuppressWarnings("serial")
public class FileContent implements Serializable {
	/* 保存图片字节数组 */
	private byte[] bytes;
	/* 保存命令 */
	private byte command;
	/* 鼠标的坐标 */
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

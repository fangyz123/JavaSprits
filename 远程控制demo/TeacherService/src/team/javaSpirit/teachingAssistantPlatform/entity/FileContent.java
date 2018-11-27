package team.javaSpirit.teachingAssistantPlatform.entity;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.media.jai.remote.SerializableRenderedImage;

/**
 * 保存通信相对应的信息。
 * 
 * @author fangyuzhen
 *
 */
@SuppressWarnings("serial")
public class FileContent implements Serializable {
	/* 保存命令 */
	private byte command;
	/* 图片的类型 */
	private int type;
	/* 转为可序列化图片对象 */
	private SerializableRenderedImage serializableRenderedImage;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public byte getCommand() {
		return command;
	}

	public void setCommand(byte command) {
		this.command = command;
	}

	public SerializableRenderedImage getSerializableRenderedImage() {
		return serializableRenderedImage;
	}

	public void setSerializableRenderedImage(BufferedImage image) {
		this.serializableRenderedImage = new SerializableRenderedImage(image, true);
		type = image.getType();
	}

}

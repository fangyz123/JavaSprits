package team.javaSpirit.teachingAssistantPlatform.entity;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.media.jai.remote.SerializableRenderedImage;

/**
 * ����ͨ�����Ӧ����Ϣ��
 * 
 * @author fangyuzhen
 *
 */
@SuppressWarnings("serial")
public class FileContent implements Serializable {
	/* �������� */
	private byte command;
	/* ͼƬ������ */
	private int type;
	/* תΪ�����л�ͼƬ���� */
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

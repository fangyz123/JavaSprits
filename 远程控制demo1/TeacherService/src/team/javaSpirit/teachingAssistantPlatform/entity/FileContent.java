package team.javaSpirit.teachingAssistantPlatform.entity;

import java.io.Serializable;

/**
 * ����ͨ�����Ӧ����Ϣ��
 * @author fangyuzhen
 *
 */
@SuppressWarnings("serial")
public class FileContent implements Serializable {
	/*����ͼƬ�ֽ�����*/
	private byte[] bytes;
	/*��������*/
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

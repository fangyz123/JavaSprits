package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * �����Ļ��ͼ�ࡣ
 * @author fangyuzhen
 *
 */
public class TScreen {
	/**
	 * �����Ļ��ͼ��
	 * ����һ��ͼƬBufferedImage
	 * @return
	 * @throws AWTException
	 * @throws IOException
	 */
	public BufferedImage getScreen() throws AWTException, IOException {
		// ��ǰ��Ļ��С
		Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		// ����Robot����
		java.awt.Robot robot = null;
		robot = new java.awt.Robot();
		Rectangle rec = new Rectangle(dm);
		// �������λ��
		Point p = MouseInfo.getPointerInfo().getLocation();
		BufferedImage cursor = ImageIO.read(new File("image/cursor_1.png"));
		// ���һ����Ļ�Ľ�ͼ
		BufferedImage image = robot.createScreenCapture(rec);
		//�����ͼƬ���ڽ�ͼ��
		image.createGraphics().drawImage(cursor, p.x, p.y, null);
		return image;
	}
}

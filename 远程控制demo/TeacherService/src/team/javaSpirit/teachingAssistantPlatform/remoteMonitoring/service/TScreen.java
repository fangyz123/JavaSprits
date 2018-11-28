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
 * 获得屏幕截图类。
 * @author fangyuzhen
 *
 */
public class TScreen {
	/**
	 * 获得屏幕截图。
	 * 返回一张图片BufferedImage
	 * @return
	 * @throws AWTException
	 * @throws IOException
	 */
	public BufferedImage getScreen() throws AWTException, IOException {
		// 当前屏幕大小
		Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		// 创建Robot对象
		java.awt.Robot robot = null;
		robot = new java.awt.Robot();
		Rectangle rec = new Rectangle(dm);
		// 获得鼠标的位置
		Point p = MouseInfo.getPointerInfo().getLocation();
		BufferedImage cursor = ImageIO.read(new File("image/cursor_1.png"));
		// 获得一个屏幕的截图
		BufferedImage image = robot.createScreenCapture(rec);
		//将鼠标图片画在截图上
		image.createGraphics().drawImage(cursor, p.x, p.y, null);
		return image;
	}
}

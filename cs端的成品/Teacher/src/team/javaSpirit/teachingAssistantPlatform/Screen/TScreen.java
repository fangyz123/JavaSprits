package team.javaSpirit.teachingAssistantPlatform.Screen;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 获得屏幕截图类。
 * 
 * @author fangyuzhen
 *
 */
public class TScreen {
	/* 鼠标的图片 */
	private static BufferedImage cursor = null;
	/* 获取屏幕 */
	private static Toolkit tk;
	/* Robot对象，用来绘图 */
	private static Robot robot;
	/* 矩形框 */
	private static Rectangle rec;

	static {
		// 读取鼠标的图片
		try {
			cursor = ImageIO.read(new File("image/cursor_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 当前屏幕大小
		tk = java.awt.Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		// 创建Robot对象
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		rec = new Rectangle(dm);
	}

	public TScreen() {

	}

	/**
	 * 获得屏幕截图。 返回一张图片BufferedImage。根据鼠标的位置，拼上一个鼠标
	 * 
	 * @return 返回一张带有鼠标的屏幕截图
	 * @throws AWTException
	 * @throws IOException
	 */
	public BufferedImage getScreen() throws AWTException, IOException {
		// 获得鼠标的位置
		Point p = MouseInfo.getPointerInfo().getLocation();
		// 获得一个屏幕的截图
		BufferedImage image = robot.createScreenCapture(rec);
		// 将鼠标图片画在截图上
		image.createGraphics().drawImage(cursor, p.x, p.y, null);
		return image;
	}

	public BufferedImage getCursor() {
		return cursor;
	}

}

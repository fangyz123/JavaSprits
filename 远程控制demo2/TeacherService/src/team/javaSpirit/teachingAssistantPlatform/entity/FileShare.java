package team.javaSpirit.teachingAssistantPlatform.entity;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import team.javaSpirit.teachingAssistantPlatform.Screen.TScreen;

/**
 * <p>
 * Title: FileShare
 * </p>
 * <p>
 * Description: 线程间的共享类。用synchronized来修饰读和写方法。 实现互斥的方式。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月1日
 */
public class FileShare {
	/* 获得屏幕截图类 */
	private TScreen tScreen = new TScreen();
	private ConcurrentHashMap<Integer, FileContent> fileContents = new ConcurrentHashMap<>(10);
	/* 传输对象 */
	private FileContent fileContent;

	public FileShare() {
		this.fileContent = new FileContent();
	}

	/**
	 * <p>
	 * Title: getFileContent
	 * </p>
	 * <p>
	 * Description: 获得传输对象
	 * </p>
	 * 
	 * @return
	 */
	public FileContent getFileContent(int index) {
		try {
			FileContent f = fileContents.get(index);
			if (f != null && f.getState() == 2) {
				Thread.sleep(100);
			}
			return f;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * <p>
	 * Title: setFileContent
	 * </p>
	 * <p>
	 * Description: 获得截图，并把它写成字节数组，保存到传输对象中。
	 * </p>
	 */
	public void setFileContent(int index) {
		try {
			BufferedImage image = tScreen.getScreen();
//			baos.reset();
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos1);
			fileContent.setBytes(baos1.toByteArray());
			fileContent.setState(2);
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		fileContents.put(index, fileContent);
		if (index == 0) {
			FileContent f = fileContents.get(9);
			if (f != null) {
				f.setState(1);
				fileContents.put(9, f);
			}
		} else {
			int pre = index - 1;
			FileContent f = fileContents.get(pre);
			f.setState(1);
			fileContents.put(pre, f);
		}

	}

}

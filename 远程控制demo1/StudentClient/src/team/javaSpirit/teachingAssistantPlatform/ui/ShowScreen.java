package team.javaSpirit.teachingAssistantPlatform.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <p>
 * Title: ShowScreen
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author fang yuzhen
 * @date 2018年11月19日
 */
public class ShowScreen {

	private JFrame jf = null;
	private JLabel imag_lab = null;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 构造函数。new一个JFrame和JLabel，设置相对应的值。
	 * </p>
	 */
	public ShowScreen() {
		jf = new JFrame("控制台");
		// 控制台大小
		imag_lab = new JLabel();
		// 获取屏幕的大小
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screensize.getWidth();
		int height = (int) screensize.getHeight();
		jf.setSize(width, height);
		jf.add(imag_lab);
		// 设置控制台可见
		jf.setVisible(true);
		// 控制台置顶
		jf.setAlwaysOnTop(true);
		// 控制台退出模式
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * <p>
	 * Title: display
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param image
	 * @throws IOException
	 */
	public void display(BufferedImage image, int x, int y) throws IOException {
		int width = imag_lab.getWidth();
		int height = imag_lab.getHeight();
		BufferedImage newImage = resize(image, width, height, x, y);
		imag_lab.setIcon(new javax.swing.ImageIcon(newImage));
	}

	/**
	 * 
	 *
	 * <p>
	 * Title: resize
	 * </p>
	 *
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param img
	 * @param newW
	 * @param newH
	 * @return
	 * @throws IOException
	 *
	 */
	public BufferedImage resize(BufferedImage img, int newW, int newH, int x, int y) throws IOException {
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		// 开启文字抗锯齿
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		// 绘制当前可用的指定图像的指定区域，动态地缩放图像使其符合目标绘制表面的指定区域。
		// 透明像素不影响该处已存在的像素
		g.drawImage(img, 0, 0, newW, newH, null);
		// 销毁程序中指定的图形界面资源
		g.dispose();
		BufferedImage cursor = ImageIO.read(new File("image/cursor_1.png"));
		dimg.createGraphics().drawImage(cursor, x, y, null);
		return dimg;
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public JLabel getImag_lab() {
		return imag_lab;
	}

	public void setImag_lab(JLabel imag_lab) {
		this.imag_lab = imag_lab;
	}

}

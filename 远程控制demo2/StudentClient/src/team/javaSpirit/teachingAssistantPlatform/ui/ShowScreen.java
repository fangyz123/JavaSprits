package team.javaSpirit.teachingAssistantPlatform.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
* <p>Title: ShowScreen</p>
* <p>Description: 屏幕展示类。
* 对控制台的初始化，new相关的组件。
* 将从服务器得到的图片进行相对应的调整和展示在控制台上。</p>
* @author Fang Yuzhen
* @date 2018年11月28日
 */
public class ShowScreen {

	private JFrame jf = null;
	private JLabel imag_lab = null;

	/**
	* <p>Title: </p>  
	* <p>Description: 对控制台进行相对应的设置和添加对应的组件。</p>
	*/
	public ShowScreen() {
		jf = new JFrame("老师的屏幕");
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
		jf.setAlwaysOnTop(false);
		// 控制台退出模式
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * <p>Title: display</p>
	 * <p>Description: 将图片展示在控制台上。</p>
	 * @param image 传进来的BufferedImage类型的图片对象
	 * @throws IOException
	 */
	public void display(BufferedImage image) throws IOException {
		int width = imag_lab.getWidth();
		int height = imag_lab.getHeight();
		// 修改图片的大小
		image = resize(image, width, height);
		imag_lab.setIcon(new javax.swing.ImageIcon(image));
	}

	/**
	 * <p>Title: resize</p>
	 * <p>Description: 对图片进行相对应的调整。</p>
	 * @param img 传进来的要修改的图片
	 * @param newW 新图片的宽
	 * @param newH 新图片的高
	 * @return 返回新的图片
	 * @throws IOException
	 */
	public BufferedImage resize(BufferedImage img, int newW, int newH) throws IOException {
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		// 开启文字抗锯齿
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		// 绘制当前可用的指定图像的指定区域，动态地缩放图像使其符合目标绘制表面的指定区域。
		// 透明像素不影响该处已存在的像素
		g.drawImage(img, 0, 0, newW, newH, null);
		// 销毁程序中指定的图形界面资源
		g.dispose();
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

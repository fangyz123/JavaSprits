package team.javaSpirit.teachingAssistantPlatform.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * �Ѵӿͻ����յ���ͼƬ��Ϣ��չʾ��JFrame�ϡ�
 * 
 * @author fangyuzhen
 *
 */
public class ShowScreen {
	private JFrame jf = null;
	private JLabel imag_lab = null;

	/**
	 * ���캯����newһ��JFrame��JLabel���������Ӧ��ֵ��
	 */
	public ShowScreen() {
		jf = new JFrame("����̨");
		// ����̨��С
		imag_lab = new JLabel();
		// ��ȡ��Ļ�Ĵ�С
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screensize.getWidth();
		int height = (int) screensize.getHeight();
		jf.setSize(width, height);
		jf.add(imag_lab);
		// ���ÿ���̨�ɼ�
		jf.setVisible(true);
		// ����̨�ö�
		jf.setAlwaysOnTop(true);
		// ����̨�˳�ģʽ
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * ����JFrame�ķֱ��ʣ�����resize(BufferedImage img, int newW, int newH)������ 
	 * ��ͼƬ�������Ӧ���޸ġ�
	 * 
	 * @param image
	 */
	public void display(BufferedImage image) {
		int width = imag_lab.getWidth();
		int height = imag_lab.getHeight();
		BufferedImage newImage = resize(image, width, height);
		imag_lab.setIcon(new javax.swing.ImageIcon(newImage));
	}

	/**
	 * ���������õĿ�͸ߣ���ͼƬ�������Ӧ���޸ġ� �����µ�ͼƬ��
	 * 
	 * @param img
	 * @param newW
	 * @param newH
	 * @return
	 */
	public BufferedImage resize(BufferedImage img, int newW, int newH) {
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		// �������ֿ����
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		// ���Ƶ�ǰ���õ�ָ��ͼ���ָ�����򣬶�̬������ͼ��ʹ�����Ŀ����Ʊ����ָ������
		// ͸�����ز�Ӱ��ô��Ѵ��ڵ�����
		g.drawImage(img, 0, 0, newW, newH, null);
		// ���ٳ�����ָ����ͼ�ν�����Դ
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

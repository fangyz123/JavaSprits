package team.javaspirit.remoteControl.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 * 
 * <p>
 * Title: MyJframe
 * </p>
 * <p>
 * Description:չʾѧ����ͼ
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��11��26��
 */
public class MyJframe extends JFrame {

	private static final long serialVersionUID = 1L;//java�������л�
	private static JLabel jLabel = new JLabel();// ����һ����ʾ��
	public static JLabel getjLabel() {
		return jLabel;
	}

	public MyJframe(ObjectOutputStream o) {
		super("����̨");
		
		// ��ȡ��Ļ�ı߽�
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		// ��ȡ�ײ��������߶�
		int taskBarHeight = screenInsets.bottom;
		// ��ȡ��Ļ�Ĵ�С
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println((int) screenDimension.getWidth() + "lll" + (int) screenDimension.getHeight());
		double ratio = screenDimension.getWidth() / screenDimension.getHeight();
		setSize((int)(screenDimension.getWidth()-taskBarHeight*ratio),(int)(screenDimension.getHeight()-taskBarHeight)); //���ô򿪴���Ϊ��Ļ��С
		//System.out.println("hhhhhhhh"+(int)(screenDimension.getHeight()-taskBarHeight));
		
		setLocation(0, 0);
		//setSize((int) screenDimension.getWidth(), (int) screenDimension.getHeight());
		setVisible(true); // �ɼ�
		setAlwaysOnTop(true);
		setResizable(false);//���ɸı�jframe�Ĵ�С
		setDefaultCloseOperation(3); // �رշ�ʽ
		add(jLabel);
		try { // ��ʾ��ʽ
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			//
		}
	

	}

	
	/*
	 * type 1 ԭͼ��ʾ 2 ���ձ������� 3 ������ʾ
	 */

	/**
	 * 
	 * <p>
	 * Title: setImgLabel
	 * </p>
	 * <p>
	 * Description:�ȱ�������
	 * </p>
	 * 
	 * @param icon
	 * @throws IOException
	 */
	public void setImgLabel(BufferedImage icon) throws IOException {
		
		System.out.println("screen:"+jLabel.getLocationOnScreen().getX()+","+jLabel.getLocationOnScreen().getY());
		System.out.println(icon.getWidth() + "tupian" + icon.getHeight());

		int width = jLabel.getWidth();  
		int height = jLabel.getHeight();
		
		
		System.out.println(width + "jlabel" + height);
		BufferedImage Image = resize(icon, width, height);
		ImageIcon newImage=  new ImageIcon(Image);
		jLabel.setIcon(newImage);//��ͼƬ��ӵ�jlabel��
		//jLabel.setIcon(new javax.swing.ImageIcon(newImage));
	}
	/**
	 * 
	 * <p>Title: resize</p>
	 * <p>Description:����ͼƬ�Ĵ�С </p>
	 * @param img
	 * @param newW
	 * @param newH
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage resize(BufferedImage img, int newW, int newH) throws IOException {
		
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
	

}

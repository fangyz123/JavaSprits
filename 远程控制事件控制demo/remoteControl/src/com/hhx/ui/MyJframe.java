package com.hhx.ui;

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
 * Description:
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年11月26日
 */
public class MyJframe extends JFrame {

	private static final long serialVersionUID = 1L;//java对象序列化
	// private static JFrame jframe=new JFrame("");
	// private ObjectOutputStream ous;
	private static JLabel jLabel = new JLabel();// 创建一个显示框
	
	public static JLabel getjLabel() {
		return jLabel;
	}


	public MyJframe(ObjectOutputStream o) {
		super("控制台");
		// ous=o;
		// 获取屏幕的边界
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		// 获取底部任务栏高度
		int taskBarHeight = screenInsets.bottom;
		// 获取屏幕的大小
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println((int) screenDimension.getWidth() + "lll" + (int) screenDimension.getHeight());
		double ratio = screenDimension.getWidth() / screenDimension.getHeight();
		// setSize((int)(screenDimension.getWidth()-taskBarHeight*ratio),(int)(screenDimension.getHeight()-taskBarHeight)); //设置打开窗口为屏幕大小
		//System.out.println("hhhhhhhh"+(int)(screenDimension.getHeight()-taskBarHeight));
		
		setLocation(0, 0);
		setSize((int) screenDimension.getWidth(), (int) screenDimension.getHeight());
		setVisible(true); // 可见
		setAlwaysOnTop(true);

		setDefaultCloseOperation(3); // 关闭方式
		add(jLabel);
		try { // 显示方式
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			//
		}
		
		
		// jLabel.setSize((int)screenDimension.getWidth()-20,(int)
		// screenDimension.getHeight()-20);
		// add(jLabel,BorderLayout.CENTER);//把这个面板加入到控制台中
		
		//jLabel.setLocation(0, 0);
		//jLabel.setBounds(0, 0, (int) screenDimension.getWidth(), (int) screenDimension.getHeight());
		
		
		/*
		 * jLabel.set;880 jLabel.getCursor(); jLabel.getLocation();
		 * jLabel.getMousePosition();
		 */

	}

	
	/*
	 * type 1 原图显示 2 按照比例缩放 3 滚动显示
	 */

	/**
	 * 
	 * <p>
	 * Title: setImgLabel
	 * </p>
	 * <p>
	 * Description:等比例缩放
	 * </p>
	 * 
	 * @param icon
	 * @throws IOException
	 */
	public void setImgLabel(BufferedImage icon) throws IOException {
		/*
		 * int imgWidth=icon.getIconWidth();//获得图片宽度 int
		 * imgHeight=icon.getIconHeight();//获得图片高度
		 * System.out.println("图片："+imgWidth+","+imgHeight); int
		 * conWidth=jLabel.getWidth();//得到组件宽度 int conHeight=jLabel.getHeight();//得到组件高度
		 * System.out.println("组件："+conWidth+";gao;"+conHeight);
		 * 
		 * // System.out.println(jframe.getWidth()+"bian"+jframe.getHeight()); int
		 * reImgWidth;//保存图片更改宽度后的值 int reImgHeight;//保存图片更改高度后的值
		 * if(imgWidth/imgHeight>=conWidth/conHeight){ if(imgWidth>conWidth){
		 * reImgWidth=conWidth; reImgHeight=imgHeight*reImgWidth/imgWidth; }else{
		 * reImgWidth=imgWidth; reImgHeight=imgHeight; } }else{ if(imgWidth>conWidth){
		 * reImgHeight=conHeight; reImgWidth=imgWidth*reImgHeight/imgHeight; }else{
		 * reImgWidth=imgWidth; reImgHeight=imgHeight; } }
		 * 
		 * icon=new ImageIcon(icon.getImage().getScaledInstance(reImgWidth,reImgHeight,
		 * Image.SCALE_DEFAULT)); jLabel.setIcon(icon); jLabel.repaint();//销掉以前画的背景
		 */
		// jLabel.setHorizontalAlignment(SwingConstants.CENTER);

		/*
		 * Graphics g = new Graphics(); g.drawImage(icon.getImage(), 0, 30,
		 * conWidth,conHeight,
		 * 
		 * icon.getImageObserver());
		 */
		System.out.println("screen:"+jLabel.getLocationOnScreen().getX()+","+jLabel.getLocationOnScreen().getY());
		System.out.println(icon.getWidth() + "tupian" + icon.getHeight());

		int width = jLabel.getWidth();  
		int height = jLabel.getHeight();
		
		/*jLabel*/
		System.out.println(width + "jlabel" + height);
		BufferedImage Image = resize(icon, width, height);
		ImageIcon newImage=  new ImageIcon(Image);
		jLabel.setIcon(newImage);
		//jLabel.setIcon(new javax.swing.ImageIcon(newImage));
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) throws IOException {
		//newW=img.getWidth(null);
		//newH=img.getHeight(null);
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
	public String returnVar() {
		return jLabel.getWidth()+","+jLabel.getHeight();
	}

}

package team.javaSpirit.teachingAssistantPlatform.ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
* <p>Title: MyJPanel</p>
* <p>Description: 继承JPanel面板类，重写paintComponent绘制组件的方法；
* 当java认为需要重新绘制组件的时候由java调用，实现想要的效果。</p>
* @author Fang Yuzhen
* @date 2018年12月6日
 */
public class MyJPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/*要绘画的图*/
	private ImageIcon imageIcon=null;

	public MyJPanel() {
		
	}

	public MyJPanel(ImageIcon imageIcon) {
		super();
		this.imageIcon = imageIcon;
	}



	/**
	 * 当java认为需要重新绘制组件的时候由java调用，实现自动绘画的效果。
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imageIcon!=null) {
			g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), imageIcon.getImageObserver());
		}
	}

}

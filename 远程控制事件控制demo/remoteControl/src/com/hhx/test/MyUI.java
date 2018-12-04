package com.hhx.test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyUI extends JFrame{
	
	private static JLabel jLabel=new JLabel();//创建一个显示框
	/*public void paint(Graphics g){
	    ImageIcon icon=new ImageIcon("images/蔡徐坤壁纸.jpg");
	    Image image=icon.getImage();
	    System.out.println(icon.getIconWidth()+"gao"+icon.getIconHeight());
	    g.drawImage(image, 0, 40, null);
	   }*/
	public  MyUI() {
		super("控制台");
	//  获取屏幕的边界
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		System.out.println(screenInsets);	
		//  获取底部任务栏高度
			  int taskBarHeight = screenInsets.bottom; 
			
			  System.out.println(taskBarHeight);
			  //获取屏幕的大小
			 Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			 System.out.println((int)screenDimension.getWidth()+"h"+(int)screenDimension.getHeight());
			 setSize((int)screenDimension.getWidth(),((int)screenDimension.getHeight()-taskBarHeight));
			// setSize(1000,700);
			 setVisible(true);  //可见
				setAlwaysOnTop(true);
				
				setDefaultCloseOperation(3); //关闭方式
				
				
				add(jLabel);//把这个面板加入到控制台中
	}
	
	public void findNum() {
		System.out.println(jLabel.getWidth());
		System.out.println(jLabel.getHeight());
	}
	
	public static  void setImgLabel() {
		ImageIcon icon=new ImageIcon("images/蔡徐坤壁纸.jpg");
		int imgWidth=icon.getIconWidth();//获得图片宽度
        int imgHeight=icon.getIconHeight();//获得图片高度
        System.out.println("图片："+imgWidth+","+imgHeight);
        int conWidth=jLabel.getWidth();//得到组件宽度
        int conHeight=jLabel.getHeight();//得到组件高度
        System.out.println("组件："+conWidth+";gao;"+conHeight);
        
       
        int reImgWidth;//保存图片更改宽度后的值
        int reImgHeight;//保存图片更改高度后的值
        if(imgWidth/imgHeight>=conWidth/conHeight){
            if(imgWidth>conWidth){
                reImgWidth=conWidth;
                reImgHeight=imgHeight*reImgWidth/imgWidth;
            }else{
                reImgWidth=imgWidth;
                reImgHeight=imgHeight;
            }
        }else{
            if(imgWidth>conWidth){
                reImgHeight=conHeight;
                reImgWidth=imgWidth*reImgHeight/imgHeight;
            }else{
                reImgWidth=imgWidth;
                reImgHeight=imgHeight;
            }
        }
    System.out.println("zhenshi"+reImgWidth+","+reImgHeight);
       icon=new ImageIcon(icon.getImage().getScaledInstance(reImgWidth,reImgHeight, Image.SCALE_DEFAULT));
        jLabel.setIcon(icon);
        //jLabel.repaint();//销掉以前画的背景
       // jLabel.setHorizontalAlignment(SwingConstants.CENTER);        
		
/*Graphics g = new Graphics();
		g.drawImage(icon.getImage(), 0, 30, conWidth,conHeight,
				
				icon.getImageObserver());*/
        
	}
	

}

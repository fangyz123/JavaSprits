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
	
	private static JLabel jLabel=new JLabel();//����һ����ʾ��
	/*public void paint(Graphics g){
	    ImageIcon icon=new ImageIcon("images/��������ֽ.jpg");
	    Image image=icon.getImage();
	    System.out.println(icon.getIconWidth()+"gao"+icon.getIconHeight());
	    g.drawImage(image, 0, 40, null);
	   }*/
	public  MyUI() {
		super("����̨");
	//  ��ȡ��Ļ�ı߽�
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		System.out.println(screenInsets);	
		//  ��ȡ�ײ��������߶�
			  int taskBarHeight = screenInsets.bottom; 
			
			  System.out.println(taskBarHeight);
			  //��ȡ��Ļ�Ĵ�С
			 Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			 System.out.println((int)screenDimension.getWidth()+"h"+(int)screenDimension.getHeight());
			 setSize((int)screenDimension.getWidth(),((int)screenDimension.getHeight()-taskBarHeight));
			// setSize(1000,700);
			 setVisible(true);  //�ɼ�
				setAlwaysOnTop(true);
				
				setDefaultCloseOperation(3); //�رշ�ʽ
				
				
				add(jLabel);//����������뵽����̨��
	}
	
	public void findNum() {
		System.out.println(jLabel.getWidth());
		System.out.println(jLabel.getHeight());
	}
	
	public static  void setImgLabel() {
		ImageIcon icon=new ImageIcon("images/��������ֽ.jpg");
		int imgWidth=icon.getIconWidth();//���ͼƬ���
        int imgHeight=icon.getIconHeight();//���ͼƬ�߶�
        System.out.println("ͼƬ��"+imgWidth+","+imgHeight);
        int conWidth=jLabel.getWidth();//�õ�������
        int conHeight=jLabel.getHeight();//�õ�����߶�
        System.out.println("�����"+conWidth+";gao;"+conHeight);
        
       
        int reImgWidth;//����ͼƬ���Ŀ�Ⱥ��ֵ
        int reImgHeight;//����ͼƬ���ĸ߶Ⱥ��ֵ
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
        //jLabel.repaint();//������ǰ���ı���
       // jLabel.setHorizontalAlignment(SwingConstants.CENTER);        
		
/*Graphics g = new Graphics();
		g.drawImage(icon.getImage(), 0, 30, conWidth,conHeight,
				
				icon.getImageObserver());*/
        
	}
	

}

package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
import team.javaSpirit.teachingAssistantPlatform.upload.service.ShareResourceServiceImpl;
/**
 * 
* <p>Title: UploadMouseListener</p>
* <p>Description:为上传资源添加鼠标事件 </p>
* @author renyuyuan
* @date 2018年12月20日
 */
public class UploadMouseListener implements MouseListener {
	private Index index;
	public UploadMouseListener(Index index) {
		this.index=index;
	}
	public UploadMouseListener() {
	}
	//点击上传文件时调用此业务逻辑
	@Override
	public void mouseClicked(MouseEvent e) {
		//创建上传文件框
		JFileChooser jchooser=new JFileChooser();
		jchooser.setBounds(20, 24, 564, 367);
		jchooser.setCurrentDirectory(new File("c:/"));
		//要求用户只选择文件
		jchooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int x=jchooser.showDialog(new JLabel(), "确定");
		if(x==JFileChooser.APPROVE_OPTION) {
			File file=jchooser.getSelectedFile();
			//将指定的文件保存到本地和数据库
			ShareResourceServiceImpl ss=new ShareResourceServiceImpl();
			//判断文件是否上传成功并做出回应
			int i=ss.saveSelectedFile(file);
			if(i==1) {
				JOptionPane.showMessageDialog(null, "上传成功", "提示", JOptionPane.PLAIN_MESSAGE);	
				this.index.jumpShareResource();
			}else if(i==2)
				JOptionPane.showMessageDialog(null, "上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
			else if(i==3)
				JOptionPane.showMessageDialog(null, "选中的文件不存在上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}

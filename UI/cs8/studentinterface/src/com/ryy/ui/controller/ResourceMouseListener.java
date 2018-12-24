package com.ryy.ui.controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ryy.ui.entity.ShareResource;
import com.ryy.ui.shareresource.service.ShareResourceServiceImpl;
import com.ryy.ui.view.Index;
/**
 * 
* <p>Title: ResourceMouseListener</p>
* <p>Description: 为每个资源添加事件</p>
* @author renyuyuan
* @date 2018年12月24日
 */
public class ResourceMouseListener implements MouseListener { 
	private Index index;
	private ShareResource shareResource;
	public ResourceMouseListener(Index index,ShareResource shareResource) {
		this.index=index;
		this.shareResource=shareResource;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//判断文件是否存在能否下载
		String s=new ShareResourceServiceImpl().readResource(this.shareResource);
		if(s.equals("1"))
			JOptionPane.showMessageDialog(null, "文件不存在", "提示", JOptionPane.PLAIN_MESSAGE);
		else if(s.equals("2")) {
			//文件下载
			JFileChooser jchooser=new JFileChooser();
			jchooser.setBounds(20, 24, 564, 367);
			jchooser.setCurrentDirectory(new File("c:/"));
			jchooser.setDialogTitle("保存文件");
			jchooser.setSelectedFile(new File(this.shareResource.getOldfile()));
			int x=jchooser.showDialog(null,"保存");
			//下载文件
			if(x==JFileChooser.APPROVE_OPTION) {
				File file=jchooser.getSelectedFile();		
				ShareResourceServiceImpl sr=new ShareResourceServiceImpl();
				String i=sr.downloadResource(file, this.shareResource);
				if(i.equals("1"))
					JOptionPane.showMessageDialog(null, "文件不存在", "提示", JOptionPane.PLAIN_MESSAGE);
				else if(i.equals("2"))
					JOptionPane.showMessageDialog(null, "下载失败", "提示", JOptionPane.PLAIN_MESSAGE);
				else if(i.equals("3"))
					JOptionPane.showMessageDialog(null, "下载成功", "提示", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(new Color(70, 130, 180));
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(new Color(105, 105, 105));
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
}
	
	
		
	


package com.Grap;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class test extends JFrame implements ActionListener,ItemListener{
	public test() {
	}
	JPanel p1,p2,p3,p4;
	JLabel jlQuestion,jlSelect,jlScore;
	JButton startbutton,nextbutton,stopbutton;
	JTextArea textarea;
	JScrollPane scrollpane;
	JRadioButton button[];
	ButtonGroup buttongroup;
	BufferedReader br;
	String answer;
	
	void display() throws IOException{
		p1=new JPanel();p2=new JPanel();
		p3=new JPanel();p4=new JPanel();
		jlQuestion=new JLabel("题目");
		jlSelect=new JLabel("选项");
		jlScore=new JLabel("");
		startbutton=new JButton("开始");
		nextbutton=new JButton("下一题");
		stopbutton=new JButton("结束");
		textarea=new JTextArea(3,30);
		scrollpane=new JScrollPane(textarea);
		button=new JRadioButton[4];
		buttongroup=new ButtonGroup();
		for(int i=0;i<4;i++){
			button[i]=new JRadioButton("");
			buttongroup.add(button[i]);
			button[i].addItemListener(this);
		}
		br=new BufferedReader(new FileReader("F:\\text.txt"));
		int m=0;
		br.mark(m);
		Container c=getContentPane();//上部添加
		p3.add(jlQuestion);
		p3.add(scrollpane);
		c.add(p3,BorderLayout.NORTH);
		
		p1.setLayout(new GridLayout(2,1));//中心添加
		p1.add(p4); p1.add(jlScore);
		p4.add(jlSelect);
		for(int i=0;i<4;i++){
			p4.add(button[i]);
		}
		c.add(p1,BorderLayout.CENTER);
//		p2.setLayout(new FlowLayout());
		p2.add(startbutton);//下部添加
		p2.add(nextbutton);
		p2.add(stopbutton);
		c.add(p2,BorderLayout.SOUTH);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		startbutton.addActionListener(this);
		nextbutton.addActionListener(this);
		stopbutton.addActionListener(this);
	}
	public void showquestion() throws Exception{
		textarea.setText(br.readLine());
		for(int i=0;i<4;i++){
			button[i].setText(br.readLine());
			button[i].setEnabled(true);
		}
		answer=br.readLine();
		jlScore.setText(" ");
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++){
			if(button[i].isSelected())
				if((int)answer.charAt(0)==i+65)
					jlScore.setText("恭喜你，答对了");
				else
					jlScore.setText("答案错误！");
				
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startbutton||e.getSource()==nextbutton){
		try{
			showquestion();
		}catch(Exception e1){
			e1.printStackTrace();
		}
		}
		if(e.getSource()==stopbutton){
			startbutton.setEnabled(false);
			nextbutton.setEnabled(false);
//			for(int i=0;i<4;i++){
//				if(button[i].isSelected())
//					button[i].setSelected(false);
////				button[i].setEnabled(false);
//			}
			stopbutton.setOpaque(true);
			stopbutton.addActionListener(this);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		(new javaIODemo()).display();
	}

}


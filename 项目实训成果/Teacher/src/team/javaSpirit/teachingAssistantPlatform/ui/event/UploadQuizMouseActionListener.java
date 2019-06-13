package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import team.javaSpirit.teachingAssistantPlatform.quiz.service.QuizService;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

public class UploadQuizMouseActionListener implements MouseListener {
	private Index index;
	private JComboBox jb;
	private JTextField text;
	public UploadQuizMouseActionListener(Index index,JComboBox jb,JTextField text) {
		this.index=index;
		this.jb=jb;
		this.text=text;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		String [] ss=this.jb.getSelectedItem().toString().split("\\s+");
		String courseName=ss[0].split("：")[1];
		String className=ss[1].split("：")[1];
		String chapter=this.text.getText();
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
					QuizService qs=new QuizService();	
					//判断文件是否上传成功并做出回应
					int i=qs.saveQuiz(file, className, courseName,chapter);
					if(i==1) {
						JOptionPane.showMessageDialog(null, "小测发布成功", "提示", JOptionPane.PLAIN_MESSAGE);	
					}else if(i==2)
						JOptionPane.showMessageDialog(null, "小测上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
					else if(i==3)
						JOptionPane.showMessageDialog(null, "选中的文件不存在上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

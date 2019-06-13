package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.quiz.dao.QuizDao;

public class QuizTest extends JFrame implements ActionListener,ItemListener{

	private Index index;
	private StudentQuiz studentQuiz;
	private JPanel p1,p2,p3,p4;
	private JLabel jlSelect,jlScore;
	private JButton startbutton,nextbutton,endbutton;
	private JTextArea textarea;
	private JScrollPane scrollpane;
	private JRadioButton button[];
	private ButtonGroup buttongroup;
	private BufferedReader br;
	private String answer;
	private int isTrue;
	private int isFalse;
	private int qustionCount;
	private long starTime;
	private long endTime;
	private String error;
	private String[] answers;
	private int preoption;
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Create the frame.
	 */
	public QuizTest(StudentQuiz studentQuiz,Index index) {
		this.index=index;
		this.studentQuiz=studentQuiz;
		File file=new File(new File("quiz").getAbsolutePath()+ "/"+this.studentQuiz.getQuiz().getClasscourse().getClass_name()+"/"+this.studentQuiz.getQuiz().getNewfile());
		try {
			InputStreamReader is = new InputStreamReader(new FileInputStream(file),"UTF-8");
			br=new BufferedReader(is);
			int m=0;
			br.mark(m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		error=null;
		answers=new String[100];
		//设置窗体大小
		this.setBounds(0, 0, 400, 600);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		// 窗体可见
		this.setVisible(true);
		//设置窗体关闭状态
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		qustionCount=0;
	}
	
	public void init() {
		p1=new JPanel();p2=new JPanel();
		p3=new JPanel();p4=new JPanel();
		jlSelect=new JLabel("选项");
		jlScore=new JLabel("");
		jlScore.setFont(new Font("宋体", Font.BOLD, 14));jlScore.setSize(new Dimension(308, 130));
		startbutton=new JButton("开始");
		nextbutton=new JButton("下一题");
		endbutton=new JButton("结束");
		textarea=new JTextArea(15,30);
		textarea.setFont(new Font("宋体", Font.BOLD, 15));
		textarea.setLineWrap(true);textarea.setWrapStyleWord(true);
		scrollpane=new JScrollPane(textarea);
		button=new JRadioButton[4];//记录各个选项
		buttongroup=new ButtonGroup();
		for(int i=0;i<4;i++){
			button[i]=new JRadioButton("");
			buttongroup.add(button[i]);
			button[i].addItemListener(this);
		}
		Container c=getContentPane();
//		c.setBackground(new Color());
		p3.add(scrollpane);
		c.add(p3,BorderLayout.NORTH);
		
		p1.setLayout(new GridLayout(2,1));//�������
		p1.add(p4); p1.add(jlScore);
		p4.add(jlSelect);//jlselect选项
		for(int i=0;i<4;i++){
			p4.add(button[i]);
		}
		c.add(p1,BorderLayout.CENTER);
		p2.add(startbutton);
		p2.add(nextbutton);
		p2.add(endbutton);
		c.add(p2,BorderLayout.SOUTH);
		setVisible(true);
		startbutton.addActionListener(this);
		nextbutton.addActionListener(this);
		endbutton.addActionListener(this);
	}
	
	
	public void showquestion() throws Exception{
		String s;
		if(error==null)
			s=br.readLine();
		else
			s=error;
		if(s==null) {
			endTime=System.currentTimeMillis();
			startbutton.setEnabled(false);
			nextbutton.setEnabled(false);
			endbutton.setEnabled(false);
			for(int i=0;i<4;i++){
				button[i]=null;
			}
			String acc=accuracy(isTrue, qustionCount);
			float time=(endTime-starTime)/1000f;
			textarea.setText("答题结束！！！"+"\n"+"正确率："+acc+"\n"+"所用时间："+time+"秒");
			QuizDao qd=new QuizDao();
			qd.saveStudentQuiz(studentQuiz, answers, time, acc);
			this.index.jumpQuiz();
			endbutton.setOpaque(true);
			endbutton.addActionListener(this);
		}else {
			textarea.setText(s);//显示问题
			for(int i=0;i<4;i++){
				button[i].setText(br.readLine());//显示选项
				button[i].setEnabled(true);
			}
			answer=br.readLine();//记录答案
			System.out.println(answer);
			jlScore.setText(" ");
			qustionCount++;
			error=null;
			answers[qustionCount]=answer;
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
				for(int i=0;i<4;i++){
					if(button[i].isSelected()) 
						if((int)answer.charAt(0)==i+65) 
							isTrue++;
						else
							isFalse++;
					
				}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startbutton) {
			starTime=System.currentTimeMillis();
			startbutton.setEnabled(false);
			try {
				showquestion();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==nextbutton) {
			try {
				showquestion();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==endbutton){
			String s=null;
			try {
				s = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(s!=null) {
				JOptionPane.showMessageDialog(null, "！！！不能结束请继续作答", "警告", JOptionPane.ERROR_MESSAGE);
				error=s;
			}else {
				endTime=System.currentTimeMillis();
				startbutton.setEnabled(false);
				nextbutton.setEnabled(false);
				for(int i=0;i<4;i++){
					button[i]=null;
				}
				String acc=accuracy(isTrue, qustionCount);
				float time=(endTime-starTime)/1000f;
				textarea.setText("正确率："+acc+"\n"+"所用时间："+time+"秒");
				QuizDao qd=new QuizDao();
				qd.saveStudentQuiz(studentQuiz, answers, time, acc);
				this.index.jumpQuiz();
				endbutton.setOpaque(true);
				endbutton.addActionListener(this);
			}
		}
	}
	//计算正确率
	public static String accuracy(double num,double total) {
			DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
			df.setMaximumFractionDigits(2);
			df.setRoundingMode(RoundingMode.HALF_UP);
			return df.format(num/total*100)+"%";
	}
}

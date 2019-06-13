package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.quiz.service.QuizService;

public class TermPlan extends JFrame {

	private JPanel contentPane;
	private JPanel text;

	/**
	 * Launch the application.
	 */
	public void setContentPanel() {
		getContentPane().setForeground(Color.BLACK);

		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("image/img1.png");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
	}
	public void setText() {
		// 滚动条
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setLocation(0, 0);
				scrollPane.setSize(563, 650);
				scrollPane.setBorder(null);
				contentPane.add(scrollPane);
				
				//text
				 text = new JPanel(){
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						ImageIcon ii = new ImageIcon("image/btbackground.jpg");
						g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
					}
				};
				text.setBackground(null);
				text.setForeground(new Color(173, 216, 230));
				text.setPreferredSize(new Dimension(700, 1400));
				scrollPane.setViewportView(text);
	}
	public void settitle() {
		JLabel jl=new JLabel("期末复习计划",JLabel.CENTER);
		jl.setFont(new Font("宋体", Font.BOLD, 25));
		jl.setForeground(new Color(100, 149, 237));
		jl.setPreferredSize(new Dimension(700, 40));
		text.add(jl);
	}
	public void setCourseAnalysis() {
		JLabel jl1=new JLabel("  一、学科分析");
		jl1.setFont(new Font("宋体", Font.BOLD, 20));
		jl1.setForeground(new Color(100, 149, 237));
		jl1.setPreferredSize(new Dimension(700, 40));
		text.add(jl1);
		
		
		//获得学科排名
		QuizService qs=new QuizService("");
		qs.analysisEveCourseChapterPlan();
		qs.analysisEveCoursePlan();
		List<String> list1=qs.getCourseRank();//记录学科排名
		Map<ClassCourse,String> map1=qs.getCourseRanks();//记录学科排名
		Map<ClassCourse,Set<String>> map2=qs.getChapterRank();//记录章节排名
		Map<ClassCourse,String> map3=qs.getCourseRankPredict();//记录学科预测
		String s1="";
		int i=0;int len=list1.size();
		for(String s:list1) {
			if(i==len-1)
				s1=s1+s;
			else
				s1=s1+s+" > ";
			i++;
		}
		JLabel jl2=new JLabel("    学科综合掌握程度排名： "+s1);
		jl2.setFont(new Font("宋体", Font.PLAIN, 16));
		jl2.setForeground(new Color(100, 149, 237));
		jl2.setPreferredSize(new Dimension(700, 30));
		text.add(jl2);
		//学科等级划分
		List<ClassCourse> ccs=new ArrayList<ClassCourse>();
		for(ClassCourse cc:map1.keySet()) {
			JLabel jl3=new JLabel("    "+cc.getCourse().getCname()+"综合掌握程度排名： "+map1.get(cc)+"   "+map3.get(cc));
			if(map3.get(cc).endsWith("赶快加油！！！"))
				ccs.add(cc);
			jl3.setFont(new Font("宋体", Font.PLAIN, 16));
			jl3.setForeground(new Color(100, 149, 237));
			jl3.setPreferredSize(new Dimension(700, 30));
			text.add(jl3);
		}
		//学科预测
		if(ccs.size()!=0) {
			String s="";
			for(ClassCourse cc:ccs) {
				s=" "+cc.getCourse().getCname();
			}
			JLabel jl4=new JLabel("   请在"+s+" 多多努力！！！");
			jl4.setFont(new Font("宋体", Font.PLAIN, 20));
			jl4.setForeground(new Color(255, 69, 0));
			jl4.setPreferredSize(new Dimension(700, 30));
			text.add(jl4);
		}
	}
	public void setChapterAnalysis() {
		QuizService qs=new QuizService("");
		qs.analysisEveCourseChapterPlan();
		qs.analysisEveCoursePlan();
		Map<ClassCourse,Set<String>> map2=qs.getChapterRank();//记录章节排名
		JLabel jl5=new JLabel("  二、学科不同章节分析");
		jl5.setFont(new Font("宋体", Font.BOLD, 20));
		jl5.setForeground(new Color(100, 149, 237));
		jl5.setPreferredSize(new Dimension(700, 40));
		text.add(jl5); 
		int i=0;
		for(ClassCourse cc:map2.keySet()) {
			Set<String> list4=new HashSet<String>();
			i++;
			//章节排名
			JLabel jl6=new JLabel("    "+i+"."+cc.getCourse().getCname()+"成绩分析");
			jl6.setFont(new Font("宋体", Font.PLAIN, 16));
			jl6.setForeground(new Color(100, 149, 237));
			jl6.setPreferredSize(new Dimension(700, 30));
			text.add(jl6);
			String s2="";int j=0;int len1=map2.get(cc).size();
			for(String s:map2.get(cc)) {
				if(j==(len1-1)) 
					s2=s2+s;
				else
					s2=s2+s+" > ";
				if(j>4)
					list4.add(s);
				j++;
			}
			JLabel jl7=new JLabel("    章节综合掌握程度排名： "+s2);
			jl7.setFont(new Font("宋体", Font.PLAIN, 16));
			jl7.setForeground(new Color(100, 149, 237));
			jl7.setPreferredSize(new Dimension(700, 30));
			text.add(jl7);
			//章节正确率
			JLabel jl8=new JLabel("    各个章节平均正确率展示： ");
			jl8.setFont(new Font("宋体", Font.PLAIN, 16));
			jl8.setForeground(new Color(100, 149, 237));
			jl8.setPreferredSize(new Dimension(700, 30));
			text.add(jl8);
			Map<String,Double> map4=qs.analysisAvgAccByChapter(cc);
			
			for(String s:map4.keySet()) {
				JLabel jl9=new JLabel("      "+s+"  正确率："+map4.get(s)+"%");
				jl9.setFont(new Font("宋体", Font.PLAIN, 16));
				jl9.setForeground(new Color(100, 149, 237));
				jl9.setPreferredSize(new Dimension(700, 30));
				text.add(jl9);
				if(map4.get(s)<65.00)
					list4.add(s);
			}
			//章节预测
			if(list4.size()!=0) {
				String s4="";
				for(String s:list4)
					s4=s4+" "+s;
				JLabel jl4=new JLabel("   请在"+s4+" 多多努力！！！");
				jl4.setFont(new Font("宋体", Font.PLAIN, 20));
				jl4.setForeground(new Color(255, 69, 0));
				jl4.setPreferredSize(new Dimension(700, 30));
				text.add(jl4);
			}
			
		}
	}
	public void init() {
		this.setContentPanel();
		this.setText();
		this.settitle();
		this.setCourseAnalysis();
		this.setChapterAnalysis();
	}
	
	/**
	 * Create the frame.
	 */
	public TermPlan() {
		// 设置窗体大小
		this.setBounds(0, 0, 570, 680);
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		// 设置关闭状态
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 窗体可见
		this.setVisible(true);
	}

}

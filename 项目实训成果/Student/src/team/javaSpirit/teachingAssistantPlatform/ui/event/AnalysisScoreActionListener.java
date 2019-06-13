package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import team.javaSpirit.teachingAssistantPlatform.entity.StudentClass;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.quiz.service.QuizService;
import team.javaSpirit.teachingAssistantPlatform.ui.view.AnalysisSingleCourse;
import team.javaSpirit.teachingAssistantPlatform.ui.view.AnalysisSingleStudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.ui.view.TermPlan;

public class AnalysisScoreActionListener implements ActionListener {

	private StudentQuiz mysq;
	private StudentClass mysc;
	public AnalysisScoreActionListener(StudentClass mysc) {
		this.mysc=mysc;
	}
	public AnalysisScoreActionListener(StudentQuiz mysq) {
		this.mysq=mysq;
	}
	public AnalysisScoreActionListener() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if("分   析   成   绩".equals(s)) {
			//小测成绩分析
			this.setAnalysisSingleStudentQuiz();
		}else if(s.endsWith("成绩分析")) {
			//单科成绩分析
			this.setAnalysisSingleCourse();
		}else if("复    习    计    划".equals(s)) {
			//复习计划
			this.setTermPlan();
		}
	}
	/**
	 * 分析一个小测的成绩
	 * <p>Title: setAnalysisSingleCourse</p>
	 * <p>Description: </p>
	 */
	public void setAnalysisSingleStudentQuiz() {
		Map<String,Double> map=new QuizService().analysisChapterScore(mysq);
		AnalysisSingleStudentQuiz assq=new AnalysisSingleStudentQuiz("成绩分析",map,this.mysq.getQuiz().getOldname());
	}
	/**
	 * 分析一门课程的成绩
	 * <p>Title: setAnalysisSingleCourse</p>
	 * <p>Description: </p>
	 */
	public void setAnalysisSingleCourse() {
		Map<String,Double> map=new QuizService().analysisAvgAccByChapter(mysc.getClassin());
		AnalysisSingleCourse assc=new AnalysisSingleCourse(mysc.getClassin().getClass_name()+"成绩分析",mysc.getClassin().getClass_name()+"成绩分析",map);
	}
	public void setTermPlan() {
		TermPlan tp=new TermPlan();
		tp.init();
	}
}

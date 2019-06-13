package team.javaSpirit.teachingAssistantPlatform.quiz.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Course;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentClass;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.quiz.dao.QuizDao;

public class QuizService {
	
	private List<String> courseRank;//学科排名
	private Map<ClassCourse,Set<String>> chapterRank;//章节排名
	private Map<ClassCourse,String> courseRanks;//学科排名记录
	private Map<ClassCourse,String> courseRankPredict;
	private String s;
	public QuizService() {}
	public QuizService(String s) {
		this.s=s;
		this.chapterRank=new HashMap<ClassCourse,Set<String>>();
		this.courseRank=new ArrayList<String>();
		this.courseRanks=new HashMap<ClassCourse,String>();
		this.courseRankPredict=new HashMap<ClassCourse,String>();
	}
	public List<String> getCourseRank() {
		return courseRank;
	}
	public Map<ClassCourse, Set<String>> getChapterRank() {
		return chapterRank;
	}
	public Map<ClassCourse, String> getCourseRanks() {
		return courseRanks;
	}
	public Map<ClassCourse, String> getCourseRankPredict() {
		return courseRankPredict;
	}
	/**
	 *获得不同章节下的学生小测
	 * <p>Title: getClassChapters</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static Map<String,List<StudentQuiz>> getClassChapters(StudentClass sc){
		Map<String,List<StudentQuiz>> map=new TreeMap<String,List<StudentQuiz>>(new MapKeyComparator());
		QuizDao qd=new QuizDao();
			//通过学号和班级号获得所有小测
			List<StudentQuiz> quizs=qd.searchStudentQuizBySid(sc.getClassin().getClass_id());
			//通过小测获得对应课程的所有章节
			Set<String> chapters=new HashSet<String>();
			for(StudentQuiz sq:quizs) {
				chapters.add(sq.getQuiz().getChapter());
			}
			//将课程名----------章节名作为主键，获得所有对应章节下的小测
			for(String chapter:chapters) {
				String key=chapter;
				List<StudentQuiz> list1=new ArrayList<StudentQuiz>();
				for(StudentQuiz sq:quizs) {
					if(sq.getQuiz().getChapter().equals(chapter))
						list1.add(sq);
				}
				map.put(key, list1);
			}
		return map;
	}
	/**
	 * 通过学生学号获得该学生应该上的所有课（实现逻辑：学号获得班级号，班级号获得课程号）
	 * <p>Title: getCourses</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static List<Course> getCourses(){
		QuizDao qd=new QuizDao();
		List<StudentClass> list=qd.searchClasses();
		List<Course> courses=new ArrayList();
		for(StudentClass sc:list) {
			Course c=sc.getClassin().getCourse();
			courses.add(c);
		}
		return courses;
	}
	/**
	 * IO读取小测内容进行展示
	 * <p>Title: getStudentQuiz</p>
	 * <p>Description: </p>
	 * @param sq
	 * @return
	 */
	public String getStudentQuiz(StudentQuiz sq) {
		File file=new File(new File("quiz").getAbsolutePath()+ "/"+sq.getQuiz().getClasscourse().getClass_name()+"/"+sq.getQuiz().getNewfile());
		String cont="  答案："+sq.getAnswer()+"\n";
		StringBuffer res=new StringBuffer();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line=null;
			while((line=reader.readLine())!=null) {
				res.append("  "+line+"\n");
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cont=cont+new String(res);
		return cont;
	}
	public Map<String,Double> analysisChapterScore(StudentQuiz sq) {
		List<StudentQuiz> list=new QuizDao().searchStudentQuizs(sq);
		Map<String,Double> map=new TreeMap<String,Double>();
		double a1=0,a2=0,a3=0,a4=0;
		for(StudentQuiz squiz:list) {
			float acc=Float.parseFloat(squiz.getAcc().split("%")[0]);
			if(acc>80)
				a1++;
			else if(acc>60)
				a2++;
			else if(acc>50)
				a3++;
			else 
				a4++;
		}
		map.put("正确率在80%-100%之间的人数："+a1, a1);
		map.put("正确率在60%-80%之间的人数："+a2, a2);
		map.put("正确率在50%-60%之间的人数："+a3, a3);
		map.put("正确率小于50%的人数："+a4, a4);
		return map;
	}
	/**
	 * 根据每门课分析每个章节的平均正确率
	 * <p>Title: analysisAvgAccByChapter</p>
	 * <p>Description: </p>
	 * @param cc
	 * @return
	 */
	public Map<String,Double> analysisAvgAccByChapter(ClassCourse cc){
		List<Object []> list=new QuizDao().searchAvgAccGroupByChapter(cc);
		Map<String,Double> map=new TreeMap<String,Double>(new MapKeyComparator());
		for(Object [] os:list) {
			String cha=(String) os[0];
			Double d=(Double)os[1];
			map.put(cha, d);
		}
		return map;
	}
	//获得了每门课每个章节的排名
	public Map<ClassCourse,Set<String>> analysisEveCourseChapterPlan() {
		QuizDao qd=new QuizDao();
		List<StudentClass> list=qd.searchClasses();
		Map<ClassCourse,Set<String>> courseChapterRanks=new HashMap<ClassCourse,Set<String>>();//排序后的每门课的章节排名
		for(StudentClass sc:list) {//每门课
			ClassCourse cc=sc.getClassin();
			Map<String,Integer> chapterRanks=new HashMap<String,Integer>();
			MapValueComparator bvc=new MapValueComparator(chapterRanks);
			TreeMap<String,Integer> sorted=new TreeMap<String,Integer>(bvc);
			Map<String,Double> map=this.analysisAvgAccByChapter(cc);
			for(String cha:map.keySet()) {//每个章节
				List<Object []> avgAcc=qd.searchAvgAccCountByChapter(cc, cha);
				Double myAcc=map.get(cha);
				int i=0;
				for(Object [] os:avgAcc) {
					Double s=(Double)os[1];
					if(s>myAcc)
						i++;
				}//获得了每门课每个章节的排名 
				chapterRanks.put(cha, i);
				System.out.println(cc.getClass_name()+cha+i);
			}
			sorted.putAll(chapterRanks);
			courseChapterRanks.put(cc, sorted.keySet());
		}
		this.chapterRank=courseChapterRanks;
		return courseChapterRanks;
	}
	//获得每门课的排名
	public Map<String,Integer> analysisEveCoursePlan() {
		QuizDao qd=new QuizDao();
		List<StudentClass> list=qd.searchClasses();
		Map<String,Integer> map2=new HashMap<String,Integer>();
		MapValueComparator bvc=new MapValueComparator(map2);
		Map<String,Integer> sorted=new TreeMap<String,Integer>(bvc);//记录排名后的科目
		Map<ClassCourse,String> map3=new HashMap<ClassCourse,String>();
		//获得该学生所有科目的平均正确率
		Map<ClassCourse,String> map1=new HashMap<ClassCourse,String>(); 
		for(StudentClass sc:list) {
			Double myAcc=qd.searchAvgAccGroupByCourse(sc.getClassin());
			//获得所有学生所有科目的平均正确率
			List<Object []> avgAccs=qd.searchAvgAccCountByCourse(sc.getClassin());
			int i=0;
			for(Object [] os:avgAccs) {
				Double d=(Double)os[1];
				if(d>myAcc)
					i++;
			}
			map2.put(sc.getClassin().getCourse().getCname(), i);
			if(i<avgAccs.size()/3)
				map3.put(sc.getClassin(), "你很优秀继续保持！！！");
			else if(i<(avgAccs.size()/3*2))
				map3.put(sc.getClassin(), "请继续努力成为更优秀的你！！！");
			else
				map3.put(sc.getClassin(), "阿奥！！！你有挂科的嫌疑！！!赶快加油！！！");
			if(i==0)
				map1.put(sc.getClassin(), 2+"/"+avgAccs.size());//给学生每门课的平均正确率
			else
				map1.put(sc.getClassin(), i+"/"+avgAccs.size());//给学生每门课的平均正确率
		}
		this.courseRankPredict=map3;
		this.courseRanks=map1;
		sorted.putAll(map2);
		List<String> list1=new ArrayList<String>();
		for(String s:sorted.keySet()) {
			list1.add(s);
		}
		this.courseRank=list1;
		return sorted;
	}
}

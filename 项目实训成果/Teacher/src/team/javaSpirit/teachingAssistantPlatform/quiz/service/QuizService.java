package team.javaSpirit.teachingAssistantPlatform.quiz.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.course.dao.CourseDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Quiz;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.quiz.dao.QuizDao;
import team.javaSpirit.teachingAssistantPlatform.rollcall.dao.RollCallDao;


public class QuizService {
	
	
	public QuizService() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	/**
	 * <p>
	 * Title: searchSid
	 * </p>
	 * <p>
	 * Description: 获得老师上课班级
	 * </p>
	 * 
	 * @return
	 */
	public List<String> searchclassname(String tid) {
		QuizDao quizdao=new QuizDao();
		List<ClassCourse> list =quizdao.searchSidByClasscourse(tid);
		List<String> l = new ArrayList<String>();
		for(ClassCourse i:list) {
			String cln=i.getClass_name();
			String cn=i.getCourse().getCname();
			l.add("课程名："+cn+"  "+" 班级名："+cln);
			}
	
		return l;
	}
	/**
	 * 将小测保存到本地和数据库
	 * <p>Title: saveQuiz</p>
	 * <p>Description: </p>
	 * @param file
	 * @param classname
	 * @param coursename
	 * @return 1保存成功，2保存到数据库失败，3保存到本地失败，4文件获取失败
	 */
	public int saveQuiz(File file,String classname,String coursename,String chapter) {
		if(file!=null) {//判断是否获得到了指定文件，避免关闭上传文件框后报错
			if(file.exists()) {
				//将文件保存到本地
				String oldname=file.getName();
				String tid=Constant.myTeacher.getTid();
				Date time=new Date();
				File f=new File("quiz/"+classname);
				if(!f.exists())
					f.mkdir();
				File newFile=new File(f.getAbsolutePath()+"/"+tid+time.getTime()+oldname.substring(oldname.indexOf(".")));
				try {
					newFile.createNewFile();
					InputStream is=new FileInputStream(file);
					OutputStream os=new FileOutputStream(newFile);
					int b;
					while((b=is.read())!=-1) {
						os.write(b);
					}
					is.close();os.close();
					//将小测保存到数据库
					Quiz quiz=new Quiz();quiz.setOldname(oldname);quiz.setNewfile(newFile.getName());
					quiz.setUploadtime(time);quiz.setChapter(chapter);
					ClassCourse cc=new CourseDaoImpl().getClassCourseByCname(classname, coursename);
					quiz.setClasscourse(cc);
					Object o=new QuizDao().saveQuiz(quiz);
					//将学生小测映射集保存到数据库
					//先获得上课班级ClassCourse对应的所有学生
					RollCallDao rcd=new RollCallDao();
					List<Students> list=rcd.searchSidByClasscourse(cc.getClass_id());
					for(Students s:list) {
						StudentQuiz squiz=new StudentQuiz();
						squiz.setQuiz(quiz);squiz.setState(0);squiz.setStudent(s);squiz.setTime(0);
						squiz.setAcc(0);squiz.setAnswer(null);
						new QuizDao().saveStudentQuiz(squiz);
					}
					if(o!=null)
						return 1;
					return 2;
				} catch (IOException e) {
					e.printStackTrace();
					return 2;
				}
			}else {
				return 3;
			}
		}
		return 4;
	}
	/**
	 * 小测展示
	 * 按照老师教授的课程班级展示上传的小测
	 * <p>Title: getQuizAsCourse</p>
	 * <p>Description: </p>
	 */
	public void getQuizAsCourse() {
		QuizDao qd=new QuizDao();
		List<ClassCourse> list=qd.searchSidByClasscourse(Constant.myTeacher.getTid());
		Map<ClassCourse,List<String>> map=new HashMap<ClassCourse,List<String>>();
		for(ClassCourse cc:list) {
			List<String> chapters=qd.searchQuizChapterByClass(cc);
			map.put(cc, chapters);
		}
		for(ClassCourse cc:map.keySet()) {
			System.out.println(cc.getClass_name());
			for(String ch:map.get(cc)) {
				System.out.println(ch);
			}
		}
	}
	/**
	 * 根据章节分门别类的展示小测
	 * <p>Title: getQuizAsChapter</p>
	 * <p>Description: </p>
	 * @param cc
	 * @return
	 */
	public Map<String,List<Quiz>> getQuizAsChapter(ClassCourse cc){
		Map<String,List<Quiz>> map=new TreeMap<String,List<Quiz>>(new MapKeyComparator());
		QuizDao qd=new QuizDao();
		List<String> list=qd.searchQuizChapterByClass(cc);
		Set<String> chapters=new HashSet<String>();
		for(String s:list)
			chapters.add(s);
		for(String chapter:chapters) {
			List<Quiz> quizs=qd.searchQuizAsChapter(cc, chapter);
			map.put(chapter, quizs);
		}
		return map;
	}
}

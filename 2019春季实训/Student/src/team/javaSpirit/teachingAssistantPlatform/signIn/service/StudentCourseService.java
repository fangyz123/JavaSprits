package team.javaSpirit.teachingAssistantPlatform.signIn.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.NodeNumber;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Times;
import team.javaSpirit.teachingAssistantPlatform.facecheck.JcvTest;
import team.javaSpirit.teachingAssistantPlatform.facematch.FaceMatch;
import team.javaSpirit.teachingAssistantPlatform.firstcheck.FirstInvoke;
import team.javaSpirit.teachingAssistantPlatform.signIn.dao.StudentCourseDao;

/**
 * <p>
 * Title: StudentCourseService
 * </p>
 * <p>
 * Description: 学生进行人脸签到时，通过调用Dao类，完成相关的操作。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class StudentCourseService {

	/* Dao类的对象 */
	private static StudentCourseDao studentCourse = new StudentCourseDao();
	/* 开学日期 */
	private static Date begin;
	/* 当前时间 */
	private static Date current;
	/* 第几周 */
	public static long week;
	/* 星期几 */
	private static String date;
	/* 开始时间 */
	private static String startT;
	/* 结束时间 */
	private static String endT;
	/* 签到状态 */
	public static int status;
	/**
	 * 静态代码块。初始化一些类内公用的变量。
	 */
	static {
		// 开学日期
		begin = studentCourse.getStartTime();
		// 当前时间
		current = new Date();
		// 相差几天
		long days = (current.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24);
		// 第几周
		week = (days - 1) / 7 + 1;
		// 星期几
		String[] weekDays = { "日", "一", "二", "三", "四", "五", "六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(current);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		date = weekDays[w];
	}

	/**
	 * <p>
	 * Title: compareWeek
	 * </p>
	 * <p>
	 * Description: 比较当前周数是否在上课周数范围内。
	 * </p>
	 * 
	 * @param time 时间类的对象
	 * @return 比较正确返回真，反之则假
	 */
	public boolean compareWeek(Times time) {
		String c_week = time.getC_week();
		String[] weeks = c_week.split("-");
		long begin = Long.parseLong(weeks[0]);
		long end = Long.parseLong(weeks[1]);
		if (begin <= week && week <= end) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * Title: compareDate
	 * </p>
	 * <p>
	 * Description: 比较这门课当天有没有。
	 * </p>
	 * 
	 * @param time 时间
	 * @return 真假
	 */
	public boolean compareDate(Times time) {
		String c_date = time.getC_date();
		if (c_date.equals(date)) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * Title: compareTime
	 * </p>
	 * <p>
	 * Description: 这门课在这个时间段上有没有。
	 * </p>
	 * 
	 * @param time 时间
	 * @return 真假
	 */
	public boolean compareTime(Times time) {
		NodeNumber nodeNumber = time.getNodeNumber();
		// 签到的时间范围
		int range = nodeNumber.getSign_range();
		// 上课的开始时间
		startT = studentCourse.getBeginTime(nodeNumber.getNode_id());
		// 上课的结束时间
		endT = studentCourse.getEndTime(nodeNumber.getNode_id());
		// 日期格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将当前时间进行格式化，只有年月日
		String fcurrent = dateFormat.format(current);
		String t1 = fcurrent + " " + startT;
		String t2 = fcurrent + " " + endT;
		try {
			Date startTime = dateFormat1.parse(t1);
			Date endTime = dateFormat1.parse(t2);
			// 离上课时间差多少分钟，有正有负
			long minute = (current.getTime() - startTime.getTime()) / (1000 * 60);
			if (Math.abs(minute) <= range) {
				status = 1;
				return true;
			} else if ((Math.abs(minute) > range) && (current.getTime() - endTime.getTime() < 0)) {
				status = 2;
				return true;
			}
			return false;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * <p>
	 * Title: findCurrentCourse
	 * </p>
	 * <p>
	 * Description: 通过学号，判断这名学生在这个时间内，有没有课。
	 * </p>
	 * 
	 * @param sid 学号
	 * @return 真假
	 * @throws ParseException
	 */
	public boolean findCurrentCourse(String sid) {
		// 这个学生所上的课
		List<Integer> course = studentCourse.allCourseBysid(sid);
		for (Integer cid : course) {
			List<Times> courseTime = studentCourse.allTimeBycid(cid);
			for (Times time : courseTime) {
				if (compareWeek(time) && compareDate(time) && compareTime(time)) {
					Constant.cid = cid;
					Constant.endT = endT;
					return true;
				}
			}

		}
		return false;
	}

	public void setImg(String sid, String image) {
		studentCourse.setImageById(sid, image);
	}

	/**
	 * <p>
	 * Title: findCname
	 * </p>
	 * <p>
	 * Description: 通过课程班级号，找到班级名称。
	 * </p>
	 * 
	 * @param cid 课程班级id
	 * @return 课程班级名字
	 */
	public String findCname(int cid) {
		return studentCourse.findCname(cid);
	}

	/**
	 * <p>
	 * Title: face
	 * </p>
	 * <p>
	 * Description: 进行人脸签到。
	 * </p>
	 * 
	 * @return 图片的路径
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws Exception
	 */
	public void firstFace() throws InterruptedException, IOException, Exception {
		Constant.imgsrc = null;
		Constant.imgsrc = FirstInvoke.firstInvoke();

	}

	public String faceCheck() throws InterruptedException, IOException, Exception {
	//	Constant.imgsrc = null;
		return JcvTest.captureFace();
	}

	/**
	 * <p>
	 * Title: insertRecort
	 * </p>
	 * <p>
	 * Description: 插入一条学生签到记录。
	 * </p>
	 * 
	 * @param studentnumber 学生的学号
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws Exception
	 */
	public void insertRecort(String studentnumber) throws InterruptedException, IOException, Exception {
		StudentCourseDao s = new StudentCourseDao();
		Students stu = s.getStudentById(studentnumber);
		ClassCourse classcourse = s.getClassCourseBycid(Constant.cid);
		s.insertRecort(stu, classcourse, Constant.imgsrc);
	}

	/**
	 * <p>
	 * Title: changeState
	 * </p>
	 * <p>
	 * Description: 签到成功，修改学生的状态
	 * </p>
	 * 
	 * @param id 学号
	 * @throws ParseException
	 */
	public void changeState(String id) throws ParseException {
		studentCourse.changeStudentStatus(id, status);
	}

	/**
	 * <p>
	 * Title: getStudentStatus
	 * </p>
	 * <p>
	 * Description: 通过学号，得到学生状态
	 * </p>
	 * 
	 * @param sid 学号
	 */
	public int getStudentStatus(String sid) {
		return studentCourse.getStudentStatus(sid);
	}

}

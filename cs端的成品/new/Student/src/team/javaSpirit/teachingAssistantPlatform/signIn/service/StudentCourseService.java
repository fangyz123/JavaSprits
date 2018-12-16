package team.javaSpirit.teachingAssistantPlatform.signIn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.NodeNumber;
import team.javaSpirit.teachingAssistantPlatform.entity.Times;
import team.javaSpirit.teachingAssistantPlatform.signIn.dao.StudentCourseDao;

public class StudentCourseService {

	private static StudentCourseDao studentCourse = new StudentCourseDao();
	/* 开学日期 */
	private static Date begin;
	/* 当前时间 */
	private static Date current;
	/* 第几周 */
	private static long week;
	/* 星期几 */
	private static String date;

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
		week = days / 7;
		// 星期几
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
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
		String startT = studentCourse.getBeginTime(nodeNumber.getNode_id());
		// 日期格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将当前时间进行格式化，只有年月日
		String fcurrent = dateFormat.format(current);
		String t1 = fcurrent + " " + startT;
		try {
			Date startTime = dateFormat1.parse(t1);
			// 离上课时间差多少分钟，有正有负
			long minute = (current.getTime() - startTime.getTime()) / (1000 * 60);
			if (Math.abs(minute) <= range) {
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
	public boolean findCurrentCourse(String sid) throws ParseException {
		// 这个学生所上的课
		List<Integer> course = studentCourse.allCourseBysid(sid);
		for (Integer cid : course) {
			List<Times> courseTime = studentCourse.allTimeBycid(cid);
			for (Times time : courseTime) {
				if (compareWeek(time) && compareDate(time) && compareTime(time)) {
					Constant.cid = cid;
					return true;
				}
			}

		}
		return false;
	}
	
	public void changeState(String id) {
		studentCourse.changeStudentStatus(id);
	}

	public static void main(String[] args) {
		StudentCourseService ss = new StudentCourseService();
		try {
			ss.findCurrentCourse("2016011357");

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}

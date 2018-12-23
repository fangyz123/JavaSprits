package team.javaSpirit.teachingAssistantPlatform.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.course.dao.CourseDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.entity.NodeNumber;
import team.javaSpirit.teachingAssistantPlatform.entity.Times;

public class CourseServiceImpl {
	/* Dao对象 */
	private static CourseDaoImpl courseDao = new CourseDaoImpl();
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
	/**
	 * 静态代码块。初始化一些类内公用的变量。
	 */
	static {
		// 开学日期
		begin = courseDao.getStartTime();
		// 当前时间
		current = new Date();
		// 相差几天
		long days = (current.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24);
		// 第几周
		week = (days - 1) / 7 + 1;
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
		// 上课的开始时间
		startT = courseDao.getBeginTime(nodeNumber.getNode_id());
		// 上课的结束时间
		endT = courseDao.getEndTime(nodeNumber.getNode_id());
		// 日期格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将当前时间进行格式化，只有年月日
		String fcurrent = dateFormat.format(current);
		String t1 = fcurrent + " " + startT;
		String t2 = fcurrent + " " + endT;

		Date startTime;
		Date endTime;
		try {
			startTime = dateFormat1.parse(t1);
			endTime = dateFormat1.parse(t2);
			// 离上课时间差多少分钟，有正有负
			long mminute = (current.getTime() - startTime.getTime()) / (1000 * 60);
			long lminute = (current.getTime() - endTime.getTime()) / (1000 * 60);
			if (mminute >= 0 && lminute <= 0) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * <p>
	 * Title: findCurrentCourse
	 * </p>
	 * <p>
	 * Description: 通过教工号，判断这名老师在这个时间内，有没有课。
	 * </p>
	 * 
	 * @param sid 教工号
	 * @return 真假
	 */
	public boolean findCurrentCourse(String tid) {
		// 这个老师所上的课
		List<Integer> course = courseDao.findCidByTid(tid);
		for (Integer cid : course) {
			List<Times> courseTime = courseDao.allTimeBycid(cid);
			for (Times time : courseTime) {
				if (compareWeek(time) && compareDate(time) && compareTime(time)) {
					Constant.cid = cid;
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * <p>
	 * Title: findCname
	 * </p>
	 * <p>
	 * Description: 通过班级课程号找到班级课程名。
	 * </p>
	 * 
	 * @param cid 班级课程号
	 * @return 班级课程名
	 */
	public String findCname(int cid) {
		return courseDao.findCname(cid);
	}
}

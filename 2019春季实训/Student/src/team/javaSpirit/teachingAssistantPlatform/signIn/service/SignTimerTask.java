package team.javaSpirit.teachingAssistantPlatform.signIn.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.signIn.dao.StudentCourseDao;

/**
 * <p>
 * Title: SignTimerTask
 * </p>
 * <p>
 * Description: 定时任务，当到下课时间时，自动把学生的签到状态状态改为0.
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月25日
 */
public class SignTimerTask extends TimerTask {
	private Timer timer;

	public SignTimerTask() {
		Date time = getTime();
		timer = new Timer();
		timer.schedule(this, time);
	}

	@Override
	public void run() {
		// 更改状态
		StudentCourseDao scs = new StudentCourseDao();
		scs.changeStudentStatus(Constant.myStudent.getSid(), 0);
		timer.cancel();
	}

	public Date getTime() {
		String[] s = Constant.endT.split(":");
		int hour = Integer.parseInt(s[0]);
		int min = Integer.parseInt(s[1]);
		int sec = Integer.parseInt(s[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, sec);
		Date time = calendar.getTime();
		return time;
	}

}

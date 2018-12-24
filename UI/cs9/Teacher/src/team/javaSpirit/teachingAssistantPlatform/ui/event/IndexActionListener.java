package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.rollcall.service.RollCallService;
import team.javaSpirit.teachingAssistantPlatform.rollcall.service.RollCallThread;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

/**
 * <p>
 * Title: IndexActionListener
 * </p>
 * <p>
 * Description: 为老师端index页面的button添加按钮的动作事件。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月21日
 */
public class IndexActionListener implements ActionListener {
	/* 监听事件的对象 */
	private Index index;
	/* 点名线程 */
	private RollCallThread rollCallThread = null;
	/* 存放点名的文本域 */
	private JLabel lblNewLabel_1;
	/* 获取当前班级的所有签到学生 */
	private RollCallService rcs = null;

	public IndexActionListener(Index index) {
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 远程监控：目前没有页面的实现，用下拉菜单
		if ("远程监控".equals(e.getActionCommand())) {
			// 没有相应的页面，不实现
		} else if ("录屏".equals(e.getActionCommand())) {
			// 没有实现录屏的功能
		} else if ("广播".equals(e.getActionCommand())) {
			// 没有实现广播的功能
		} else if ("学生演示".equals(e.getActionCommand())) {
			// 跳转到学生演示界面，显示每个学生的小电脑和名字
			this.index.jumpSelectstu();
		} else if ("随机点名".equals(e.getActionCommand())) {
			// 跳转到随机点名界面，展示"学号 姓名"、开始和暂停的按钮
			this.index.jumpRandomcall();
		} else if ("签到信息".equals(e.getActionCommand())) {
			// 显示学生的签到情况
			this.index.jumpIndex();
		} else if ("学生作业".equals(e.getActionCommand())) {
			// 没有实现学生作业的功能
		} else if ("开始".equals(e.getActionCommand())) {
			// 随机点名的事件
			if (rcs == null) {
				rcs = new RollCallService();
			}
			if (rollCallThread != null) {
				// 先把以前的线程停了
				rollCallThread.setRe(false);
			}
			// 开启新的线程
			rollCallThread = new RollCallThread(lblNewLabel_1);
			List<Students> list = rcs.searchSid();
			rollCallThread.setList(list);
			rollCallThread.setRe(true);
			rollCallThread.start();
		} else if ("暂停".equals(e.getActionCommand())) {
			rollCallThread.setRe(false);
		}

	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

}

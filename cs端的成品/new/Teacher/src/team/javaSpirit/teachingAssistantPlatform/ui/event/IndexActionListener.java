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
		// 随机点名的事件
		if ("开始".equals(e.getActionCommand())) {
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

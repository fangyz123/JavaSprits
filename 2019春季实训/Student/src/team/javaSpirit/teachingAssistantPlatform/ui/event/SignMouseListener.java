package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.signIn.service.StudentCourseService;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

/**
 * 
 * <p>
 * Title: SignMouseListener
 * </p>
 * <p>
 * Description:为签到菜单添加鼠标事件
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月19日
 */
public class SignMouseListener implements MouseListener {

	private Index index;

	public SignMouseListener(Index index) {
		this.index = index;
	}

	/**
	 * 添加签到菜单触发此业务逻辑
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		StudentCourseService scs = new StudentCourseService();
		// 找到当前课程
		if (scs.findCurrentCourse(Constant.myStudent.getSid())
				&& (scs.getStudentStatus(Constant.myStudent.getSid()) == 0
						|| scs.getStudentStatus(Constant.myStudent.getSid()) == 4)) {
			try {
				if (Constant.myStudent.getImage() == null) {
					// 人脸检测
					scs.firstFace();
					scs.setImg(Constant.myStudent.getSid(), Constant.imgsrc);
				} else {
					// 人脸识别
					Constant.imgsrc = scs.faceCheck();
				}
				// 修改数据库
				if (Constant.imgsrc != null) {
					scs.changeState(Constant.myStudent.getSid());
					scs.insertRecort(Constant.myStudent.getSid());
				}
				if (Constant.imgsrc != null&&StudentCourseService.status != 2) {
					JOptionPane.showMessageDialog(null,"您与"+Constant.myStudent.getSid()+"成功匹配，且签到成功");
				}else if (Constant.imgsrc == null) {
					JOptionPane.showMessageDialog(null,"您与"+Constant.myStudent.getSid()+"未能成功匹配，请再次尝试");
				}else if(StudentCourseService.status == 2){
					JOptionPane.showMessageDialog(null,"You are late!");
				}else {
					JOptionPane.showMessageDialog(null,"error");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (scs.getStudentStatus(Constant.myStudent.getSid()) != 0) {
			JOptionPane.showMessageDialog(null, "您已签到");
		} else {
			JOptionPane.showMessageDialog(null, "当前没有可以签到的课程");
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * 鼠标放到签到菜单改变鼠标形状
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	/**
	 * 鼠标离开签到菜单恢复鼠标原形状
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}

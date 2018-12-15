package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Service;

/**
 * <p>
 * Title: MyItemListener
 * </p>
 * <p>
 * Description: 选择监听事件。根据下拉菜单所选择不同的按钮，完成不同的操作。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月6日
 */
public class MyItemListener implements ItemListener {
	/* 开启连接的服务 */
	private Service service;
	/* 下拉框 */
	private JComboBox<?> comboBox;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 无参构造函数
	 * </p>
	 */
	public MyItemListener() {
		super();
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 有参构造函数，初始化对象
	 * </p>
	 * 
	 * @param comboBox
	 */
	public MyItemListener(JComboBox<?> comboBox) {
		service = new Service();
		this.comboBox = comboBox;
	}

	/**
	 * 选择下拉菜单触发的事件
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (comboBox.getSelectedItem() == "开启") {
				// 开启服务
				service.openService();
			} else if (comboBox.getSelectedItem() == "关闭") {
				// 关闭服务
				service.closeServise();
			}

		}

	}

}

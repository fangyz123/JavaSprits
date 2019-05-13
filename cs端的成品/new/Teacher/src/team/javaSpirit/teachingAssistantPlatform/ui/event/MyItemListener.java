package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import team.javaSpirit.teachingAssistantPlatform.common.Communication;
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
	public MyItemListener(Service service) {
		this.service = service;
	}

	/**
	 * 选择下拉菜单触发的事件
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if ("开启".equals(e.getItem())) {
				// 开启服务
				service.openService(Communication.tPort);
			} else if ("关闭".equals(e.getItem())) {
				// 关闭服务
				if (service.getSendMessageThreads().size()>0) {
					service.closeScreenShare();
				}
				service.closeServise();
			} else if ("开启共享".equals(e.getItem())) {
				// 开启屏幕共享
				service.openScreenShare();
			} else if ("关闭共享".equals(e.getItem())){
				// 关闭屏幕共享
				service.closeScreenShare();
			}
		}
	}

}

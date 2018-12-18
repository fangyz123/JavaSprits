package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.dao.ServiceOpenDaoImpl;

/**
 * <p>
 * Title: ServiceOpenServiceImpl
 * </p>
 * <p>
 * Description: 老师开启服务时，调用相关的Dao类，完成相关的服务。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class ServiceOpenServiceImpl {

	private ServiceOpenDaoImpl serviceOpen = new ServiceOpenDaoImpl();

	/**
	 * <p>Title: updateStatus</p>
	 * <p>Description: 把数据库的teacherStatus表的状态改为1。</p>
	 */
	public void updateStatus() {
		serviceOpen.reviseStatus();
	}
}

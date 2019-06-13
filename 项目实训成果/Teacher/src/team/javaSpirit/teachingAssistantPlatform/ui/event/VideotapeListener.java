package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.vediotape.dao.ToDoFile;
import team.javaSpirit.teachingAssistantPlatform.vediotape.service.VediotapeService;

public class VideotapeListener implements ItemListener {

	/* 开启连接的服务 */
	private VediotapeService service1;
	/* 下拉框 */
	private JComboBox<?> comboBox_1;

	
	public VideotapeListener() {
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
	public VideotapeListener(JComboBox<?> comboBox_1,VediotapeService service1) {
		// 开启服务
		ToDoFile tdf=new ToDoFile();
		tdf.deleteFiles();
		String relativelyPath=System.getProperty("user.dir");
		String  filePath  =  relativelyPath+"//picture//";
		this.service1 = new VediotapeService(filePath, "jpeg");
		this.comboBox_1 = comboBox_1;
	}

	/**
	 * 选择下拉菜单触发的事件
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		
					
		if (e.getStateChange() == ItemEvent.SELECTED) {
			
			if (comboBox_1.getSelectedItem() == "开始") {
//				JOptionPane.showMessageDialog(null, "录屏开启成功！！！");
				service1.openVedio();
				JOptionPane.showMessageDialog(null, "录屏开启成功！！！");
				
			} else if (comboBox_1.getSelectedItem() == "暂停") {
				
				// 暂停服务
				service1.pauseVedio();
				JOptionPane.showMessageDialog(null, "录屏暂停成功！！！");
			} else if (comboBox_1.getSelectedItem() == "停止") {
				// 停止录屏	
//				JOptionPane.showMessageDialog(null, "录屏结束！！！");
				service1.stopVedio();
//				JOptionPane.showMessageDialog(null, "录屏结束！！！");
												
			} else {
				// 关闭录屏
//				service.closeScreenShare();
			}
		}
	}
	

}

package team.javaspirit.remoteControl.entity;

import java.awt.event.InputEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 
* <p>Title: Events</p>
* <p>Description:events��һ�����Ա����л���ʵ���࣬������objectoutputstream֮�䴫�� �����л�
* �Ȱ�һ���������ֽ����飬Ȼ����Լ������������ɶ���</p>
* @author �λ�ϼ
* @date 2018��12��1��
 */
@SuppressWarnings("serial")
public class Events implements Serializable {
	private Map map=new HashMap<String,Object>();//������������ŵ�����
	private InputEvent event;//��ŵ���¼�
	
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public InputEvent getEvent() {
		return event;
	}
	public void setEvent(InputEvent event) {
		this.event = event;
	}
	
	

}

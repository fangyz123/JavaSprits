package team.javaSpirit.teachingAssistantPlatform.entity;

import java.awt.event.InputEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 
* <p>Title: Events</p>
* <p>Description:events是一个可以被序列化的实体类，用于在objectoutputstream之间传输 。序列化
* 先把一个对象变成字节数组，然后把自己数组最后传输后变成对象。 </p>
* @author 何慧霞
* @date 2018年12月1日
 */
@SuppressWarnings("serial")
public class Events implements Serializable {
	private Map<String,Object> map=new HashMap<String,Object>();//存放鼠标比例缩放的数据
	private InputEvent event;//存放点击事件
	
	public Map<String,Object> getMap() {
		return map;
	}
	public void setMap(Map<String,Object> map) {
		this.map = map;
	}
	public InputEvent getEvent() {
		return event;
	}
	public void setEvent(InputEvent event) {
		this.event = event;
	}
	
	

}

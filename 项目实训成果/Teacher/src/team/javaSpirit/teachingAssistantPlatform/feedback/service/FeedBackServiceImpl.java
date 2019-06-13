package team.javaSpirit.teachingAssistantPlatform.feedback.service;

import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.entity.FeedBack;
import team.javaSpirit.teachingAssistantPlatform.feedback.dao.FeedBackDaoImpl;

public class FeedBackServiceImpl {
	private static FeedBackDaoImpl fbDaoImpl = new FeedBackDaoImpl();
	public static List<FeedBack> ListshowTxtByStatus() {
		List<FeedBack> list =fbDaoImpl.showTxtByStatus(0);
		return list;
	}		
		
		
	public static void changeStatus(FeedBack fb) {
		fbDaoImpl.changeStatus(fb);
	}
}

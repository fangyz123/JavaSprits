package team.javaSpirit.teachingAssistantPlatform.common;

/**
 * <p>
 * Title: Communication
 * </p>
 * <p>
 * Description: 网络连接的相关端口和通信的相关命令。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月19日
 */
public class Communication {
	/* 老师开服务的端口，为学生发送截图 */
	public static int tPort = 8081;
	/* 老师开服务的端口，老师进行控制 */
	public static int sPort = 8082;
	/* 学生打开屏幕展示控制台的命令 */
	public static byte openScreen = 1;
	/* 学生关闭屏幕展示控制台的命令 */
	public static byte closeScreen = 2;
	/* 学生连接的命令，为老师提供控制的服务 */
	public static byte connectCommand = 3;
	/* 学生给老师发收到的命令 */
	public static byte receivedCommand = 4;

}

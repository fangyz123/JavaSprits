package team.javaSpirit.teachingAssistantPlatform.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * <p>
 * Title: IpUtil
 * </p>
 * <p>
 * Description: 获得IP工具包。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月13日
 */
public class IpUtil {
	/**
	 * <p>
	 * Title: getRealIP
	 * </p>
	 * <p>
	 * Description: 获得局域网的IP
	 * </p>
	 * 
	 * @return IP地址
	 */
	public static String getRealIP() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();

				// 去除回环接口，子接口，未运行和接口
				if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
					continue;
				}

				if (!netInterface.getDisplayName().contains("Intel")
						&& !netInterface.getDisplayName().contains("Realtek")) {
					continue;
				}
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress ip = addresses.nextElement();
					if (ip != null) {
						// ipv4
						if (ip instanceof Inet4Address) {
							return ip.getHostAddress();
						}
					}
				}
				break;
			}
		} catch (SocketException e) {
		}
		return null;
	}
}

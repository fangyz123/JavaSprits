package com.ryy.ui.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpUtil {
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
				System.out.println(netInterface.getDisplayName());
				while (addresses.hasMoreElements()) {
					InetAddress ip = addresses.nextElement();
					if (ip != null) {
						// ipv4
						if (ip instanceof Inet4Address) {
							System.out.println("ipv4 = " + ip.getHostAddress());
							return ip.getHostAddress();
						}
					}
				}
				break;
			}
		} catch (SocketException e) {
			System.err.println("Error when getting host ip address" + e.getMessage());
		}
		return null;
	}
}

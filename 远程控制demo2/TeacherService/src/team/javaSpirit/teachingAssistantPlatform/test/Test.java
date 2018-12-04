package team.javaSpirit.teachingAssistantPlatform.test;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer,String> fileContents=new ConcurrentHashMap<>(10);
		System.out.println("容量："+fileContents.size());
		fileContents.put(1, "111");
		String s1=fileContents.get(1);
		System.out.println("s1:  "+s1);
		System.out.println("容量："+fileContents.size());
		fileContents.put(1, "222");
		String s2=fileContents.get(1);
		System.out.println("s2:  "+s2);
		System.out.println("容量："+fileContents.size());
		
//		MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
//		myReadWriteLock.put("a", "fantj_a");
//		Test.read(myReadWriteLock);
//		Test.write(myReadWriteLock);
//		Test.wr(myReadWriteLock);
	}

	// 读-写互斥
	public static void wr(MyReadWriteLock myReadWriteLock) {
		// 读读不互斥（共享）
		// 读写互斥
		new Thread(new Runnable() {
			@Override
			public void run() {
				myReadWriteLock.put("a", "fantj_a");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
	}

	// 写写互斥
	public static void write(MyReadWriteLock myReadWriteLock) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				myReadWriteLock.put("b", "fantj_b");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				myReadWriteLock.put("b", "fantj_b");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				myReadWriteLock.put("b", "fantj_b");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				myReadWriteLock.put("b", "fantj_b");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				myReadWriteLock.put("b", "fantj_b");
			}
		}).start();
	}

	// 读读共享
	public static void read(MyReadWriteLock myReadWriteLock) {
		// 读读不互斥（共享）
		// 读写互斥
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(myReadWriteLock.get("a"));
			}
		}).start();
	}
}

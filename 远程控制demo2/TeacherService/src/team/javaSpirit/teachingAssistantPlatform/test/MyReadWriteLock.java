package team.javaSpirit.teachingAssistantPlatform.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReadWriteLock {

	public MyReadWriteLock() {

	}

	private Map<String, Object> map = new HashMap<>();

	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	private Lock r = rwl.readLock();
	private Lock w = rwl.writeLock();

	public Object get(String key) {
		try {
			r.lock();
			System.out.println(Thread.currentThread().getName() + "read 操作执行");
//			Thread.sleep(500);
			return map.get(key);
		} finally {
			r.unlock();
			System.out.println(Thread.currentThread().getName() + "read 操作结束");
		}

	}

	public void put(String key, Object value) {
		try {
			w.lock();
			System.out.println(Thread.currentThread().getName() + "write 操作执行");
			Thread.sleep(500);
			map.put(key, value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			w.unlock();
			System.out.println(Thread.currentThread().getName() + "write 操作结束");
		}
	}

}

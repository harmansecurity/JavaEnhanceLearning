package com.ecnu.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

	/**
	 * @param args
	 */
	private Map<String, Object> cache = new HashMap<String, Object>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ReadWriteLock rw1 = new ReentrantReadWriteLock();

	public Object getData(String key) {
		rw1.readLock().lock();
		Object value = null;
		try {
			value = cache.get(key);
			if (value == null) {
				rw1.readLock().unlock();
				rw1.writeLock().lock();
				try {
					if (value == null) {
						value = "DB";//  µº  ß»•queryDB();
					}
				} finally {
					rw1.writeLock().unlock();
				}
				rw1.readLock().lock();
			}
		} finally {
			rw1.readLock().unlock();
		}
		return value;
	}

}

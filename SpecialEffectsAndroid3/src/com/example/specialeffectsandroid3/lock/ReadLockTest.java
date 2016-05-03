package com.example.specialeffectsandroid3.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.example.specialeffectsandroid3.Diary;

public class ReadLockTest {

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	double value = 0d; // 值
	int addtimes = 0;

	public void addValue(double v) {
		lock.readLock().lock();
		Diary.print("LockTest to addValue: " + v + "   "
				+ System.currentTimeMillis());
		try {
			Thread.sleep(1000);
			this.value += v;
			this.addtimes++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}

	public String getValue() {
		lock.readLock().lock();
		Diary.print("ReadWriteLockTest to getInfo   "
				+ System.currentTimeMillis());
		try {
			Thread.sleep(1000);
			return this.value + " : " + this.addtimes;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return null;
	}

}

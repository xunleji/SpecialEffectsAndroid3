package com.example.specialeffectsandroid3.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.example.specialeffectsandroid3.Diary;

public class LockTest {

	private Lock lock = new ReentrantLock();
	double value = 0d; // 值
	int addtimes = 0;

	public void addValue(double v) {
		lock.lock();
		Diary.print("LockTest to addValue: " + v + "   "
				+ System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		this.value += v;
		this.addtimes++;
		lock.unlock();// 释放锁

	}

	public double getValue() {
		return value;
	}
}

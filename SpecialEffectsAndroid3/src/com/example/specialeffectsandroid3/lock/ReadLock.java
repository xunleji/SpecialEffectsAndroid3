package com.example.specialeffectsandroid3.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.example.specialeffectsandroid3.Diary;

public class ReadLock {

	// 传统的synchronized方法
	public synchronized void readLockTest(Thread thread) {
		try {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				Diary.print(thread.getName() + "正在进行读操作");
			}
			Diary.print(thread.getName() + "读操作完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void readLockTests(Thread thread) {
		lock.readLock().lock();
		try {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				Diary.print(thread.getName() + "正在进行读操作");
			}
			Diary.print(thread.getName() + "读操作完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}

	}
}

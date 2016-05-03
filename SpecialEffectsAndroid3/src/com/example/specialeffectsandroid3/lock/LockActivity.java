package com.example.specialeffectsandroid3.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.example.specialeffectsandroid3.Diary;
import com.example.specialeffectsandroid3.R;

import android.app.Activity;
import android.os.Bundle;

public class LockActivity extends Activity {

	private List<Integer> arrayList = new ArrayList<Integer>();
	private ReadLock rwlock = new ReadLock();
	private LockTest lockTest = new LockTest();
	private ReadLockTest rlTest = new ReadLockTest();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// rwlock.readLockTests(Thread.currentThread());
		// // lockInterruptiblyTest(Thread.currentThread());
		// }
		// }).start();
		// Thread thread = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// rwlock.readLockTests(Thread.currentThread());
		// // lockInterruptiblyTest(Thread.currentThread());
		// }
		// });
		// thread.start();
		// thread.interrupt();

		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				// lockTest.addValue(55.55);
				rlTest.addValue(55.55);
			}
		};
		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				// Diary.print("value: " + lockTest.getValue());
				Diary.print("value: " + rlTest.getValue());
			}
		};
		ExecutorService excutor = Executors.newCachedThreadPool();
		Future future = null;
		for (int i = 0; i < 2; i++) {
			future = excutor.submit(run1);
		}
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 2; i++) {
			future = excutor.submit(run2);
		}
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		future = excutor.submit(run1);
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// future = excutor.submit(run2);
		// try {
		// future.get();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// e.printStackTrace();
		// }
		excutor.shutdownNow();

	}

	// lock设置为局部变量没有效果
	private void lockTest(Thread thread) {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println(thread.getName() + "得到了锁");
			for (int i = 0; i < 10000; i++) {
				arrayList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println(thread.getName() + "释放了锁");
		}
	}

	private Lock lock = new ReentrantLock();

	private void lockTests(Thread thread) {
		lock.lock();
		try {
			System.out.println(thread.getName() + "得到了锁");
			for (int i = 0; i < 50000; i++) {
				arrayList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println(thread.getName() + "释放了锁");
		}
	}

	private void trylockTest(Thread thread) {
		if (lock.tryLock()) {
			try {
				System.out.println(thread.getName() + "得到了锁");
				for (int i = 0; i < 10000; i++) {
					arrayList.add(i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				System.out.println(thread.getName() + "释放了锁");
			}
		} else {
			System.out.println(thread.getName() + "获取锁失败");
		}
	}

	private void lockInterruptiblyTest(Thread thread) {
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			System.out.println(Thread.currentThread().getName() + "被中断");
		}
		try {
			System.out.println(thread.getName() + "得到了锁");
			for (int i = 0; i < 50; i++) {
				System.out.println(thread.getName() + "arrayList");
				arrayList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println(thread.getName() + "释放了锁");
		}
	}

}

package com.imac.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Lock1 extends ReentrantLock {

	public ReentrantLock lock = new ReentrantLock();

	public void waitMethod()
	{
		if (lock.tryLock()) {
			System.out.println(Thread.currentThread().getName() + "获得了锁");
//			while (true) {
//
//			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			lock.unlock();
		}
		else
			System.out.println(Thread.currentThread().getName() + "没有获得锁");
	}

	public void testLock() {
		try {

			if (lock.isLocked()) {
				System.out.println(Thread.currentThread().getName() + "2222222222");
			}
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "333333333333333");
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Lock1 lock1 = new Lock1();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				lock1.waitMethod();
			}
		};

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				lock1.testLock();
			}
		};

		Thread t1 = new Thread(runnable);
		t1.start();

		Thread.sleep(2000);

		Thread t2 = new Thread(runnable1);
		t2.start();
	}


}

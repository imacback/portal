package com.imac.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

	private static  Lock lock = new ReentrantLock();

	private Object object = new Object();

	public void methodA() throws InterruptedException {
		synchronized (this) {
			System.out.println("method A begin");

			this.wait();

		}
		System.out.println("method A end");
		Thread.sleep(10000);
//		try {
//			lock.lock();
//
//			System.out.println("method A begin");
//
//			object.wait();
//
//
//
//		} catch (Exception e) {
//
//		} finally {
//			System.out.println("method A end");
//			Thread.sleep(10000);
//			lock.unlock();
//		}
	}

	public synchronized void methodB() {
		try {
//			lock.lock();
			System.out.println("Thread:" + Thread.currentThread().getName() + ",begin");
		} catch (Exception e) {

		} finally {
//			lock.unlock();
		}
	}

	public static void main(String[] args) {
		MyService service = new MyService();

		MyThreadA threadA = new MyThreadA(service);
		Thread t1 = new Thread(threadA);
		t1.setName("threadA");

		MyThreadB threadB = new MyThreadB(service);
		Thread t2 = new Thread(threadB);
		t2.setName("threadB");

		t1.start();
//		t1.start(); 多次调用 start throw java.lang.IllegalThreadStateException 异常
		t2.start();
	}
}

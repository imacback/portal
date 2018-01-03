package com.imac.sync;

/**
 * Created by ab054857 on 2017/8/14.
 */
public class BaseClass {

	private String str = "123";

	public  void dosomething() {
//		System.out.println("in base dosomthing.........");
synchronized(BaseClass.class) {

//}
		try {
			System.out.println(Thread.currentThread().getName() + "begin");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		System.out.println("out base dosomething...........");
	}
	}

	public synchronized void test1() {
//		synchronized (str) {
			try {
			System.out.println(Thread.currentThread().getName() + "-------begin");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "-------end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		}

	}

}

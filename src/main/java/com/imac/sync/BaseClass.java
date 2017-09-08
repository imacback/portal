package com.imac.sync;

/**
 * Created by ab054857 on 2017/8/14.
 */
public class BaseClass {

	public synchronized void dosomething() {
		System.out.println("in base dosomthing.........");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("out base dosomething...........");
	}
}

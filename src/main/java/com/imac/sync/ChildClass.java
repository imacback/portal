package com.imac.sync;

/**
 * Created by ab054857 on 2017/8/14.
 */
public class ChildClass extends BaseClass {

	public synchronized void childMethod() {
		System.out.println("in childrenMethod...................");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("out childrenMethod............");
	}
}

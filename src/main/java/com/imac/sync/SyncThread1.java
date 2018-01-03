package com.imac.sync;

/**
 * Created by ab054857 on 2017/8/14.
 */
public class SyncThread1 implements Runnable {

	private BaseClass childClass ;

	public SyncThread1(BaseClass childClass) {
		this.childClass = childClass;
	}

	@Override
	public void run() {
		childClass.test1();
	}
}

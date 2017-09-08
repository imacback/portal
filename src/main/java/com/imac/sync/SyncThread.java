package com.imac.sync;

/**
 * Created by ab054857 on 2017/8/14.
 */
public class SyncThread implements Runnable{

	private SyncTest syncTest;

	private BaseClass baseClass;

	public SyncThread(BaseClass baseClass) {
		this.baseClass = baseClass;
	}


	public SyncThread(SyncTest syncTest) {
		this.syncTest = syncTest;
	}

	@Override
	public void run() {
		try {
			baseClass.dosomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

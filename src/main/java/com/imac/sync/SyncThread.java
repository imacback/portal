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

	public static void main(String[] args) {
		BaseClass baseClass = new BaseClass();
		SyncThread syncThread = new SyncThread(baseClass);
		SyncThread1 syncThread1 = new SyncThread1(baseClass);
		Thread t1 = new Thread(syncThread);

		t1.setName("a");
		t1.start();

		Thread t2 = new Thread(syncThread1);
		t2.setName("b");
		t2.start();
	}
}

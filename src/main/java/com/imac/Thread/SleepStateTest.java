package com.imac.Thread;

public class SleepStateTest extends Thread {

	public SleepStateTest()
	{
	}

	public void run()
	{

		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread end:");
	}

	public void getS() {
		System.out.println("thread stata:" + Thread.currentThread().getName() + "))))))))))))))))))))" + Thread.currentThread().getState());
		// sleep 后线程状态变为 TIMED_WAITING
		System.out.println("thread stata:" + this.getName() + "==============" + this.getState());
	}

	public static void main(String[] args) throws InterruptedException {
		SleepStateTest myThread = new SleepStateTest();
		myThread.setName("A");
		myThread.start();
		Thread.sleep(2000);
		myThread.getS();
	}
}

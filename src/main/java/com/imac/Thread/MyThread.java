package com.imac.Thread;

public class MyThread extends Thread {

	public MyThread()
	{
		System.out.println("MyThread5----->Begin");
		System.out.println("Thread.currentThread().getName()----->" +
				Thread.currentThread().getName());
		System.out.println("this.getName()----->" + this.getName());
		System.out.println("MyThread5----->end");
	}

	public void run()
	{
		System.out.println("run----->Begin");
		System.out.println("Thread.currentThread().getName()----->" +
				Thread.currentThread().getName());
		System.out.println("this.getName()----->" + this.getName());
		System.out.println("run----->end");

		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread end:");
	}

	public void getS() {
		System.out.println("thread stata:" + Thread.currentThread().getName() + "))))))))))))))))))))" + Thread.currentThread().getState());
		System.out.println("thread stata:" + this.getName() + "==============" + this.getState());
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.setName("A");
		myThread.start();
		Thread.sleep(2000);
		myThread.getS();
	}
}

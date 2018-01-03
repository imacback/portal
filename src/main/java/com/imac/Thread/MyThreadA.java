package com.imac.Thread;

public class MyThreadA implements Runnable {

	private MyService service;

	public MyThreadA(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		try {
			service.methodA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

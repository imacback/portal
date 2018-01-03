package com.imac.Thread;

public class MyThreadB implements Runnable {

	private MyService service;

	public MyThreadB(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}

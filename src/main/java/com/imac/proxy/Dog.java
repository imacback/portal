package com.imac.proxy;

/**
 * Created by ab054857 on 2017/9/7.
 */
public class Dog implements Animal {
	@Override
	public void run() {
		System.out.println("小狗跑！");
	}

	@Override
	public void jump() {
		System.out.println("小狗跳！");
	}
}

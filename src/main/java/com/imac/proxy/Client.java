package com.imac.proxy;

/**
 * Created by ab054857 on 2017/9/7.
 */
public class Client {
	public static void main(String[] args) {
		MyProxy proxy = new MyProxy();
		Animal dog = (Animal) proxy.createProxyInstance(new Dog());
		dog.run();
		dog.jump();
	}
}

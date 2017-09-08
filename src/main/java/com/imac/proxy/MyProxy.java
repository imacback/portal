package com.imac.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ab054857 on 2017/9/7.
 */
public class MyProxy implements InvocationHandler {

	private Object targetObject;

	public Object createProxyInstance(Object o) {
		this.targetObject = o;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		command();
		Object ret = method.invoke(targetObject, args);
		award();
		return ret;
	}

	private void command() {
		System.out.println("驯兽师发出命令！");
	}

	private void award(){
		System.out.println("驯兽师给与奖励！");
	}
}

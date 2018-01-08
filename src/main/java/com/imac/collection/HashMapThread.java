package com.imac.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapThread extends Thread {

	private static AtomicInteger ai = new AtomicInteger(0);
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

	@Override
	public void run() {
		while (ai.get() < 500000)
		{
			map.put(ai.get(), ai.get());
			ai.incrementAndGet();
		}
	}

	public static void main(String[] args)
	{
//		HashMapThread hmt0 = new HashMapThread();
//		HashMapThread hmt1 = new HashMapThread();
//		HashMapThread hmt2 = new HashMapThread();
//		HashMapThread hmt3 = new HashMapThread();
//		HashMapThread hmt4 = new HashMapThread();
//		HashMapThread hmt5 = new HashMapThread();
//		HashMapThread hmt6 = new HashMapThread();
//		HashMapThread hmt7 = new HashMapThread();
//		HashMapThread hmt8 = new HashMapThread();
//		HashMapThread hmt9 = new HashMapThread();
//		HashMapThread hmt10 = new HashMapThread();
//
//		hmt0.start();
//		hmt1.start();
//		hmt2.start();
//		hmt3.start();
//		hmt4.start();
//		hmt5.start();
//		hmt6.start();
//		hmt7.start();
//		hmt8.start();
//		hmt9.start();
//		hmt10.start();

		HashMapThread hmt0 = null;
		for (int i = 0; i < 100; i++) {
			hmt0 = new HashMapThread();
			hmt0.start();
		}
	}
}

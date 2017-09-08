package com.imac.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ab054857 on 2017/8/22.
 * volatile 线程可见性测试
 */
public class VolatileTest {

//	private static  volatile int count = 0;
	private static AtomicInteger count = new AtomicInteger();

	public static void inc() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		count++;
		count.incrementAndGet();
	}

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
			System.out.println(count.get());
//				System.out.println(count);
		});

		for (int i=0; i < 10; i++) {
			new Thread(() -> {

//					System.out.println("子线程执行" + Thread.currentThread().getName() + "执行");

				try {
					inc();
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();

		}
	}
}

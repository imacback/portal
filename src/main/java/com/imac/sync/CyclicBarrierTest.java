package com.imac.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ab054857 on 2017/8/16.
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		int n = 4;

		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "主线程执行");
			}
		});

		for (int i=0; i< n; i++) {
			new Thread(new Work(cyclicBarrier) ,String.valueOf(i)).start();
		}

	}

	static class Work implements Runnable {
		private CyclicBarrier cyclicBarrier;

		public Work(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			System.out.println("线程:" + Thread.currentThread().getName() + "正在执行");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程:" + Thread.currentThread().getName() + "执行完毕,等待其他线程");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("线程" +Thread.currentThread().getName()+ "写入完毕，继续处理其他任务...");
		}
	}


}

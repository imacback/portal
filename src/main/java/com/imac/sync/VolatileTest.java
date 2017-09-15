package com.imac.sync;

/**
 * Created by ab054857 on 2017/8/22.
 * volatile 线程可见性测试
 */
public class VolatileTest {
	volatile int a = 1;
	volatile int b = 2;

	public void change(){
		a = 3;
		b = a;
	}

	public void print(){
		System.out.println("b="+b+";a="+a);
	}


	int count = 0;
//	private static AtomicInteger count = new AtomicInteger();

	public static void inc() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		count++;
//		count.incrementAndGet();
	}

	public static void read(VolatileTest volatileTest) throws InterruptedException {
		System.out.println("read");
//		Thread.sleep(2000);
		while (true) {
			int i = volatileTest.count;
			System.out.println(i);
		}

	}

	public static void write(VolatileTest volatileTest, int b) {
		System.out.println("write");
		volatileTest.count = b;
	}

	public static void main(String[] args) throws Exception{
		while (true){
			final VolatileTest test = new VolatileTest();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.change();
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.print();
				}
			}).start();

		}

//		VolatileTest volatileTest = new VolatileTest();
//
//		new Thread(() -> {
//			try {
//				read(volatileTest);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}).start();
//
//		new Thread(() -> {
//			write(volatileTest,2);
//		}).start();


//		CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
////			System.out.println(count.get());
////				System.out.println(count);
//		});

//		for (int i=0; i < 10; i++) {
//			new Thread(() -> {
//
////					System.out.println("子线程执行" + Thread.currentThread().getName() + "执行");
//
//				try {
//					inc();
//					cyclicBarrier.await();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				} catch (BrokenBarrierException e) {
//					e.printStackTrace();
//				}
//			}).start();
//
//		}
	}
}

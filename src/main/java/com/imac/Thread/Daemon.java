package com.imac.Thread;

import java.util.Scanner;

/**
 *守护线程
 */
public class Daemon {
    public static void main(String args[]) {
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();

		System.out.println("isDaemon = " + thread.isDaemon());
		Scanner scanner = new Scanner(System.in);
		// 接受输入，使程序在此停顿，一旦接受到用户输入,main线程结束，JVM退出!
		scanner.next();

		//AddShutdownHook方法增加JVM停止时要做处理事件：123

		//当JVM退出时，打印JVM Exit语句.
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.out.println("JVM Exit!");
			}
		});
	}

    static class DaemonThread implements Runnable {

        @Override
        public void run() {
//			while (true) {
//				for (int i = 1; i <= 3; i++) {
//
//					System.out.println("守护线程:"+i);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					} finally {
//					}
//				}
//			}

			System.out.println("守护线程:");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("finally not excuete!");
			}
		}
    }
}

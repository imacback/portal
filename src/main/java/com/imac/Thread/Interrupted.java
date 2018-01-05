package com.imac.Thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {

    public static void main(String args[]) throws InterruptedException {
         Thread sleep = new Thread(new SleepRunner());
         sleep.setDaemon(true);
         Thread busy = new Thread(new BusyRunner());
//         busy.setDaemon(true);
         busy.setName("busy");

//         sleep.start();
         busy.start();

         Thread.sleep(2000);

//         sleep.interrupt();
         busy.interrupt();

//         System.out.println(sleep.isInterrupted());
//         System.out.println(busy.isInterrupted());

//		System.out.println(sleep.interrupted());
//		System.out.println(busy.interrupted());
//		System.out.println(busy.interrupted());

         Thread.sleep(1000);
    }



    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
            	if (Thread.currentThread().interrupted()) {
					System.out.println(Thread.currentThread().getName() + "====");
				}

            }
        }
    }
}

package com.imac.Thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {

    public static void main(String args[]) throws InterruptedException {
         Thread sleep = new Thread(new SleepRunner());
         sleep.setDaemon(true);
         Thread busy = new Thread(new BusyRunner());
         busy.setDaemon(true);

         sleep.start();
         busy.start();

         Thread.sleep(10000);

         sleep.interrupt();
         busy.interrupt();

         System.out.println(sleep.isInterrupted());
         System.out.println(busy.isInterrupted());

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

            }
        }
    }
}

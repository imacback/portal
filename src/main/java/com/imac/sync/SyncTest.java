package com.imac.sync;

import com.imac.collection.HashMapTest;

public class SyncTest {

    private HashMapTest hashMapTest = new HashMapTest();

    public static void main(String[] args) {
        SyncTest test = new SyncTest();

        Thread t2 = new Thread(new TheadTest2(test));
        Thread t1 = new Thread(new ThreadTest(test));

        t2.start();
        t1.start();
    }

    public  synchronized void method1() {
        System.out.println("access method1");
    }

    public  void method2() {
        synchronized (this) {
             System.out.println("access method2");
            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             System.out.println("access method2 end");
        }
    }

    static class ThreadTest implements Runnable{

        private SyncTest test;
        private ThreadTest(SyncTest test) {
            this.test = test;
        }
        @Override
        public void run() {
            System.out.println("t1 start");
            test.method1();
            System.out.println("t1 end");
        }
    }

    static class TheadTest2 implements Runnable {
        private SyncTest test;
        private TheadTest2(SyncTest test) {
            this.test = test;
        }
        @Override
        public void run() {
            System.out.println("t2 start");
            try {
                test.method2();
//                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("t2 end");
        }
    }
}

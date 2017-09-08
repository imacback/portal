package com.imac.core;

import java.util.concurrent.TimeUnit;

public class FinalTest {

     int i = 1;
    static FinalTest test;

    public FinalTest() {
        test = this;
        for (int j = 0; j < 10000000; j++) {

        }
        i = 2;
    }

    public static void write() {
        new FinalTest();
    }

    public static void read() {
        if (test != null) {
            int tmp = test.i;

            System.out.println(tmp);
        } else {
            System.out.println("test is null");
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                write();

//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 100 ; i++) {
//                    read();
//                }
                 read();

            }
        });

        t2.start();
    }
}

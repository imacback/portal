package com.imac.sync;

import com.imac.collection.HashMapTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncTest {

    private static HashMapTest hashMapTest = new HashMapTest();

    private static HashMapTest hashMapTest2 = new HashMapTest();

     private static HashMapTest hashMapTest3 = new HashMapTest();

    private static HashMapTest hashMapTest4 = new HashMapTest();

//    static List<Class<?>> list = new ArrayList<>();

    static Map<Integer, HashMapTest> map = new ConcurrentHashMap<>();

    private static int i = 10;

    public static void main(String[] args) throws Exception {

//        list.add(String.class);
//        list.add(Integer.class);

//        list.add("1");
//        list.add("2");

        /**
         *  只锁部分对象 比如：同一个POJO，对ID不同的对象进行加锁，提高并发度
         *  （利用ConcurrentHashMap实现,POJO需要覆盖hashcode()方法，返回相同hash值,新建一个辅助类，属性只有ID）
         *  V putIfAbsent(K key, V value)
            如果key对应的value不存在，则put进去，返回null。否则不put，返回已存在的value。
         */
//        HashMapTest h1 = map.putIfAbsent(1,hashMapTest);
//        HashMapTest h2 =  map.putIfAbsent(1,hashMapTest2);
//
//        HashMapTest h3 = map.putIfAbsent(2,hashMapTest3);
//        HashMapTest h4 =  map.putIfAbsent(2,hashMapTest4);
//
//        System.out.println(h1);
//        System.out.println(h2 == hashMapTest);
//
        SyncTest test = new SyncTest();
//
//        Thread t2 = new Thread(new TheadTest2(test));
//        Thread t1 = new Thread(new ThreadTest(test));
//
//        t2.start();
//        t1.start();

		for (int j = 0; j < 10; j++) {
			Thread t1 = new Thread(new ThreadTest(test));
			t1.start();
			t1.join();
		}

		System.out.println(i);
	}

    public  void method1() {
    synchronized (map.get(1)) {
        System.out.println(Thread.currentThread().getName() + "access method1");
            try {
            	--i;
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             System.out.println(Thread.currentThread().getName() + " access method1 end");
        }
    }

    public  void method2() {
        synchronized (map.get(2)) {
            System.out.println(Thread.currentThread().getName() + " access method2");
            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             System.out.println(Thread.currentThread().getName() + " access method2 end");
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
			map.putIfAbsent(1,new HashMapTest());
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
			map.putIfAbsent(2,new HashMapTest());
            try {
                test.method2();
//                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("t2 end");
        }
    }
}

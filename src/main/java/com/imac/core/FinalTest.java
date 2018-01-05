package com.imac.core;

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
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                write();
//
////                try {
////                    TimeUnit.SECONDS.sleep(2);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        });
//
//        t1.start();
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
////                for (int i = 0; i < 100 ; i++) {
////                    read();
////                }
//                 read();
//
//            }
//        });
//
//        t2.start();

        System.out.println("result:" + CatchException());
    }

    public static int test() {
    	int i = 0;

    	try {
    		return 1;
		} catch (Exception e) {

		} finally {
    		return 2;
		}
	}

	public static int CatchException(){
		int i=10;
		try{
			System.out.println("i in try block is--"+i);
			i=i/0;
			return --i;
		}catch(Exception e){
			System.out.println("i in catch - form try block is--"+i);
			int j = i/0;
			return --i;
		}
//		finally{
//
//			System.out.println("i in finally - from try or catch block is--"+i);
//			--i;
//			System.out.println("i in finally block is--"+i);
//			//return --i;
//		}
	}
}

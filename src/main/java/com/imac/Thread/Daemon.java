package com.imac.Thread;

/**
 *守护线程
 */
public class Daemon {
    public static void main(String args[]) {
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally excute");
            }
        }
    }
}

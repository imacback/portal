package com.imac;

/**
 * Created by ab054857 on 2017/8/14.
 * 构造器this逃逸
 */
public class ThreadThisEscape {

	private int a = 1;



	public ThreadThisEscape() {
		new Thread(new EscapeRunable()).start();

//		for (int i = 0; i< 100000; i++) {
//
//		}

		a = 2;
	}

	private class EscapeRunable implements Runnable  {

		@Override
		public void run() {
			System.out.println(ThreadThisEscape.this.a);
		}
	}

	public static void main(String[] args) {
		new ThreadThisEscape();
	}
}

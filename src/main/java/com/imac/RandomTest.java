package com.imac;

import java.util.Random;

/**
 * Created by ab054857 on 2017/8/23.
 */
public class RandomTest {

	public static void main(String[] args) {
		Random r1 = new Random(10);
		Random r2 = new Random(10);

		for (int i=0; i<10; i++) {
			System.out.print(r1.nextInt(10) + "_");
			System.out.println(r2.nextInt(10));
		}
	}
}

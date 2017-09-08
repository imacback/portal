package com.company;

/**
 * created by ab054857 on 2017/8/24.
 *
 * 递归
 */
public class TestDG {

	public static void main(String[] args) {

		int a = dg(2);
		System.out.println(a);
	}

	public static int dg(int a) {

		if (a == 1) {
			return 1;
		} else {
			return dg(a-1) + a;
		}
	}
}

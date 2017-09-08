package com.imac.Sort;

/**
 * Created by ab054857 on 2017/8/21.
 * 选择排序
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 7;
		a[1] = 12;
		a[2] = 5;
		a[3] = 8;
		a[4] = 10;

		a = selectSort(a);

		for (int i= 0; i < a.length; i++ ) {
			System.out.println(a[i]);
		}
	}

	public static int[] selectSort(int[] a) {
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			int min = a[i];

			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					index = j;
				}
			}

			int tmp = a[i];
			a[i] = a[index];
			a[index] = tmp;
		}

		return a;
	}
}

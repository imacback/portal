package com.imac.Sort;

/**
 * Created by ab054857 on 2017/8/21.
 * 冒泡排序
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] a = new int[5];
		a[0] = 7;
		a[1] = 12;
		a[2] = 5;
		a[3] = 8;
		a[4] = 10;

		a = bubbleSort(a);

		for (int i= 0; i < a.length; i++ ) {
			System.out.println(a[i]);
		}

	}

	public static int[] bubbleSort(int[] a) {
		int length = a.length;
		int times = 0;

//		for (int i= 0; i < length; i++) {
//			for (int j = i + 1; j < length; j++) {
//				times++;
//				if (a[i] > a[j]) {
//					int tmp = a[j];
//					a[j] = a[i];
//					a[i] = tmp;
//				}
//			}
//		}



//		for (int i= 1; i < length; i++) {
//			for (int j = 0; j < i; j++) {
//				times++;
//				if (a[j] > a[j + 1]) {
//					int tmp = a[j + 1];
//					a[j + 1] = a[j];
//					a[j] = tmp;
//				}
//			}
//		}

		for (int i = length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				times++;
				if (a[j] > a[j + 1]) {
					int tmp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = tmp;
				}
			}
		}

		System.out.println("times:" + times);

		return a;
	}

//	public static void swap(int a, int b) {
//		int tmp = a;
//		a = b;
//		b = tmp;
//	}
}

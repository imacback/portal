package com.imac.Sort;

/**
 * Created by ab054857 on 2017/8/25.
 * 希尔排序
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,12,8,6};

		a = shellSort(a);

		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static int[] shellSort(int[] a) {
		int h = 1;

		while ((h = 3 * h + 1) < a.length) {
			System.out.println(h);
		}

//		while (h < a.length/3) {
//			h = 3* h + 1;
//			int in,out;
		h = (h - 1) / 3;
			while (h   > 0) {
				h = (h - 1) / 3;

				for (int i = 0; i< h ; i++) {
					int in,out;
					for (out=h; out< a.length; out=out+h) {
						int tmp = a[out];

						in = out;

						while (in > h -1  && a[in -h] >= tmp) {
							a[in] = a[in - h];
							in -= h;
						}

						a[in] = tmp;
					}
				}



//			}
		}

		return a;

	}
}

package com.imac.Sort;

import java.util.Random;

/**
 * Created by ab054857 on 2017/8/25.
 * 快速排序
 */
public class QuickSort {

	static int[] a = new int[5];
	public static void main(String[] args) {
		Random r = new Random();
		for (int i=0; i<5; i++) {
			a[i] = r.nextInt(10);
		}

		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + "_");
		}

		System.out.println("==========");
		quickSort();

		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void quickSort() {
		recQuickSort(0,a.length -1);
	}

	public static void recQuickSort(int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = a[right];

			int[] atmp = a;

			int position = pivotIt(atmp, left,right);

			recQuickSort(left, position - 1);
			recQuickSort(position + 1, right);

		}
	}

	public static int pivotIt(int[] a, int left, int right) {
		int pivot = a[right];

		while (left < right) {
			while (a[left] <= pivot && left < right) {
				left++;
			}

			a[right] = a[left];

			while (a[right] >= pivot && left < right) {
				right--;
			}

			a[left] = a[right];
		}

		a[right] = pivot;

		return right;

	}

	public int medianof3(int[] a, int left, int right) {
		int center = (left + right) /2;

		if (a[left] > a[center]) {
			swap(left, center);
		}

		if (a[left] > a[right]) {
			swap(left, right);
		}

		if (a[center] > a[right]) {
			swap(center, right);
		}

		swap(center, right -1);

		return a[right - 1];
	}

	public static void swap(int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
}

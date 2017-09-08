package com.imac;

/**
 * Created by ab054857 on 2017/8/18.
 * 有序数组二分查询
 */
public class OrderArray {

	private int[] array = null;

	public OrderArray(int size) {
		array = new int[size];
	}

	public void find(int key) {
		int begin = 0;
		int end = array.length - 1;
		int middle = array.length / 2;

		while (true) {
			middle = end - begin;
			if (array[middle] == key) {
				System.out.println("find key in :" + middle);
				return;
			} else if (begin >= end) {
				System.out.println("not find");
				return;
			} else {
				if (array[middle] > key) {
					end = middle - 1;
				} else if (array[middle] < key) {
					begin = middle;
				}
			}
		}
	}

	public void find1(int key) {
		int begin = 0;
		int end = array.length - 1;
		int middle  ;

		while (true) {
			middle = (begin + end) / 2;

			if (array[middle] == key) {
				System.out.println("find key in :" + middle);
				return;
			} else if (begin > end) {
				System.out.println("not find");
				return;
			} else {
				if (array[middle] > key) {
					end = middle - 1;
				} else if (array[middle] < key) {
					begin = middle + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		OrderArray orderArray = new OrderArray(4);

		orderArray.array[0] = 1;
		orderArray.array[1] = 3;
		orderArray.array[2] = 10;
		orderArray.array[3] = 11;
//		orderArray.array[4] = 16;

		orderArray.find1(11);

	}

}

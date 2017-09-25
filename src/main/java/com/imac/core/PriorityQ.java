package com.imac.core;

/**
 * 优先级队列
 * Created by ab054857 on 2017/9/25.
 */
public class PriorityQ {

	private int maxSize;

	private Long[] queArray;

	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new Long[maxSize];
		nItems = 0;
	}

	public void insert(Long item) {
		int j;

		if (nItems == 0) {
			queArray[nItems++] = item;
		} else {
			for (j = nItems - 1; j >=0 ; j--) {
				if (item > queArray[j]) {
					queArray[j+1] = queArray[j];
				} else {
					break;
				}
			}

			queArray[j + 1] = item;
			nItems++;
		}
	}

	public Long remove() {
		return queArray[--nItems];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

	public static void main(String[] args) {
		PriorityQ priorityQ = new PriorityQ(5);

		priorityQ.insert(10L);
		priorityQ.insert(40L);
		priorityQ.insert(30L);
		priorityQ.insert(50L);
		priorityQ.insert(20L);

		while (!priorityQ.isEmpty()) {
			Long item = priorityQ.remove();

			System.out.println("item:" + item);
		}
	}
}

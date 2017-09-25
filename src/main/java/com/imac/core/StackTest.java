package com.imac.core;

/**
 * Created by ab054857 on 2017/9/25.
 */
public class StackTest {

	private int maxSize;

	private int[] stackArray;

	private int top ;


	public StackTest(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int num) {
		stackArray[++top] = num;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public static void main(String[] args) {
		StackTest test = new StackTest(5);
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);

		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
	}
}

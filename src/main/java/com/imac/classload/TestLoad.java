package com.imac.classload;

public class TestLoad {

	static {
		System.out.println("init...........");
	}

	public TestLoad() {
		System.out.println("============");
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.imac.classload.TestLoad");
			Class.forName("com.imac.classload.TestLoad");

			TestLoad testLoad = new TestLoad();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

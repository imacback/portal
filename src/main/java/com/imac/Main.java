package com.imac;

import java.util.List;
import java.util.Random;

public class Main {

	static {
		i = 100;
	}

	public static int i = -1;
	public static final int A = new Random().nextInt();

    public static void main(String[] args) {

    	        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());

    	String str = "";

    	System.out.println(str.hashCode());

	// write your code here

//		for (int i=0;;) {
//			System.out.println(i++);
//		}
//
		Integer a = new Integer(100);
		Integer b = new Integer(100);

		System.out.println(a.equals(b));

//		System.out.println(a.getClass() == b.getClass());
//
//		Long c = 1L;
//
//		System.out.println(0 < c);

//		String[] array = new String[] {
//				"hello",
//				", ",
//				"world",
//		};
//		List<String> list = Arrays.asList(array);
//		list.forEach(System.out::println);
	}

//    public String test(List<String> list) {
//		return "";
//	}

	public Integer test(List<Integer> list, int discount) {
    	return 0;
	}

	public Integer test(List<Integer> list, int ... discounts) {
		return 0;
	}

	//1.8编译不了
//	public String test(List<Integer> list) {
//		return "";
//	}
//
//	public int test(List<String> list) {
//		return 0;
//	}


}

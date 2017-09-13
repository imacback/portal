package com.imac.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ab054857 on 2017/8/31.
 */
public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new LinkedList<String>();

		list1.add(1);
		list2.add("1");

		System.out.println(list1.equals(list2));

		assert list1.equals(list2) : "2个list不相等";

		System.out.println(new Integer(1).equals("1"));
	}
}

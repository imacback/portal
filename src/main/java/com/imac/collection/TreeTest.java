package com.imac.collection;

import java.util.TreeMap;

public class TreeTest {

	public static void main(String[] args) {
		TreeMap<Person, String> map = new TreeMap<>();

		for (int i = 0; i < 10 ; i++) {
			map.put(new Person(), "test");
		}

		System.out.print(map.size());

	}
	static class Person implements Comparable<Person>{
		private Long id;

		private String name;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return 0;
		}
	}
}

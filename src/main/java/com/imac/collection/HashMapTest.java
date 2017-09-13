package com.imac.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<Person, String>();

        // 1.8 put时，链表尾部  1.6链表头部
        for (int i=0; i<13; i++) {
        	Person person = new Person(new Long(i), String.valueOf(i));
            map.put(person, String.valueOf(i));
        }

    }

    private static class Person {
    	private Long id;

    	private String name;

    	private Person(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Person person = (Person) o;

			if (id != null ? !id.equals(person.id) : person.id != null) return false;
			return name != null ? name.equals(person.name) : person.name == null;
		}

		@Override
		public int hashCode() {
			return 1;
		}

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
	}
}

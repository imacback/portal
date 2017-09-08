package com.imac.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        for (int i=0; i<13; i++) {
            map.put(String.valueOf(i), "1");
        }

    }
}

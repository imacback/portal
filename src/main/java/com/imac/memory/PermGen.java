package com.imac.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量池溢出
 * -XX:PermSize=10m -XX:MaxPermSize=10m
 */
public class PermGen {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

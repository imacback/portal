package com.imac.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OomObject {

    }

    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();

        while (true) {
            list.add(new OomObject());
        }
    }
}

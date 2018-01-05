package com.imac.gc;

public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *           -Xms20M 最小堆内存20M
     *           -Xmx20M 最大堆内存20M
     *           -Xmn10M 新生代内存10M
     *           -XX:SurvivorRatio=8 新生代中 eden 和 survivor 比例为8:1
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; //出现一次 Minor GC
    }
}

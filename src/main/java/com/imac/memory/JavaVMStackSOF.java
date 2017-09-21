package com.imac.memory;

/**
 * stack 内存溢出
 * -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stacekLeak() {
        stackLength++;
        stacekLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stacekLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

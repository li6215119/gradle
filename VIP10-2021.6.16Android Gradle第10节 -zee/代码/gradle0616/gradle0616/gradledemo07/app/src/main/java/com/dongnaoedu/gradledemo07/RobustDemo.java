package com.dongnaoedu.gradledemo07;

// ASM Javassit 操作的是class文件
public class RobustDemo {

    interface A {
        int insertMethod();
    }

    private int test() {
        A a = null;
        if (a != null) {
            return a.insertMethod();
        }
        return 666;
    }

    public static void main(String[] args) {

    }

}

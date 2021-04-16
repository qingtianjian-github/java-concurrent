package com.shengsiyuan.concurrency3;

/**
 * 锁粗化
 */

public class MyTest5 {

    private Object object = new Object();

    public void method() {

        synchronized (object) {
            System.out.println("hello world");
        }

        synchronized (object) {
            System.out.println("welcome");
        }

        synchronized (object) {
            System.out.println("person");
        }
    }
}

package com.shengsiyuan.concurrency3;

public class MyTest4 {

    //private Object object = new Object();

    public void method() {
        Object object = new Object();

        synchronized (object) {
            System.out.println("hello world");
        }
    }
}

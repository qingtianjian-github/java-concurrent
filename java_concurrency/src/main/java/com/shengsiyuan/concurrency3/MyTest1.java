package com.shengsiyuan.concurrency3;

/**
 * @author cjw
 */
public class MyTest1 {

    private Object object = new Object();

    public void method() {
        synchronized (object) {
            System.out.println("hello world");
        }
    }

}

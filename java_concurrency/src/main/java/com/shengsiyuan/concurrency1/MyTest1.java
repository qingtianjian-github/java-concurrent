package com.shengsiyuan.concurrency1;

/**
 * @author cjw
 */
public class MyTest1 {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        //object.wait();

        synchronized (object){
            object.wait();
        }
    }
}

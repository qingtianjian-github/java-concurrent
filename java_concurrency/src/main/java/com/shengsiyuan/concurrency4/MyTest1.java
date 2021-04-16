package com.shengsiyuan.concurrency4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cjw
 */
public class MyTest1 {

    /**
     * 可重入锁
     */

    private Lock lock = new ReentrantLock();


    public void method1() {
        lock.lock();
        try {
            System.out.println("myMethod1 invoke");
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("myMethod2 invoke");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final MyTest1 myTest1 = new MyTest1();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    myTest1.method1();

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(r1, "线程1");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    myTest1.method2();

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(r2,"线程2");
        t1.start();
        t2.start();
    }
}

package com.shengsiyuan.concurrency3;

public class MyTest6 {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("myMethod1 invoked");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("myMethod2 invoked");
            }
        }
    }

    public static void main(String[] args) {
        final MyTest6 myTest6 = new MyTest6();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    myTest6.method1();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                myTest6.method2();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable1,"myThread1");
        Thread thread2 = new Thread(runnable2,"myThread2");
        thread1.start();
        thread2.start();
    }
}

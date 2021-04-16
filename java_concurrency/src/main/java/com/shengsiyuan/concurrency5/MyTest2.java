package com.shengsiyuan.concurrency5;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author cjw
 */
public class MyTest2 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("hello world");
        });

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (Math.random() * 2000));

                        int intRandomInt = new Random().nextInt(500);

                        System.out.println("hello：" + intRandomInt);

                        cyclicBarrier.await(20, TimeUnit.MICROSECONDS);

                        System.out.println("world：" + intRandomInt);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}

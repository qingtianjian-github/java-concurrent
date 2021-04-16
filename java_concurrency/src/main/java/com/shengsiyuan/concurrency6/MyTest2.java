package com.shengsiyuan.concurrency6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cjw
 */
public class MyTest2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.getAndSet(8));

        System.out.println(atomicInteger.getAndIncrement());

        System.out.println(atomicInteger.get());
    }
}

package com.shengsiyuan.concurrency9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author cjw
 */
public class MyTest5 {

    public static void main(String[] args) {
        Random random = new Random();

        IntStream.range(0, 10).forEach(i -> {
            System.out.println(random.nextInt(10));
        });


        System.out.println("============================");

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        IntStream.range(0, 10).forEach(i -> System.out.println(threadLocalRandom.nextInt(100)));


    }

}

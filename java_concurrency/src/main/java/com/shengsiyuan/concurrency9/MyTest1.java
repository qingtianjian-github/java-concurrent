package com.shengsiyuan.concurrency9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author cjw
 */
public class MyTest1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IntStream.range(0,10).forEach(i->{
            executorService.submit(() -> {
                IntStream.range(0, 50).forEach(j -> {
                    System.out.println(Thread.currentThread().getName());
                });
            });
        });

        executorService.shutdown();
    }
}

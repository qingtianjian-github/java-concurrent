package com.shengsiyuan.concurrency9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author cjw
 */
public class MyTest2 {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(3), new ThreadPoolExecutor.AbortPolicy());
        IntStream.range(0, 10).forEach(i -> executorService.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(0, 10).forEach(j -> System.out.println(Thread.currentThread().getName()));
        }));
        executorService.shutdownNow();
    }
}

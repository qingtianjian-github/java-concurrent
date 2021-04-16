package com.shengsiyuan.concurrency7;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author cjw
 */
public class MyTest2 {

    public static void main(String[] args) {
        //对结果进行转换
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApplyAsync(value -> value + " world").join();
        System.out.println(result);

        System.out.println("=========");

        //对结果进行消费
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(value -> System.out.println(value));

        System.out.println("=========");

        //对结果进行合并
        String result2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "world";
        }), (v1, v2) -> v1 + " " + v2).join();

        System.out.println(result2);

        System.out.println("==========");

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.MICROSECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("task finished");
        });

        completableFuture.whenComplete((t,action)-> System.out.println("执行完成！"));

        System.out.println("主线程执行完毕");

        try {
            TimeUnit.MICROSECONDS.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

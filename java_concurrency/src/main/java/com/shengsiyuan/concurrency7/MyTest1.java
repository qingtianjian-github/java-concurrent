package com.shengsiyuan.concurrency7;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author cjw
 */
public class MyTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> callable = () -> {

            System.out.println("pre execution");

            Thread.sleep(5000);

            int randomNumber = new Random().nextInt(500);

            System.out.println("post execution");

            return randomNumber;
        };


        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        System.out.println("Thread has started");

        Integer integer = (Integer) futureTask.get(1, TimeUnit.MICROSECONDS);
        System.out.println(integer);

        Thread.sleep(2000);
    }

}

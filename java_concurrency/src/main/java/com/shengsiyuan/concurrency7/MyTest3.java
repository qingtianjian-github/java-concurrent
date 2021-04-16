package com.shengsiyuan.concurrency7;


/**
 * @author cjw
 * <p>
 * ThreadLocal：
 */
public class MyTest3 {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("hello world");

        System.out.println(threadLocal.get());

        threadLocal.set("welcome");

        System.out.println(threadLocal.get());
    }

}

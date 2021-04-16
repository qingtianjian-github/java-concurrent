package com.shengsiyuan.concurrency1;

public class Client {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        Thread increaseThread1 = new IncreaseThread(myObject);
        Thread increaseThread2 = new IncreaseThread(myObject);
        Thread decreaseThread1 = new DecreaseThread(myObject);
        Thread decreaseThread2 = new DecreaseThread(myObject);

        increaseThread1.start();
        increaseThread2.start();
        decreaseThread1.start();
        decreaseThread2.start();
    }
}

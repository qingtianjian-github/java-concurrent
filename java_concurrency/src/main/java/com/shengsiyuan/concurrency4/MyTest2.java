package com.shengsiyuan.concurrency4;


import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author cjw
 */
public class MyTest2 {

    public static void main(String[] args) {
        BoundedContainer boundedContainer = new BoundedContainer();

        IntStream.range(0, 8).forEach(i -> new Thread(() -> {
            try {
                boundedContainer.put("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());

        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                boundedContainer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }
}

class BoundedContainer {

    private String[] elements = new String[10];

    private Lock lock = new ReentrantLock();

    private Condition notEmptyCondition = lock.newCondition();

    private Condition notFullCondition = lock.newCondition();

    /**
     * elementCount数组中已有的元素数量
     */
    private int elementCount;

    private int putIndex;

    private int takeIndex;

    public void put(String element) throws InterruptedException {
        this.lock.lock();

        try {
            while (this.elementCount == this.elements.length) {
                notFullCondition.await();
            }

            elements[putIndex] = element;

            if (++putIndex == this.elements.length) {
                putIndex = 0;
            }

            ++elementCount;

            System.out.println("put method：" + Arrays.toString(elements));

            notEmptyCondition.signal();
        } finally {
            this.lock.unlock();
        }
    }

    public String take() throws InterruptedException {
        this.lock.lock();

        try {
            while (0 == this.elementCount) {
                notEmptyCondition.await();
            }

            String element = elements[takeIndex];

            elements[takeIndex] = null;

            if (++takeIndex == this.elements.length) {
                takeIndex = 0;
            }

            --elementCount;

            System.out.println("take method：" + Arrays.toString(elements));

            notFullCondition.signal();

            return element;
        } finally {
            this.lock.unlock();
        }
    }
}

package com.shengsiyuan.concurrency6;


/**
 * CAS：变量操作的原子性
 */
public class MyTest1 {

    private int count;

    public int getCount() {
        return count;
    }

    /**
     * 读取->修改->写入：这三个操作不是真正的原子操作
     */

    public void increaseCount() {
        ++this.count;
    }
}

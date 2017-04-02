package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/29/17.
 */
public class VolatileTest {
    private volatile boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void m1() {
        System.out.println(Thread.currentThread().getName());
        while (flag) {
            //...
        }
        if (!flag) {
            System.out.println("线程停止...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.setFlag(true);
        Thread t1 = new Thread(() -> volatileTest.m1());
        Thread t2 = new Thread(() -> volatileTest.m1());
        t1.start();
        Thread.sleep(3000);
        volatileTest.setFlag(false);
        t2.start();
        System.out.println("flag: " + volatileTest.flag);
    }
}

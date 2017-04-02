package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/28/17.
 */
public class StringLock {
/*    public void m1() {
        synchronized (this) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "开始");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束");
            }
        }
    }*/

    public void m2() {
        synchronized ("StringLock") {
        //synchronized (new String("StringLock")) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束");

            }
        }
    }

    public static void main(String[] args) {
        StringLock stringLock = new StringLock();
        //Thread t1 = new Thread(() -> stringLock.m1(), "t1");
        //Thread t2 = new Thread(() -> stringLock.m1(), "t2");
        Thread t3 = new Thread(() -> stringLock.m2(), "t3");
        Thread t4 = new Thread(() -> stringLock.m2(), "t4");

        //t1.start();
        //t2.start();
        t3.start();
        t4.start();
    }
}

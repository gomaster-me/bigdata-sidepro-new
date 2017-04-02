package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/28/17.
 */
public class ChangeLock {
    private String lock = "lock";

    public void m1() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "开始");
            lock = "change-lock";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        final ChangeLock changeLock = new ChangeLock();
        Thread t1 = new Thread(() -> changeLock.m1(), "t1");
        Thread t2 = new Thread(() -> changeLock.m1(), "t2");
        Thread t3 = new Thread(() -> changeLock.m1(), "t3");
        Thread t4 = new Thread(() -> changeLock.m1(), "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

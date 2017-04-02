package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/28/17.
 */
public class ObjectLock {
    public void m1() {
        synchronized (this) {//当前对象锁
            System.out.println(Thread.currentThread().getName() + "=>m1()");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        synchronized (ObjectLock.class) {//类级别锁
            System.out.println(Thread.currentThread().getName() + "=>m2()");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object obj = new Object();//任意对象锁

    public void m3() {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + "=>m3()");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final ObjectLock objectLock = new ObjectLock();
        Thread t1 = new Thread(() -> objectLock.m1(), "t11");
        Thread t2 = new Thread(() -> objectLock.m2(), "t22");
        Thread t3 = new Thread(() -> objectLock.m3(), "t33");

        t1.start();
        t2.start();
        t3.start();
    }
}

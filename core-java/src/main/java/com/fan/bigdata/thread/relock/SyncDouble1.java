package com.fan.bigdata.thread.relock;

/**
 * Created by fqc on 3/28/17.
 */
public class SyncDouble1 {
    public synchronized void m1() {
        System.out.println("m1");
        m2();
    }

    public synchronized void m2() {
        System.out.println("m2");
        m3();
    }

    public synchronized void m3() {
        System.out.println("m3");
    }

    public static void main(String[] args) {
        SyncDouble1 syncDouble1 = new SyncDouble1();
        Thread t1 = new Thread(() -> syncDouble1.m1());
        Thread t2 = new Thread(() -> syncDouble1.m1());

        t1.start();
        t2.start();
    }
}

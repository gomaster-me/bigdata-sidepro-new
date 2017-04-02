package com.fan.bigdata.thread.async;

/**
 * Created by fqc on 3/27/17.
 */
public class MyObject {
    public synchronized void m1() {
        System.out.println("m1");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2() {
        System.out.println("m2");
    }
}

class Test {
    public static void main(String[] args) {
        MyObject myObj = new MyObject();
        Thread t1 = new Thread(() -> myObj.m1());
        Thread t2 = new Thread(() -> myObj.m2());
        t1.start();
        t2.start();

    }
}

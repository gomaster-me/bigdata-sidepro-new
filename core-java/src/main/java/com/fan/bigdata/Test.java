package com.fan.bigdata;

/**
 * Created by fqc on 4/1/17.
 */
public class Test {

    public synchronized void m1() {
        try {
            System.out.println("m1...start");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1....");
    }

    public  void m2() {
        System.out.println("m2....");
    }
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(() -> test.m1(), "t1");
        //test.m1();
       t1.start();
        test.m2();

    }
}

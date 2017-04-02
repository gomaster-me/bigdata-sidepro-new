package com.fan.bigdata.thread.threadsafe;

/**
 * Created by fqc on 3/26/17.
 */
public class MyThread extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
    //public void run() {
        count--;
        System.out.println(this.currentThread().getName() + "--count:" + count);
    }
}

class MyThreadTest {
    public static void main(String[] args) {
        //一个对象
        MyThread myThread = new MyThread();
        //多个线程
        Thread t1 = new Thread(myThread, "t1");
        Thread t2 = new Thread(myThread, "t2");
        Thread t3 = new Thread(myThread, "t3");
        Thread t4 = new Thread(myThread, "t4");
        Thread t5 = new Thread(myThread, "t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}

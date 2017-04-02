package com.fan.bigdata.thread.multiple;

/**
 * Created by fqc on 3/27/17.
 */
public class MultipleThread {

    private static int num = 0;

    public static synchronized void printNum(String tag) {
        try {
            if ("a".equals(tag)) {
                num = 100;
                System.out.println("tag a, set num over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over");
            }
            System.out.println("tag: " + tag + ",num:" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultipleThread m1 = new MultipleThread();
        MultipleThread m2 = new MultipleThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        Thread t3 = new Thread(() -> m1.printNum("a"));
        Thread t4 = new Thread(() -> m2.printNum("a"));

        t1.start();
        t2.start();

    }

}

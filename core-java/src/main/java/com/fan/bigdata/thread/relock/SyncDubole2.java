package com.fan.bigdata.thread.relock;

/**
 * Created by fqc on 3/28/17.
 */
public class SyncDubole2 {
    static class Parent {
        public int num = 10;

        public synchronized void subParent() throws InterruptedException {
            num--;
            System.out.println("parent: " + num);
            Thread.sleep(100);
        }
    }

    static class Sub extends Parent {
        public  synchronized void subSub() throws InterruptedException {
            while (num > 0) {
                num--;
                System.out.println("sub: " + num);
                this.subParent();
                Thread.sleep(100);
            }
        }
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        Thread t1 = new Thread(() -> {
            try {
                sub.subSub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                sub.subSub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}

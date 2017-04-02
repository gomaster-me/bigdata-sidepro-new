package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/28/17.
 */
public class DeadLock {

    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    public void m1() {
        if (flag) {
            while (true) {
                synchronized (LockObj.obj_a) {
                    System.out.println("当前线程: " + Thread.currentThread().getName() + "if.....");
                    synchronized (LockObj.obj_b) {
                        System.out.println("当前线程: " + Thread.currentThread().getName() + "if.....");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (LockObj.obj_b) {
                    System.out.println("当前线程: " + Thread.currentThread().getName() + "else.....");
                    synchronized (LockObj.obj_a) {
                        System.out.println("当前线程: " + Thread.currentThread().getName() + "else.....");
                    }
                }
            }
        }
    }

    static class LockObj {
        public static final Object obj_a = new Object();
        public static final Object obj_b = new Object();
    }

    public static void main(String[] args) {
        DeadLock obj1 = new DeadLock(false);
        DeadLock obj2 = new DeadLock(true);
        Thread t1 = new Thread(() -> obj1.m1(), "t1");
        Thread t2 = new Thread(() -> obj2.m1(), "t2");

        t1.start();
        t2.start();
    }
}

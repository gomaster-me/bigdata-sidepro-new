package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/28/17.
 */
public class ModifyLock {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void m1() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "开始");
            this.name = "kobe";
            this.age = 10;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public void changeAttribute(String name, int age) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "开始");
            this.setName(name);
            this.setAge(age);
            System.out.println("线程:" + Thread.currentThread().getName() + "，修改对象内容，name: " + name + ", age: " + age);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }

    }

    public static void main(String[] args) {
        ModifyLock modifyLock = new ModifyLock();
        Thread t1 = new Thread(() -> modifyLock.m1(), "t1");
        Thread t2 = new Thread(() -> modifyLock.m1(), "t2");
        Thread t3 = new Thread(() -> modifyLock.m1(), "t3");
        Thread t4 = new Thread(() -> modifyLock.m1(), "t4");

        Thread t5 = new Thread(() -> modifyLock.changeAttribute("kobe", 10), "t5");
        Thread t6 = new Thread(() -> modifyLock.changeAttribute("james", 5), "t6");
        Thread t7 = new Thread(() -> modifyLock.changeAttribute("jordan", 20), "t7");
        Thread t8 = new Thread(() -> modifyLock.changeAttribute("allen", 18), "t8");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}

package com.fan.bigdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 3/30/17.
 */
public class ThreadCommunication {
    private static volatile List list = new ArrayList();
    //private static List list = new ArrayList();

    public  void add() {
        list.add("hello");
    }

    //synchronized
    public  int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ThreadCommunication threadCommunication = new ThreadCommunication();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                threadCommunication.add();
                System.out.println(Thread.currentThread().getName() + " add hello");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            while (true) {
                //System.out.println(Thread.currentThread().getName()+", size:"+list.size());
                if (threadCommunication.size() == 5) {
                System.out.println(Thread.currentThread().getName() + ", size:" + threadCommunication.size());
                    System.out.println("收到通知，结束线程....");
                    throw new RuntimeException();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

package com.fan.bigdata.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fqc on 3/30/17.
 */
public class AtomicUse {
    private static AtomicInteger count = new AtomicInteger(0);

    public synchronized void multipleAdd() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);
        System.out.println(count);
    }

    public static void main(String[] args) {
        AtomicUse au = new AtomicUse();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadList.add(new Thread(() -> au.multipleAdd()));
        }
        threadList.forEach(thread -> thread.start());
        //threadList.forEach(Thread::start);
    }
}

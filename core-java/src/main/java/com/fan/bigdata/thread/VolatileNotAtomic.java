package com.fan.bigdata.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fqc on 3/30/17.
 */
public class VolatileNotAtomic implements Runnable {
    //private static volatile int count = 0;
    private static volatile AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        addCount();
    }

    private void addCount() {
        for (int i = 0; i < 1000; i++) {
            //count++;
            //count.getAndAdd(1);
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        VolatileNotAtomic[] volatileNotAtomics = new VolatileNotAtomic[20];
        for (VolatileNotAtomic volatileNotAtomic : volatileNotAtomics) {
            //new Thread(volatileNotAtomic).start();

            volatileNotAtomic = new VolatileNotAtomic();
            new Thread(volatileNotAtomic).start();
        }
    }
}

package com.fan.bigdata.thread.threadsafe;

/**
 * Created by fqc on 3/26/17.
 */
public class ThreadTestExtend extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadTest");
        }
    }
}

class Test {
    public static void main(String[] args) {
        ThreadTestExtend test = new ThreadTestExtend();
        test.start();
    }
}

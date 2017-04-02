package com.fan.bigdata.thread.threadsafe;

/**
 * Created by fqc on 3/26/17.
 */
public class ThreadTestImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadTestImpl");
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        new Thread(new ThreadTestImpl()).start();
    }
}


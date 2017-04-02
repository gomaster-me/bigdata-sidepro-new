package com.fan.bigdata.thread;

/**
 * Created by fqc on 3/30/17.
 */
public class VolatileTest001Thread implements Runnable {
    private volatile boolean isRunning = true;

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void run() {
        System.out.println("run方法开始");
        while (isRunning) {
            //...
        }
        System.out.println("线程结束");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest001Thread rt = new VolatileTest001Thread();
        Thread runThread = new Thread(rt);
        runThread.start();
        Thread.sleep(3000);
        rt.setRunning(false);
        System.out.println("isRunning has been set false");

        Thread.sleep(1000);
        System.out.println(rt.isRunning());
    }
}

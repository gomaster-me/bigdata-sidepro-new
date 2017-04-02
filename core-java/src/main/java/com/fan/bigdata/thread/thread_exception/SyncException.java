package com.fan.bigdata.thread.thread_exception;

/**
 * Created by fqc on 3/28/17.
 */
public class SyncException {
    public int i = 0;

    public synchronized void operate() {
        while (true) {
            try {
                i++;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " i=" + i);
                if (i == 10) {
                    Integer.parseInt("a");
                }
                if (i == 20) {
                    Integer.parseInt("b");
                }

            } catch (Exception ex) {
                //continue;
                ex.printStackTrace();
                System.err.println("log info error i=" + i);
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        SyncException syncException = new SyncException();
        Thread t1 = new Thread(() -> syncException.operate());
        Thread t2 = new Thread(() -> syncException.operate());

        t1.start();
        t2.start();
    }
}



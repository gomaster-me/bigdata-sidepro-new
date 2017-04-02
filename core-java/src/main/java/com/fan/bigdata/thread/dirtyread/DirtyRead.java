package com.fan.bigdata.thread.dirtyread;

/**
 * Created by fqc on 3/27/17.
 */
public class DirtyRead {
    private String username = "james";
    private String password = "000";

    public synchronized void setValue(String name, String pwd) {
        this.username = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.password = pwd;
    }

    public synchronized void getValue() {
        System.out.println("name: " + this.username + " pwd: " + this.password);
    }

    public static void main(String[] args) {
        DirtyRead dr = new DirtyRead();
        dr.getValue();
        Thread t1 = new Thread(() -> dr.setValue("kobe", "123"));
        t1.start();
        try {
            t1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dr.getValue();
    }
}

package com.fan.bigdata.base;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fqc on 4/2/17.
 */
public class StackTraceTest {
    public static void main(String[] args) {
        assert 1 > 0;
        //Logger.getGlobal().info("info");
        Logger.getGlobal().log(Level.ALL, "info1");

        ArrayList<String> list = new ArrayList();
        list.add("hello");
        //System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.toString());
        List<String> lst = new ArrayList();
        lst.add("world");
        System.out.println(lst);
    }

}

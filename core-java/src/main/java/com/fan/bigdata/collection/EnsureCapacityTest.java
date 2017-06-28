package com.fan.bigdata.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 4/10/17
 */
public class EnsureCapacityTest {
    public static void main(String[] args) {

        final Object obj = new Object();
        List<Object> list = new ArrayList<>();
        int N = 1000000;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(obj);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(list.size());

        startTime = System.currentTimeMillis();
        N = 1000000;
        List<Object> list2 = new ArrayList<>(N);
        //ArrayList<Object> list2 = new ArrayList<>();
        //list2.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list2.add(obj);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


    }
}

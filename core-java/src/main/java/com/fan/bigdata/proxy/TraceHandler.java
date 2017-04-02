package com.fan.bigdata.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by fqc on 3/22/17.
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(proxy + "." + method.getName() + "(" + args[i] + ")");
            }
        }
        return method.invoke(target, args);
    }
}

class Test {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            TraceHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        int key = new Random().nextInt(elements.length) + 1;
        System.out.println("the key is: " + key);
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) {
            System.out.println("result is: " + elements[result]);
        }
    }
}

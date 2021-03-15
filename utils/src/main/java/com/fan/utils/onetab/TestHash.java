package com.fan.utils.onetab;

/**
 * @author TonyFeng(itdamo)
 */
public class TestHash {
    public static void main(String[] args) {
        String a = "[ 618摆摊啦！全场满减，6410元红包白送！ - 知乎](https://zhuanlan.zhihu.com/p/146983279 )\n";
        String b = "[ 618摆摊啦！全场满减，6410元红包白送！ - 知乎](https://zhuanlan.zhihu.com/p/146983279 )\n";
        String c = "world";
        System.out.println("hash(a): " + a.hashCode());
        System.out.println("hash(b): " + b.hashCode());
        System.out.println("hash(c): " + c.hashCode());
    }
}

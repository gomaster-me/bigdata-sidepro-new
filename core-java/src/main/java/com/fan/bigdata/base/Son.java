package com.fan.bigdata.base;

/**
 * Created by fqc on 4/10/17.
 * 多态 动态链接
 */
public class Son extends P {

    public void testSon() {
        System.out.println("testSon");
    }

    //@Override
    //public void testP() {
    //    System.out.println("Son...testP()");
    //}

    public static void main(String[] args) {
        P p = new P();
        p.testP();

        Son son = new Son();
        son.testP();
        son.testSon();

        //son.getId();
        //son.setId();

        P p2 = new P();
        p2.testP();

        P p3 = new Son();
        p3.testP();//Son...定义一个父类类型的引用指向一个子类的对象既可以使用子类强大的功能，又可以抽取父类的共性。
        // 所以，父类类型的引用可以调用父类中定义的所有属性和方法，而对于子类中定义而父类中没有的方法，父类引用是无法调用的



    }
}

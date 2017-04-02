package com.fan.bigdata.inheritance;

/**
 * Created by fqc on 3/30/17.
 */
public class Parent {
    private int id;
    public int age;
}

class Son2 extends Parent{

}
class Son extends Parent {
    public Son() {
        this.age = 10;
        //this.id
        super.age = 20;
        //super.id
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.age = 20;
        //son.id;
    }
}

class Test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.age = 40;
        //parent.id

    }
}


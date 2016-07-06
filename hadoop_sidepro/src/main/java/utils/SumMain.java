package utils;

//泛型接口定义
interface ISum<T> {
    public abstract void sum(T... t);
}
 
//从泛型接口继承的具体类型类
class IntSum implements ISum<Integer> {
    public void sum(Integer... t) {
        int s = 0;
        for (int e : t) {
            s += e;
        }
        System.out.println(s);
    }
}
 
class DoubleSum implements ISum<Double> {
    public void sum(Double... t) {
        double s = 0.0;
        for (double e : t) {
            s += e;
        }
        System.out.println(s);
    }
}
 
//使用示例
public class SumMain {
 
    public static void main(String[] args) {
 
        IntSum intSum = new IntSum();
        intSum.sum(1, 2, 3, 4, 5);
        intSum.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 
        DoubleSum doubleSum = new DoubleSum();
        doubleSum.sum(1.0, 1.5, 2.0, 2.5, 3.0);
        doubleSum.sum(1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0);
 
    }
}
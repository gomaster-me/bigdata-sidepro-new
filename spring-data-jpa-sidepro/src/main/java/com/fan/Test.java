package com.fan;

/**
 * Created by fqc on 11/30/16.
 */
public class Test {

    public static void main(String[] args) {

        Complex complex = Complex.FromRealNumber(30.0);
        System.out.println(complex.getPoint());
    }
}

class Complex {
    private Double point;

    private Complex() {
    }

    private Complex(Double point) {
        this.point = point;
    }

    public static Complex FromRealNumber(Double point) {
        return new Complex(point);
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}


package com.fan.bigdata.generic;

/**
 * Created by fqc on 4/3/17.
 */
public class ArrayAlg {
    public static Pair<String> getMinMax(String[] arr) {
        if (arr == null || arr.length == 0) return null;

        String min = arr[0];
        String max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < min.length()) min = arr[i];
            if (arr[i].length() > max.length()) max = arr[i];
        }
        return new Pair(min, max);
    }

    public static void main(String[] args) {

        String[] strs = new String[]{"hello", "test", "a", "nba"};

        Pair<String> pairs = ArrayAlg.getMinMax(strs);
        System.out.println(pairs.getFirst());
        System.out.println(pairs.getSecond());

        System.out.println(ArrayAlg.getMinMax(strs));
    }
}

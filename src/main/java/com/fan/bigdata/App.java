package com.fan.bigdata;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        testToStringOfArrays();//注意先写方法声明后，idea自动创建，这种方式是几号的
        testStringTokenizer();//
    }

    private static void testStringTokenizer() {
        String line = "a b c d e\n" +
                "x y z";
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            System.out.println(word);
        }
    }

    private static void testToStringOfArrays() {
        int[] arrs = new int[10];
        System.out.println(arrs);
        System.out.println(Arrays.toString(arrs));
    }


}

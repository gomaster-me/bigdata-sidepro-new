package com.fan.hadoop.mytest;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.sun.tools.doclint.Entity;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import static com.sun.tools.doclint.Entity.sum;

/**
 * Created by fqc on 2016/7/6.
 */
public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    public static final  IntWritable total = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int  sum = 0;
        for (IntWritable value : values) {
            sum += Integer.parseInt(value.toString());
        }
        total.set(sum);
        context.write(key, total);
    }
}

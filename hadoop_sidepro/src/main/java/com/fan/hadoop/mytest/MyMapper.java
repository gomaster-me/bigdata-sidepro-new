package com.fan.hadoop.mytest;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by fqc on 2016/7/6.
 */
class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    public static final Text word = new Text();
    public static final IntWritable ONE = new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        StringTokenizer stringTokenizer = new StringTokenizer(line," ");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            word.set(token);
            context.write(word,ONE);
        }

    }
}

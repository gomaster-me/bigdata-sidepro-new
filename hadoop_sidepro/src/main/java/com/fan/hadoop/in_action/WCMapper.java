package com.fan.hadoop.in_action;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by fqc on 2016/6/22.
 */
public class WCMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final Text text = new Text();
    private static final IntWritable ONE = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);
        StringTokenizer stringTokenizer = new StringTokenizer(value.toString(), " ");
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            //context.write(new Text(word),new IntWritable(1));
            text.set(word);
            context.write(text, ONE);
        }

    }
}

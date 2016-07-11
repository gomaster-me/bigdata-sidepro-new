package com.fan.hadoop.in_action.flowcalc.combiner;

import com.sun.corba.se.spi.ior.Writeable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/9.
 */
public class WordCountCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        IntWritable val = new IntWritable();
        val.set(sum);
        context.write(key, val);
    }
}

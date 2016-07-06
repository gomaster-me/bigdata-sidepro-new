package com.fan.hadoop.mytest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/6.
 */
public class Driver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = null;

        job = Job.getInstance(new Configuration());

        job.setJarByClass(Driver.class);
        job.setMapperClass(MyMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(MyReducer.class);


        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

       /* FileInputFormat.setInputPaths(job, "c:/a.txt");
        FileOutputFormat.setOutputPath(job, new Path("c:/com.fan.hadoop.in_action.wordcount/output40"));*/
        FileInputFormat.setInputPaths(job, new Path(args[0]));//addInputPaths(job,string)，但两者都可以指定多个输入路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res ? 0 : 1);

    }
}

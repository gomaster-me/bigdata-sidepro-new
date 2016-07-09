package com.fan.hadoop.in_action.flowcalc;

import com.fan.hadoop.in_action.wordcount.WCDriver;
import com.fan.hadoop.in_action.wordcount.WCMapper;
import com.fan.hadoop.in_action.wordcount.WCReducer;
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
 * Created by fqc on 2016/7/8.
 */
public class FlowCalcDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {


        Job job = null;

        job = Job.getInstance(new Configuration());

        job.setJarByClass(FlowCalcDriver.class);
        job.setMapperClass(FlowCalcMapper.class);
        job.setReducerClass(FlowCalcReducer.class);

        /*job.setMapOutputKeyClass(Text.class); 这两段多余，//v2 纠正之前的错误(并不多余)，将mapper的输出设置 需要明确指定，前提是与reducer的输出不同的情况下。否则可以不设定
        job.setMapOutputValueClass(IntWritable.class);*/
        job.setOutputKeyClass(FlowBean.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, "c:/flow/");
        FileOutputFormat.setOutputPath(job, new Path("c:/flow/flowsum"));
       /* FileInputFormat.setInputPaths(job, new Path(args[0]));//addInputPaths(job,string)，但两者都可以指定多个输入路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
*/
        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res ? 0 : 1);
    }

}

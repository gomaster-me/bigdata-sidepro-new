package com.fan.hadoop.in_action.join.v2;

import com.fan.hadoop.in_action.join.JoinMapper;
import com.fan.hadoop.in_action.join.JoinReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utils.PropertiesUtils;

import java.io.IOException;

/**
 * Created by fqc on 7/11/16.
 */
public class OrderJoin {

    public static final String Info= "info.txt";
    public static final String Order = "order.txt";



    //按照文件来区分 并获取字段
    static class OrderMapper extends Mapper<LongWritable, Text, IntWritable, OrderInfo> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //通过上下文获取切割对象 并通过转换获取到文件信息
            FileSplit fileSplit = (FileSplit) context.getInputSplit();
            String fileName = fileSplit.getPath().getName();
            if (fileName == Info) {
                //
                String[] line = value.toString().split(",");
                String orderId = line[1];
                




            } else { //这里默认认为有俩文件,先简单处理 可以优化 // TODO: 7/11/16


            }





        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = null;

        job = Job.getInstance(new Configuration());

        job.setJarByClass(OrderJoin.class);

        job.setMapperClass(OrderMapper.class);
        job.setNumReduceTasks(0);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(OrderInfo.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(OrderInfo.class);


//        FileInputFormat.setInputPaths(job, new Path("c:/aaa/"));
//        FileOutputFormat.setOutputPath(job, new Path("c:/student/output08"));
        FileInputFormat.setInputPaths(job, new Path("/Users/fqc/input/"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/fqc/output/"));


//        FileInputFormat.setInputPaths(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));
//        job.setCombinerClass(IntSumReducer.class);

        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res ? 0 : 1);
    }
}

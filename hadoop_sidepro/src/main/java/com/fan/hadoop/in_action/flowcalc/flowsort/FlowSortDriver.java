package com.fan.hadoop.in_action.flowcalc.flowsort;

import com.fan.hadoop.in_action.flowcalc.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/9.
 */
public class FlowSortDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {


        Job job = null;

        job = Job.getInstance(new Configuration());

        job.setJarByClass(FlowSortDriver.class);
        job.setMapperClass(FlowSortMapper.class);
        job.setReducerClass(FlowSortReducer.class);

        /*job.setMapOutputKeyClass(Text.class); 这两段多余
        job.setMapOutputValueClass(IntWritable.class);*/


        //指定mapper输出数据的kv类型
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        Path outputPath = new Path("c:/flow/flowsort/output");
        FileSystem fs = FileSystem.get(new Configuration());
        if (fs.exists(outputPath)) {
            fs.delete(outputPath, true);
        }

        FileInputFormat.setInputPaths(job, "c:/flow/flowsort/");
        FileOutputFormat.setOutputPath(job, new Path("c:/flow/flowsort/output"));
       /* FileInputFormat.setInputPaths(job, new Path(args[0]));//addInputPaths(job,string)，但两者都可以指定多个输入路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
*/
        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res ? 0 : 1);
    }
}

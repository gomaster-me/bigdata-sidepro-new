package com.fan.hadoop.in_action.join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utils.PropertiesUtils;

import java.io.IOException;

/**
 * Created by fqc on 2016/6/23.
 */
public class JoinDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = null;

        job = Job.getInstance(new Configuration());

        job.setJarByClass(com.fan.hadoop.in_action.join.JoinDriver.class);

        job.setMapperClass(JoinMapper.class);
        job.setReducerClass(JoinReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);


//        FileInputFormat.setInputPaths(job, new Path("c:/aaa/"));
//        FileOutputFormat.setOutputPath(job, new Path("c:/student/output08"));
        FileInputFormat.setInputPaths(job, new Path(PropertiesUtils.readFilePaths()[0]));
        FileOutputFormat.setOutputPath(job, new Path(PropertiesUtils.readFilePaths()[1]));


//        FileInputFormat.setInputPaths(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));
//        job.setCombinerClass(IntSumReducer.class);

        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res ? 0 : 1);

    }
}

package com.fan.hadoop.in_action.flowcalc.calc_province;

import com.fan.hadoop.in_action.flowcalc.FlowBean;
import com.fan.hadoop.in_action.flowcalc.FlowCalcMapper;
import com.fan.hadoop.in_action.flowcalc.FlowCalcReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

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

        job.setPartitionerClass(ProvincePartition.class);
        job.setNumReduceTasks(5);

        /*job.setMapOutputKeyClass(Text.class); 这两段多余
        job.setMapOutputValueClass(IntWritable.class);*/
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job, "c:/flow/");
        FileOutputFormat.setOutputPath(job, new Path("c:/flow_province"));
       /* FileInputFormat.setInputPaths(job, new Path(args[0]));//addInputPaths(job,string)，但两者都可以指定多个输入路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
*/
        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res ? 0 : 1);
    }

}

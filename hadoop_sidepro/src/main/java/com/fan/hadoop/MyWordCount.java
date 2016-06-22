package com.fan.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by fqc on 2016/6/21.
 */

public class MyWordCount {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        /*//1. 检验函数
        *//*if (args.length != 2) {
            System.err.println("args useage : wordcount <in> <out>");
            System.exit(2);
        }*//*
        //2. 初始化配置
//        Configuration config = new Configuration();
//
//        //3. 初始化任务类
//        Job job = new Job(config, "mywordcount");


        Job job = Job.getInstance(new Configuration());


        //3. 设置Driver启动类
        job.setJarByClass(MyWordCount.class);
        //4. 设置mapper与reducer类
        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReducer.class);
        //5. 设置reducer输出key的类与value的类
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //6. 输入指定路径与输出路径


        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.setInputPaths(job,"c:/a.txt");
        FileOutputFormat.setOutputPath(job,new Path("c:/wordcount/output"));

//        FileInputFormat.addInputPath(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));


        //7. 提交任务
        //job.submit();
        //8. 测试
        System.exit(job.waitForCompletion(true) ? 0 : 1);
*/



        Job job = null;

        job = Job.getInstance(new Configuration());

        job.setJarByClass(MyWordCount.class);

        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job,"c:/a.txt");
        FileOutputFormat.setOutputPath(job,new Path("c:/wordcount/output29"));
        boolean res = job.waitForCompletion(true);
        //int a = 1/0; 为了测试exit 1
        System.exit(res?0:1);
    }

    public static class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        public static final IntWritable ONE = new IntWritable(1);
        private Text word = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);
            String line = value.toString();
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            while (stringTokenizer.hasMoreTokens()) {
                word.set(stringTokenizer.nextToken());
                //context.write(new Text(word), new IntWritable(1));
                context.write(word, ONE); //不能够每次循环都new，否则资源消耗很快
            }

        }
    }

    public static class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        private IntWritable result = new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//        super.reduce(key, values, context);
            int sum = 0;
            for (IntWritable value : values) {
                sum += value.get();
            }
//        context.write(key, new IntWritable(sum)); //这种情况，框架也是在循环的逐行调用，因此也不可行。
            result.set(sum);
            context.write(key, result);
        }
    }


}


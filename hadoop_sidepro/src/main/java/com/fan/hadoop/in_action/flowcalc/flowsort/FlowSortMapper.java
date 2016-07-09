package com.fan.hadoop.in_action.flowcalc.flowsort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/9.
 */
public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {

    FlowBean bean = new FlowBean();
    Text text = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split("\t");
        String phoneNo = fields[0];

        long upFlow = Long.parseLong(fields[1]);
        long downFlow = Long.parseLong(fields[2]);

        bean.setFlow(upFlow, downFlow);
        text.set(phoneNo);

        context.write(bean, text);

    }
}

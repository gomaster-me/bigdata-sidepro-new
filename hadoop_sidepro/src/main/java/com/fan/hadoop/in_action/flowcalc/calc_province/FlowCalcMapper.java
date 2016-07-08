package com.fan.hadoop.in_action.flowcalc.calc_province;

import com.fan.hadoop.in_action.flowcalc.FlowBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/8.
 */
public class FlowCalcMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    Text phoneNo = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //StringTokenizer stringTokenizer = new StringTokenizer(value.toString(), "\t");
        //stringtokenizer在这个场景下不适合，因为要获取字段需要通过下标索引的形式，不适合迭代器。
        String[] files = value.toString().split("\t");
        String phone = files[1];
        long upFlow = Long.parseLong(files[files.length - 3]);
        long downFlow = Long.parseLong(files[files.length - 2]);
        phoneNo.set(phone);
        context.write(phoneNo, new FlowBean(upFlow, downFlow));
    }
}

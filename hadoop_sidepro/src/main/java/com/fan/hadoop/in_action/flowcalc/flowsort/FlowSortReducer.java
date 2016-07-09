package com.fan.hadoop.in_action.flowcalc.flowsort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/9.
 */
public class FlowSortReducer extends Reducer<FlowBean,Text,Text,FlowBean> {
    Text text = new Text();

    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String phoneNO = values.iterator().next().toString();
        text.set(phoneNO);
        context.write(text,key);
    }
}

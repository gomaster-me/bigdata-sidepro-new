package com.fan.hadoop.in_action.flowcalc;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by fqc on 2016/7/8.
 */
public class FlowCalcReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        int sum_upFlow = 0;
        int sum_downFlow = 0;

        for (FlowBean bean : values) {
            sum_upFlow += bean.getUpFlow();
            sum_downFlow += bean.getDownFlow();
        }
        FlowBean flowBean = new FlowBean(sum_upFlow, sum_downFlow);
        context.write(key, flowBean);
    }
}

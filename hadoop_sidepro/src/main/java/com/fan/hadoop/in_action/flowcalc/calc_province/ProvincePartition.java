package com.fan.hadoop.in_action.flowcalc.calc_province;

import com.fan.hadoop.in_action.flowcalc.FlowBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

/**
 * Created by fqc on 2016/7/8.
 */
public class ProvincePartition extends Partitioner<Text, FlowBean> {

    //模拟数据库字典
    public static final HashMap<String, Integer> provinces = new HashMap<String, Integer>();

    static {
        provinces.put("136", 0);
        provinces.put("137", 1);
        provinces.put("138", 2);
        provinces.put("139", 3);
    }

    public int getPartition(Text text, FlowBean flowBean, int i) {
        // jdbcUtils.getProvinceByPhoneNo(text.toString().subString(0,7))
        String prefix = text.toString().substring(0, 3);
        Integer provinceId = provinces.get(prefix);
        return provinceId == null ? 4 : provinceId;
    }
}

package com.fan.hadoop.in_action.join;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by fqc on 2016/6/23.
 */
public class JoinReducer extends Reducer<Text, Text, Text, Text> {
    public static final String LEFT_FILENAME_FLAG = "L";
    public static final String RIGHT_FILENAME_FLAG = "R";

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
//        super.reduce(key, values, context);
        Iterator<Text> iterator = values.iterator();
        String studentName = "";
        //String studentClassName = "";
//        ArrayList list = new ArrayList();
        ArrayList studentClassNames = new ArrayList();
        while (iterator.hasNext()) {
            String fileName_flag = iterator.next().toString();
            String fileFlag = fileName_flag.split("\t")[1];
            String joinValue = fileName_flag.split("\t")[0];

            if (fileFlag.equals(LEFT_FILENAME_FLAG)) {
                studentName = joinValue;
            } else if (fileFlag.equals(RIGHT_FILENAME_FLAG)) {
                studentClassNames.add(joinValue);
            }
            //list.add(studentClassName);
        }

        for (int i = 0; i < studentClassNames.size(); i++) {

            context.write(new Text(studentName),new Text(studentClassNames.get(i).toString()));
            
        }

    }
}

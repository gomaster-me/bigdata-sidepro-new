package in_action;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by fqc on 2016/6/22.
 */
public class WCReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    public static final IntWritable result = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//        super.reduce(key, values, context);
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        //context.write(key,new IntWritable(sum));
        result.set(sum);
        context.write(key,result);

    }
}

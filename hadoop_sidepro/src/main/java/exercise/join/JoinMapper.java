package exercise.join;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * Created by fqc on 2016/6/23.
 */
public class JoinMapper extends Mapper<LongWritable, Text, Text, Text> {

    public static final String LEFT_FILENAME = "student_info.txt";
    public static final String RIGHT_FILENAME = "student_class_info.txt";
    public static final String LEFT_FILENAME_FLAG = "L";
    public static final String RIGHT_FILENAME_FLAG = "R";

    public static final Text text_key = new Text();
    public static final Text text_value = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);
        //判断键值对 来源文件 打标签
        String filePath = ((FileSplit) context.getInputSplit()).getPath().toString();//获得源数据文件
        String joinKey = "";
        String joinValue = "";
        String fileFlag = "";
        String[] words = value.toString().split("\t");

        if (filePath.contains(LEFT_FILENAME)) {
            fileFlag = LEFT_FILENAME_FLAG;
            joinKey = words[1];
            joinValue = words[0];
        } else if (filePath.contains(RIGHT_FILENAME)) {
            fileFlag = RIGHT_FILENAME_FLAG;
            joinKey = words[0];
            joinValue = words[1];
        }
        text_key.set(joinKey);
        text_value.set(joinValue + "\t" + fileFlag);
        //context.write(new Text(joinKey),new Text(joinValue+"\t"+fileFlag));
        context.write(text_key,text_value);
    }
}

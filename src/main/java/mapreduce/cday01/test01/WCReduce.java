package mapreduce.cday01.test01;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Create by GuoJF on 2019/5/20
 */
public class WCReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int total = 0;

        for (IntWritable value : values) {
            total += value.get();
        }

        context.write(key, new IntWritable(total));


    }
}

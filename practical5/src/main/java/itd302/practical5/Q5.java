package itd302.practical5;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.*;

public class Q5 extends Configured implements Tool {
    public static class MMap extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	    String line = value.toString();
	    String[] cols = line.split("\t");
	    int studentid = Integer.parseInt(cols[1]);
	    int moduleid  = Integer.parseInt(cols[2]);
	    context.write(new IntWritable(studentid), new IntWritable(moduleid));
	}
    }
    
    public static class MReduce extends Reducer<IntWritable, IntWritable, IntWritable,IntWritable> {
	public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
	    boolean found = false;
	    for (IntWritable val:values) {
		 int moduleid = val.get();
		 if (moduleid == 302) {
		     found = true;
		 }
	    }
	    if (found) {
		context.write(key, new IntWritable(1));
	    }
	    else {
		context.write(key, new IntWritable(0));
	    }
	}
    }

    public int run(String[] args) throws Exception {
	Configuration conf = getConf();
	Job job = new Job(conf, "Q5");
	job.setJarByClass(Q5.class);
	
	FileInputFormat.setInputPaths(job, new Path(args[0]));
	FileOutputFormat.setOutputPath(job, new Path(args[1]));

	job.setMapperClass(MMap.class);
	job.setReducerClass(MReduce.class);
	job.setCombinerClass(MReduce.class);
	job.setInputFormatClass(TextInputFormat.class);
	job.setOutputFormatClass(TextOutputFormat.class);
	job.setOutputKeyClass(IntWritable.class);
	job.setOutputValueClass(IntWritable.class);
	System.exit(job.waitForCompletion(true)?0:1);
	return 0;
    }
    public static void main(String[] args) throws Exception {
	int res = ToolRunner.run(new Configuration(), new Q5(), args);
	System.exit(res);
    }
}


/*
mvn package
hadoop dfs -rmr output
hadoop jar target/practical3-0.1.jar itd302.practical3.WordCount practical3/data/ output/ 

 */
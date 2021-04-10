import java.io.IOException;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Job j = new Job();
		j.setJobName("Count Frequency");
		j.setJarByClass(MDriver.class);
		j.setMapperClass(MyMapperM.class);
		j.setReducerClass(MyReducerM.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path(args[1]));

		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}

}

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author CharlesGao
 * Function: This is a class that store the size(number of words) of each tweet
 * and calculate the median of updated tweets
 */
public class TaskTwoHelperClass {

	private int sizeOfEachTweet;
	static double sum = 0;
	static String roundedMedian;
	static List<Integer> sizesOfEachTweet = new ArrayList<>();
	//This ArrayList is the final updateable median that will be output to the ft2.txt
	static List<String> finalUpdateableMedian = new ArrayList<>();

	public TaskTwoHelperClass(int sizeOfEachTweet) {
		this.sizeOfEachTweet = sizeOfEachTweet;
		sizesOfEachTweet.add(sizeOfEachTweet);
	}

	// Calculate the median of
	public static String calculateMedian() {
		for (int i = 0; i < sizesOfEachTweet.size(); i++) {
			sum = sum + sizesOfEachTweet.get(i);
		}
		// Only 2 digits after the decimal (From FAQ)
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		roundedMedian = df.format(sum / sizesOfEachTweet.size());
		// Make sure every time you reset the sum for next calculation
		sum = 0;
		finalUpdateableMedian.add(roundedMedian);
		System.out.println(roundedMedian);
		return roundedMedian;

	}
}
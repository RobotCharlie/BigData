import java.text.DecimalFormat;
import java.util.*;

/**
 * @author CharlesGao Function(Only For TASK 2): This is a Helper class that
 *         help TASK2 to store the size(number of words) of every single Tweet
 *         in order to calculate the median of updateable Tweets
 */
public class MedianCalculator {

	private int sizeOfEachTweet;
	private static double sum = 0;
	private static String roundedMedian;
	static List<Integer> sizesOfEachTweet = new ArrayList<>();
	/*
	 * This ArrayList is the final updateable median that will be output to the
	 * ft2.txt
	 */
	static List<String> finalUpdateableMedian = new ArrayList<>();

	public MedianCalculator(int sizeOfEachTweet) {
		this.sizeOfEachTweet = sizeOfEachTweet;
		sizesOfEachTweet.add(sizeOfEachTweet);
	}

	// Calculate the median
	public static String calculateMedian() {
		for (int i = 0; i < sizesOfEachTweet.size(); i++) {
			sum = sum + sizesOfEachTweet.get(i);
		}
		// Only 2 digits after the decimal
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		roundedMedian = df.format(sum / sizesOfEachTweet.size());
		// Make sure every time you reset the sum for next calculation
		sum = 0;
		finalUpdateableMedian.add(roundedMedian);
		// System.out.println(roundedMedian);
		return roundedMedian;

	}
}
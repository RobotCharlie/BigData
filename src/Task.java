import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task {

	public static void main(String args[]) {

		// Read input file
		File file = new File(
				"/Users/CharlesGao/Projects/cc-example/tweet_input/tweets.txt");

		/** THIS IS TASK 1 */

		// Use a TreeSet<String> which will automatically sort the words
		// in alphabetical order
		// Set<String> wordsInTweet = new TreeSet<>();
		// try {
		// Scanner tokenizeScanner = new Scanner(new FileReader(file));
		// tokenizeScanner.useDelimiter(" ");
		// while (tokenizeScanner.hasNext()) {
		// String singleWordInTweet = tokenizeScanner.next();
		// if (!singleWordInTweet.equals("")) {
		// // process only non-empty strings
		// // convert to lower-case and then add to the set
		// wordsInTweet.add(singleWordInTweet.toLowerCase());
		// }
		// }
		// // Now wordsInTweet are in alphabetical order without duplicates,
		// // print the wordsInTweet separating them in lines
		// for (String eachWord : wordsInTweet) {
		// System.out.print(eachWord + "\r\n");
		// }
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		/** THIS IS TASK 2 */

		List<String> Tweets = new ArrayList<>();
		try {
			// Divided .txt file into several Tweets, and store them into
			// ArrayList Tweets.
			Scanner singleTweetScanner = new Scanner(new FileReader(file));
			singleTweetScanner.useDelimiter("\\n");
			while (singleTweetScanner.hasNext()) {
				String singleTweet = singleTweetScanner.next();
				Tweets.add(singleTweet);
			}
			// Then divided each tweet into words, we use TreeSet to avoid
			// multi-store of same
			Set<String> wordsInSingleTweet = new TreeSet<>();
			// For each tweet
			for (String eachTweet : Tweets) {
				Scanner singleTweet = new Scanner(eachTweet);
				singleTweet.useDelimiter(" ");
				while (singleTweet.hasNext()) {
					wordsInSingleTweet.add(singleTweet.next());
				}
				// Pass and save the size of each tweet to a ArrayList in {@link
				// TaskTwoHelper}
				new TaskTwoHelper(wordsInSingleTweet.size());
				TaskTwoHelper.calculateMedian();
				wordsInSingleTweet.clear();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

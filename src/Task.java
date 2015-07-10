import java.io.*;
import java.util.*;

/**
 * @author CharlesGao Function: This is a class that including the main frame of
 *         TASK 1 & TASK 2.
 */

public class Task {

	public static void main(String args[]) {

		// Read input file
		if (args.length != 3) {
			System.err.println("pass the right number of the arguments");
			System.exit(-1);
		}
		String fileInput = args[0];
		String fileOutput1 = args[1];
		String fileOutput2 = args[2];

		// File file = new File("./tweet_input/tweets.txt");

		/**
		 * THIS IS TASK 1 : Calculate the total number of times each word has
		 * been tweeted.
		 */

		/*
		 * Use a TreeMap<String,Integer> which will automatically sort the
		 * words(String) as Keys in alphabetical order, and could save the
		 * number of occurrence of each word as Value
		 */
		TreeMap<String, Integer> wordsInTweet = new TreeMap<>();
		try {
			Scanner tokenizeScanner = new Scanner(new FileReader(fileInput));
			/*
			 * Both space and return are taken as a beginning of a new word,
			 * could add more constrain if needed
			 */
			tokenizeScanner.useDelimiter(" |\\n");
			while (tokenizeScanner.hasNext()) {
				String singleWordInTweet = tokenizeScanner.next();
				/*
				 * If and only if the Key(word) has already been stored in
				 * TreeMap, then value(times of occurrence of the word) replaced
				 * and increased by 1, or we put a new key-value and set the
				 * value to 1 by default
				 */
				if (wordsInTweet.keySet().contains(singleWordInTweet)) {
					wordsInTweet.replace(singleWordInTweet,
							wordsInTweet.get(singleWordInTweet) + 1);
				} else {
					wordsInTweet.put(singleWordInTweet, 1);
				}
			}
			/*
			 * Now wordsInTweet are in alphabetical order without duplicates, //
			 * separating them in lines and write the wordsInTweet in ft1.txt
			 */
			FileWriter writer = new FileWriter(fileOutput1);
			for (String eachWord : wordsInTweet.keySet()) {
				String format = "%-50s\t%d\n";
				String output = String.format(format, eachWord,
						wordsInTweet.get(eachWord));
				System.out.println(output);
				writer.write(output);
			}
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * THIS IS TASK 2 : Calculate the median number of unique words per
		 * tweet, and update this median as tweets come in.
		 */

		/*
		 * Divide all the Tweets that in the .txt file into several single
		 * Tweets, and store them into ArrayList
		 */
		List<String> Tweets = new ArrayList<>();
		try {
			Scanner singleTweetScanner = new Scanner(new FileReader(fileInput));
			// Because each Tweet beginning with a new line
			singleTweetScanner.useDelimiter("\\n");
			while (singleTweetScanner.hasNext()) {
				String singleTweet = singleTweetScanner.next();
				Tweets.add(singleTweet);
			}
			/*
			 * Then divide every single Tweet into words, we use TreeSet to
			 * avoid multi-store of same words
			 */
			Set<String> wordsInSingleTweet = new TreeSet<>();
			for (String eachTweet : Tweets) {
				Scanner singleTweet = new Scanner(eachTweet);
				singleTweet.useDelimiter(" ");
				while (singleTweet.hasNext()) {
					wordsInSingleTweet.add(singleTweet.next());
				}
				/*
				 * Pass and save the size of each Tweet to a ArrayList in {@link
				 * MedianCalculator}
				 */
				new MedianCalculator(wordsInSingleTweet.size());
				MedianCalculator.calculateMedian();
				wordsInSingleTweet.clear();
			}

			// Write the final updateable median into ft2.txt
			FileWriter writer = new FileWriter(fileOutput2);
			for (String str : MedianCalculator.finalUpdateableMedian) {
				writer.write(str + "\t\n");
				System.out.println(str);
			}
			writer.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

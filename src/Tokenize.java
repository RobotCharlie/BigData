import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Tokenize {

	public static void main(String args[]) {

		List<Integer> numOfWordsInEachTweet = new ArrayList<>();
		
		// Read input file
		File file = new File(
				"/Users/CharlesGao/Projects/cc-example/tweet_input/tweets.txt");
		// Use a TreeSet<String> which will automatically sort the words
		// in alphabetical order
//		Set<String> wordsInTweet = new TreeSet<>();
//		try {
//			Scanner tokenizeScanner = new Scanner(new FileReader(file));
//			tokenizeScanner.useDelimiter(" ");
//			while (tokenizeScanner.hasNext()) {
//				String singleWordInTweet = tokenizeScanner.next();
//				if (!singleWordInTweet.equals("")) {
//					// process only non-empty strings
//					// convert to lowercase and then add to the set
//					wordsInTweet.add(singleWordInTweet.toLowerCase());
//				}
//			}
//			// Now wordsInTweet are in alphabetical order without duplicates,
//			// print the wordsInTweet separating them in lines
//			for (String eachWord : wordsInTweet) {
//				System.out.print(eachWord + "\r\n");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		List<String> Tweets = new ArrayList<>();
		try {
			Scanner singleTweetScanner = new Scanner(new FileReader(file));
			singleTweetScanner.useDelimiter("\\n");
			while (singleTweetScanner.hasNext()) {
				String singleTweet = singleTweetScanner.next();
				Tweets.add(singleTweet);
			}
			Set<String> wordsInSingleTweet = new TreeSet<>();
			for (String eachTweet : Tweets) {
				Scanner singleTweet = new Scanner(eachTweet);
				singleTweet.useDelimiter(" ");
				while (singleTweet.hasNext()){
					wordsInSingleTweet.add(singleTweet.next());
				}
				wordsInSingleTweet.size();
				System.out.println(wordsInSingleTweet.size());
				wordsInSingleTweet.clear();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

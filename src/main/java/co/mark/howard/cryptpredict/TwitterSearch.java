package co.mark.howard.cryptpredict;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterSearch {

	private Twitter twitter;
	private boolean isConfigured = false;
	
	public void configure () {
		if(isConfigured)
			return;
		
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setOAuthConsumerKey("");
		configurationBuilder.setOAuthConsumerSecret("");
		configurationBuilder.setOAuthAccessToken("");
		configurationBuilder.setOAuthAccessTokenSecret("");
		TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
		twitter = twitterFactory.getInstance();
	}

	public List<String> search(final Crypto crypto) {
		configure();
		List<String> tweets = new ArrayList<> ();
		try {
			Query query = new Query(String.format("%s -btc", crypto.getSymbol()));
			query.count(100);
			query.lang("en");
			query.setResultType(Query.RECENT);
			QueryResult result = twitter.search(query);
			for(Status tweet: result.getTweets()) {
				if(tweet.getHashtagEntities().length > 3)
					continue;
				tweets.add(tweet.getText());
			}
				
		} catch (TwitterException exception) {
			exception.printStackTrace();
		}
		return tweets;
	}

}

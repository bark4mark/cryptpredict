package co.mark.howard.cryptpredict;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwitterSearchTest {
	private TwitterSearch twitterSearch;
	
	@Before
	public void setUp () {
		twitterSearch = new TwitterSearch ();
	}
	
	@Test
	public void shouldSearchTwitter() {
		Crypto crypto = new Crypto ("XRP");
		Assert.assertFalse(twitterSearch.search(crypto).isEmpty());
	}
	
}

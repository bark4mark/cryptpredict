package co.mark.howard.cryptpredict.analyzer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AnalyzerTest {
	private static Analyzer<Integer> sentimentAnalyzer;
	
	@BeforeClass
	public static void setUp () {
		sentimentAnalyzer = new SentimentAnalyzer ();
		sentimentAnalyzer.init();
	}
	
	@Test
	public void shouldReturnNegativeScore () {
		Assert.assertTrue(sentimentAnalyzer.analyze ("Oh no this is a very negative bad thing") < 0);
	}
	
	@Test
	public void shouldReturnPositiveScore () {
		Assert.assertTrue(sentimentAnalyzer.analyze ("Yes this is very positive, I am so happy") > 0);
	}
}

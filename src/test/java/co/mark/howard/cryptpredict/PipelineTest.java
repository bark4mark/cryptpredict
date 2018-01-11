package co.mark.howard.cryptpredict;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.mark.howard.cryptpredict.pipeline.Pipe;
import co.mark.howard.cryptpredict.pipeline.Pipeline;
import co.mark.howard.cryptpredict.pipeline.pipes.RemoveAtReplies;
import co.mark.howard.cryptpredict.pipeline.pipes.RemoveDollarTags;
import co.mark.howard.cryptpredict.pipeline.pipes.RemoveHashTags;
import co.mark.howard.cryptpredict.pipeline.pipes.RemoveStopWords;

public class PipelineTest {
	
	private Pipeline<String> pipeline;
	private Pipe<String> removeDollarTags = new RemoveDollarTags (2);
	private Pipe<String> removeHashTags = new RemoveHashTags (3);
	private Pipe<String> removeAtReplies = new RemoveAtReplies (4);
	private Pipe<String> removeStopWords = new RemoveStopWords (1);
	
	@Before
	public void setUp () {
		pipeline = new Pipeline<>();
		pipeline.add (removeDollarTags).add (removeHashTags).add (removeStopWords).add (removeAtReplies);
	}

	@Test
	public void shouldRemoveHashAndDollarTags() {
		String result = pipeline.process(EXAMPLE);
		System.out.println (result);
		Assert.assertFalse(result.contains("#ripple"));
		Assert.assertFalse(result.contains("$XVG"));
		Assert.assertFalse (result.contains ("for"));
		Assert.assertFalse (result.contains ("@cryptnotik"));
	}

	private final static String EXAMPLE = "Giveaway time. You guys wanted for more & here it is I will be giving away 1000 #ripple this week. Already given away 5000. Just follow @cryptnotik & RT. Winner at 0.5k. $BTC $ETH $LTC $XRP $XVG $TRX $RDD $POE $IOTA $ADA";
}

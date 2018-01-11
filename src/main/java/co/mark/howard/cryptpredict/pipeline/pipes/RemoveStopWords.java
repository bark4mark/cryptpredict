package co.mark.howard.cryptpredict.pipeline.pipes;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.google.common.io.Resources;

import co.mark.howard.cryptpredict.CryptPredict;
import co.mark.howard.cryptpredict.pipeline.Pipe;


public class RemoveStopWords
		extends
		DefaultPipe
		implements
		Pipe<String> {

	private final Set<String> stopWords = Sets.newHashSet ();

	public RemoveStopWords (final int order) {
		super (order);

		try {
			for (String stopWord : Resources.readLines (Resources.getResource ("stopWords.txt"), Charset.forName (CryptPredict.CHARSET)))
				stopWords.add (stopWord);
		}
		catch (IOException exception) {

		}
	}

	@Override
	public String process (final String input) {
		if (Strings.isNullOrEmpty (input))
			return "";

		StringBuilder text = new StringBuilder ();
		Iterator<String> words = Splitter.on (CharMatcher.breakingWhitespace ()).split (input).iterator ();
		while (words.hasNext ()) {
			String wordInstance = words.next ();
			if (!stopWords.contains (wordInstance)) {
				text.append (wordInstance);
				if (words.hasNext ())
					text.append (" ");
			}

		}
		return text.toString ();
	}
}

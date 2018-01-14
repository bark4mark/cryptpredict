package co.mark.howard.cryptpredict.analyzer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.google.common.primitives.Ints;

import co.mark.howard.cryptpredict.CryptPredict;

public class SentimentAnalyzer implements Analyzer<Integer> {
	
	Map<String, Integer> wordScores = Maps.newHashMap();

	@Override
	public void init() {
		try {
			List<String> lines = Resources.readLines(Resources.getResource("AFINN-111.txt"), Charset.forName(CryptPredict.CHARSET));
			for (String line: lines) {
				Iterator<String> wordAndScore = Splitter.on(CharMatcher.whitespace()).split(line).iterator();
				String word = wordAndScore.next();
				Integer score = Ints.tryParse(wordAndScore.next());
				wordScores.put(word, score);
			}
		} catch (IOException exception) {
		}
	}

	@Override
	public Integer analyze(final String input) {
		int total = 0;
		if (Strings.isNullOrEmpty(input))
			return 0;
		
		String lower = input.toLowerCase();
		Iterator<String> words = Splitter.on(CharMatcher.whitespace()).split(lower).iterator();
		while(words.hasNext()) {
			String word = words.next();
			Integer score = wordScores.get(word);
			if(score != null) 
				total = total + score;
		}
		return total;
	}
	
}

package co.mark.howard.cryptpredict.pipeline.pipes;

import com.google.common.base.Strings;

import co.mark.howard.cryptpredict.pipeline.Pipe;

public class RemoveDollarTags
		extends
		DefaultPipe
		implements
		Pipe<String> {

	public RemoveDollarTags (final int order) {
		super (order);
	}

	@Override
	public String process (final String input) {
		if (Strings.isNullOrEmpty (input))
			return "";
		return input.replaceAll ("(\\s|\\A)\\$(\\w+)", "");
	}

}

package co.mark.howard.cryptpredict.pipeline.pipes;

import com.google.common.base.Strings;

import co.mark.howard.cryptpredict.pipeline.Pipe;

public class RemoveHashTags implements Pipe<String> {
	private final int order;

	public RemoveHashTags(final int order) {
		this.order = order;
	}

	@Override
	public String process(final String input) {
		if(Strings.isNullOrEmpty(input))
			return "";
		return input.replaceAll("(\\s|\\A)#(\\w+)", "");
	}

	@Override
	public int compareTo(Pipe<String> other) {
		return (this.getOrder() > other.getOrder() ? -1 : (this.getOrder() == other.getOrder() ? 0 : 1));
	}

	@Override
	public int getOrder() {
		return this.order;
	}

}

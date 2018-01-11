package co.mark.howard.cryptpredict.pipeline.pipes;

import co.mark.howard.cryptpredict.pipeline.Pipe;

public class DefaultPipe {

	protected int order;

	public DefaultPipe (final int order) {
		this.order = order;
	}

	public int compareTo (@SuppressWarnings("rawtypes") Pipe other) {
		return (this.getOrder () > other.getOrder () ? -1 : (this.getOrder () == other.getOrder () ? 0 : 1));
	}

	public int getOrder () {
		return this.order;
	}
}

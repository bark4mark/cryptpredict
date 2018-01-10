package co.mark.howard.cryptpredict.pipeline;

public interface Pipe<InputOutput> extends Comparable<Pipe<InputOutput>> {
	/**
	 * Processes an input and returns a result
	 * 
	 * @param input
	 * @return
	 */
	InputOutput process(final InputOutput input);
	
	/**
	 * Returns the order this pipe should be executed
	 * @return The order
	 */
	int getOrder();
}

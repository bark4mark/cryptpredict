package co.mark.howard.cryptpredict.analyzer;

public interface Analyzer<ReturnType> {

	/**
	 * Initializes this class, so that any models can be created before use
	 */
	void init();

	/**
	 * Returns the result of the analysis
	 * @param string What to analyze
	 * @return The result
	 */
	ReturnType analyze(String string);

}

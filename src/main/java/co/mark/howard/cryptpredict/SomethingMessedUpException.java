package co.mark.howard.cryptpredict;

public class SomethingMessedUpException extends Exception {
	public SomethingMessedUpException(final Exception exception) {
		super(exception);
	}

	public SomethingMessedUpException(final String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}

package co.mark.howard.cryptpredict.errors;

public class CryptPredictException extends Exception {
	public CryptPredictException(final Exception exception) {
		super(exception);
	}

	public CryptPredictException(final String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}

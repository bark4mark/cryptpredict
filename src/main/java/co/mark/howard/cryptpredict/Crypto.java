package co.mark.howard.cryptpredict;

import lombok.Data;

@Data
public class Crypto {
	private final String symbol;
	
	public Crypto(final String symbol) {
		this.symbol = symbol;
	}
}

package co.mark.howard.cryptpredict;

import co.mark.howard.cryptpredict.errors.CryptPredictException;

public class CryptPredict {

	public static void main(String[] args) throws Exception {
		CryptPredict cryptPredict = new CryptPredict ();
		cryptPredict.start();
	}

	private void start() throws CryptPredictException {
		CryptoList cryptoList = new CryptoList();
		cryptoList.init();
		
		
	}

	public static final String CHARSET = "UTF-8";
}

package co.mark.howard.cryptpredict;

public class CryptPredict {

	public static void main(String[] args) throws Exception {
		CryptPredict cryptPredict = new CryptPredict ();
		cryptPredict.start();
	}

	private void start() throws SomethingMessedUpException {
		CryptoList cryptoList = new CryptoList();
		cryptoList.init();
		
		
	}

}

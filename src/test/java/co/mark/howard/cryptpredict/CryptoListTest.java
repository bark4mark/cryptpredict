package co.mark.howard.cryptpredict;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import co.mark.howard.cryptpredict.errors.CryptPredictException;

public class CryptoListTest {
	private static CryptoList cryptoList;
	
	@BeforeClass
	public static void setUp () throws CryptPredictException {
		cryptoList = new CryptoList();
		cryptoList.init();
	}
	
	@Test
	public void shouldGetListOfCryptos () throws CryptPredictException {
		Assert.assertFalse(cryptoList.get().isEmpty());
	}
	
	@Test(expected=CryptPredictException.class)
	public void shouldThrowExceptionWhenInitIsNotCalled () throws CryptPredictException {
		CryptoList newList = new CryptoList();
		newList.get();
	}
}

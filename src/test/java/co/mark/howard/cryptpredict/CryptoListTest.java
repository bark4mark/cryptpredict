package co.mark.howard.cryptpredict;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CryptoListTest {
	private static CryptoList cryptoList;
	
	@BeforeClass
	public static void setUp () throws SomethingMessedUpException {
		cryptoList = new CryptoList();
		cryptoList.init();
	}
	
	@Test
	public void shouldGetListOfCryptos () throws SomethingMessedUpException {
		Assert.assertFalse(cryptoList.get().isEmpty());
	}
	
	@Test(expected=SomethingMessedUpException.class)
	public void shouldThrowExceptionWhenInitIsNotCalled () throws SomethingMessedUpException {
		CryptoList newList = new CryptoList();
		newList.get();
	}
}

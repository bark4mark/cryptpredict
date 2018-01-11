package co.mark.howard.cryptpredict;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.mark.howard.cryptpredict.errors.CryptPredictException;

public class CryptoList {
	private List<Crypto> cryptos = new ArrayList<> ();
	private static ObjectMapper mapper;
	private boolean init = false;

	public void init() throws CryptPredictException {
		init = true;
		
		if(mapper == null) {
			mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		
		try {
			TypeReference<List<Crypto>> typeReference = new TypeReference<List<Crypto>>(){};
			URL url = new URL("https://api.coinmarketcap.com/v1/ticker/?convert=EUR");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			if(responseCode != 200)
				throw new CryptPredictException("Cannot connect to API to download currencies");
			List<Crypto> response = mapper.readValue(connection.getInputStream(), typeReference);
			for(Crypto crypto: response)
				cryptos.add(crypto);
		} catch (IOException exception) {
			throw new CryptPredictException(exception);
		}
	}
	
	public List<Crypto> get () throws CryptPredictException {
		if(!init)
			throw new CryptPredictException("Run init first! Please");
		return cryptos;
	}
}

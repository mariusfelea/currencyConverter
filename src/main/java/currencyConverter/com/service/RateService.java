package currencyConverter.com.service;

import java.math.BigDecimal;
import java.util.Set;

import currencyConverter.com.model.RateConverter;

public interface RateService {

	String getRates(String baseCurrency);
	
	String getRates();
	
	RateConverter convertJsonToObject(String json);
	
	Double getRateBetweenCurrencies(String fromCurrency, String toCurrency);
	
	BigDecimal multiplyAmountByRate(BigDecimal amount, Double rate);
	
	Set<String> getCurrencies();
}

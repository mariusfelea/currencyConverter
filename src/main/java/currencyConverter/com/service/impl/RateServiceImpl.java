package currencyConverter.com.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currencyConverter.com.model.RateConverter;
import currencyConverter.com.service.RateService;
import currencyConverter.com.util.UrlUtil;

@Service
public class RateServiceImpl implements RateService {

	private static final String RATES_URL = "http://api.fixer.io/latest?base=";
	private static final String DEFAULT_BASE_CURRENCY = "EUR";

	@Override
	public String getRates(String baseCurrency) {
		return UrlUtil.doGet(RATES_URL + (baseCurrency == null ? DEFAULT_BASE_CURRENCY : baseCurrency));
	}
	
	@Override
	public String getRates() {
		return getRates(null);
	}
	
	public RateConverter convertJsonToObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, RateConverter.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Double getRateBetweenCurrencies(String fromCurrency, String toCurrency) {
		RateServiceImpl rateServiceImpl = new RateServiceImpl();
		String rates = rateServiceImpl.getRates(fromCurrency);
		RateConverter rateConverter = rateServiceImpl.convertJsonToObject(rates);
		Double rate = rateConverter.getRates().get(toCurrency);
		return rate;
	}

	@Override
	public BigDecimal multiplyAmountByRate(BigDecimal amount, Double rate) {
		return amount.multiply(new BigDecimal(rate)).setScale(3, RoundingMode.HALF_UP);
	}

	@Override
	public Set<String> getCurrencies() {
		RateServiceImpl rateServiceImpl = new RateServiceImpl();
		String rates = rateServiceImpl.getRates();
		RateConverter rateConverter = rateServiceImpl.convertJsonToObject(rates);
		return rateConverter.getRates().keySet();
	}
}

package currencyConverter.com.service;

import java.util.List;
import java.util.Set;

import currencyConverter.com.model.RateConverter;

public interface RateConverterService {

	void save(RateConverter rateConverter);
	
	Set<String> getCurrencies();

	List<RateConverter> getRatesConverter(RateConverter rateConverter);
	
}

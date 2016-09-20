package currencyConverter.com.service;

import java.util.List;

import currencyConverter.com.model.RateConverter;

public interface RateConverterService {
	
	void save(RateConverter rateConverter);
	
	List<RateConverter> getRatesConverter();
}

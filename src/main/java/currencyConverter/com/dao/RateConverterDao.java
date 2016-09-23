package currencyConverter.com.dao;

import java.util.List;

import currencyConverter.com.model.RateConverter;

public interface RateConverterDao {

	void save(RateConverter rateConverter);

	List<RateConverter> getRatesConverter(RateConverter rateConverter);
	
}

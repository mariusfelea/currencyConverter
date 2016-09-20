package currencyConverter.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currencyConverter.com.dao.RateConverterDao;
import currencyConverter.com.model.RateConverter;
import currencyConverter.com.service.RateConverterService;

@Service
public class RateConverterServiceImpl implements RateConverterService {

	@Autowired
	private RateConverterDao rateConverterDao;
	
	@Override
	public void save(RateConverter rateConverter) {
		rateConverterDao.save(rateConverter);
	}

	@Override
	public List<RateConverter> getRatesConverter() {
		return rateConverterDao.getRatesConverter();
	}
}

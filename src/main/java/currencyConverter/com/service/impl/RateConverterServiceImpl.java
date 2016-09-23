package currencyConverter.com.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currencyConverter.com.dao.RateConverterDao;
import currencyConverter.com.model.RateConverter;
import currencyConverter.com.service.RateConverterService;
import currencyConverter.com.service.UserService;
import currencyConverter.com.util.JsonUtil;
import currencyConverter.com.util.UrlUtil;

@Service
public class RateConverterServiceImpl implements RateConverterService {

	private static final String RATES_URL = "http://api.fixer.io/latest?base=";
	private static final String DEFAULT_BASE_CURRENCY = "EUR";

	@Autowired
	private RateConverterDao rateConverterDao;

	@Autowired
	private UserService userService;
	
	@Override
	public void save(RateConverter rateConverter) {
		rateConverter.setUserMail(userService.getMail());
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringFormatdate = formatter.format(date);
		rateConverter.setDate(stringFormatdate);
		rateConverter.setConvertedAmount(getConvertedAmount(rateConverter));
		rateConverterDao.save(rateConverter);
	}
	
	@Override
	public Set<String> getCurrencies() {
		RateConverter rateConverter = JsonUtil.convertJsonToObject(getRates());
		return rateConverter.getRates().keySet();
	}

	@Override
	public List<RateConverter> getRatesConverter(RateConverter rateConverter) {
		rateConverter.setUserMail(userService.getMail());
		return rateConverterDao.getRatesConverter(rateConverter);
	}

	
	private BigDecimal getConvertedAmount(RateConverter rateConverter) {
		return multiplyAmountByRate(rateConverter.getAmount(),
				getRateBetweenCurrencies(rateConverter.getFromCurrency(), rateConverter.getToCurrency()));
	}
	
	private BigDecimal multiplyAmountByRate(BigDecimal amount, Double rate) {
		return amount.multiply(new BigDecimal(rate)).setScale(3, RoundingMode.HALF_UP);
	} 
	
	private Double getRateBetweenCurrencies(String fromCurrency, String toCurrency) {
		RateConverter rateConverter = JsonUtil.convertJsonToObject(getRates(fromCurrency));
		return rateConverter.getRates().get(toCurrency);
	}
	
	private String getRates(String baseCurrency) {
		return UrlUtil.doGet(RATES_URL + (baseCurrency == null ? DEFAULT_BASE_CURRENCY : baseCurrency));
	}

	private String getRates() {
		return getRates(null);
	}

}

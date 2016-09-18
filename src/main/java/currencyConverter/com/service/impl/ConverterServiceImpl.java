package currencyConverter.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currencyConverter.com.dao.ConverterDao;
import currencyConverter.com.model.Registration;
import currencyConverter.com.service.ConverterService;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	private ConverterDao converterDao;
	
	public List<Registration> getRegistrations() {
		List<Registration> registration = converterDao.getRegistrations();
		return registration;
	}
}

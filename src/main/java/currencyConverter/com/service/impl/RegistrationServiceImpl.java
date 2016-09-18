package currencyConverter.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currencyConverter.com.dao.RegistrationDao;
import currencyConverter.com.model.Registration;
import currencyConverter.com.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	public void save(Registration registration) {
		registrationDao.save(registration);
	}
}

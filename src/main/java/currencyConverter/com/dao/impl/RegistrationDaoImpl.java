package currencyConverter.com.dao.impl;

import org.springframework.stereotype.Repository;

import currencyConverter.com.dao.RegistrationDao;
import currencyConverter.com.model.Registration;
import currencyConverter.com.util.CustomHibernateDaoSupport;

@Repository
public class RegistrationDaoImpl extends CustomHibernateDaoSupport implements RegistrationDao {

	public void save(Registration registration) {
		getHibernateTemplate().save(registration);
	}
}

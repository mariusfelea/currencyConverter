package currencyConverter.com.dao.impl;

import org.springframework.stereotype.Service;

import currencyConverter.com.dao.UserRoleDao;
import currencyConverter.com.model.UserRole;
import currencyConverter.com.util.CustomHibernateDaoSupport;

@Service
public class UserRoleDaoImpl extends CustomHibernateDaoSupport implements UserRoleDao {

	@Override
	public void saveUserRoles(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}
	
}

package currencyConverter.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import currencyConverter.com.dao.UserDao;
import currencyConverter.com.dao.UserRoleDao;
import currencyConverter.com.model.User;
import currencyConverter.com.model.UserRole;
import currencyConverter.com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final String USER_ROLE = "ROLE_USER";

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public Boolean userAlreadyRegistered(String mail) {
		return userDao.userAlreadyRegistered(mail);
	}

	@Override
	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public String getMail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@Override
	public void save(User user) {
		user.setEnabled(true);
		userDao.save(user);
		saveUserRole(user);
	}

	private void saveUserRole(User user) {
		UserRole useRole = new UserRole(user.getMail(), USER_ROLE);
		userRoleDao.saveUserRoles(useRole);
	}
	
}

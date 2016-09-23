package currencyConverter.com.service;

import currencyConverter.com.model.User;

public interface UserService {

	Boolean userAlreadyRegistered(String mail);
	
	public User getCurrentUser();

	String getMail();

	void save(User user);
	
}

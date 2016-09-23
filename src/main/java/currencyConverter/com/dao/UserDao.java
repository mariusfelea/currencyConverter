package currencyConverter.com.dao;

import java.util.List;

import currencyConverter.com.model.User;

public interface UserDao {

	void save(User user);

	List<User> getUsers();

	Boolean userAlreadyRegistered(String mail);
	
}

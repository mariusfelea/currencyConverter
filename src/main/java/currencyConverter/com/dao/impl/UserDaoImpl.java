package currencyConverter.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import currencyConverter.com.dao.UserDao;
import currencyConverter.com.model.User;
import currencyConverter.com.util.CustomHibernateDaoSupport;

@Repository
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

	public void save(User user) {
		getHibernateTemplate().save(user);
	}
	
	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder hql = new StringBuilder();
				hql.append("select user from User user");
				Query query = session.createQuery(hql.toString());
				return query.list();
			}
		});
		return users;
	}

	public Boolean userAlreadyRegistered(final String mail) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder hql = new StringBuilder();
				hql.append("select user from User user where user.mail = :mail");
				Query query = session.createQuery(hql.toString());
				query.setParameter("mail", mail);
				return query.list();
			}
		});
		return users != null && users.size() > 0;
	}

}

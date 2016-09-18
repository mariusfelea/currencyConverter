package currencyConverter.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import currencyConverter.com.dao.ConverterDao;
import currencyConverter.com.model.Registration;
import currencyConverter.com.util.CustomHibernateDaoSupport;

@Repository
public class ConverterDaoImpl extends CustomHibernateDaoSupport implements ConverterDao{

	public List<Registration> getRegistrations() {
		@SuppressWarnings("unchecked")
		List<Registration> registrations = (List<Registration>)getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder hql = new StringBuilder();
				hql.append("select registration from Registration registration");
				Query query = session.createQuery(hql.toString());
				return query.list();
			}
		});
		return registrations;
	}
}

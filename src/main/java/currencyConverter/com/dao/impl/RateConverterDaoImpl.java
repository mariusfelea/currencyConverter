package currencyConverter.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import currencyConverter.com.dao.RateConverterDao;
import currencyConverter.com.model.RateConverter;
import currencyConverter.com.util.CustomHibernateDaoSupport;

@Repository
public class RateConverterDaoImpl extends CustomHibernateDaoSupport implements RateConverterDao {

	public final static int MAX_ROW = 10;
	
	@Override
	public void save(RateConverter rateConverter) {
		getHibernateTemplate().save(rateConverter);
	}

	@Override
	public List<RateConverter> getRatesConverter() {
		@SuppressWarnings("unchecked")
		List<RateConverter> ratesConverter = (List<RateConverter>) getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder hql = new StringBuilder();
				hql.append("select rateconverter from RateConverter rateconverter order by id desc");
				Query query = session.createQuery(hql.toString());
				return query.setMaxResults(MAX_ROW).list();
			}
		});
		return ratesConverter;
	}

}

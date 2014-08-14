package com.assist.platform.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.assist.platform.common.page.Page;
import com.assist.platform.dao.LogDao;
import com.assist.platform.model.Log;

@Repository("logDao")
public class LogDaoImpl extends GenericDaoImpl<Log, Integer> implements LogDao {

	public LogDaoImpl(){
		
	}
	
	public LogDaoImpl(Class<Log> clazz){
		super(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> getListByPage(Integer userid, Page page) {
		String queryString = null;
		Query queryObject = null;
		if (userid == null) {
			queryString = "from Log order by logdate desc";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
		} else {
			queryString = "from Log where userid=:userid order by logdate desc";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter("userid", userid);
		}

		queryObject.setFirstResult(page.getBeginIndex());
		queryObject.setMaxResults(page.getEveryPage());
		return queryObject.list();
	}

	public int getListCount(Integer userid) {
		String queryString = null;
		Query queryObject = null;
		if (userid == null) {
			queryString = "select count(*) from Log";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
		} else {
			queryString = "select count(*) from Log where userid = :userid";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter("userid", userid);
		}
		return ((Long) queryObject.list().iterator().next()).intValue();
	}

}

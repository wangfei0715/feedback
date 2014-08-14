package com.assist.platform.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.assist.platform.dao.PathDao;
import com.assist.platform.model.Path;

@Repository("pathDao")
public class PathDaoImpl extends GenericDaoImpl<Path, Integer> implements
		PathDao {

	public PathDaoImpl() {

	}

	public PathDaoImpl(Class<Path> clazz) {
		super(clazz);
	}

	public Path getPathByPathSign(String pathSign) {
		String queryString = "from Path where pathsign = :pathsign";
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		queryObject.setParameter("pathsign", pathSign);
		return (Path) queryObject.uniqueResult();
	}

}

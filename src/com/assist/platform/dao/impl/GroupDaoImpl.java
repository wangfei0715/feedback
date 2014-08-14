package com.assist.platform.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.assist.platform.dao.GroupDao;
import com.assist.platform.model.Group;

@Repository("groupDao")
public class GroupDaoImpl extends GenericDaoImpl<Group, Integer> implements
		GroupDao {

	public GroupDaoImpl() {
		this.order = "groupname";
	}

	public GroupDaoImpl(Class<Group> clazz) {
		super(clazz);
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroupUsers() {
		String queryString = "from Group order by groupname";
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		List list = queryObject.list();
		Hibernate.initialize(list);
		return list;
	}

}

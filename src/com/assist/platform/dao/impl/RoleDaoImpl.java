package com.assist.platform.dao.impl;

import org.springframework.stereotype.Repository;

import com.assist.platform.dao.RoleDao;
import com.assist.platform.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements
		RoleDao {
	
	public RoleDaoImpl() {
	}

	public RoleDaoImpl(Class<Role> clazz) {
		super(clazz);
	}

}

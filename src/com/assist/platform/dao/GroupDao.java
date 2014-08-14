package com.assist.platform.dao;

import java.util.List;

import com.assist.platform.model.Group;

public interface GroupDao extends GenericDao<Group, Integer> {

	/**
	 * 返回部门带有用户信息
	 * 
	 * @return
	 */
	public abstract List<Group> getAllGroupUsers();

}

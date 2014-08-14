package com.assist.platform.service;

import java.util.List;

import com.assist.platform.model.Group;

public interface GroupService extends GenericService<Group, Integer> {

	/**
	 * 返回部门列表,带有用户信息
	 * 
	 * @return
	 */
	public abstract List<Group> getAllGroupUsers();

}

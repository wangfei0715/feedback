package com.assist.platform.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.GroupDao;
import com.assist.platform.model.Group;
import com.assist.platform.service.GroupService;

@Service("groupService")
@Transactional
public class GroupServiceImpl extends GenericServiceImpl<Group, Integer>
		implements GroupService {
	@Resource
	private GroupDao groupDao;

	public Document update(Integer groupid, Group group) {
		try {
			Group newGroup = getById(group.getGroupid());
			newGroup.setGroupame(group.getGroupame());
			newGroup.setGroupleader(group.getGroupleader());
			newGroup.setParentid(group.getParentid());
			groupDao.update(newGroup);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Group> getAllGroupUsers() {
		return groupDao.getAllGroupUsers();
	}

	@Override
	public void injectDao() {
		setGenericDao(groupDao);
	}
}

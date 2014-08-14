package com.assist.platform.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.RoleDao;
import com.assist.platform.dao.UserDao;
import com.assist.platform.model.Group;
import com.assist.platform.model.Role;
import com.assist.platform.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer>implements RoleService {
	@Resource
	private RoleDao roleDao;
	@Resource
	private UserDao userDao;

	@Override
	public Document save(Role role){
		try {
			// 将userid替换为username
			// role.setCreator(userDao.getUser(role.getCreator()).getUsername());
			role.setCreatetime(new Date());
			roleDao.save(role);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document update(Integer roleid, Role role) throws HibernateException {
		try {
			// 此处roleid 为 当前操作更改角色人员的id,便于创建setCreator
			Role newRole = getById(role.getRoleid());
			newRole.setRolename(role.getRolename());
			newRole.setCreator(userDao.getById(roleid).getUsername());
			newRole.setGroupid(role.getGroupid());
			newRole.setFuncs(role.getFuncs());
			roleDao.update(newRole);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}
	
	@Override
	public void injectDao() {
		setGenericDao(roleDao);
	}
}

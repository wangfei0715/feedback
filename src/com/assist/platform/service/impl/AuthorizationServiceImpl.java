package com.assist.platform.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assist.platform.dao.UserDao;
import com.assist.platform.model.Func;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;
import com.assist.platform.service.AuthorizationService;

/**
 * 类说明: 权限控制服务层
 * 
 * @author 作者:王飞
 * @version
 */
@Service("authorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {
	@Resource
	private UserDao userDao;

	public boolean getAuth(Integer userid, String path) {
		User user = userDao.getById(userid);
		List<Role> rolelist = user.getRoles();
		boolean result = false;
		if (!"".equals(path) && path != null) {
			for (Role role : rolelist) {
				for (Func func : role.getFuncs()) {
					if (path.indexOf(func.getPath()) != -1) {
						result = true;
						break;
					}
				}
			}
			return result;
		} else {
			return false;
		}
	}

	public boolean getAuth(User user, String path) {
		List<Role> rolelist = user.getRoles();
		boolean result = false;
		if (!"".equals(path) && path != null) {
			for (Role role : rolelist) {
				for (Func func : role.getFuncs()) {
					if (path.indexOf(func.getPath()) != -1) {
						result = true;
						break;
					}
				}
			}
			return result;
		} else {
			return false;
		}
	}
}

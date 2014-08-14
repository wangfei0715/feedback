package com.assist.platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.common.constant.MsgSign;
import com.assist.platform.common.constant.UserType;
import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.PageUtil;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.dao.GroupDao;
import com.assist.platform.dao.RoleDao;
import com.assist.platform.dao.UserDao;
import com.assist.platform.model.Group;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;
import com.assist.platform.model.UserInfo;
import com.assist.platform.model.UserRank;
import com.assist.platform.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User, Integer>
		implements UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private RoleDao roleDao;

	@Resource
	private GroupDao groupDao;

	public Document save(User user) {
		try {
			user.setTel("");
			user.setCreatetime(new Date());
			user.setScore("0");
			user.setIsdel(MsgSign.NOT);
			user.setIsadmin(UserType.NORMAL);
			Group group = new Group();
			group.setGroupid(1);
			user.setGroup(group);
			UserRank userrank = new UserRank();
			userrank.setRankid(1);
			user.setUserrank(userrank);
			UserInfo userinfo = new UserInfo();
			userinfo.setUser(user);
			userinfo.setSex(0);
			userinfo.setConstellation("");
			userinfo.setZodiac("");
			userinfo.setQq("");
			user.setUserinfo(userinfo);
			List<Role> roles = new ArrayList<Role>();
			Role role = new Role();
			role.setRoleid(1);
			roles.add(role);
			user.setRoles(roles);
			userDao.save(user);
			return retrunValue(Boolean.TRUE, "注册用户成功");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "注册用户失败", e);
		}
	}

	public Document update(Integer userid, User user) {
		try {
			// 个人修改
			if (!"".equals(userid) && userid != null) {
				User newUser = getById(userid);
				UserInfo newUserInfo = newUser.getUserinfo();
				UserInfo userinfo = user.getUserinfo();
				
				newUser.setPassword(user.getPassword());
				newUser.setUsername(user.getUsername());
				newUser.setEmail(user.getEmail());
				newUser.setTel(user.getTel());
				
				if (null != userinfo){
					newUserInfo.setQq(userinfo.getQq());
					newUserInfo.setBirthday(userinfo.getBirthday());
					newUserInfo.setConstellation(userinfo.getConstellation());
					newUserInfo.setSex(userinfo.getSex());
					newUserInfo.setZodiac(userinfo.getZodiac());
					newUserInfo.setSelfinfo(userinfo.getSelfinfo());
					newUser.setUserinfo(newUserInfo);
				}
					
				// newUser.setGroup(user.getGroup());
				// List<Role> roles = user.getRoles();
				// if (null != roles)
				//					newUser.setRoles(user.getRoles());
				userDao.update(newUser);
			} else {
				// 管理员修改
				User newUser = getById(user.getUserid());
				newUser.setPassword(user.getPassword());
				newUser.setEmail(user.getEmail());
				newUser.setUsername(user.getUsername());
				// 关联userinfo
				// user.getUserinfo().setUserinfoid(user.getUserid());
				newUser.setUserinfo(user.getUserinfo());
				newUser.setGroup(user.getGroup());
				newUser.setRoles(user.getRoles());
				userDao.update(newUser);
			}
			return retrunValue(Boolean.TRUE, "修改信息成功");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "修改信息失败", e);
		}
	}

	public boolean checkUser(String loginname) {
		User user = userDao.getUserByLoginname(loginname);
		if (user != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkPwd(Integer userid, String password) {
		if ("".equals(password) || null == password) {
			return false;
		} else {
			User user = userDao.getById(userid);
			if (password.equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

	public String forgetPwd(String loginname, String username, String email) {
		User user = userDao.getUserByNameEmail(loginname, username, email);
		if (user != null) {
			return "您的密码是：" + user.getPassword();
		} else {
			return "对不起,没有匹配的密码";
		}
	}

	public User login(String loginname, String pwd) {
		return userDao.getUserByNamePwd(loginname, pwd);
	}

	@SuppressWarnings("unchecked")
	public Pagination<User> getUserListByPage(Integer groupid, Page page) {
		int totalRecords = userDao.getUserListCount(groupid);
		page = PageUtil.createPage(page, totalRecords);
		List<User> userList = userDao.getUserListByPage(groupid, page);
		return new Pagination(page, userList);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<User> search(User user) {
		Integer groupid = user.getGroup().getGroupid();
		List<User> userList = null;
		if (!"0".equals(groupid)) {
			userList = userDao.search(user, groupDao.getById(groupid));
		} else {
			userList = userDao.search(user, null);
		}
		return new Pagination(null, userList);
	}

	@Override
	public void injectDao() {
		setGenericDao(userDao);
	}
}

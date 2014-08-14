package com.assist.platform.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.assist.platform.common.page.Page;
import com.assist.platform.dao.GenericDao;
import com.assist.platform.dao.UserDao;
import com.assist.platform.model.Group;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements
		UserDao {

	public UserDaoImpl() {
	}

	public UserDaoImpl(Class<User> clazz) {
		super(clazz);
	}

	@Override
	public void delete(Integer userid) {
		// sessionFactory.getCurrentSession().delete(
		// sessionFactory.getCurrentSession().load(User.class, userid));
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				userid);
		user.setIsdel(1);
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public void delete(User user) {
		user.setIsdel(1);
		sessionFactory.getCurrentSession().merge(user);
	}

	public User getUserByLoginname(String loginname) {
		String queryString = "from User where loginname = :loginname";
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		queryObject.setParameter("loginname", loginname);
		return (User) queryObject.uniqueResult();
	}

	public User getUserByNamePwd(String loginname, String pwd) {
		String queryString = "from User where loginname = :loginname and password = :pwd";
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		queryObject.setParameter("loginname", loginname);
		queryObject.setParameter("pwd", pwd);
		return (User) queryObject.uniqueResult();
	}

	public User getUserByNameEmail(String username, String email) {
		String queryString = "from User where username = :username and email = :email";
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		queryObject.setParameter("username", username);
		queryObject.setParameter("email", email);
		return (User) queryObject.uniqueResult();
	}

	public User getUserByNameEmail(String loginname, String username,
			String email) {
		String queryString = "from User where loginname = :loginname and username"
				+ " = :username and email = :email";
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		queryObject.setParameter("loginname", loginname);
		queryObject.setParameter("username", username);
		queryObject.setParameter("email", email);
		return (User) queryObject.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserListByPage(Integer groupid, Page page) {
		String queryString = null;
		Query queryObject = null;
		if (groupid == null) {
			queryString = "from User order by loginname";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
		} else {
			queryString = "from User where groupid=:groupid order by loginname";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter("groupid", groupid);
		}

		queryObject.setFirstResult(page.getBeginIndex());
		queryObject.setMaxResults(page.getEveryPage());
		return queryObject.list();
	}

	public int getUserListCount(Integer groupid) {
		String queryString = null;
		Query queryObject = null;
		if (groupid == null) {
			queryString = "select count(*) from User";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
		} else {
			queryString = "select count(*) from User where groupid = :groupid";
			queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter("groupid", groupid);
		}
		return ((Long) queryObject.list().iterator().next()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<User> search(User user, Group group) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		String loginname = user.getLoginname();
		String username = user.getUsername();
		String tel = user.getTel();
		if (group != null) {
			criteria.add(Restrictions.eq("group", group));
		}
		if (!"".equals(loginname))
			criteria.add(Restrictions.like("loginname", "%" + loginname + "%"));
		if (!"".equals(username))
			criteria.add(Restrictions.like("username", "%" + username + "%"));
		if (!"".equals(tel))
			criteria.add(Restrictions.like("tel", "%" + tel + "%"));

		criteria.addOrder(Order.desc("username"));
		return criteria.list();
	}

}

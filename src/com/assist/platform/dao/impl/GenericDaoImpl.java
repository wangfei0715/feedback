package com.assist.platform.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.assist.platform.common.page.Page;
import com.assist.platform.dao.GenericDao;

/**
 * 泛型DAO通用实现
 * 
 * @author FLY
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDaoImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {
	@Resource
	protected SessionFactory sessionFactory;

	// 具体的实体类型
	protected Class<T> clazz;

	// 查询条件
	protected String hql;

	protected String order;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.hql = "from " + clazz.getName();
		this.order = defaultOrder(clazz.getName());
	}

	/**
	 * 必须提供的构造方法,以便创建实例的时候就知道具体实体的类型
	 * 
	 * @param clazz
	 *            实体类型
	 */
	public GenericDaoImpl(Class<T> clazz) {
		 // 一个构造方法调用另一个构造方法，必须在第一行
		this.clazz = clazz;
		this.hql = "from " + clazz.getName();
		this.order = clazz.getName().toLowerCase() + "id";
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getHql() {
		return hql;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@SuppressWarnings("unchecked")
	public ID save(T entity) throws HibernateException {
		return (ID) sessionFactory.getCurrentSession().save(entity);
	}

	public void delete(ID id) throws HibernateException {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(clazz, id));
	}

	public void delete(T entity) throws HibernateException {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public void deleteALL(Collection<T> entities) throws HibernateException {
		for (T entity : entities) {
			sessionFactory.getCurrentSession().delete(entity);
		}
	}

	public void update(T entity) throws HibernateException {
		sessionFactory.getCurrentSession().merge(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		StringBuffer queryString = new StringBuffer();
		queryString.append("from " + clazz.getName());
		// if (null != order && !"".equals(order))
		queryString.append(" order by " + order);
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString.toString());
		return queryObject.list();
	}

	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public List<T> getListByPage(Page page) {
		StringBuffer queryString = new StringBuffer();
		queryString.append("from " + clazz.getName());
		// if (null != order && !"".equals(order))
		queryString.append(" order by " + order);
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString.toString());
		queryObject.setFirstResult(page.getBeginIndex());
		queryObject.setMaxResults(page.getEveryPage());
		return queryObject.list();
	}

	public int getListCount() {
		String queryString = "select count(*) from " + clazz.getName();
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				queryString);
		return ((Long) queryObject.list().iterator().next()).intValue();
	}
	
	private String defaultOrder(String order){
		return order.substring(order.lastIndexOf(".") + 1, order.length()).toLowerCase()+"id";
	}
}

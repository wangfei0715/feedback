package com.assist.platform.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;

import com.assist.platform.common.page.Page;

/**
 * 泛型DAO通用接口
 * 
 * @author FLY
 * 
 * @param <T>
 *            持久化的实体Bean
 * @param <ID>
 *            实体Bean的id
 */
public interface GenericDao<T, ID extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity :
	 *            实体
	 * @return 保存后得到的id
	 */
	public abstract ID save(T entity) throws HibernateException;

	public abstract void update(T entity) throws HibernateException;

	/**
	 * 根据id查找实体
	 * 
	 * @param id
	 * @return
	 */
	public abstract T getById(ID id);

	/**
	 * 查找全部实体
	 * 
	 * @return
	 */
	public abstract List<T> getAll();

	public abstract void delete(ID id) throws HibernateException;

	public abstract void delete(T entity) throws HibernateException;

	public abstract void deleteALL(Collection<T> entities)
			throws HibernateException;

	/**
	 * 在查找所有记录的时候,使用提供查询语句,查询匹配的记录,否则将使用默认的查询语句查询数据的所有记录.
	 * 
	 * @param hql
	 *            自定义的HQL语句
	 */
	public abstract void setHql(String hql);

	/**
	 * @return 自定义的HQL语句
	 */
	public abstract String getHql();

	/**
	 * 取得回复列表分页
	 * 
	 * @param id
	 * @param entity
	 * @param page
	 * @return
	 */
	public abstract List<T> getListByPage(Page page);

	/**
	 * 计算匹配查询条件的记录总数,如果没有注入或者设置hql语句,将使用默认的查询语句返回数据库中所有记录
	 * 
	 * @param id
	 * @param entity
	 * @return
	 */
	public abstract int getListCount();
}

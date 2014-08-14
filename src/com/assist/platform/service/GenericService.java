package com.assist.platform.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Document;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;

/**
 * 泛型Service通用接口
 * 
 * @author FLY
 * 
 * @param <T>
 *            持久化的实体Bean
 * @param <ID>
 *            实体Bean的id
 */
public interface GenericService<T, ID extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity :
	 *            实体
	 * @return 保存后得到的id
	 */
	public abstract Document save(T entity);

	public abstract Document update(T entity);

	public abstract Document update(ID id, T entity);

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

	public abstract Document delete(ID id);

	public abstract Document delete(T entity);

	public abstract Document deleteALL(Collection<T> entities);

	/**
	 * 取得列表分页
	 * 
	 * @param page
	 * @return
	 */
	public abstract Pagination<T> getListByPage(Page page);

	/**
	 * 注入Dao资源
	 */
	public abstract void injectDao();
}

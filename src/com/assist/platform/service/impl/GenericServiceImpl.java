package com.assist.platform.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.PageUtil;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.dao.GenericDao;
import com.assist.platform.service.GenericService;
import com.assist.platform.util.ConfigProperties;
import com.assist.platform.util.XMLAdapter;

/**
 * 类说明:
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 29, 2011 12:40:42 AM
 */
@Transactional
public class GenericServiceImpl<T, ID extends Serializable> implements
		GenericService<T, ID> {

	// 具体的实体类型
	protected Class<T> clazz;

	protected GenericDao<T, ID> genericDao;

	@SuppressWarnings("unchecked")
	public GenericServiceImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericServiceImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	public GenericDao<T, ID> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<T, ID> genericDao) {
		this.genericDao = genericDao;
	}

	public Document save(T entity) {
		try {
			genericDao.save(entity);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document update(T entity) {
		try {
			genericDao.update(entity);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document update(ID id, T entity) {
		try {
			genericDao.update(entity);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document delete(ID id) {
		try {
			genericDao.delete(id);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document delete(T entity) {
		try {
			genericDao.delete(entity);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document deleteALL(Collection<T> entities) {
		try {
			genericDao.deleteALL(entities);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List getAll() {
		return genericDao.getAll();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public T getById(ID id) {
		return genericDao.getById(id);
	}

	@SuppressWarnings("unchecked")
	public Pagination getListByPage(Page page) {
		int totalRecords = genericDao.getListCount();
		page = PageUtil.createPage(page, totalRecords);
		List<T> list = genericDao.getListByPage(page);
		return new Pagination(page, list);
	}

	/**
	 * 构建返回值document
	 * 
	 * @param boolean
	 *            state
	 * @param String
	 *            msg
	 * @return Document xmlDoc
	 */
	protected Document retrunValue(boolean state, String msg) {
		boolean isDebug = ConfigProperties.getInstance().isIsdebug();
		String status = "";
		if (Boolean.TRUE == state) {
			status = "1";
			if (isDebug)
				System.out.println("GenericService: " + clazz.getName()
						+ " 中执行成功");
		} else if (Boolean.FALSE == state) {
			status = "0";
			if (isDebug)
				System.out.println("GenericService: " + clazz.getName()
						+ " 中执行失败");
		}
		Document xmlDoc = XMLAdapter.newDocument();
		Element result = xmlDoc.createElement("result");
		// Element msg = xmlDoc.createElement("msg");
		// Element type = xmlDoc.createElement("type");
		// result.appendChild(msg);
		// result.appendChild(type);
		result.setAttribute("msg", msg);
		result.setAttribute("status", status);
		result.setAttribute("type", clazz.getName());
		xmlDoc.appendChild(result);
		return xmlDoc;
	}

	/**
	 * 构建返回值document
	 * 
	 * @param boolean
	 *            state
	 * @param String
	 *            msg
	 * @param Exception
	 *            e
	 * @return Document xmlDoc
	 */
	protected Document retrunValue(boolean state, String msg, Exception e) {
		e.printStackTrace();
		return retrunValue(state, msg);
	}

	public void injectDao() {
	}

}

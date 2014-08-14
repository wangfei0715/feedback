package com.assist.platform.service.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.CatalogDao;
import com.assist.platform.model.Catalog;
import com.assist.platform.service.CatalogService;

@Service("catalogService")
@Transactional
public class CatalogServiceImpl extends GenericServiceImpl<Catalog, Integer>
		implements CatalogService {
	
	@Resource
	private CatalogDao catalogDao;

	@Override
	public Document update(Integer catalogid, Catalog catalog) {
		try{
			Catalog newCatalog = getById(catalog.getCatalogid());
			newCatalog.setCatalogname(catalog.getCatalogname());
			catalogDao.update(newCatalog);
			return retrunValue(Boolean.TRUE, "");
		}catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "");
		}
	}

	@Override
	public void injectDao() {
		setGenericDao(catalogDao);
	}
}

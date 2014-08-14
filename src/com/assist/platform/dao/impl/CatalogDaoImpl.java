package com.assist.platform.dao.impl;

import org.springframework.stereotype.Repository;

import com.assist.platform.dao.CatalogDao;
import com.assist.platform.model.Catalog;

@Repository("catalogDao")
public class CatalogDaoImpl extends GenericDaoImpl<Catalog, Integer> implements
		CatalogDao {
	public CatalogDaoImpl() {
	}

	public CatalogDaoImpl(Class<Catalog> clazz) {
		super(clazz);
	}

}

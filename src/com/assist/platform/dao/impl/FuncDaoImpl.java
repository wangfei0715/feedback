package com.assist.platform.dao.impl;

import org.springframework.stereotype.Repository;

import com.assist.platform.dao.FuncDao;
import com.assist.platform.model.Func;

@Repository("funcDao")
public class FuncDaoImpl extends GenericDaoImpl<Func, Integer> implements FuncDao {
	public FuncDaoImpl() {
	}
	
	public FuncDaoImpl(Class<Func> clazz) {
		super(clazz);
	}
	

}

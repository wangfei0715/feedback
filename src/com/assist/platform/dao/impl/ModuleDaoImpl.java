package com.assist.platform.dao.impl;

import org.springframework.stereotype.Repository;

import com.assist.platform.dao.ModuleDao;
import com.assist.platform.model.Module;

@Repository("moduleDao")
public class ModuleDaoImpl extends GenericDaoImpl<Module, Integer> implements ModuleDao {

	public ModuleDaoImpl(){
		this.order = "modulename";
	}
	
	public ModuleDaoImpl(Class<Module> clazz){
		super(clazz);
	}
	
}

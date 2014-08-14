package com.assist.platform.service.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.ModuleDao;
import com.assist.platform.model.Module;
import com.assist.platform.service.ModuleService;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl extends GenericServiceImpl<Module, Integer>
		implements ModuleService {
	@Resource
	private ModuleDao moduleDao;

	public Document update(Integer moduleid, Module module)
			throws HibernateException {
		try {
			Module newModule = getById(module.getModuleid());
			newModule.setModulename(module.getModulename());
			moduleDao.update(newModule);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	@Override
	public void injectDao() {
		setGenericDao(moduleDao);
	}
}

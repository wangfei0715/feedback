package com.assist.platform.service.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.FuncDao;
import com.assist.platform.model.Func;
import com.assist.platform.service.FuncService;

@Service("funcService")
@Transactional
public class FuncServiceImpl extends GenericServiceImpl<Func, Integer>
		implements FuncService {
	
	@Resource
	private FuncDao funcDao;

	@Override
	public Document update(Integer funcid, Func func) {
		try{
			Func newFunc = getById(func.getFuncid());
			newFunc.setFuncname(func.getFuncname());
			newFunc.setPath(func.getPath());
			newFunc.setModule(func.getModule());
			funcDao.update(newFunc);
			return retrunValue(Boolean.TRUE, "");
		}catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "");
		}
	}

	@Override
	public void injectDao() {
		setGenericDao(funcDao);
	}
}

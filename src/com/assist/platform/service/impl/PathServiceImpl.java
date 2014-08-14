package com.assist.platform.service.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.PathDao;
import com.assist.platform.model.Path;
import com.assist.platform.service.PathService;

@Service("pathService")
@Transactional
public class PathServiceImpl extends GenericServiceImpl<Path, Integer>
		implements PathService {
	@Resource
	private PathDao pathDao;

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Path getPathByPathsign(String pathsign) {
		return pathDao.getPathByPathSign(pathsign);
	}

	public Document update(Integer pathid, Path path) throws HibernateException {
		try {
			Path newPath = getById(path.getPathid());
			pathDao.update(newPath);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	@Override
	public void injectDao() {
		setGenericDao(pathDao);
	}
}

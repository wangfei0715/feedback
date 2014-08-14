package com.assist.platform.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assist.platform.dao.LogDao;
import com.assist.platform.model.Log;
import com.assist.platform.model.User;
import com.assist.platform.service.LogService;

@Service("logService")
@Transactional
public class LogServiceImpl extends GenericServiceImpl<Log, Integer> implements
		LogService {
	@Resource
	private LogDao logDao;

	public void save(User user, String title, String content)
			throws HibernateException {
		Log log = new Log();
		log.setOperator(user.getUsername());
		log.setLogtime(new Date());
		log.setUserid(user.getUserid());
		log.setTitle(title);
		log.setContent(content);
		logDao.save(log);
	}

	@Override
	public void injectDao() {
		setGenericDao(logDao);
	}
}

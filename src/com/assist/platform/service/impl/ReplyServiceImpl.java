package com.assist.platform.service.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.assist.platform.dao.ReplyDao;
import com.assist.platform.model.Reply;
import com.assist.platform.model.User;
import com.assist.platform.service.ReplyService;

/**
 * 类说明:
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 28, 2011 10:05:50 PM
 */
@Service("replyService")
@Transactional
public class ReplyServiceImpl extends GenericServiceImpl<Reply, Integer>
		implements ReplyService {

	@Resource
	private ReplyDao replyDao;

	public ReplyServiceImpl() {
	}

	public ReplyServiceImpl(Class<Reply> clazz) {
		super(clazz);
	}

	public Document update(Integer userid, Integer replyid, Reply reply) {
		try {
			Reply replyNew = replyDao.getById(replyid);
			replyNew.setUser(new User(userid));
			replyNew.setContent(reply.getContent());
			replyDao.update(replyNew);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}

	}

	@Override
	public void injectDao() {
		setGenericDao(replyDao);
	}

}

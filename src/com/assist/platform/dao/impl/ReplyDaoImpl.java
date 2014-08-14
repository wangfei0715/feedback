package com.assist.platform.dao.impl;

import org.springframework.stereotype.Repository;

import com.assist.platform.dao.ReplyDao;
import com.assist.platform.model.Reply;

/**
 * 类说明:
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 28, 2011 9:16:19 PM
 */
@Repository("replyDao")
public class ReplyDaoImpl extends GenericDaoImpl<Reply, Integer> implements ReplyDao {
	
	public ReplyDaoImpl() {
	}
	
	public ReplyDaoImpl(Class<Reply> clazz) {
		super(clazz);
	}
	
}

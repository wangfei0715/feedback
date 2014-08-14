package com.assist.platform.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.assist.platform.common.constant.MsgSign;
import com.assist.platform.common.constant.MsgStatus;
import com.assist.platform.common.constant.MsgType;
import com.assist.platform.common.page.Page;
import com.assist.platform.dao.MessageDao;
import com.assist.platform.model.Catalog;
import com.assist.platform.model.Message;
import com.assist.platform.model.User;

@Repository("messageDao")
public class MessageDaoImpl extends GenericDaoImpl<Message, Integer> implements
		MessageDao {

	public MessageDaoImpl() {
	}

	public MessageDaoImpl(Class<Message> clazz) {
		super(clazz);
	}

	@Override
	public void delete(Integer messageid) throws HibernateException {
		Message message = (Message) sessionFactory.getCurrentSession().load(
				Message.class, messageid);
		message.setIsdel(1);
		sessionFactory.getCurrentSession().merge(message);
	}

	@Override
	public void delete(Message message) throws HibernateException {
		// 0 未删 1 已删
		message.setIsdel(1);
		sessionFactory.getCurrentSession().merge(message);
	}

	public List<Message> getListByPage(Integer userid, Message message,
			Page page) {
		Criteria criteria = getMessageList(userid, message);
		criteria.setFirstResult(page.getBeginIndex());
		criteria.setMaxResults(page.getEveryPage());
		criteria.addOrder(Order.desc("modifytime"));
		return criteria.list();
	}

	public int getListCount(Integer userid, Message message) {
		Criteria criteria = getMessageList(userid, message);
		return criteria.list().size();
	}

	public List<Message> getList(Message message, int limit) {
		Criteria criteria = getMessageList(null, message);
		criteria.addOrder(Order.desc("modifytime"));
		if (limit > 0)
			criteria.setMaxResults(limit);
		return criteria.list();
	}

	public List<Message> getList(Integer userid, Message message) {
		Criteria criteria = getMessageList(userid, message);
		criteria.addOrder(Order.desc("modifytime"));
		return criteria.list();
	}

	private Criteria getMessageList(Integer userid, Message message) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Message.class);
		int isDel = MsgSign.NOT;
		if (null != message.getIsdel())
			isDel = message.getIsdel();
		int isTop = MsgSign.ALL;
		if (null != message.getIstop())
			isTop = message.getIstop();
		int checked = MsgSign.ALL;
		if (null != message.getChecked())
			checked = message.getChecked();
		int status = MsgStatus.ALL;
		if (null != message.getStatus())
			status = message.getStatus();
		int type = MsgType.ALL;
		if (null != message.getType())
			type = message.getType();
		int recommend = MsgSign.ALL;
		if (null != message.getRecommend())
			recommend = message.getRecommend();
		Catalog catalog = null;
		if (null != message.getCatalog())
			catalog = message.getCatalog();
		// String content = message.getContent();

		criteria.add(Restrictions.eq("isdel", isDel));
		if (MsgSign.ALL != isTop)
			criteria.add(Restrictions.eq("istop", isTop));
		if (MsgSign.ALL != checked)
			criteria.add(Restrictions.eq("checked", checked));
		if (MsgSign.ALL != recommend)
			criteria.add(Restrictions.eq("recommend", recommend));
		if (MsgType.ALL != type)
			criteria.add(Restrictions.eq("type", type));
		if (MsgStatus.ALL != status)
			criteria.add(Restrictions.eq("status", status));

		if (catalog != null)
			criteria.add(Restrictions.eq("catalog", new Catalog(catalog
					.getCatalogid())));

		// userid == null 为管理员，查看所有建议
		if (userid != null && MsgSign.YES != recommend)
			criteria.add(Restrictions.eq("user", new User(userid)));

		return criteria;
	}

}

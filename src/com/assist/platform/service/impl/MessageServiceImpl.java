package com.assist.platform.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.assist.platform.common.constant.MsgSign;
import com.assist.platform.common.constant.MsgStatus;
import com.assist.platform.common.constant.MsgType;
import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.PageUtil;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.dao.MessageDao;
import com.assist.platform.model.Catalog;
import com.assist.platform.model.Message;
import com.assist.platform.model.Reply;
import com.assist.platform.model.User;
import com.assist.platform.service.MessageService;
import com.assist.platform.service.ReplyService;
import com.assist.platform.util.StringUtil;
import com.assist.platform.util.XMLAdapter;

/**
 * 类说明:
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 28, 2011 10:04:07 PM
 */
@Service("messageService")
@Transactional
public class MessageServiceImpl extends GenericServiceImpl<Message, Integer>
		implements MessageService {
	@Resource
	private MessageDao messageDao;

	@Resource
	private ReplyService replyService;

	public Document save(Integer userid, Message message) {
		try {
			if (null != userid && !"".equals(userid))
				message.setUser(new User(userid));
			message.setChecked(MsgSign.NOT);
			message.setIsdel(MsgSign.NOT);
			message.setIstop(MsgSign.NOT);
			message.setRecommend(MsgSign.NOT);
			message.setStatus(MsgStatus.UNREPLY);
			message.setCreatetime(new Date());
			message.setModifytime(new Date());
			messageDao.save(message);
			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	public Document update(Integer userid, Message message, Reply reply) {
		// if (null != userid && !"".equals(userid))
		// message.setUser(new User(userid));
		try {
			if (null == reply) {
				// 无回复，只更新信息
				Message messageNew = getById(message.getMessageid());
				messageNew.setChecked(message.getChecked());
				messageNew.setRecommend(message.getRecommend());
				messageNew.setIsdel(message.getIsdel());
				messageNew.setIstop(message.getIstop());
				messageNew.setType(message.getType());
				messageNew.setStatus(message.getStatus());
				update(messageNew);

			} else {
				// 更新信息和添加回复
				reply.setUser(new User(userid));
				reply.setTitle("回复");
				reply.setReplytime(new Date());

				Message messageNew = getById(message.getMessageid());

				messageNew.setChecked(message.getChecked());
				messageNew.setRecommend(message.getRecommend());
				messageNew.setIsdel(message.getIsdel());
				messageNew.setIstop(message.getIstop());
				messageNew.setType(message.getType());
				// messageNew.setStatus(message.getStatus());

				messageNew.setStatus(MsgStatus.REPLIED);
				messageNew.setReplytime(new Date());

				reply.setMessage(messageNew);
				update(messageNew);
				replyService.save(reply);
			}

			return retrunValue(Boolean.TRUE, "");
		} catch (HibernateException e) {
			return retrunValue(Boolean.FALSE, "", e);
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination getListByPage(Integer userid, int type, int status,
			Page page) {
		int totalRecords = messageDao.getListCount();
		page = PageUtil.createPage(page, totalRecords);
		List<Message> list = messageDao.getListByPage(page);
		return new Pagination(page, list);
	}

	public List<Message> getByUser(Integer userid, int type, int status) {
		Message message = new Message();
		message.setType(type);
		message.setStatus(status);
		message.setIsdel(MsgSign.NOT);
		message.setChecked(MsgSign.ALL);
		message.setIstop(MsgSign.ALL);
		message.setRecommend(MsgSign.ALL);
		return messageDao.getList(userid, message);
	}

	public Pagination getRecommendByPage(int type, int catalogid, Page page) {
		Message message = new Message();
		message.setType(type);
		message.setCatalog(new Catalog(catalogid));
		message.setIsdel(MsgSign.NOT);
		message.setChecked(MsgSign.ALL);
		message.setIstop(MsgSign.ALL);
		message.setRecommend(MsgSign.YES);

		int totalRecords = messageDao.getListCount(null, message);
		page = PageUtil.createPage(page, totalRecords);
		List<Message> list = messageDao.getListByPage(null, message, page);
		return new Pagination(page, list);
	}

	@SuppressWarnings("unchecked")
	public Pagination getAdminByPage(int type, int status, int catalogid,
			Page page) {
		Message message = new Message();
		message.setType(type);
		message.setStatus(status);
		message.setIsdel(MsgSign.NOT);
		message.setChecked(MsgSign.ALL);
		message.setIstop(MsgSign.ALL);
		message.setRecommend(MsgSign.ALL);

		if (catalogid != 0)
			message.setCatalog(new Catalog(catalogid));

		int totalRecords = messageDao.getListCount(null, message);
		page = PageUtil.createPage(page, totalRecords);
		List<Message> list = messageDao.getListByPage(null, message, page);
		return new Pagination(page, list);
	}

	public Document getTop(int type, int limit) {
		Message message = new Message();
		message.setType(type);
		message.setStatus(MsgType.ALL);
		message.setIsdel(MsgSign.NOT);
		message.setChecked(MsgSign.ALL);
		message.setIstop(MsgSign.YES);
		message.setRecommend(MsgSign.ALL);

		List<Message> messages = messageDao.getList(message, limit);
		return listToDocument(messages);
	}

	private Document listToDocument(List<Message> messages) {
		Document xmlDoc = XMLAdapter.newDocument();
		Element result = xmlDoc.createElement("result");
		for (Message message : messages) {
			Element msg = xmlDoc.createElement("message");
			msg.setAttribute("title", StringUtil.subString(message.getTitle(),
					16));
			msg.setAttribute("catalogname", message.getCatalog().getCatalogname());
			msg.setAttribute("url", "message/message_detail.action?messageid="
					+ message.getMessageid());
			result.appendChild(msg);
		}
		xmlDoc.appendChild(result);
		return xmlDoc;
	}

	@Override
	public void injectDao() {
		setGenericDao(messageDao);
	}

}

package com.assist.platform.dao;

import java.util.List;

import com.assist.platform.common.page.Page;
import com.assist.platform.model.Message;

public interface MessageDao extends GenericDao<Message, Integer> {

	/**
	 * 取得建议列表分页
	 * 
	 * @param userid
	 * @param message
	 * @param page
	 * @return
	 */
	public List<Message> getListByPage(Integer userid, Message message,
			final Page page);

	/**
	 * 取得建议列表总数
	 * 
	 * @param userid
	 * @param message
	 * @return
	 */
	public int getListCount(Integer userid, Message message);

	/**
	 * 查询建议
	 * 
	 */
	public abstract List<Message> getList(Message message, int limit);

	public abstract List<Message> getList(Integer userid, Message message);
}

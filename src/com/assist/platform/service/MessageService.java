package com.assist.platform.service;

import java.util.List;

import org.w3c.dom.Document;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Message;
import com.assist.platform.model.Reply;

/**
 * 类说明: 问题建议信息服务层
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 28, 2011 8:46:49 PM
 */

public interface MessageService extends GenericService<Message, Integer> {

	/**
	 * 保存问题/建议
	 * 
	 * @return
	 */
	public abstract Document save(Integer userid, Message message);

	/**
	 * 更新问题/建议
	 * 
	 * @return
	 */
	public abstract Document update(Integer userid, Message message, Reply reply);

	/**
	 * 查询 我的提问/建议
	 * 
	 * @param userid
	 * @param type
	 * @param status
	 * @return
	 */
	public abstract List<Message> getByUser(Integer userid, int type, int status);

	/**
	 * 查询 常见问题/精彩建议
	 * 
	 * @param type
	 * @param catalogid
	 * @param page
	 * @return
	 */
	public abstract Pagination getRecommendByPage(int type, int catalogid,
			Page page);

	/**
	 * 管理 常见问题/精彩建议
	 * 
	 * @param type
	 * @param status
	 * @param catalogid
	 * @param page
	 * @return
	 */
	public abstract Pagination getAdminByPage(int type, int status,
			int catalogid, Page page);

	/**
	 * 返回问题/建议列表
	 * 
	 * @return
	 */
	public abstract Pagination getListByPage(Integer userid, int type,
			int status, Page page);

	/**
	 * 返回置顶文章
	 * 
	 * @param catalogid
	 * @param limit
	 * @return
	 */
	public abstract Document getTop(int type, int limit);
}

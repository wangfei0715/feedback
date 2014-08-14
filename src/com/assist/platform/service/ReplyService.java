package com.assist.platform.service;

import org.w3c.dom.Document;

import com.assist.platform.model.Message;
import com.assist.platform.model.Reply;

/**
 * 类说明: 回复服务类
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 28, 2011 9:03:56 PM
 */

public interface ReplyService extends GenericService<Reply, Integer> {
	public abstract Document update(Integer userid, Integer replyid, Reply reply);
}

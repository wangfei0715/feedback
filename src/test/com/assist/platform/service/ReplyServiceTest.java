package test.com.assist.platform.service;


import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assist.platform.common.constant.MsgStatus;
import com.assist.platform.model.Message;
import com.assist.platform.model.Reply;
import com.assist.platform.model.User;
import com.assist.platform.service.MessageService;
import com.assist.platform.service.ReplyService;

/**
 *	类说明:
 *
 *	@author 作者:王飞
 * 	@version
 * 	@copyright 
 *	Jun 29, 2011 12:21:52 AM
 */

public class ReplyServiceTest {

	private static ReplyService replyService;
	
	private static MessageService messageService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			replyService = (ReplyService) cxt.getBean("replyService");
			messageService = (MessageService) cxt.getBean("messageService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSave() {
		Reply reply = new Reply();
		reply.setUser(new User(101));
		reply.setTitle("回复标题");
		reply.setContent("回复内容");
		reply.setReplytime(new Date());
		Message message = messageService.getById(1);
		message.setStatus(MsgStatus.REPLIED);
		message.setReplytime(new Date());
		reply.setMessage(message);
		messageService.update(message);
		replyService.save(reply);
	}
	
	@Test
	public void testUpdate() {
		Reply reply = new Reply();
		reply.setReplyid(1);
		reply.setContent("回复内容");
		replyService.update(reply);
	}

}

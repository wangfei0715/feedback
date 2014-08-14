/**
 *	类说明:
 *
 *	@author 作者:王飞
 * 	@version
 * 	@copyright 中国软件与技术服务股份有限公司 战略客户部
 *	Jul 7, 2009
 *	4:04:35 PM
 */

package test.com.assist.platform.service;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;

import com.assist.platform.common.constant.MsgSign;
import com.assist.platform.common.constant.MsgStatus;
import com.assist.platform.common.constant.MsgType;
import com.assist.platform.model.Catalog;
import com.assist.platform.model.Message;
import com.assist.platform.model.User;
import com.assist.platform.service.MessageService;
import com.assist.platform.util.XMLAdapter;

public class MessageServiceTest {

	private static MessageService messageService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			messageService = (MessageService) cxt.getBean("messageService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		Message message = new Message();
		message.setUser(new User(101));
		message.setCatalog(new Catalog(1));
		message.setTitle("建议message");
		message.setContent("建议内容建议内容建议内容建议内容建议内容");
		message.setChecked(MsgSign.NOT);
		message.setIsdel(MsgSign.NOT);
		message.setIstop(MsgSign.NOT);
		message.setStatus(MsgStatus.UNREPLY);
		message.setType(MsgType.SUGGESTION);
		message.setCreatetime(new Date());
		message.setModifytime(new Date());
		message.setRecommend(MsgSign.YES);		
		messageService.save(101, message);
	}
	
	@Test
	public void testGetById(){
		Message message = messageService.getById(1);
		System.out.println(message.getTitle()+" "+message.getUser().getUsername());
	}
	
	@Test
	public void testGetTop(){
		Document xmlDoc = messageService.getTop(MsgType.QUESTION, 2);
		System.out.println(XMLAdapter.nodeXML(xmlDoc));
	}

}

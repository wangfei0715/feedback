package test.com.assist.platform.service;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assist.platform.model.Group;
import com.assist.platform.service.GroupService;

/**
 *	类说明:
 *
 *	@author 作者:王飞
 * 	@version
 * 	@copyright 
 *	Jun 27, 2011 11:57:18 PM
 */

public class GroupTest {
	
	private static GroupService groupService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			groupService = (GroupService) cxt.getBean("groupService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSave(){
		Group group = new Group();
		group.setGroupame("test");
		groupService.save(group);
	}

}

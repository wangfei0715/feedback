package test.com.assist.platform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assist.platform.common.constant.MsgSign;
import com.assist.platform.common.constant.UserType;
import com.assist.platform.model.Group;
import com.assist.platform.model.Message;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;
import com.assist.platform.model.UserInfo;
import com.assist.platform.model.UserRank;
import com.assist.platform.service.UserService;

public class UserServiceTest {

	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			userService = (UserService) cxt.getBean("userService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		// User user = new User();
		// user.setLoginname("guest");
		// user.setUsername("访客");
		// user.setPassword("1");
		// user.setEmail("guest@adp.com");
		// user.setTel("123456789");
		// user.setCreatetime(new Date());
		// user.setScore("0");
		// user.setIsdel(MsgSign.NOT);
		// user.setIsadmin(UserType.ANONYMOUS);
		// Group group = new Group();
		// group.setGroupid(1);
		// user.setGroup(group);
		// UserRank userrank = new UserRank();
		// userrank.setRankid(1);
		// user.setUserrank(userrank);
		// UserInfo userinfo = new UserInfo();
		// userinfo.setUser(user);
		// userinfo.setSex(0);
		// userinfo.setConstellation("5");
		// userinfo.setZodiac("5");
		// userinfo.setQq("123456789");
		// user.setUserinfo(userinfo);
		// List<Role> roles = new ArrayList<Role>();
		// Role role = new Role();
		// role.setRoleid(1);
		// roles.add(role);
		//		user.setRoles(roles);
		//		userService.save(user);
		
		User user = new User();
		user.setLoginname("admin");
		user.setUsername("管理员");
		user.setPassword("admin");
		user.setEmail("admin@adp.com");
		user.setTel("123456789");
		user.setCreatetime(new Date());
		user.setScore("9999");
		user.setIsdel(MsgSign.NOT);
		user.setIsadmin(UserType.ADMINISTRATOR);
		Group group = new Group();
		group.setGroupid(1);
		user.setGroup(group);
		UserRank userrank = new UserRank();
		userrank.setRankid(1);
		user.setUserrank(userrank);
		UserInfo userinfo = new UserInfo();
		userinfo.setUser(user);
		userinfo.setSex(0);
		userinfo.setConstellation("3");
		userinfo.setZodiac("3");
		userinfo.setQq("123456789");
		user.setUserinfo(userinfo);
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setRoleid(99);
		roles.add(role);
		user.setRoles(roles);
		userService.save(user);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setUsername("xxxxxx");
		user.setPassword("xxxxxx");
		user.setEmail("xxxxxx");
		UserInfo userinfo = new UserInfo();
		userinfo.setQq("xxxxxx");
		user.setUserinfo(userinfo);
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setRoleid(3);
		roles.add(role);
		user.setRoles(roles);
		userService.update(3, user);
	}

	@Test
	public void testGetUser() {
		User user = userService.getById(101);
		System.out.println(user.getUserid() + " " + user.getUsername() + " "
				+ user.getRoles().get(0).getRolename());
		for (Message message : user.getMessages()) {
			System.out.println(message.getTitle());
		}
	}

	@Test
	public void testGetAllUser() {
		for (User user : userService.getAll()) {
			System.out.println(user.getUserid() + " " + user.getUsername());
		}
	}

	@Test
	public void testDelete() {
		userService.delete(3);
	}

	@Test
	public void testGetUserByLoginname() {
		System.out.println(userService.checkUser("test"));
	}

	@Test
	public void getUserByNamePwd() {
		System.out.println(userService.login("guest", "1"));
	}

	@Test
	public void getUserByNameEmail() {
		System.out.println(userService.forgetPwd("test", "测试用户",
				"test@test.com"));
	}
	
	@Test
	public void testCheck(){
		System.out.println(userService.checkUser("guest1"));
	}
	
	@Test
	public void test1() {
		String s = "test.com.assist.platform.service.User";
		String s1 = s.substring(s.lastIndexOf(".") + 1, s.length());
		System.out.println(s1);
	}
}

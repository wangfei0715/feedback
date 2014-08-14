package com.assist.platform.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.model.User;
import com.assist.platform.service.LogService;
import com.assist.platform.service.UserService;
import com.assist.platform.util.ConfigProperties;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private LogService logService;

	private User user;
	private String message;

	/**
	 * 登录
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String login() {
		User userinfo = null;
		if (null == user) {
			return "login";
		}
		if ("".equals(user.getLoginname()) || "".equals(user.getPassword())) {
			message = "* 请输入登录名称或登录密码";
			return "loginerror";
		}
		userinfo = userService.login(user.getLoginname(), user.getPassword());
		session.put("user", userinfo);
		if (userinfo == null) {
			message = "* 登录名称或登录密码输入错误";
			return "loginerror";
		} else {
			if (ConfigProperties.getInstance().isIslog() == true)
				logService.save(userinfo, "登录系统", "登录系统");
			return "login";
		}
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	public String logout() {
		if ((User) session.get("user") != null) {
			if (ConfigProperties.getInstance().isIslog() == true)
				logService.save((User) session.get("user"), "登出系统", "登出系统");
		}
		request.getSession().invalidate();
		return "logout";
	}

	public String sendMsg() {
		// response.setContentType("text/xml;charset=UTF-8");
		// response.setHeader("Cache-Control", "no-cache");
		// User user = (User) session.get("user");
		//
		// try {
		// receiveuser = URLDecoder.decode(receiveuser, "UTF-8");
		// title = URLDecoder.decode(title, "UTF-8");
		// content = URLDecoder.decode(content, "UTF-8");
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		//
		// xmlDoc = messageService.sendMsg(user.getUserid(), receiveuser, title,
		// content, showmobile);

		return "xml";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Group;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;
import com.assist.platform.model.UserInfo;
import com.assist.platform.service.GroupService;
import com.assist.platform.service.RoleService;
import com.assist.platform.service.UserService;
import com.assist.platform.util.ConfigProperties;
import com.assist.platform.util.XMLAdapter;

/**
 * 类说明: 用户控制类
 * 
 * @author 作者:王飞
 * @version
 */

@Controller
@Scope("prototype")
public class UserAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private GroupService groupService;

	private User user;
	private String message;
	private Integer userid;
	private String loginname;
	private String username;
	private String password;
	private String param;
	private String email;
	private Integer[] chk;
	private Integer chkid;

	private List<Group> grouplist;
	private List<Role> rolelist;
	private UserInfo userinfo;

	private Document xmlDoc;

	private String feedbackType;

	/**
	 * 分页属性
	 */
	private Pagination<User> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "manager/user_getUserList.action?page.currentPage=";

	public String getUserList() {
		pagination = userService.getUserListByPage(null,
				getPage(page, gotoPage));
		return "getUserList";
	}

	public String checkUser() {
		boolean result = userService.checkUser(param);
		if (result == true) {
			message = "n";
		} else {
			message = "y";
		}
		return "xmlstr";
	}

	public String checkPwd() {
		boolean result = userService.checkPwd(((User) session.get("user"))
				.getUserid(), param);
		if (result == true) {
			message = "y";
		} else {
			message = "n";
		}
		return "xmlstr";
	}

	/**
	 * 忘记密码
	 * 
	 * @return
	 */
	public String forgetpwd() {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		message = userService.forgetPwd(loginname, username, email);
		return "xmlstr";
	}

	public String save() {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		xmlDoc = userService.save(user);
		return "xml";
	}

	public String edit() {
		user = userService.getById(userid);
		rolelist = roleService.getAll();
		grouplist = groupService.getAll();
		return "edit";
	}

	public String editSelf() {
		user = userService.getById(((User) session.get("user")).getUserid());
		feedbackType = "10";
		// rolelist = roleService.getAll();
		// grouplist = groupService.getAll();
		return "editSelf";
	}

	public String viewInfo() {
		user = userService.getById(((User) session.get("user")).getUserid());
		rolelist = roleService.getAll();
		grouplist = groupService.getAll();
		return "viewInfo";
	}

	public String update() {
		userService.update(null, user);
		return "update";
	}

	public String updateSelf() {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		xmlDoc = userService.update(((User) session.get("user")).getUserid(),
				user);
		return "xml";
	}

	public String beforeSearch() {
		grouplist = groupService.getAll();
		return "beforeSearch";
	}

	public String search() {
		pagination = userService.search(user);
		return "search";
	}

	public String deleteAll() {
		for (Integer id : chk) {
			userService.delete(id);
		}
		return "delete";
	}

	public String delete() {
		userService.delete(chkid);
		return "delete";
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

	public Pagination<User> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<User> pagination) {
		this.pagination = pagination;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	public String getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(String pageinfo) {
		this.pageinfo = pageinfo;
	}

	public List<Group> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}

	public List<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}

	public UserInfo getUserInfo() {
		return userinfo;
	}

	public void setUserInfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Document getXmlDoc() {
		return xmlDoc;
	}

	public void setXmlDoc(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}

	public Integer[] getChk() {
		return chk;
	}

	public void setChk(Integer[] chk) {
		this.chk = chk;
	}

	public Integer getChkid() {
		return chkid;
	}

	public void setChkid(Integer chkid) {
		this.chkid = chkid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

}

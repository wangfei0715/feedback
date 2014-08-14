package com.assist.platform.web.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;

import com.assist.platform.model.Group;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;
import com.assist.platform.model.UserInfo;
import com.assist.platform.service.GroupService;
import com.assist.platform.service.RoleService;
import com.assist.platform.service.UserService;

/**
 * 类说明: 用户控制类
 * 
 * @author 作者:王飞
 * @version
 */

@Controller
@Scope("prototype")
public class UserTransferAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private GroupService groupService;

	private Connection connection;

	private User user;
	private String type;
	private String url;
	private String name;
	private String pwd;
	private String tablename;
	private Integer groupid;
	private Integer roleid;

	private String message;

	private List<Group> grouplist;
	private List<Role> rolelist;
	private UserInfo userinfo;

	private Document xmlDoc;

	public String input() {
		grouplist = groupService.getAll();
		rolelist = roleService.getAll();
		return "transferuser";
	}

	public String save() {
		try {
			connection(url, name, pwd);
			String sql = "select " + user.getLoginname() + ","
					+ user.getPassword() + "," + user.getUsername() + ","
					+ user.getScore() + "," + user.getTel() + ","
					+ user.getEmail() + " from " + tablename;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			int count1 = 0;
			int count2 = 0;
			while (resultSet.next()) {
				if (!userService.checkUser(resultSet.getString(1))) {
					User usernew = new User();
					Group group = new Group();
					group.setGroupid(groupid);
					usernew.setGroup(group);
					Role role = new Role();
					role.setRoleid(roleid);
					List<Role> rolelist = new ArrayList<Role>();
					rolelist.add(role);
					usernew.setRoles(rolelist);
					usernew.setLoginname(resultSet.getString(1));
					usernew.setPassword(resultSet.getString(2));
					usernew.setUsername(resultSet.getString(3));
					usernew.setTel(resultSet.getString(5));
					usernew.setEmail(resultSet.getString(6));

					userService.save(usernew);
					System.out.println("完成 " + ++count2);
				}
				++count1;
			}
			message = "本次更新" + count2 + "条/源数据库中共" + count1 + "条";
		} catch (ClassNotFoundException e) {
			message = "装载 JDBC/ODBC 驱动程序失败。";
			return "saveerror";
		} catch (SQLException e) {
			message = "无法连接数据库";
			return "saveerror";
		} catch (Exception e) {
			message = e.toString();
			return "saveerror";
		}
		return "save";
	}

	public void connection(String url, String name, String pass)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// url="jdbc:oracle:thin:@10.11.1.233:1521:aicmap";
		connection = DriverManager.getConnection(url, name, pass);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Document getXmlDoc() {
		return xmlDoc;
	}

	public void setXmlDoc(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

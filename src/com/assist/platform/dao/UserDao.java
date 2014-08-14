package com.assist.platform.dao;

import java.util.List;

import com.assist.platform.common.page.Page;
import com.assist.platform.model.Group;
import com.assist.platform.model.User;

public interface UserDao extends GenericDao<User, Integer> {

	/**
	 * 通过登录名验证用户是否存在
	 * 
	 * @param loginname
	 * @return
	 */
	public abstract User getUserByLoginname(String loginname);

	public abstract User getUserByNamePwd(String loginname, String pwd);

	public abstract User getUserByNameEmail(String username, String email);

	public abstract User getUserByNameEmail(String loginname, String username,
			String email);

	/**
	 * 取得用户列表分页
	 * 
	 * @param deptid
	 * @param page
	 * @return
	 */
	public List<User> getUserListByPage(Integer userid, final Page page);

	/**
	 * 取得用户列表总数
	 * 
	 * @param deptid
	 * @return 返回数据的总数
	 */
	public int getUserListCount(Integer userid);

	/**
	 * 查询用户
	 * 
	 * @param user
	 * @param group
	 * @return
	 */
	public abstract List<User> search(User user, Group group);
}

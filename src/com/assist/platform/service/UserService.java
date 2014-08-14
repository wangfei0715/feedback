package com.assist.platform.service;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.User;

public interface UserService extends GenericService<User, Integer> {

	/**
	 * 通过登录名验证用户是否存在
	 * 
	 * @param loginname
	 * @return
	 */
	public abstract boolean checkUser(String loginname);

	/**
	 * 验证用户密码是否正确
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public abstract boolean checkPwd(Integer userid, String password);

	/**
	 * 系统登录
	 * 
	 * @param loginname
	 * @param pwd
	 * @return
	 */
	public abstract User login(String loginname, String pwd);

	/**
	 * 忘记密码
	 * 
	 * @param loginname
	 * @param name
	 * @param email
	 * @return
	 */
	public abstract String forgetPwd(String loginname, String username,
			String email);

	/**
	 * 取得用户列表分页
	 * 
	 * @param deptid
	 * @param page
	 * @return
	 */
	public Pagination<User> getUserListByPage(Integer groupid, Page page);

	/**
	 * 查询用户
	 * 
	 * @param user
	 * @return
	 */
	public Pagination<User> search(User user);
}

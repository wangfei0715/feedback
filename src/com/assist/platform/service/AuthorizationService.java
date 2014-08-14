package com.assist.platform.service;

import com.assist.platform.model.User;

/**
 * 类说明: 权限控制接口
 * 
 * @author 作者:王飞
 * @version
 */
public interface AuthorizationService {

	/**
	 * 数据库查出权限
	 * 
	 * @param userid
	 * @param path
	 * @return
	 */
	public abstract boolean getAuth(Integer userid, String path);

	/**
	 * 缓存中取得权限<br>
	 * 用此方法时需要登录系统时事先将用户的Role,Func,加载进缓存中,或取消懒加载<br>
	 * 则系统中便可用此用户信息了<br>
	 * 否则初始化用户和取得用户权限不在一个事务中<br>
	 * 
	 * @param user
	 * @param path
	 * @return
	 */
	public abstract boolean getAuth(User user, String path);

}

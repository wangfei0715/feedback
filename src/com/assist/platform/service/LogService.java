package com.assist.platform.service;

import com.assist.platform.model.Log;
import com.assist.platform.model.User;

/**
 * 日志服务类
 * 
 * @author FLY
 * 
 */
public interface LogService extends GenericService<Log, Integer> {

	public abstract void save(User user, String title, String content);

}

package com.assist.platform.dao;

import java.util.List;

import com.assist.platform.common.page.Page;
import com.assist.platform.model.Log;

public interface LogDao extends GenericDao<Log, Integer> {

	public abstract List<Log> getListByPage(Integer userid, Page page);
	
	public abstract int getListCount(Integer userid);

}

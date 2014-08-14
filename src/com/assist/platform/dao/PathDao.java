package com.assist.platform.dao;

import com.assist.platform.model.Path;

/**
 * 类说明:页面路径DAO
 * 
 * @author 作者:王飞
 * @version
 */
public interface PathDao extends GenericDao<Path, Integer> {

	public abstract Path getPathByPathSign(String pathSign);
}

package com.assist.platform.common.page;

import java.util.List;

/**
 * 类说明: 分页结果集类
 * 
 * @author 作者:王飞
 * @version
 */
public class Pagination<T> {
	private Page page; // 分页信息
	private List<T> list; // 每页显示的集合

	// The default constructor
	public Pagination() {
	}

	// The constructor using fields
	public Pagination(Page page, List<T> list) {
		this.page = page;
		this.list = list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}

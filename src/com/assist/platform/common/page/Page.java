package com.assist.platform.common.page;

/**
 * 类说明: 分页属性类
 * 
 * @author 作者:王飞
 * @version
 */
public class Page {
	// 是否有上一页
	private boolean hasPrePage;

	// 是否有下一页
	private boolean hasNextPage;

	// 每页的数量
	private int everyPage;

	// 总页数
	private int totalPage;

	// 当前页
	private int currentPage;

	// 起始点
	private int beginIndex;

	// 总记录数
	private int totalCount;

	// The default constructor
	public Page() {
	}

	// construct the page by everyPage
	public Page(int everyPage) {
		this.everyPage = everyPage;
	}

	// The whole constructor
	public Page(boolean hasPrePage, boolean hasNextPage, int everyPage,
			int totalPage, int currentPage, int beginIndex, int totalCount) {
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
		this.everyPage = everyPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.totalCount = totalCount;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}

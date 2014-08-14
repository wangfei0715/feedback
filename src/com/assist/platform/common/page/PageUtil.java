package com.assist.platform.common.page;

/**
 * 类说明: 分页工具类
 * 
 * @author 作者:王飞
 * @version
 */
public class PageUtil {
	// Use the origin page to create a new page

	public static Page createPage(Page page, int totalRecords) {
		return createPage(page.getEveryPage(), page.getCurrentPage(),
				totalRecords);
	}

	// the basic page utils not including exception handler
	public static Page createPage(int everyPage, int currentPage,
			int totalRecords) {
		int totalPage = getTotalPage(everyPage, totalRecords);
		if (currentPage < 1)
			currentPage = 1;
		if (currentPage > totalPage)
			currentPage = totalPage;
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int beginIndex = getBeginIndex(everyPage, currentPage);

		boolean hasNextPage = hasNextPage(currentPage, totalPage);
		boolean hasPrePage = hasPrePage(currentPage);

		return new Page(hasPrePage, hasNextPage, everyPage, totalPage,
				currentPage, beginIndex, totalRecords);
	}

	private static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}

	private static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}

	private static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	private static int getTotalPage(int everyPage, int totalRecords) {
		int totalPage = 0;
		if (totalRecords % everyPage == 0)
			totalPage = totalRecords / everyPage;
		else
			totalPage = totalRecords / everyPage + 1;
		return totalPage;
	}

	private static boolean hasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	private static boolean hasNextPage(int currentPage, int totalPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}

}

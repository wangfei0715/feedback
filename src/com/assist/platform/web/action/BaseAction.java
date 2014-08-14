package com.assist.platform.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.util.ConfigProperties;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 类说明:Action基类,session,request,response接口
 * 
 * @author 作者:王飞
 * @version
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {
	@SuppressWarnings("unchecked")
	protected Map session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 分页
	 * 
	 * @param pagination
	 * @param gotoPage
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Page getPage(Pagination pagination, int gotoPage) {
		if (pagination == null) {
			pagination = new Pagination();
			Page page = new Page();
			page.setCurrentPage(1);
			pagination.setPage(page);
		}
		Page page = pagination.getPage();
		int currentPage = pagination.getPage().getCurrentPage();
		page.setEveryPage(ConfigProperties.getInstance().getEveryPage());
		if (gotoPage == 0) {
			page.setCurrentPage(currentPage);
		} else {
			page.setCurrentPage(gotoPage);
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	protected Page getPage(Page page, int gotoPage) {
		if (page == null) {
			page = new Page();
			page.setCurrentPage(1);
		}
		int currentPage = page.getCurrentPage();
		page.setEveryPage(ConfigProperties.getInstance().getEveryPage());
		if (gotoPage == 0) {
			page.setCurrentPage(currentPage);
		} else {
			page.setCurrentPage(gotoPage);
		}
		return page;
	}
}

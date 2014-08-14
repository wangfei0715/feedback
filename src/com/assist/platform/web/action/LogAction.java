package com.assist.platform.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Log;
import com.assist.platform.service.LogService;

@Controller
@Scope("prototype")
public class LogAction extends BaseAction {
	@Resource
	private LogService logService;

	private Integer[] chk;
	private Integer chkid;

	/**
	 * 分页属性
	 */
	private Pagination<Log> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "manager/log_getLogList.action?page.currentPage=";

	public String getLogList() {
		pagination = logService.getListByPage(getPage(page, gotoPage));
		return "getLogList";
	}

	public String deleteAll() {
		for (Integer id : chk) {
			logService.delete(id);
		}
		return "delete";
	}

	public String delete() {
		logService.delete(chkid);
		return "delete";
	}

	public Integer[] getChk() {
		return chk;
	}

	public void setChk(Integer[] chk) {
		this.chk = chk;
	}

	public Integer getChkid() {
		return chkid;
	}

	public void setChkid(Integer chkid) {
		this.chkid = chkid;
	}

	public Pagination<Log> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Log> pagination) {
		this.pagination = pagination;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	public String getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(String pageinfo) {
		this.pageinfo = pageinfo;
	}

}

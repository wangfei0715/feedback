package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Module;
import com.assist.platform.service.ModuleService;

@Controller
@Scope("prototype")
public class ModuleAction extends BaseAction {

	@Resource
	private ModuleService moduleService;

	private Integer[] chk;
	private Integer chkid;

	private List<Module> modulelist;
	private Module module;
	private Integer moduleid;

	/**
	 * 分页属性
	 */
	private Pagination<Module> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "manager/module_getModuleList.action?page.currentPage=";

	public String getModuleList() {
		pagination = moduleService.getListByPage(getPage(page, gotoPage));
		return "getModuleList";
	}

	public String add() {
		return "add";
	}

	public String save() {
		moduleService.save(module);
		return "save";
	}

	public String edit() {
		module = moduleService.getById(moduleid);
		return "edit";
	}

	public String update() {
		moduleService.update(null, module);
		return "update";
	}

	public String deleteAll() {
		for (Integer id : chk) {
			moduleService.delete(id);
		}
		return "delete";
	}

	public String delete() {
		moduleService.delete(chkid);
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

	public List<Module> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<Module> modulelist) {
		this.modulelist = modulelist;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Pagination<Module> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Module> pagination) {
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

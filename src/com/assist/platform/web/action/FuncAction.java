package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Func;
import com.assist.platform.model.Module;
import com.assist.platform.service.FuncService;
import com.assist.platform.service.ModuleService;

@Controller
@Scope("prototype")
public class FuncAction extends BaseAction {

	@Resource
	private FuncService funcService;
	
	@Resource
	private ModuleService moduleService;

	private Integer[] chk;
	private Integer chkid;

	private List<Module> modulelist;
	private Func func;
	private Integer funcid;

	/**
	 * 分页属性
	 */
	private Pagination<Func> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "manager/func_getFuncList.action?page.currentPage=";

	public String getFuncList() {
		pagination = funcService.getListByPage(getPage(page, gotoPage));
		return "getFuncList";
	}

	public String add() {
		modulelist = moduleService.getAll();
		return "add";
	}

	public String save() {
		funcService.save(func);
		return "save";
	}

	public String edit() {
		func = funcService.getById(funcid);
		modulelist = moduleService.getAll();
		return "edit";
	}

	public String update() {
		funcService.update(null, func);
		return "update";
	}

	public String deleteAll() {
		for (Integer id : chk) {
			funcService.delete(id);
		}
		return "delete";
	}

	public String delete() {
		funcService.delete(chkid);
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

	public Func getFunc() {
		return func;
	}

	public void setFunc(Func func) {
		this.func = func;
	}

	public Integer getFuncid() {
		return funcid;
	}

	public void setFuncid(Integer funcid) {
		this.funcid = funcid;
	}

	public Pagination<Func> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Func> pagination) {
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

package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Func;
import com.assist.platform.model.Group;
import com.assist.platform.model.Role;
import com.assist.platform.model.User;
import com.assist.platform.service.FuncService;
import com.assist.platform.service.GroupService;
import com.assist.platform.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction {
	@Resource
	private RoleService roleService;
	@Resource
	private GroupService groupService;
	@Resource
	private FuncService funcService;

	private Integer[] chk;
	private Integer chkid;

	private List<Role> rolelist;
	private List<Group> grouplist;
	private Role role;
	private Integer roleid;

	private List<Func> funclist;

	/**
	 * 分页属性
	 */
	private Pagination<Role> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "manager/role_getRoleList.action?page.currentPage=";

	public String getRoleList() {
		pagination = roleService.getListByPage(getPage(page, gotoPage));
		return "getRoleList";
	}

	public String add() {
		grouplist = groupService.getAll();
		rolelist = roleService.getAll();
		funclist = funcService.getAll();
		return "add";
	}

	public String save() {
		// 此处存操作用户的username
		role.setCreator(((User) session.get("user")).getUsername());
		roleService.save(role);
		return "save";
	}

	public String edit() {
		funclist = funcService.getAll();
		role = roleService.getById(roleid);
		grouplist = groupService.getAll();
		return "edit";
	}

	public String update() {
		roleService.update(((User) session.get("user")).getUserid(), role);
		return "update";
	}

	public String deleteAll() {
		for (Integer id : chk) {
			roleService.delete(id);
		}
		return "delete";
	}

	public String delete() {
		roleService.delete(chkid);
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

	public List<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}

	public List<Group> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public List<Func> getFunclist() {
		return funclist;
	}

	public void setFunclist(List<Func> funclist) {
		this.funclist = funclist;
	}

	public Pagination<Role> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Role> pagination) {
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

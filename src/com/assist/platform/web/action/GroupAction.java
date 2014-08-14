package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Group;
import com.assist.platform.service.GroupService;

@Controller
@Scope("prototype")
public class GroupAction extends BaseAction {

	@Resource
	private GroupService groupService;

	private Integer[] chk;
	private Integer chkid;

	private List<Group> grouplist;
	private Group group;
	private Integer groupid;

	/**
	 * 分页属性
	 */
	private Pagination<Group> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "manager/group_getGroupList.action?page.currentPage=";

	public String getGroupList() {
		pagination = groupService.getListByPage(getPage(page, gotoPage));
		return "getGroupList";
	}

	public String add() {
		grouplist = groupService.getAll();
		return "add";
	}

	public String save() {
		groupService.save(group);
		return "save";
	}

	public String edit() {
		group = groupService.getById(groupid);
		grouplist = groupService.getAll();
		return "edit";
	}

	public String update() {
		groupService.update(null, group);
		return "update";
	}

	public String deleteAll() {
		for (Integer id : chk) {
			groupService.delete(id);
		}
		return "delete";
	}

	public String delete() {
		groupService.delete(chkid);
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

	public List<Group> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Pagination<Group> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Group> pagination) {
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

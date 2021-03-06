package com.assist.platform.model;

import java.util.List;

/**
 * Group generated by MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer groupid;
	private String groupame;
	private String groupleader;
	private Integer parentid;
	private List<User> users;

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	public Group(Integer groupid, String groupame, String groupleader,
			Integer parentid, List<User> users) {
		this.groupid = groupid;
		this.groupame = groupame;
		this.groupleader = groupleader;
		this.parentid = parentid;
		this.users = users;
	}
	
	// Property accessors
	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getGroupame() {
		return this.groupame;
	}

	public void setGroupame(String groupame) {
		this.groupame = groupame;
	}

	public String getGroupleader() {
		return this.groupleader;
	}

	public void setGroupleader(String groupleader) {
		this.groupleader = groupleader;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
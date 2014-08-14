package com.assist.platform.model;

import java.util.List;

/**
 * UserRank generated by MyEclipse Persistence Tools
 */

public class UserRank implements java.io.Serializable {

	// Fields

	private Integer rankid;
	private String rankname;
	private String score;
	private Integer roleid;
	private List<User> users;

	// Constructors

	/** default constructor */
	public UserRank() {
	}

	/** full constructor */
	public UserRank(Integer rankid, String rankname, String score,
			Integer roleid, List<User> users) {
		this.rankid = rankid;
		this.rankname = rankname;
		this.score = score;
		this.roleid = roleid;
		this.users = users;
	}
	
	// Property accessors

	public Integer getRankid() {
		return this.rankid;
	}

	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}

	public String getRankname() {
		return this.rankname;
	}

	public void setRankname(String rankname) {
		this.rankname = rankname;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
package com.assist.platform.model;

import java.util.Date;

/**
 * Log generated by MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable {

	// Fields

	private Integer logid;
	private String operator;
	private String title;
	private String content;
	private Date logtime;
	private Integer moduleid;
	private Integer funcid;
	private Integer userid;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Integer userid, String operator, String title, String content,
			Date logtime, Integer moduleid, Integer funcid) {
		this.userid = userid;
		this.operator = operator;
		this.title = title;
		this.content = content;
		this.logtime = logtime;
		this.moduleid = moduleid;
		this.funcid = funcid;
	}

	// Property accessors

	public Integer getLogid() {
		return this.logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Integer getFuncid() {
		return this.funcid;
	}

	public void setFuncid(Integer funcid) {
		this.funcid = funcid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

}
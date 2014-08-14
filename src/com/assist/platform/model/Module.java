package com.assist.platform.model;

import java.util.List;

/**
 * Module generated by MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private Integer moduleid;
	private String modulename;
	private List<Func> funcs;

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** full constructor */
	public Module(Integer moduleid, String modulename, List<Func> funcs) {
		super();
		this.moduleid = moduleid;
		this.modulename = modulename;
		this.funcs = funcs;
	}

	// Property accessors

	public Integer getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public List<Func> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Func> funcs) {
		this.funcs = funcs;
	}

}
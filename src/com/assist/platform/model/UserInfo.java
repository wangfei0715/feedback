package com.assist.platform.model;

import java.util.Date;

/**
 * UserInfo generated by MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userinfoid;
	private User user;
	private Integer sex;
	private Date birthday;
	private String constellation;
	private String zodiac;
	private String qq;
	private String selfinfo;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(Integer userinfoid, User user, Integer sex, Date birthday,
			String constellation, String zodiac, String qq, String selfinfo) {
		this.userinfoid = userinfoid;
		this.user = user;
		this.sex = sex;
		this.birthday = birthday;
		this.constellation = constellation;
		this.zodiac = zodiac;
		this.qq = qq;
		this.selfinfo = selfinfo;
	}

	// Property accessors

	public Integer getUserinfoid() {
		return this.userinfoid;
	}

	public void setUserinfoid(Integer userinfoid) {
		this.userinfoid = userinfoid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getZodiac() {
		return zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSelfinfo() {
		return selfinfo;
	}

	public void setSelfinfo(String selfinfo) {
		this.selfinfo = selfinfo;
	}

}
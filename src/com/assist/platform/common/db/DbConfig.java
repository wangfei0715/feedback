package com.assist.platform.common.db;

import com.assist.platform.common.config.ConfigRdo;

/**
 * @author
 * @version 1.0
 */

public class DbConfig {
	private String driver;
	private String url;
	private String user;
	private String password;
	private ConfigRdo configrdo;
	private String conntype;
	private String poolname;

	/**
	 * 数据库信息构造函数 根据系统配置文件system.properties读出数据库的基本信息配置文件jdbc.properties
	 * 利用数据库配置信息文件jdbc.properties的信息实例化数据库信息实体
	 * 
	 * @throws DbException
	 */
	public DbConfig() throws Exception {
		try {
			configrdo = new ConfigRdo("db");
			init();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void init() throws Exception {
		try {
			this.setConntype(configrdo.getCfgInfo("conntype"));
		} catch (Exception e) {
			throw new Exception(e);
		}

		try {
			this.setDriver(configrdo.getCfgInfo("driver"));
		} catch (Exception e) {
			throw new Exception(e);
		}
		try {
			this.setPassword(configrdo.getCfgInfo("password"));
		} catch (Exception e) {
			throw new Exception(e);
		}
		try {
			this.setUrl(configrdo.getCfgInfo("url"));
		} catch (Exception e) {
			throw new Exception(e);
		}
		try {
			this.setUser(configrdo.getCfgInfo("user"));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConntype() {
		return conntype;
	}

	public void setConntype(String conntype) {
		this.conntype = conntype;
	}

	public String getPoolname() {
		return poolname;
	}

	public void setPoolname(String poolname) {
		this.poolname = poolname;
	}

	public static void main(String[] s) {
		try {
			DbConfig dc = new DbConfig();
			System.out.println(dc.getConntype());
			System.out.println(dc.getDriver());
			System.out.println(dc.getPassword());
			System.out.println(dc.getUrl());
		} catch (Exception e) {
		}
	}
}

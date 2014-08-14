package com.assist.platform.util;

import com.assist.platform.common.config.ConfigRdo;

/**
 * 类说明: 配置文件类
 */
public class ConfigProperties {
	private int everyPage;
	private String smb;

	private boolean isdebug = false;

	private boolean islog = false;

	private ConfigRdo configrdo;

	private static ConfigProperties instance = null;

	private ConfigProperties() throws Exception {
		try {
			configrdo = new ConfigRdo("config");
			init();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void init() throws Exception {
		try {
			this.setEveryPage(Integer.parseInt(configrdo
					.getCfgInfo("everyPage")));
			this.setSmb(configrdo.getCfgInfo("smb"));
			String isdebug = configrdo.getCfgInfo("isdebug");
			if ("true".equals(isdebug)) {
				this.setIsdebug(true);
			} else {
				this.setIsdebug(false);
			}
			String islog = configrdo.getCfgInfo("islog");
			if ("true".equals(islog)) {
				this.setIslog(true);
			} else {
				this.setIslog(false);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static synchronized ConfigProperties getInstance() {
		if (instance == null)
			try {
				instance = new ConfigProperties();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return instance;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public String getSmb() {
		return smb;
	}

	public void setSmb(String smb) {
		this.smb = smb;
	}

	public ConfigRdo getConfigrdo() {
		return configrdo;
	}

	public void setConfigrdo(ConfigRdo configrdo) {
		this.configrdo = configrdo;
	}

	public boolean isIsdebug() {
		return isdebug;
	}

	public void setIsdebug(boolean isdebug) {
		this.isdebug = isdebug;
	}

	public boolean isIslog() {
		return islog;
	}

	public void setIslog(boolean islog) {
		this.islog = islog;
	}

}

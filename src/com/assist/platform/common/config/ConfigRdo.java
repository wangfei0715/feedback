package com.assist.platform.common.config;

import java.util.ResourceBundle;

public class ConfigRdo {

	/* 系统资源 */
	private ResourceBundle resources;
	private String propertiesFile;

	/**
	 * 构造函数，获取默认的系统配置文件
	 */
	@SuppressWarnings("unused")
	private ConfigRdo() {
	}

	/**
	 * 构造函数，根据输入的配置文件名获取系统的配置文件
	 * 
	 * @param fileName:配置文件名称
	 */
	public ConfigRdo(String fileName) throws Exception {
		try {
			resources = java.util.ResourceBundle.getBundle(fileName);
			propertiesFile = fileName + ".properties";
		} catch (Exception mre) {
			throw new Exception("没有发现:" + fileName + ".properties 配置文件");
		}
	}

	/**
	 * 获取系统的资源信息
	 * 
	 * @return ：返回系统资源对象
	 */
	@SuppressWarnings("unused")
	private ResourceBundle getRes() {
		return resources;
	}

	public String getCfgInfo(String name) throws Exception {
		String retval = null;
		try {
			byte[] value = resources.getString(name).getBytes("iso8859-1");
			retval = new String(value);
		} catch (Exception e) {
			throw new Exception("取配置文件:" + propertiesFile + ".properties中的项目名"
					+ name + " 时出错");
		}
		return retval;
	}

	public String getPropertiesFile() {
		return propertiesFile;
	}

	public static void main(String[] s) {
		try {
			ConfigRdo cf = new ConfigRdo("config");
			System.out.println("" + cf.getCfgInfo("realfiledir"));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}

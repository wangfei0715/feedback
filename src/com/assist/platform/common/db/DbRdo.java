package com.assist.platform.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbRdo {

	// private Connection connection;
	private DbConfig dbconfig;
	private Connection conn;

	public DbRdo() throws Exception {
		dbconfig = new DbConfig();
	}

	/**
	 * 获取数据库的连接,数据库的配置信息由配置文件读取
	 * 
	 * @return 数据库的连接
	 * @throws DbException
	 *             有异常时将异常抛出
	 */
	public Connection getConnection() throws Exception {
		try {
			if (dbconfig.getConntype().equalsIgnoreCase("jdbc")) {
				Class.forName(dbconfig.getDriver());
				conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig
						.getUser(), dbconfig.getPassword());
			} else if (dbconfig.getConntype().equalsIgnoreCase("dbpool")) {
				Context env = new InitialContext();
				DataSource pool = (DataSource) env.lookup(dbconfig
						.getPoolname());
				if (pool == null)
					throw new Exception(dbconfig.getPoolname()
							+ " is an unknown DataSource");
				conn = pool.getConnection();
			} else {
				Class.forName(dbconfig.getDriver());
				conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig
						.getUser(), dbconfig.getPassword());
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return conn;
	}

	/**
	 * 关闭打开的数据库连接
	 * 
	 * @return 成功与失败
	 * @throws DbException
	 *             有异常时将异常抛出
	 */
	public boolean closeConnection() throws Exception {
		@SuppressWarnings("unused")
		boolean ret = false;
		try {
			if (conn != null)
				conn.close();
			return true;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new Exception(e);
			}
		}
	}

	public DbConfig getDbinfo() {
		return dbconfig;
	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			DbRdo dr = new DbRdo();
			conn = dr.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from test");
			while (rs.next()) {
				System.out.println("the name is :" + rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}

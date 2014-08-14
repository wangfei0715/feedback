package com.assist.platform.common.db;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 类说明: 扩展hibernate3让其支持MySQL的text类型
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 28, 2011 1:34:16 AM
 */

public class MYSQLDialect extends MySQL5InnoDBDialect {
	public MYSQLDialect() {
		super();
		registerHibernateType(Types.DECIMAL, Hibernate.BIG_DECIMAL.getName());
		registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
	}
}
package com.assist.platform.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *	类说明:
 *
 *	@author 作者:王飞
 * 	@version
 * 	@copyright 
 *	Jun 30, 2011 5:07:00 PM
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserOperateLog {
	/**
	 * 用户操作名称
	 * @return 用户操作名称，默认为空串
	 */
	String value() default "";
	
	/**
	 * 用户操作类型，默认类型为0<br/>
	 * 0 - 其他操作 <br/>
	 * 1 - 查询 <br/>
	 * 2 - 新增 <br/>
	 * 3 - 修改 <br/>
	 * 4 - 删除
	 * @return 用户操作类型
	 */
	int type() default 0;
	
	/**
	 * 用户操作名称对应的key,可以通过该key值在属性文件中查找对应的value
	 * @return key
	 */
	String key() default "";
}


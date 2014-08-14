package com.assist.platform.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录控制权限拦截
 * 
 * @author FLY
 * 
 */
public class LoginAuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3363926000416510686L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// System.out.println("LoginAuthorityInterceptor");
		@SuppressWarnings("unused")
		ActionContext act = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) act
				.get(StrutsStatics.HTTP_REQUEST);
		// String uri = request.getRequestURI();
		// if(null != uri && uri.indexOf("common/redirect_")!= -1){
		// return invocation.invoke();
		//		}
		
		Map map = invocation.getInvocationContext().getSession();// 获取session映射

		if (null == map.get("user")) {// 如果未登陆转到登陆页
			return "notlogin";
		} else {
			return invocation.invoke();// 如果登陆继续执行
		}
	}

}

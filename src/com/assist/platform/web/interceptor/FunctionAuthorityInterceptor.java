package com.assist.platform.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.assist.platform.common.constant.UserType;
import com.assist.platform.model.User;
import com.assist.platform.service.AuthorizationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 功能控制权限拦截
 * 
 * @author FLY
 * 
 */
public class FunctionAuthorityInterceptor extends AbstractInterceptor {
	@Resource
	private AuthorizationService authorizationService;

	private static final long serialVersionUID = 4102209009950426410L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// System.out.println("FunctionAuthorityInterceptor");
		ActionContext act = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) act
				.get(StrutsStatics.HTTP_REQUEST);
		User user = (User) act.getSession().get("user");
		String uri = request.getRequestURI();

		// if(null != uri && uri.indexOf("common/redirect_")!= -1){
		// return invocation.invoke();
		// }

		// 匿名用户或管理员不进行权限验证
		if (UserType.ANONYMOUS == user.getIsadmin()
				|| UserType.ADMINISTRATOR == user.getIsadmin()) {
			return invocation.invoke();
		}

		boolean result = authorizationService.getAuth(user.getUserid(), uri);
		// System.out.println(result);
		if (result) {
			return invocation.invoke();
		} else {
			return "notauth";
		}

	}

}

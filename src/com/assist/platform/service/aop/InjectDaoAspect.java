package com.assist.platform.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.assist.platform.service.impl.GenericServiceImpl;
import com.assist.platform.util.ConfigProperties;

/**
 * DAO资源注入切面
 */
@Component
@Aspect
public class InjectDaoAspect {

	// 声明一个切入点
	@SuppressWarnings("unused")
	@Pointcut("execution (* com.assist.platform.service.impl..*.*(..))")
	private void injectDaoMethod() {
	}

	@Before("injectDaoMethod()")
	public void injectDaoStart(JoinPoint joinPoint) {
		boolean isDebug = ConfigProperties.getInstance().isIsdebug();
		Object obj = joinPoint.getTarget();
		if (obj instanceof GenericServiceImpl) {
			GenericServiceImpl gs = (GenericServiceImpl) obj;
			gs.injectDao();
			if (isDebug)
				System.out.println("InjectDaoAspect: " + gs.getClass()
						+ " 中注入DAO");
		}
	}

}

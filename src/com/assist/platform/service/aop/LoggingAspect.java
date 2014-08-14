package com.assist.platform.service.aop;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.assist.platform.common.annotation.UserOperateLog;
import com.assist.platform.common.log.ArgsLogger;
import com.assist.platform.service.LogService;
import com.assist.platform.util.ConfigProperties;

/**
 * 类说明: 日志管理切面
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 30, 2011 4:22:38 PM
 */
@Component
@Aspect
public class LoggingAspect {

	private Logger logger;// 日志句柄

	private String loggerName;// 日志名称

	private Properties properties;// 属性文件句柄

	@javax.annotation.Resource
	private LogService logService;

	@javax.annotation.Resource
	private ArgsLogger argsLogger;

	// 声明一个切入点
	@Pointcut("execution (* com.assist.platform.service.impl..*.*(..))")
	private void servicePointCut() {
	}

	@Around("servicePointCut()")
	public Object serviceAdvice(ProceedingJoinPoint pjp) throws Throwable {
		boolean isDebug = ConfigProperties.getInstance().isIsdebug();

		Object result = null;
		String operationMethodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		if (isDebug) {
			System.out.println("LoggingAspect: " + className + " 类 "
					+ operationMethodName + " 方法" + " 开始");
			argsLogger.debug(pjp.getArgs(), operationMethodName);
		}
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			if (isDebug)
				System.out.println("LoggingAspect: " + className + " 类 "
						+ operationMethodName + " 方法" + " 异常");
			throw e;
		}
		if (isDebug)
			System.out.println("LoggingAspect: " + className + " 类 "
					+ operationMethodName + " 方法" + " 完成");
		return result;
	}

	/**
	 * To get the target class
	 * 
	 * @param pjp
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Class getTargetClass(ProceedingJoinPoint pjp)
			throws ClassNotFoundException {
		String classname = pjp.getTarget().getClass().toString().substring(6);
		Class cls = Class.forName(classname);
		return cls;
	}

	/**
	 * To get the methods of the target class
	 * 
	 * @param pjp
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Method[] getTargetMethods(ProceedingJoinPoint pjp)
			throws ClassNotFoundException {
		Class cls = this.getTargetClass(pjp);
		Method[] methods = cls.getMethods();
		return methods;
	}

	public int getOperaType(String methodName) {
		int type = 0;
		if (methodName.startsWith("save") || methodName.startsWith("add")
				|| methodName.startsWith("insert")
				|| methodName.startsWith("update")) {
			type = 1;
		} else if (methodName.startsWith("delete")
				|| methodName.startsWith("del")) {
			type = 2;
		}
		return type;
	}

	/**
	 * 描述 : <该方法用于初始化属性文件>. <br>
	 * <p>
	 * 日志内容可以预先配置在配置文件中，在需要打印日志时从配置文件中找到对应的值。 这里是做扩展使用，读者可以根据实际情况进行设计
	 * 
	 * @param propertiesFilePath
	 * @throws IOException
	 */
	public void setPropertiesFilePath(Resource propertiesFilePath)
			throws IOException {
		if (properties == null)
			properties = new Properties();
		properties.load(new FileInputStream(propertiesFilePath.getFile()));
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		String username = "未知";
		for (Object object : args) {
			// 这里只提供一种获得操作人的方式，既从HttpSession中获取，但这要求方法参数中包含HttpSession
			if (object instanceof HttpSession) {
				username = ((HttpSession) object).getAttribute("username") == null ? "未知"
						: (String) ((HttpSession) object)
								.getAttribute("username");
			}
		}
		// 判断方法是否注解了UserOperateLog
		UserOperateLog anno = method.getAnnotation(UserOperateLog.class);
		if (anno == null)
			return;

		String defaultMessage = anno.value();
		String methodName = target.getClass().getName() + "."
				+ method.getName();
		String desc = this.handleDescription(anno.key(), StringUtils
				.hasText(defaultMessage) ? defaultMessage : methodName);
		// 装配日志信息
		String logline = this.buildLogLine(username, anno.type(), desc);

		logger.info(logline);
	}

	/**
	 * 构建日志行
	 * 
	 * @param usrname
	 *            用户名称
	 * @param operateType
	 *            操作类型
	 * @param description
	 *            操作描述
	 * @return 日志行： username - operateType - description
	 */
	protected String buildLogLine(String username, int operateType,
			String description) {
		StringBuilder sb = new StringBuilder();
		sb.append(username).append(" - ").append(operateType).append(" - ")
				.append(description);
		return sb.toString();
	}

	/**
	 * 获取日志内容描述，可以从消息配置文件中找到对应的信息
	 * 
	 * @param key
	 *            日志内容key
	 * @param defaultMessage
	 *            默认的描述信息
	 * @return 描述信息
	 */
	protected String handleDescription(String key, String defaultMessage) {
		if (properties == null)
			return defaultMessage;
		if (!StringUtils.hasText(key))
			return defaultMessage;
		String message = properties.getProperty(key);
		if (!StringUtils.hasText(message))
			return defaultMessage;
		else
			return message;
	}

	// @PostConstruct
	public void init() {
		Assert.notNull(loggerName);
		logger = Logger.getLogger(loggerName);
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

}

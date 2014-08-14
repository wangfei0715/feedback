package com.assist.platform.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jun 30, 2011 4:36:12 PM
 */
@Component
public class ArgsLogger {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ArgsLogger.class);

	public void debug(Object[] args, String operationMethodName) {

		if (logger.isDebugEnabled()) {
			logger.debug(getArgsInfo(args, operationMethodName));
		}
	}

	public void error(Object[] args, String operationMethodName) {
		if (logger.isErrorEnabled()) {
			logger.error(getArgsInfo(args, operationMethodName));
		}

	}

	private StringBuffer getArgsInfo(Object[] args, String operationMethodName) {
		StringBuffer argsBuffer = new StringBuffer();
		argsBuffer.append("\nprinting the Args of " + operationMethodName
				+ "(..):\n");
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			argsBuffer.append("args[" + i + "]='").append(arg).append("'\n");
		}
		return argsBuffer;
	}

}

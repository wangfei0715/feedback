package com.assist.platform.common.constant;

/**
 *	类说明: 状态枚举
 *
 *	@author 作者:王飞
 * 	@version
 * 	@copyright 
 *	Jun 27, 2011 7:02:01 PM
 */

/**
 * 建议状态
 */
public enum MsgStatusEnum {
	MsgUnReply(1), MsgPartReply(2), MsgReplied(3), MsgIgnored(4);

	private final int status;

	private MsgStatusEnum(int status) {
		this.status = status;
	}
	
	public int getValue(){
		return status;
	}
	
	public static void main(String[] args) {
		System.out.println(MsgStatusEnum.MsgReplied.getValue());
	}
}

/**
 * 信息类型
 */
enum MsgTypeEnum {
	Question(1), Suggestion(2);

	private final int type;

	private MsgTypeEnum(int type) {
		this.type = type;
	}
}

/**
 * 信息标志
 */
enum MsgSignEnum {
	/**
	 * 未被
	 */
	Not(0),

	/**
	 * 已被
	 */
	Yes(1);

	private final int sign;

	private MsgSignEnum(int sign) {
		this.sign = sign;
	}
}


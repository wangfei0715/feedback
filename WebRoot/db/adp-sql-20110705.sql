/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50142
Source Host           : localhost:3306
Source Database       : feedback

Target Server Type    : MYSQL
Target Server Version : 50142
File Encoding         : 65001

Date: 2011-07-05 05:01:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `adp_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `adp_catalog`;
CREATE TABLE `adp_catalog` (
  `catalogid` int(11) NOT NULL AUTO_INCREMENT,
  `catalogname` varchar(30) DEFAULT NULL,
  `cataloginfo` varchar(200) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_catalog
-- ----------------------------
INSERT INTO `adp_catalog` VALUES ('1', '助益数据质量', '助益数据质量', null);
INSERT INTO `adp_catalog` VALUES ('2', '反馈平台', '反馈平台', null);

-- ----------------------------
-- Table structure for `adp_favorite`
-- ----------------------------
DROP TABLE IF EXISTS `adp_favorite`;
CREATE TABLE `adp_favorite` (
  `favoriteid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `messageid` int(11) DEFAULT NULL,
  PRIMARY KEY (`favoriteid`),
  KEY `FK_Favorite_Message` (`messageid`),
  KEY `FK_Favorite_User` (`userid`),
  CONSTRAINT `FK_Favorite_Message` FOREIGN KEY (`messageid`) REFERENCES `adp_message` (`messageid`),
  CONSTRAINT `FK_Favorite_User` FOREIGN KEY (`userid`) REFERENCES `adp_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_func`
-- ----------------------------
DROP TABLE IF EXISTS `adp_func`;
CREATE TABLE `adp_func` (
  `funcid` int(11) NOT NULL AUTO_INCREMENT,
  `funcname` varchar(50) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  `moduleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`funcid`),
  KEY `FK_Func_Module` (`moduleid`),
  CONSTRAINT `FK_Func_Module` FOREIGN KEY (`moduleid`) REFERENCES `adp_module` (`moduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_func
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_group`
-- ----------------------------
DROP TABLE IF EXISTS `adp_group`;
CREATE TABLE `adp_group` (
  `groupid` int(11) NOT NULL AUTO_INCREMENT,
  `groupame` varchar(50) DEFAULT NULL,
  `groupleader` varchar(50) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_group
-- ----------------------------
INSERT INTO `adp_group` VALUES ('1', '一般用户', null, null);
INSERT INTO `adp_group` VALUES ('2', '开发人员', null, null);
INSERT INTO `adp_group` VALUES ('3', '高级会员', null, null);

-- ----------------------------
-- Table structure for `adp_log`
-- ----------------------------
DROP TABLE IF EXISTS `adp_log`;
CREATE TABLE `adp_log` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `logtime` datetime DEFAULT NULL,
  `moduleid` int(11) DEFAULT NULL,
  `funcid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`logid`),
  KEY `FK_Log_User` (`userid`),
  CONSTRAINT `FK_Log_User` FOREIGN KEY (`userid`) REFERENCES `adp_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_log
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_message`
-- ----------------------------
DROP TABLE IF EXISTS `adp_message`;
CREATE TABLE `adp_message` (
  `messageid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `replytime` datetime DEFAULT NULL,
  `istop` int(11) DEFAULT NULL,
  `checked` int(11) DEFAULT NULL,
  `isdel` int(11) DEFAULT NULL,
  `recommend` int(11) DEFAULT NULL,
  `catalogid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`messageid`),
  KEY `FK_Message_Catalog` (`catalogid`),
  KEY `FK_Message_User` (`userid`),
  CONSTRAINT `FK_Message_Catalog` FOREIGN KEY (`catalogid`) REFERENCES `adp_catalog` (`catalogid`),
  CONSTRAINT `FK_Message_User` FOREIGN KEY (`userid`) REFERENCES `adp_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_message
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_module`
-- ----------------------------
DROP TABLE IF EXISTS `adp_module`;
CREATE TABLE `adp_module` (
  `moduleid` int(11) NOT NULL AUTO_INCREMENT,
  `modulename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`moduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_module
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_path`
-- ----------------------------
DROP TABLE IF EXISTS `adp_path`;
CREATE TABLE `adp_path` (
  `pathid` int(11) NOT NULL AUTO_INCREMENT,
  `pathname` varchar(50) DEFAULT NULL,
  `pathurl` varchar(200) DEFAULT NULL,
  `actionname` varchar(200) DEFAULT NULL,
  `pathinfo` varchar(200) DEFAULT NULL,
  `pathsign` varchar(50) DEFAULT NULL,
  `resultname` varchar(50) DEFAULT NULL,
  `funcid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pathid`),
  KEY `FK_Path_Func` (`funcid`),
  CONSTRAINT `FK_Path_Func` FOREIGN KEY (`funcid`) REFERENCES `adp_func` (`funcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_path
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_reply`
-- ----------------------------
DROP TABLE IF EXISTS `adp_reply`;
CREATE TABLE `adp_reply` (
  `replyid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `replytime` datetime DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `messageid` int(11) DEFAULT NULL,
  PRIMARY KEY (`replyid`),
  KEY `FK_Message_Reply` (`messageid`),
  KEY `FK_Reply_User` (`userid`),
  CONSTRAINT `FK_Message_Reply` FOREIGN KEY (`messageid`) REFERENCES `adp_message` (`messageid`),
  CONSTRAINT `FK_Reply_User` FOREIGN KEY (`userid`) REFERENCES `adp_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_role`
-- ----------------------------
DROP TABLE IF EXISTS `adp_role`;
CREATE TABLE `adp_role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(30) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `funcid` int(11) DEFAULT NULL,
  `groupid` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_role
-- ----------------------------
INSERT INTO `adp_role` VALUES ('1', '匿名用户', '2011-06-27 23:18:57', '管理员', null, null);
INSERT INTO `adp_role` VALUES ('2', '普通用户', '2011-06-27 23:16:50', '管理员', null, null);
INSERT INTO `adp_role` VALUES ('3', '中级用户', '2011-06-28 04:01:56', '管理员', null, null);
INSERT INTO `adp_role` VALUES ('4', '高级用户', '2011-06-28 04:01:53', '管理员', null, null);
INSERT INTO `adp_role` VALUES ('99', '管理员', '2011-06-27 23:18:26', '管理员', null, null);

-- ----------------------------
-- Table structure for `adp_rolefunc`
-- ----------------------------
DROP TABLE IF EXISTS `adp_rolefunc`;
CREATE TABLE `adp_rolefunc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `funcid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Rolefunc_Func` (`funcid`),
  KEY `FK_Rolefunc_Role` (`roleid`),
  CONSTRAINT `FK_Rolefunc_Func` FOREIGN KEY (`funcid`) REFERENCES `adp_func` (`funcid`),
  CONSTRAINT `FK_Rolefunc_Role` FOREIGN KEY (`roleid`) REFERENCES `adp_role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_rolefunc
-- ----------------------------

-- ----------------------------
-- Table structure for `adp_user`
-- ----------------------------
DROP TABLE IF EXISTS `adp_user`;
CREATE TABLE `adp_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(30) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `score` varchar(20) DEFAULT NULL,
  `isadmin` int(11) DEFAULT NULL,
  `isdel` int(11) DEFAULT NULL,
  `rankid` int(11) DEFAULT NULL,
  `groupid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `FK_User_Group` (`groupid`),
  KEY `FK_User_Rank` (`rankid`),
  CONSTRAINT `FK_User_Group` FOREIGN KEY (`groupid`) REFERENCES `adp_group` (`groupid`),
  CONSTRAINT `FK_User_Rank` FOREIGN KEY (`rankid`) REFERENCES `adp_userrank` (`rankid`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_user
-- ----------------------------
INSERT INTO `adp_user` VALUES ('101', 'guest', '访客', 'guest', 'guest@adp.com', '123456789', '2011-06-28 04:18:43', '0', '1', '0', '1', '1');
INSERT INTO `adp_user` VALUES ('102', 'admin', '管理员', 'admin', 'admin@adp.com', '123456789', '2011-07-03 00:16:58', '9999', '99', '0', '1', '1');
INSERT INTO `adp_user` VALUES ('103', 'nomal', '普通用户', '111111', 'nomal@adp.com', '13611111111', '2011-07-04 05:27:31', '0', '2', '0', '1', '1');

-- ----------------------------
-- Table structure for `adp_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `adp_userinfo`;
CREATE TABLE `adp_userinfo` (
  `userinfoid` int(11) NOT NULL AUTO_INCREMENT,
  `sex` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `constellation` varchar(10) DEFAULT NULL,
  `zodiac` varchar(6) DEFAULT NULL,
  `qq` varchar(16) DEFAULT NULL,
  `selfinfo` varchar(500) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userinfoid`),
  KEY `FK_Userinfo_User` (`userid`),
  CONSTRAINT `FK_Userinfo_User` FOREIGN KEY (`userid`) REFERENCES `adp_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_userinfo
-- ----------------------------
INSERT INTO `adp_userinfo` VALUES ('4', '0', '2011-07-04', '5', '5', '123456789', null, '101');
INSERT INTO `adp_userinfo` VALUES ('5', '1', '2011-07-05', '6', '3', '123456789', '我就是我', '102');
INSERT INTO `adp_userinfo` VALUES ('6', '1', '2011-07-05', '2', '2', '21123123123123', '啊哈', '103');

-- ----------------------------
-- Table structure for `adp_userrank`
-- ----------------------------
DROP TABLE IF EXISTS `adp_userrank`;
CREATE TABLE `adp_userrank` (
  `rankid` int(11) NOT NULL AUTO_INCREMENT,
  `rankname` varchar(50) DEFAULT NULL,
  `score` varchar(20) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rankid`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_userrank
-- ----------------------------
INSERT INTO `adp_userrank` VALUES ('1', '匿名用户', '-1', null);
INSERT INTO `adp_userrank` VALUES ('2', '普通用户', '0', null);
INSERT INTO `adp_userrank` VALUES ('3', '中级用户', '100', null);
INSERT INTO `adp_userrank` VALUES ('4', '高级用户', '1000', null);
INSERT INTO `adp_userrank` VALUES ('99', '管理员', '9999', null);

-- ----------------------------
-- Table structure for `adp_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `adp_userrole`;
CREATE TABLE `adp_userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Userrole_Role` (`roleid`),
  KEY `FK_Userrole_User` (`userid`),
  CONSTRAINT `FK_Userrole_Role` FOREIGN KEY (`roleid`) REFERENCES `adp_role` (`roleid`),
  CONSTRAINT `FK_Userrole_User` FOREIGN KEY (`userid`) REFERENCES `adp_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adp_userrole
-- ----------------------------
INSERT INTO `adp_userrole` VALUES ('10', '101', '1');
INSERT INTO `adp_userrole` VALUES ('11', '102', '99');
INSERT INTO `adp_userrole` VALUES ('12', '103', '1');

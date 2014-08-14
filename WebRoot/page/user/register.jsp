<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ADP反馈中心-用户注册</title>
		<link type="text/css" rel="stylesheet" href="common/css/login.css" />
		<link type="text/css" rel="stylesheet" href="common/css/register.css" />
		<style type="text/css">
		#registerdiv {
			width: 650px;
			margin: 15px auto;
			padding: 20px;
			text-align: center;
			border: 1px solid #A4CDF2;
		}
		</style>
		<script src="common/js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript" src="common/js/plugin/validform.js"></script>
		<script type="text/javascript">
		$(function(){
			$(".registerform:last").Validform({
				tiptype:2, // 1为弹窗，2为右侧提示
				ajaxurl:"<%=path %>/manager/ajax_save.action",
				callback:function(data){
					var result = $(data).find("result");
					var msg = result.attr("msg");
					var status = result.attr("status");
					if(status=="1"){
						$.Hidemsg();
						$.Showmsg(msg+"! 请重新登录,5秒后页面自动跳转...");
						setTimeout(function(){
							location.href="logout.action";  
						},6000);
					}else{
						$.Hidemsg();
						$.Showmsg(msg);
						setTimeout(function(){
							$.Hidemsg(); //公用方法关闭信息提示框;
						},2000);
					}
				}
			});
				
			//调取公用方法显示信息提示框，可用于全站统一的弹出框提示效果;
			$.Showmsg("欢迎您注册!");  //公用方法显示信息提示框;
			setTimeout(function(){
				$.Hidemsg(); //公用方法关闭信息提示框;
			},2000);
		})
		</script>
	</head>
	<body>
		<h3>
		未注册创建帐户
		</h3>
		<div  id="registerdiv">
		<fieldset>
		<legend>
			用户注册
		</legend>
		<p>
			<strong>您的电子邮箱不会被公布出去,但是必须填写,找回密码时为必填项.</strong>
		</p>
		<p>
			在您注册之前请先认真阅读服务条款.
		</p>
		<form class="registerform" action="<%=basePath%>manager/user_save.adp" method="post">
	    <table width="100%" style="table-layout:fixed;">
	        <tr>
	            <td class="need" style="width:10px;">*</td>
	            <td style="width:80px;">用户名：</td>
	            <td style="width:205px;"><input type="text" value="" name="user.loginname" class="inputxt" datatype="s5-18" ajaxurl="<%=path %>/manager/ajax_checkUser.action" nullmsg="请输入用户名！" errormsg="用户名至少5个字符,最多18个字符！" /></td>
	            <td><div class="Validform_checktip">用户名至少5个字符,最多18个字符</div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;">*</td>
	            <td style="width:80px;">昵称：</td>
	            <td style="width:205px;"><input type="text" value="" name="user.username" class="inputxt" datatype="*" nullmsg="请输入昵称！" errormsg="昵称不能为空！" /></td>
	            <td><div class="Validform_checktip">昵称不能为空</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>密码：</td>
	            <td><input type="password" value="" id="userpassword" name="user.password" class="inputxt" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间,不能使用空格！" /></td>
	            <td><div class="Validform_checktip">密码范围在6~16位之间,不能使用空格</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>确认密码：</td>
	            <td><input type="password" value="" name="userpassword2" class="inputxt" datatype="*" recheck="userpassword" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" /></td>
	            <td><div class="Validform_checktip">两次输入密码需一致</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>Email：</td>
	            <td><input type="text" value="" name="user.email" class="inputxt" datatype="e" nullmsg="请输入您常用的邮箱！" errormsg="请输入您常用的邮箱！" /></td>
	            <td><div class="Validform_checktip">请输入您常用的邮箱</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>同意服务条款</td>
	            <td><input name="serviceitem" id="serviceitem" type="checkbox"  value="1" datatype="checkbox" errormsg="您是否同意服务条款" /></td>
	            <td><div class="Validform_checktip">您是否同意服务条款</div></td>
	        </tr>
	        
	        <tr>
	            <td class="need"></td>
	            <td></td>
	            <td colspan="2" style="padding:10px 0 18px 0;">
	                <input type="submit" value="提 交" class="buttom"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置" class="buttom"/>
	            </td>
	        </tr>
	    </table>
		</form>
		</fieldset>
		</div>
	</body>
</html>
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
		<title>ADP反馈中心-用户登录</title>
		<link type="text/css" rel="stylesheet" href="common/css/login.css" />
		<script src="common/js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
		function logoutsys(){
			var msg = confirm("退出系统,您确认吗?");
			if(!msg){
				return;
			}
			window.location="logout.action";
		}
		
		function registeruser(){
			$("#forgetpwddiv").slideUp();
			$("#registerdiv").slideToggle();
		}
		
		function forgetpwd(){
			$("#registerdiv").slideUp();
			$("#forgetpwddiv").slideToggle();
		}
		
		function usersubmit(){
			$("#loginname").val("guest");
			$("#password").val("guest");
			$("#userForm").submit();
		}
		
		function getpwd(){
		    var loginname = $("#floginname").val();
		    var username = $("#fusername").val();
		    var email = $("#femail").val();
		    if(loginname==null || loginname=="") {
		    	alert("请输入用户名");
		    	return false;
		    }
		    if(username==null || username==""){
		    	alert("请输入真实姓名");
		    	return false;
		    }
		    if(email==null || email=="") {
		    	alert("请输入电子邮箱");
		    	return false;
		    }
		    
		    var url="<%=path %>/manager/ajax_forgetpwd.action";
		    
	    	$.post(converURL(url),{ loginname: $("#floginname").val(), username: $("#fusername").val(),email:$("#femail").val() } ,callback);
    	}
    	
    	function callback(data){
	        var resultObj =$("#forgetpwdmsg");
	        //eval("json="+data);
	        //resultObj.html(json.message);
	        resultObj.html("<font color='blue'>" +$(data).text() +"</font>");
	    }
	    
	    function converURL(url){
		    //获取时间戳
		    var timstamp = new Date().valueOf();
		    //将时间戳品拼接到url上
		    //url="AJAXServer"
		    if(url.indexOf("?")>=0){
		        url=url + "&t=" + timstamp;
		    }else{
		        url=url + "?t=" + timstamp;
		    }
		    return url;
		}
		
		function registerVerify(){
			$("#rloginname")
			$("#rusername")
			$("#remail")
			$("#rpassword")
			$("#rpassword2")
		}
		</script>
	</head>

	<body>
		<br /><br /><br />
		<div id="formwrapper">
			<h3>
				已注册用户登录
			</h3>
			<form method="post" name="userForm" id="userForm" action="<%=basePath%>login.adp">
				<fieldset>
					<legend>
						用户登录
					</legend>
					<div>
						<p><strong><font color="red"><s:property value="message"/></font></strong></p>
						<label for="UName">
							用户名
						</label>
						<input type="text" name="user.loginname" class="input" id="loginname" size="18"
							maxlength="30" />
						<br />
					</div>
					<div>
						<label for="PWord">
							密码
						</label>
						<input type="password" name="user.password" class="input" id="password"
							size="18" maxlength="30" />
						<br />
					</div>
					<div class="cookiechk">
						<label for="CookieYN" style="color: #1E7ACE; cursor: pointer;">
							记住我
						</label>
						<input type="checkbox" name="CookieYN" id="CookieYN" value="1" />
						<a href="#" title="选择是否记录您的信息"></a>
						<input name="login" type="submit" class="buttom" value="登录" />
						<input name="login" type="button" class="buttom" value="匿名登录" onclick="usersubmit();"/>
					</div>
					<div class="forgotpass">
						<a href="javascript:forgetpwd();">忘记密码</a>
					</div>
					<div class="forgotpass">
						<a href="page/user/register.jsp">注册新用户</a>
					</div>
					<div class="forgotpass">
						<a href="<%=basePath %>">返回首页</a>
					</div>
				</fieldset>
			</form>
			<br />
			<div id="registerdiv" style="display:none;">
			<h3>
				未注册创建帐户
			</h3>
			<form method="post" name="apForm" id="apForm" action="<%=basePath%>manager/user_save.adp" onsubmit="return registerVerify()">
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
					<div>
						<label for="Name">
							用户名
						</label>
						<input type="text" name="user.loginname" class="input" id="rloginname" size="20"
							maxlength="30" />
						*(最多30个字符)
						<br />
					</div>
					<div>
						<label for="Name">
							用户昵称
						</label>
						<input type="text" name="user.username" class="input" id="rusername" size="20"
							maxlength="30" />
						*(最多20个字符)
						<br />
					</div>
					<div>
						<label for="Email">
							电子邮箱
						</label>
						<input type="text" name="user.email" class="input" id="remail" size="20"
							maxlength="150" />
						*
						<br />
					</div>
					<div>
						<label for="password">
							密码
						</label>
						<input type="password" name="user.password" class="input" id="rpassword"
							size="18" maxlength="15" />
						*(最多15个字符)
						<br />
					</div>
					<div>
						<label for="confirm_password">
							重复密码
						</label>
						<input type="password" name="confirm_password" class="input"
							id="rpassword2" size="18" maxlength="15" />
						*
						<br />
					</div>
					<div>
						<label for="AgreeToTerms">
							同意服务条款
						</label>
						<input type="checkbox" name="AgreeToTerms" id="AgreeToTerms"
							value="1" />
						<a href="#" title="您是否同意服务条款">先看看条款？</a> *
					</div>
					<div class="enter">
						<input name="rusersubmit" type="submit" class="buttom" value="提交" />
						<input name="ruserreset" type="reset" class="buttom" value="重置" />
					</div>
				</fieldset>
			</form>
			</div>
			<div id="forgetpwddiv" style="display:none;">
			<h3>
				找回用户密码
			</h3>
			<form method="post" name="apForm" id="apForm">
				<fieldset>
					<legend>
						找回密码
					</legend>
					<div>
						<p><strong><div id="forgetpwdmsg"></div></strong></p>
						<label for="Name">
							用户名
						</label>
						<input type="text" name="usre.loginname" class="input" id="floginname" size="20"
							maxlength="30" />
						*
						<br />
					</div>
					<div>
						<label for="Name">
							真实姓名
						</label>
						<input type="text" name="usre.username" class="input" id="fusername" size="20"
							maxlength="30" />
						*
						<br />
					</div>
					<div>
						<label for="Email">
							电子邮箱
						</label>
						<input type="text" name="user.email" class="input" id="femail" size="20"
							maxlength="150" />
						*
						<br />
					</div>
					<div class="enter">
						<input name="fpwdsubmit" type="button" class="buttom" onclick="getpwd()" value="提交" />
						<input name="fpwdreset" type="reset" class="buttom" value="重置" />
					</div>
				</fieldset>
			</form>
			</div>
			<br />
		</div>
	</body>
</html>
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
		<title>ADP反馈中心</title>
		<link type="text/css" rel="stylesheet" href="css/style.css"></link>
		<style type="text/css">
		body {
		font-family:"宋体",Verdana,Arial,Helvetica,sans-serif;
		font-size:12px;
		margin:0 auto;
		padding:0;
		text-align:center;
		}
		span {
		margin:0;
		padding:0;
		}
		a {
		text-decoration:underline;
		}
		a:hover {
		text-decoration:none;
		}
		ul {
		list-style-type:none;
		margin:0;
		padding:0;
		}
		#container {
		margin:50px auto 0;
		width:480px;
		}
		#containertwo {
		margin:50px auto 0;
		width:249px;
		}
		.headertwo {
		float:left;
		width:249px;
		}
		.header {
		float:left;
		width:480px;
		}
		.main {
		float:left;
		width:480px;
		}
		.main_top {
		background:transparent ../images/icon_bj01.gif no-repeat scroll 0 0;
		float:left;
		font-size:10px;
		height:12px;
		width:480px;
		}
		.main_msg {
		background-color:#EAF3FD;
		border-left:1px solid #C6DFF9;
		border-right:1px solid #C6DFF9;
		color:#5983AC;
		float:left;
		font-size:12px;
		padding-left:34px;
		width:440px;
		}
		.msg h1 {
		color:#5983AC;
		float:left;
		font-size:14px;
		margin:16px 0 0;
		padding:0 0 10px;
		text-align:left;
		width:424px;
		}
		.msg {
		float:left;
		padding:0 20px 20px 0;
		}
		.msg p {
		color:#5983AC;
		float:left;
		font-size:12px;
		line-height:23px;
		margin:0;
		padding:0;
		text-align:left;
		width:424px;
		}
		.msg p a {
		color:#5983AC;
		font-size:12px;
		}
		.msg ul {
		float:left;
		margin-top:20px;
		}
		.msg ul li {
		float:left;
		margin-bottom:10px;
		text-align:left;
		width:424px;
		}
		.msg ul li a {
		color:#5983AC;
		font-size:12px;
		}
		.msg ol {
		float:left;
		margin:0;
		padding:0;
		}
		.msg ol li {
		line-height:23px;
		margin-top:20px;
		text-align:left;
		}
		.main_bottom {
		background:transparent ../images/icon_bj02.gif no-repeat scroll 0 0;
		float:left;
		height:5px;
		width:480px;
		}
		.msgtwo {
		float:left;
		padding-bottom:20px;
		}
		.msgtwo h1 {
		color:#5983AC;
		float:left;
		font-size:14px;
		margin:16px 0 0;
		padding:0 0 10px;
		text-align:left;
		width:249px;
		}
		.msgtwo p {
		color:#5983AC;
		float:left;
		font-size:12px;
		line-height:23px;
		margin:0;
		padding:0;
		text-align:left;
		width:249px;
		}
		.msgtwo p a {
		color:#5983AC;
		font-size:12px;
		}
		.msgtwo ul {
		color:#5983AC;
		float:left;
		font-size:12px;
		margin-top:20px;
		}
		.msgtwo ul li {
		float:left;
		margin-bottom:10px;
		text-align:left;
		width:249px;
		}
		.msgtwo a {
		color:#0000FF;
		float:left;
		font-size:14px;
		font-weight:bold;
		margin-top:25px;
		text-align:left;
		width:249px;
		}
		</style>
	</head>

	<body>
		<div id="container">
			<div class="main">
				<div class="main_top"></div>
				<div class="main_msg">
					<div class="msg">
						<h1>
							<font color="red">提示</font>
						</h1>
						<p>
							<s:property value="message"/>
							<br />
						</p>
					</div>
				</div>
				<div class="main_bottom"></div>
			</div>
		</div>
	</body>
</html>
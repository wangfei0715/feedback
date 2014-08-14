<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath %>common/js/plugin/wbox-min.js"></script> 
<link rel="stylesheet" type="text/css" href="<%=basePath %>common/wbox/wbox.css" />

<div id="topbar">
	<div id="topbar_nav" class="nav">
		<a href="<%=basePath%>">回首页</a><a href="#">项目简介</a>
	</div>
	<div id="topbar_login">
		<s:if test="#session.user == null">
		您还未登录 , 请<a href="page/login.jsp"><b> <u>登录</u> </b></a>
		</s:if>
		<s:else>
		<b id="topbar_acc">
		<s:property value="#session.user.username" /> , 您好!
		</b> |
		<s:if test="#session.user.isadmin != 1">
		<a href="#" id="editMyself">我的帐户</a>
		</s:if>
		<a href="logout.action">退出</a>
		</s:else>
	</div>
</div>
<div id="header">
	<a id="logo" href="<%=basePath %>">助益数据质量</a>
	<div id="nav">
		<b class="b b-l"></b>
		<b class="b b-r"></b>
		<ul>
			<li>
				<a href="<%=basePath %>common/redirect_question.action"
				 <s:if test="feedbackType == 1">
				 class="active"
				 </s:if>
				 <s:elseif test="feedbackType == 2">
				 class="active"
				 </s:elseif>
				><span>反馈中心</span> </a>
			</li>
			<li>
				<a href="<%=basePath %>message/message_commquestions.action"
				 <s:elseif test="feedbackType == 4">
				 class="active"
				 </s:elseif>
				><span>常见问题</span>
				</a>
			</li>
			<li>
				<a href="<%=basePath %>message/message_greatsuggestions.action"
				 <s:elseif test="feedbackType == 5">
				 class="active"
				 </s:elseif>
				><span>精彩建议</span>
				</a>
			</li>
<!--			<li><a href="#"><span>帮助中心</span></a></li>-->
		</ul>
	</div>
</div>
<script type="text/javascript">
	$("#editMyself").wBox({title:"我的账户",requestType:"iframe",iframeWH:{width:800,height:430},target:"<%=basePath %>manager/my_editSelf.action"});
</script>
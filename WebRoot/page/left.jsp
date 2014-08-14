<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
function setClassforTag(obj){
	$(obj).addClass("cur");
}
</script>

<div class="lay-side">
	<div class="mod-box-c">
		<b class="r-t"><b></b> </b>
		<div class="bc-c">

			<div class="con-user">
				<ul class="clearfix">
					<li class="user-head">
						<a href="#">
						<img src="<%=basePath %>common/images/user/
						<s:if test="#session.user.userinfo.sex == 1">
						user_male.png
						</s:if>
						<s:elseif test="#session.user.userinfo.sex == 2">
						user_female.png
						</s:elseif>
						<s:else>
						user.png
						</s:else>
						" width="58" height="58" /> </a>
					</li>
					<li class="user-info">
						<s:if test="#session.user == null">
						您还未登录 , 请<a href="page/login.jsp"><b> <u>登录</u> </b></a>
						</s:if>
						<s:else>
						<p class="user-name">
							您好，
							<a href="#" id="editMyselfLeft"><b><s:property value="#session.user.username" /></b>
							</a>
						</p>
						<s:if test="#session.user.isadmin != 1">
						<p class="user-other">
							<a href="<%=basePath %>message/message_getMyQuestions.action?myQuestionType=1">等待解决的问题</a>
							<br />
							<a href="<%=basePath %>message/message_getMyQuestions.action?myQuestionType=3">已经解决的问题</a>
						</p>
						</s:if>
						<s:else>
						您现为访客还未登录<br /> 请重新<a href="logout.action"><b> <u>登录</u> </b></a>
						</s:else>
						</s:else>
					</li>
				</ul>

			</div>

		</div>
		<b class="r-b"><b></b> </b>
	</div>

	<div class="mod-box-d mt5">
		<b class="r-t"><b></b> </b>
		<div class="bc-d">

			<ul class="con-left-menu">
				<li>
					<i class="icon-menu icon-ask"></i>
					<a href="<%=basePath %>common/redirect_question.action"
						 <s:if test="feedbackType == 1">
				           class="cur"
				         </s:if>
					>我要提问</a>
				</li>
				<li>
					<i class="icon-menu icon-sug"></i>
					<a href="<%=basePath %>common/redirect_suggestion.action"
						 <s:if test="feedbackType == 2">
				           class="cur"
				         </s:if>
						
					>我要建议</a>
				</li>
				<li>
					<i class="icon-menu icon-res"></i>
					<a href="<%=basePath %>common/redirect_myquestions.action"
						 <s:if test="feedbackType == 3">
				           class="cur"
				         </s:if>
					>结果查询</a>
				</li>
				<li>
					<i class="icon-menu icon-que"></i>
					<a href="<%=basePath %>message/message_commquestions.action"
						<s:if test="feedbackType == 4">
				           class="cur"
				        </s:if>
					>常见问题</a>
				</li>
				<li>
					<i class="icon-menu icon-wdf"></i>
					<a href="<%=basePath %>message/message_greatsuggestions.action"
						<s:if test="feedbackType == 5">
				           class="cur"
				        </s:if>
					>精彩建议</a>
				</li>
				<s:if test="#session.user.isadmin == 99">
				<li>
					<i class="icon-menu icon-res"></i>
					<a href="<%=basePath %>message/message_questionadmin.action?myQuestionType=0"
						<s:if test="feedbackType == 7">
				           class="cur"
				        </s:if>
					>问题建议管理</a>
				</li>
				</s:if>
			</ul>

		</div>
		<b class="r-b"><b></b> </b>
	</div>
</div>
<script type="text/javascript">
	$("#editMyselfLeft").wBox({title:"我的账户",requestType:"iframe",iframeWH:{width:800,height:430},target:"<%=basePath %>manager/my_editSelf.action"});
</script>
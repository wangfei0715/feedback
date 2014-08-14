<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="main-wrap">
	<div class="mod-box-e">
		<b class="r-t"><b></b>
		</b>
		<div class="bh-e">
			<h3>
			    <s:if test="myQuestionType == 1">
				反馈中心 &gt; 常见问题 &gt; 全部
				</s:if>
				<s:elseif test="myQuestionType == 2">
				反馈中心 &gt; 精彩建议 &gt; 全部
				</s:elseif>
			</h3>
		</div>
		<div class="bc-e">

			<ul id="con_syt_list" class="con-sys-list sys-list-ext black clearfix">
				<s:if test="myQuestionType == 1">
					<li onclick="window.location.href='<%=basePath %>message/message_commquestions.action?catalogid=1'" class="">
						<b class="r-t"><b></b>
						</b>
						<p class="sys-con">
							<i class="icon icon-u"></i>
							<b><a href="<%=basePath %>message/message_commquestions.action?catalogid=1">数据质量</a>
							</b>
						</p>
						<b class="r-b"><b></b>
						</b>
					</li>
	
	
					<li onclick="window.location.href='<%=basePath %>message/message_commquestions.action?catalogid=2'">
						<b class="r-t"><b></b>
						</b>
						<p class="sys-con">
							<i class="icon icon-115brown"></i>
							<b><a href="<%=basePath %>message/message_commquestions.action?catalogid=2">反馈平台</a>
							</b>
						</p>
						<b class="r-b"><b></b>
						</b>
					</li>
				</s:if>
				<s:elseif test="myQuestionType == 2">
					<li onclick="window.location.href='<%=basePath %>message/message_greatsuggestions.action?catalogid=1'" class="">
						<b class="r-t"><b></b>
						</b>
						<p class="sys-con">
							<i class="icon icon-u"></i>
							<b><a href="<%=basePath %>message/message_greatsuggestions.action?catalogid=1">数据质量</a>
							</b>
						</p>
						<b class="r-b"><b></b>
						</b>
					</li>
	
	
					<li onclick="window.location.href='<%=basePath %>message/message_greatsuggestions.action?catalogid=2'">
						<b class="r-t"><b></b>
						</b>
						<p class="sys-con">
							<i class="icon icon-115brown"></i>
							<b><a href="<%=basePath %>message/message_greatsuggestions.action?catalogid=2">反馈平台</a>
							</b>
						</p>
						<b class="r-b"><b></b>
						</b>
					</li>
				</s:elseif>
			</ul>
			<ul id="con_q_list" class="con-q-list">
				<s:iterator value="pagination.list">
				<li class="first">
					<dl>
						<dt>
							<i class="icon-s icon-s-ask"></i>
							<a class="black"
								href="<%=basePath %>message/message_detail.action?messageid=<s:property value="messageid" />"><strong><s:property value="title" /></strong>
							</a><span class="q-date grey">[<s:property value="user.username" />] <s:date name="modifytime" format="yyyy-MM-dd HH:mm" /></span>
						</dt>
						<dd class="q-con">
							<a class="black" href="<%=basePath %>message/message_detail.action?messageid=<s:property value="messageid" />"><s:property value="content" /></a>
						</dd>
						<s:iterator value="replys">
						<dd class="q-repay">
							<i class="icon-s icon-s-repay"></i>
							<a href="<%=basePath %>message/message_detail.action?messageid=<s:property value="messageid" />">
							<s:property value="content" />
							<span class="q-date grey">(<s:date name="replytime" format="yyyy-MM-dd HH:mm" />)</span> </a>
						</dd>
						</s:iterator>
					</dl>
				</li>
				</s:iterator>
			</ul>
			<div class="other-info">
				<div class="mod-page">
					<div class="ylmf-page">
						<s:if test="pagination.page.hasPrePage"><a class="nextprev" href="<%=basePath%><s:property value="pageinfo"/><s:property value="1"/>">«首页</a><a class="nextprev" href="<%=basePath%><s:property value="pageinfo"/><s:property value="pagination.page.currentPage-1"/>">«上一页</a></s:if>
						<s:else><span class="nextprev">«首页</span><span class="nextprev">«上一页</span></s:else>
						<s:if test="pagination.page.hasNextPage"><a class="nextprev" href="<%=basePath%><s:property value="pageinfo"/><s:property value="pagination.page.currentPage+1"/>">下一页»</a><a href="<%=basePath%><s:property value="pageinfo"/><s:property value="pagination.page.totalPage"/>">末页»</a></s:if>
						<s:else><span class="nextprev">下一页»</span><span class="nextprev">末页»</span></s:else>
						<span>当前第 <strong><s:property value="pagination.page.currentPage"/></strong> 页，共 <s:property value="pagination.page.totalPage"/> 页，<s:property value="pagination.page.totalCount"/> 记录</span>
					</div>
				</div>
				<div class="some-link">
					<s:if test="myQuestionType == 1">
					<a href="<%=basePath %>common/redirect_question.action" class="btn">我也要提问</a>
					</s:if>
					<s:elseif test="myQuestionType == 2">
					<a href="<%=basePath %>common/redirect_suggestion.action" class="btn">我要提建议</a>
					</s:elseif>
				</div>

			</div>

		</div>
		<b class="r-b"><b></b>
		</b>
	</div>
</div>
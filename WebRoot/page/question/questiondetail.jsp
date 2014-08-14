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
				详细信息 - <s:property value="message.title" />
			</h3>
			<p class="font-size">
				<a href="javascript:addFav()">[收藏本问题]</a>
			</p>
		</div>
		<div class="bc-e">
			<ul class="con-repay-list repay-list-ext clearfix">
				<li>
					<p>
						<s:property value="message.content" />
					</p>
					<span class="q-date grey"> <b><s:property value="message.user.username" /></b> 发表于
						(<s:date name="message.modifytime" format="yyyy-MM-dd HH:mm" />)</span>
				</li>
				<s:iterator value="message.replys">
				<li class="repay">
					<div class="user-head-s">
						<img width="65" height="65" src="<%=basePath %>common/images/admin_logo.gif">
						<s:property value="user.username" />
					</div>
					<div class="user-con">
						<div class="mod-box-d">
							<b class="r-t"><b></b>
							</b>
							<div class="bc-d">
<!--								<p class="txt-c-2">-->
<!--								</p>-->
								<p class="txt-c-2">
								<s:property value="content" />
								</p>
								<span class="q-date grey">(<s:date name="replytime" format="yyyy-MM-dd HH:mm:ss" />)</span>
								<p></p>
							</div>
							<b class="r-b"><b></b>
							</b>
							<b class="icon-s icon-arrow"></b>
						</div>

					</div>
				</li>
				</s:iterator>
			</ul>

			<div class="other-info f14">
				<a href="javascript:window.history.go(-1)">返回上一步</a>
			</div>

		</div>
		<b class="r-b"><b></b>
		</b>
	</div>
</div>
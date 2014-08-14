<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style type="text/css">
.btn-submitclass {
	font: 12px/ 1.5 Tahoma, Helvetica, Arial, "宋体", sans-serif;
	background-image: url("../images/bg_main.png");
	background-repeat: no-repeat;
	cursor: pointer;
	text-decoration: none;
	border: medium none;
	background-position: 0 -228px;
	color: #4077A9;
	display: inline-block;
	font-weight: bold;
	height: 28px;
	line-height: 28px;
	text-align: center;
	width: 99px;
}
</style>
<div class="main-wrap">
	<div class="mod-box-e">
		<b class="r-t"><b></b> </b>
		<div class="bh-e">
			<h3>
				详细信息 -
				<s:property value="message.title" />
			</h3>
			<p class="font-size">
				<a href="javascript:addFav()">[收藏本问题]</a>
			</p>
		</div>
		<div class="bc-e">
			<ul class="con-repay-list repay-list-ext clearfix">
				<li class="repay">
					<p>
						<s:property value="message.content" />
					</p>
					<span class="q-date grey"> <b><s:property
								value="message.user.username" />
					</b> 发表于 (<s:date name="message.modifytime"
							format="yyyy-MM-dd HH:mm:ss" />)</span>
					<div align="right"><font color="blue"><b>双击[回复区域]修改</b></font></div>
				</li>
				<s:iterator value="message.replys">
					<li class="repay">
						<div class="user-head-s">
							<img width="65" height="65"
								src="<%=basePath %>common/images/admin_logo.gif">
							<s:property value="user.username" />
						</div>
						<div class="user-con" ondblclick="editReply(this,<s:property value="replyid" />)">
							<div class="mod-box-d">
								<b class="r-t"><b></b> </b>
								<div class="bc-d">
									<p class="txt-c-2"><s:property value="content" /></p>
									<span class="q-date grey">(<s:date name="replytime"
											format="yyyy-MM-dd HH:mm:ss" />)</span>
									<p></p>
								</div>
								<b class="r-b"><b></b> </b>
								<b class="icon-s icon-arrow"></b>
							</div>

						</div>
					</li>
				</s:iterator>
				<li class="repay">
					<form action="<%=basePath %>message/message_savereply.action"
						method="post" name="replyform">
						<input type="hidden" name="message.messageid"
							value="<s:property value="message.messageid" />" />
						<table align="center" border="0">
							<tr>
								<td width="80px">
									回复:
								</td>
								<td colspan="3">
									<textarea cols="100" rows="6" name="replyContent"
										id="replyContent"></textarea>
								</td>
							</tr>
							<tr height="30px">
								<td rowspan="2" width="80px">
									管理:
								</td>
								<td width="180px">
									是否删除：
									<s:checkbox name="msg.isdel"></s:checkbox>
								</td>
								<td width="180px">
									是否推荐：
									<s:checkbox name="msg.recommend"></s:checkbox>
								</td>
								<td width="180px">
									是否置顶：
									<s:checkbox name="msg.istop"></s:checkbox>
								</td>
							</tr>
							<tr height="30px">
								<td>
									是否已读：
									<s:checkbox name="msg.checked"></s:checkbox>
								</td>
								<td>
									信息类型：
									<s:select list="#{1:'提问',2:'建议'}" name="message.type"></s:select>
								</td>
								<td>
									信息状态：
									<s:select list="#{1:'未回复',2:'部分回复',3:'已回复',4:'已忽略'}"
										name="message.status"></s:select>
								</td>
							</tr>
							<tr height="100px">
								<td>
									操作:
								</td>
								<td></td>
								<td></td>
								<td>
									<input id="submit1" type="submit" class="btn-submitclass"
										value="提交回复" />
								</td>
							</tr>
						</table>
					</form>
				</li>
			</ul>

			<div class="other-info f14">
				<a href="javascript:window.history.go(-1)">返回上一步</a>
			</div>

		</div>
		<b class="r-b"><b></b> </b>
	</div>
	<div id="replycontentdiv" style="display:none;">
		<form action="<%=basePath%>message/message_replyupdate.action" method="post">
			<textarea rows="5" cols="50" id="replycontent_textarea" name="replyContent"></textarea>
			<input type="hidden" name="replyid" id="replycontent_replyid"/>
			<input type="hidden" name="messageid" id="replycontent_messageid" value="<s:property value="message.messageid" />"/>
			<div align="right" ><input type="submit" value="更新回复"/></div>
		</form>
	</div>
</div>
<script type="text/javascript" src="<%=basePath %>common/js/plugin/mapapi.js"></script> 
<script type="text/javascript" src="<%=basePath %>common/js/plugin/wbox-min.js"></script> 
<link rel="stylesheet" type="text/css" href="<%=basePath %>common/wbox/wbox.css" />
<script type="text/javascript">
function editReply(obj,replyid){
	$("#replycontent_textarea").text($(obj).find("p.txt-c-2").html());
	$("#replycontent_replyid").val(replyid);
	var innerHtml = $("#replycontentdiv").html();
	$('#_replycontent').wBox({title:"修改回复",show:true,html:innerHtml});
}
</script>
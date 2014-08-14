<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath %>common/js/plugin/mapapi.js"></script> 
<script type="text/javascript" src="<%=basePath %>common/js/plugin/wbox-min.js"></script> 
<link rel="stylesheet" type="text/css" href="<%=basePath %>common/wbox/wbox.css" />

<!--<div id="page">-->
	<div id="content">
		<div class="layout lay-sm">
			<div class="lay-main">
				<div class="main-wrap">
					<div class="mod-box-e">
						<b class="r-t"><b></b> </b>
						<div class="bc-e">

							<div class="mod-tab-a p15">
								<div class="th-a">
									<ul>
										<li>
											<a href="javascript:filt(0)"
											<s:if test="myQuestionType == 0">
											 class="cur"
											</s:if>
											>全部</a>
										</li>
										<li>
											<a href="javascript:filt(1)"
											<s:if test="myQuestionType == 1">
											 class="cur"
											</s:if>
											>等待解决</a>
										</li>
										<li>
											<a href="javascript:filt(3)"
											<s:if test="myQuestionType == 3">
											 class="cur"
											</s:if>
											>已结束</a>
										</li>
									</ul>
								</div>
								<div class="tb-a">

									<div class="top-opt">
										<div class="opt-title">
											<span class="q-check"></span>
										</div>
										<div class="mod-page-s">

										</div>
									</div>
									<dl class="con-table clearfix">
										<dt>
											<span class="fl icon-msg"></span>

											<span class="fl q-title">标题</span>
											<span class="fl q-type">类型
												<select onchange="filt('type');" id="ftype" value="<s:property value="myMsgType" />">
													<option value="0">
														全部
													</option>
													<option label="提问" value="1">
														提问
													</option>
													<option label="建议" value="2">
														建议
													</option>

												</select> </span>
											<span class="fl q-state"> 状态
												<select onchange="filt('status')" id="fstatus" value="<s:property value="myMsgStatus" />">
													<option value="0">
														全部
													</option>
													<option label="未回复" value="1">
														未回复
													</option>
													<option label="部分回复" value="2">
														部分回复
													</option>
													<option label="已回复" value="3">
														已回复
													</option>
													<option label="已忽略" value="4">
														已忽略
													</option>

												</select> </span>

											<span class="fl q-date">发布时间</span>
										</dt>
										<s:iterator value="pagination.list">
										<dd id="<s:property value="messageid" />_titlediv" >
											<span class="fl icon-s icon-msg"></span>
											<span class="fl q-title black"> 
												<i class="icon-s icon-open" id="icon_114434"></i>
												<a href="javascript:showDetail(<s:property value="messageid" />)" class="my-a">
												<strong>[<s:property value="catalog.catalogname" />]</strong><s:property value="title" /></a> </span>
											<span class="fl q-type">
											 <s:if test="type == 1">
									          提问
									         </s:if>
									         <s:elseif test="type == 2">
									          建议
									         </s:elseif>
									         <s:else>
									                  其他
									         </s:else>
											</span>
											<span class="fl q-state">
											<s:if test="status == 1">
									          未回复
									         </s:if>
									         <s:elseif test="status == 2">
									          部分回复
									         </s:elseif>
									         <s:elseif test="status == 3">
									          已回复
									         </s:elseif>
									         <s:elseif test="status == 4">
									                  已忽略
									         </s:elseif>
									         <s:else>
									                  其他
									         </s:else>
											
											</span>
											<span class="fl q-date"><s:date name="modifytime" format="yyyy-MM-dd HH:mm" /></span>
										</dd>
										<dd id="<s:property value="messageid" />_detaildiv" style="display:none;" class="opt-repay">
											<ul class="con-repay-list clearfix">
												<li>
													<p><b><s:property value="title" /></b></p>
													<div class="user-head-s"><img width="65" height="65" src="<%=basePath %>common/images/9v1qw_l.png"></div>
													<div class="user-con">
														<div class="mod-box-d">
															<b class="r-t"><b></b></b>
															<div class="bc-d">
																<div class="txt-c-1">
																	<p><s:property value="content" /></p>
																	<span class="q-date grey">(<s:date name="modifytime" format="yyyy-MM-dd HH:mm" />)</span>
																</div>
															</div>
															<b class="r-b"><b></b></b><b class="icon-s icon-arrow"></b>
														</div>
													</div>
												</li>
												<!--回复结束-->
											</ul>
											 <s:if test="status == 1">
									         	<p id="note_114434" class="txt-c-3">(该问题还没有得到回复)</p>
									         </s:if>
									         <s:elseif test="status == 2">
									         	<s:iterator value="replys">
									            <ul class="con-repay-list clearfix">
													<li>
														<p><b><s:property value="title" /></b></p>
														<div class="user-head-s"><img width="65" height="65" src="<%=basePath %>common/images/admin_logo.gif"></div>
														<div class="user-con">
															<div class="mod-box-d">
																<b class="r-t"><b></b></b>
																<div class="bc-d">
																	<div class="txt-c-1">
																		<p><s:property value="content" /></p>
																		<span class="q-date grey">(<s:date name="replytime" format="yyyy-MM-dd HH:mm" />)</span>
																	</div>
																</div>
																<b class="r-b"><b></b></b><b class="icon-s icon-arrow"></b>
															</div>
														</div>
													</li>
													<!--回复结束-->
												</ul>
									         	</s:iterator>
									         </s:elseif>
									         <s:elseif test="status == 3">
									            <s:iterator value="replys">
									            <ul class="con-repay-list clearfix">
													<li>
														<p><b><s:property value="title" /></b></p>
														<div class="user-head-s"><img width="65" height="65" src="<%=basePath %>common/images/admin_logo.gif"></div>
														<div class="user-con">
															<div class="mod-box-d">
																<b class="r-t"><b></b></b>
																<div class="bc-d">
																	<div class="txt-c-1">
																		<p><s:property value="content" /></p>
																		<span class="q-date grey">(<s:date name="replytime" format="yyyy-MM-dd HH:mm" />)</span>
																	</div>
																</div>
																<b class="r-b"><b></b></b><b class="icon-s icon-arrow"></b>
															</div>
														</div>
													</li>
													<!--回复结束-->
												</ul>
									         	</s:iterator>
									         </s:elseif>
									         <s:elseif test="status == 4">
									         	<p id="note_114434" class="txt-c-3">(该问题已被搁置)</p>
									         </s:elseif>
									         <s:else>
									         	<p id="note_114434" class="txt-c-3">(该问题还没有得到回复)</p>
									         </s:else>
											 
										</dd>
										</s:iterator>
									</dl>
								</div>
							</div>

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
							</div>

						</div>
						
						<b class="r-b"><b></b> </b>
					</div>
				</div>
			</div>
			<!--/.lay-main-->
		</div>
		<!--/.lay-sm-->
	</div>
	<!--/#content-->
<!--</div>-->

<script>
function filt(opt){
	var type = $("#ftype").val();
	var status = $("#fstatus").val();
	// alert(opt);
	// alert(type);
	// alert(status);
	var href = "<%=basePath %>message/message_questionadmin.action";
	
	if(opt == "status"){
		href = href + "?myMsgType="+type+"&myMsgStatus="+status;
	}
	else if (opt == "type"){
		href = href + "?myMsgType="+type+"&myMsgStatus="+status;
	}else if(opt == 0){
		href = href + "?myQuestionType=" + opt;
	}
	else if(opt == 1){
		href = href + "?myQuestionType=" + opt;
	}else if(opt == 3){
		href = href + "?myQuestionType=" + opt;
	}
	// alert(href);
	window.location.href = href;
}
// 检查是否全部选中
function batch_deal(){
	var checked = false;
	$("input[rel=batch_box]").each(function(i){
		if(this.checked == true){
			checked = true;
		}
	});
	if(!checked){
		alert("请至少选中一行");
		return false;
	}
	return confirm("确定删除");
}
function setSelectVal(){
	$("#ftype").val(<s:property value="myMsgType" />);
	$("#fstatus").val(<s:property value="myMsgStatus" />);
}
setSelectVal();
function showDetail(id){
	// alert($('#'+id+'_detaildiv').html());
	// $('#111111').wBox({title:"详细信息",show:true,html:$('#'+id+'_detaildiv').html()});
	// $('#'+id+'_titlediv').toggleClass("cur");
	// $('#'+id+'_detaildiv').slideToggle();
	
	var href = "<%=basePath %>message/message_admindetail.action?messageid="+id;
	window.location.href = href;
}

//window.onload = (function () {
//}); 
</script>
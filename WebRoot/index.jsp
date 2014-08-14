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
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>ADP反馈中心-首页</title>
		<s:include value="/page/include.jsp"></s:include>
		<script type="text/javascript">
		$(document).ready(function(){
			getTop(1,10);
			getTop(2,10);
		});
		
		function getTop(type,topLimit){
			var url="<%=basePath %>/message/ajax_getTop.action?topType="+type+"&topLimit="+topLimit;
			var callfun = "callbackQuestion";
			if(type == 2) callfun = "callbackSuggestion";
			$.ajax({
			   type: "GET",
			   url: converURL(url),
			   dataType: "xml",
			   success: eval(callfun)
			});
		}
		
		function callbackQuestion(data){
			// alert( "Data Saved: " + data );
			var ul = $("#commquestionul");
			var li = "";
			$.each( $(data).find("message"), function(i, msg){
			  // alert( "Name: " + i + ", Value: " + msg.attributes.title.value );
			  li += "<li><a href='"+$(msg).attr("url")+"' class='black'><b>["+$(msg).attr("catalogname")+"]</b></a>";
			  li += "<a href='"+$(msg).attr("url")+"' class='grey'>"+$(msg).attr("title")+"</a></li>";
			});
			ul.html(li);
	    }
	    
		function callbackSuggestion(data){
			// alert( "Data Saved: " + data );
			var ul = $("#greatsuggestionul");
			var li = "";
			$.each( $(data).find("message"), function(i, msg){
			  // alert( "Name: " + i + ", Value: " + msg.attributes.title.value );
			  li += "<li><a href='"+$(msg).attr("url")+"' class='black'><b>["+$(msg).attr("catalogname")+"]</b></a>";
			  li += "<a href='"+$(msg).attr("url")+"' class='grey'>"+$(msg).attr("title")+"</a></li>";
			});
			ul.html(li);
			
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
		</script>
	</head>
	<body>
		<s:include value="/page/top.jsp"></s:include>
		<div id="page">
			<div id="content">
				<div class="layout lay-ms">
					<div class="lay-main">
						<div class="main-wrap">
							<div class="mod-box-a">
								<b class="r-t"><b></b>
								</b>
								<div class="bc-a">

									<ul class="con-sys-list" id="con_syt_list">
										<li
											onclick="window.location.href='<%=basePath %>message/message_commquestions.action?catalogid=1'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-u"></i>
												<b>助益数据质量</b>
												<a href="<%=basePath %>message/message_commquestions.action?catalogid=1">常见问题</a> |
												<a href="<%=basePath %>message/message_greatsuggestions.action?catalogid=1">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>
 
										<li
											onclick="window.location.href='<%=basePath %>message/message_commquestions.action?catalogid=2'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-115brown"></i>
												<b>反馈平台</b>
												<a href="<%=basePath %>message/message_commquestions.action?catalogid=2">常见问题</a> |
												<a href="<%=basePath %>message/message_greatsuggestions.action?catalogid=2">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>
									</ul>
								</div>
								<b class="r-b"><b></b>
								</b>
							</div>
						</div>
					</div>
					<!--/.lay-main-->
					<div class="lay-side">

						<div class="btn-area">

							<p class="link-big">
								<a title="我要提问" href="<%=basePath %>common/redirect_question.action"
									class="link1"></a>
								<a title="我要提建议" href="<%=basePath %>common/redirect_suggestion.action"
									class="link2"></a>
							</p>
							<p class="link-other">
								<a href="<%=basePath %>common/redirect_myquestions.action">结果查询</a>
							</p>
						</div>
						<div class="btn-suggest">
							<a title="精彩建议" href="<%=basePath %>message/message_greatsuggestions.action"
								class="link1"></a>
						</div>

					</div>
					<!--/.lay-side-->
				</div>
				<!--/.lay-ms-->

				<div class="layout lay-mes mt10">
					<div class="lay-main">
						<div class="main-wrap">
							<div class="mod-box-b">
								<b class="r-t"><b></b>
								</b>
								<div class="bh-b">
									<h3>
										常见问题
										<span class="more"><a
											href="<%=basePath %>message/message_commquestions.action">更多>></a>
										</span>
									</h3>

								</div>
								<div class="bc-b">

									<ul class="con-txt" id="commquestionul">
									</ul>

								</div>
								<b class="r-b"><b></b>
								</b>
							</div>
						</div>
					</div>
					<!--/.lay-main-->
					<div class="lay-extra">
						<div class="mod-box-b">
							<b class="r-t"><b></b>
							</b>
							<div class="bh-b">
								<h3>
									精彩建议
									<span class="more"><a
										href="<%=basePath %>message/message_greatsuggestions.action">更多>></a>
									</span>
								</h3>

							</div>
							<div class="bc-b">

								<ul class="con-txt" id="greatsuggestionul">
								</ul>

							</div>
							<b class="r-b"><b></b>
							</b>
						</div>
					</div>
					<!--/.lay-extra-->
					<div class="lay-side">
						<div class="mod-box-b">
							<b class="r-t"><b></b>
							</b>
							<div class="bh-b">
								<h3>
									帮助中心
									<span class="more"><a href="<%=basePath %>message/message_commquestions.action"
										target="_blank">更多>></a>
									</span>
								</h3>

							</div>
							<div class="bc-b">

								<ul class="con-txt">
<!--									<li>-->
<!--										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>-->
<!--										</a>-->
<!--										<a href="http://115.com/help/tq.html" target="_blank"-->
<!--											class="grey">115.com:天气预报查询</a>-->
<!--									</li>-->
								</ul>

							</div>
							<b class="r-b"><b></b>
							</b>
						</div>
					</div>
					<!--/.lay-side-->
				</div>
				<!--/.lay-mes-->
			</div>
			<!--/#content-->
			<s:include value="/page/bottom.jsp"></s:include>


		</div>


		<script>tagHover('con_syt_list','li');</script>
	</body>
</html>
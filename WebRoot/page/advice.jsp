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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>反馈中心 - <s:property value="title" /></title>
		<s:include value="/page/include.jsp"></s:include>
		<script type="text/javascript">    
		function setCwinHeight(iframeObj){   
			try{
				if (document.getElementById){     
				  if (iframeObj){    
				    if (iframeObj.contentDocument && iframeObj.contentDocument.body.scrollHeight){    
				      iframeObj.height = iframeObj.contentDocument.body.scrollHeight;    
				    }else if (document.frames[iframeObj.name].document && document.frames[iframeObj.name].document.body.scrollHeight){
				             iframeObj.height = document.frames[iframeObj.name].document.body.scrollHeight;    
				             }    
				  }    
				}    
			}catch(e){
				iframeObj.height = 500;
			} 
			
		}
		
		/*
		window.onload = (function () { 
			var iObj = document.getElementById("rightFrame"); 
			// iObj.height = iObj.contentWindow.document.documentElement.scrollHeight; 
			var sub = iObj.contentDocument ? iObj.contentDocument:iObj.contentWindow.document;     
			if(iObj!=null&&sub!=null){    
			iObj.height=sub.body.scrollHeight;    
			if(iObj.height < 400)iObj.height = 428;
			}    
		}); 
		*/    
		</script>   
	</head>

	<body>
		<s:include value="/page/top.jsp"></s:include>
		<div id="page">
			<div id="content">
				<div class="layout lay-sm" style="overflow: hidden; zoom: 1;">
					<s:include value="/page/left.jsp"></s:include>
					<!--/.lay-side-->
					 <s:if test="feedbackType == 1">
			         <s:include value="/page/question/question.jsp"></s:include>
			         </s:if>
			         <s:elseif test="feedbackType == 2">
			         <s:include value="/page/question/question.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 3">
			         <s:include value="/page/question/myquestions.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 4">
			         <s:include value="/page/question/commquestions.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 5">
			         <s:include value="/page/question/commquestions.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 6">
			         <s:include value="/page/question/questiondetail.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 7">
			         <s:include value="/page/admin/questionadmin.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 8">
			         <s:include value="/page/admin/admindetail.jsp"></s:include>
			         </s:elseif>
			         <s:elseif test="feedbackType == 10">
			         <s:include value="/page/user/editself.jsp"></s:include>
			         </s:elseif>
					
<!--					<iframe marginwidth=0 marginheight=0 frameborder="0" scrolling="no" style="margin-left: 205px;width: 730px;"-->
<!--						src="<s:property value='includeUrl' />" name="rightFrame" id="rightFrame"-->
<!--						title="rightFrame" ></iframe>-->
<!--					<iframe border="0" frameborder="0" scrolling="no" style="margin-left: 205px;width: 730px;height: 500px;"-->
<!--						src="<s:property value='includeUrl' />" name="rightFrame" id="rightFrame"-->
<!--						title="rightFrame"></iframe>-->
					<!--/.lay-main-->
				</div>
				<!--/.lay-sm-->
			</div>
			<!--/#content-->

		</div>
		<s:include value="/page/bottom.jsp"></s:include>


	</body>
</html>
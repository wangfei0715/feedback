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
		<script type="text/javascript" src="common/js/jquery.js"></script>
	    <script language="javascript"> 
	        $(function() {  
	            function jump(count) {  
	                window.setTimeout(function(){  
	                    count--;  
	                    if(count > 0) {  
	                        $('#num').html(' '+count+' ');  
	                        jump(count);  
	                    } else {  
	                        history.go(-1); 
	                    }  
	                }, 1000);  
	            }  
	            jump(15);  
	        });  
	    </script> 
		<style type="text/css">
		<!--
		*{margin:0 auto; padding:0; list-style-type:none;}
		body{font-size:12px;line-height: 1.5;color: #333;font-family:'宋体'，Verdana, Arial, Helvetica, sans-serif;height:100%;text-align:center;}
		li{list-style:none;}
		ul, ol, li, img  {margin:0; padding:0; border:0;}
		button,input{border:0;background:none;margin:0;padding:0; cursor:pointer;}
		table,th,td {border-collapse:collapse;}
		th {font-weight:normal;}
		.clear{ clear:both;height:1px;  margin-top:-1px;  overflow:hidden;}
		.mainbox{width:474px; height:258px; margin:0 auto; padding:0; text-align:center;background:#f0f8ff;overflow:hidden;}
		.false{padding-top:80px;width:250px; overflow:hidden; clear:both; color:#333333;}
		.false span{float:left; width:39px; overflow:hidden; clear:both; }
		.false ul{ width:200px;float:right;}
		.false li{ display:block; float:left; text-align:left; width:200px; height:18px;line-height:18px;}
		a:link {color: #0066FF;text-decoration: underline;}
		a:hover {color: #660099;text-decoration: underline;}
		a:active {color: #660099;text-decoration: underline;}
		.quxiao input{ margin-top:20px; margin-right:20px;float:right;width:73px; height:21px;background:url(common/images/tip/cancel.jpg) no-repeat;}
		 -->
		</style>
	</head>

	<body>
	<br /><br /><br /><br /><br /><br />
	<div class="mainbox">
		<div class="false">
	        <span><img src="common/images/tip/false.jpg" /></span>
	    	<ul>
	        	<li>提示：</li>
            	<li><font color="blue"><s:property value="resultmsg"/></font></li>
	            <li>还有<font id="num" color="red"> 15 </font>秒页面自动跳转...</li>
	        </ul>
	    </div>
	   <br />
    <a href="javascript:history.go(-1);">返回上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>common/redirect_myquestions.action">查询结果</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>">返回首页</a>
	</div>
	
	</body>
</html>
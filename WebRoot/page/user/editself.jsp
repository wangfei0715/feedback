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
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>ADP反馈中心-用户注册</title>
		<link type="text/css" rel="stylesheet" href="common/css/login.css" />
		<link type="text/css" rel="stylesheet" href="common/css/register.css" />
		<style type="text/css">
		#editselfdiv {
			width: 650px;
			margin: 15px auto;
			padding: 20px;
			text-align: center;
			border: 1px solid #A4CDF2;
		}
		
		.editselfform .need{
			width:10px;
			color:#b20202;
		}
		.editselfform td{
			padding:1px 0;
		}
		.editselfform .inputxt,.editselfform textarea{
			border:1px solid #a5aeb6;
			width:196px;
			padding:2px;
		}
		.editselfform label{
			margin:0 26px 0 10px;
		}
		.editselfform .tip{
			line-height:20px;
			color:#5f6a72;
		}
		.editselfform select{
			width:202px;
		}
		.editselfformalter select{
			width:124px;
		}
		</style>
		<script src="common/js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript" src="common/js/plugin/validform.js"></script>
		<script language="javascript" type="text/javascript" src="common/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(function(){
			$(".editselfform:last").Validform({
				tiptype:2, // 1为弹窗，2为右侧提示
				ajaxurl:"<%=path %>/manager/my_updateSelf.action",
				callback:function(data){
					var result = $(data).find("result");
					var msg = result.attr("msg");
					var status = result.attr("status");
					if(status=="1"){
						$.Hidemsg();
						$.Showmsg(msg);
						setTimeout(function(){
							$.Hidemsg();
						},6000);
					}else{
						$.Hidemsg();
						$.Showmsg(msg);
						setTimeout(function(){
							$.Hidemsg(); //公用方法关闭信息提示框;
						},2000);
					}
				}
			});
				
		})
		</script>
	</head>
	<body>
		<div id="editselfdiv">
		<fieldset>
		<legend>
			个人信息
		</legend>
		<form class="editselfform" action="<%=basePath%>manager/my_updateSelf.adp" method="post">
	    <table width="100%" style="table-layout:fixed;">
	    	<tr>
	            <td class="need" style="width:10px;">*</td>
	            <td style="width:80px;">旧密码：</td>
	            <td style="width:205px;"><input type="text" value="" name="oldpassword" class="inputxt" datatype="*" ajaxurl="<%=path %>/manager/ajax_checkPwd.action" nullmsg="请输入旧密码！" errormsg="旧密码输入错误！" /></td>
	            <td><div class="Validform_checktip">请输入旧密码！</div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;">*</td>
	            <td style="width:80px;">用户名：</td>
	            <td style="width:205px;"><s:property value="user.loginname"/> </td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;">*</td>
	            <td style="width:80px;">昵称：</td>
	            <td style="width:205px;"><input type="text" value="<s:property value="user.username"/>" name="user.username" class="inputxt" datatype="*" nullmsg="请输入昵称！" errormsg="昵称不能为空！" /></td>
	            <td><div class="Validform_checktip">昵称不能为空</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>密码：</td>
	            <td><input type="password" value="" id="userpassword" name="user.password" class="inputxt" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间,不能使用空格！" /></td>
	            <td><div class="Validform_checktip">密码范围在6~16位之间,不能使用空格</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>确认密码：</td>
	            <td><input type="password" value="" name="userpassword2" class="inputxt" datatype="*" recheck="userpassword" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" /></td>
	            <td><div class="Validform_checktip">两次输入密码需一致</div></td>
	        </tr>
	        <tr>
	            <td class="need">*</td>
	            <td>Email：</td>
	            <td><input type="text" value="<s:property value="user.email"/>" name="user.email" class="inputxt" datatype="e" nullmsg="请输入您常用的邮箱！" errormsg="请输入您常用的邮箱！" /></td>
	            <td><div class="Validform_checktip">请输入您常用的邮箱</div></td>
	        </tr>
	        <tr></tr><tr></tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">手机号码：</td>
	            <td style="width:205px;"><input type="text" value="<s:property value="user.tel"/>" name="user.tel" datatype="m" ignore="ignore" class="inputxt" errormsg="请填入正确的手机号码！"/></td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">性别：</td>
	            <td style="width:205px;">
	            	<s:select list="#{0:'选择',1:'男',2:'女'}" name="user.userinfo.sex"></s:select>
	            </td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">生日：</td>
	            <td style="width:205px;"><input type="text" value="<s:date name="user.userinfo.birthday" format="yyyy-MM-dd" />" name="user.userinfo.birthday" class="inputxt" onclick="WdatePicker({isShowWeek:true})"/></td>
	            <td><div class="Validform_checktip">格式yyyy-MM-dd</div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">QQ：</td>
	            <td style="width:205px;"><input type="text" value="<s:property value="user.userinfo.qq"/>" name="user.userinfo.qq" class="inputxt"/></td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">星座：</td>
	            <td style="width:205px;">
	            	<s:select list="#{0:'选择',1:'水瓶座',2:'双鱼座',3:'白羊座',4:'金牛座',5:'双子座',6:'巨蟹座',7:'狮子座',8:'处女座',9:'天平座',10:'天蝎座',11:'射手座',12:'魔蝎座'}" name="user.userinfo.constellation"></s:select>
	            </td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">生肖：</td>
	            <td style="width:205px;">
	            	<s:select list="#{0:'选择',1:'鼠',2:'牛',3:'虎',4:'兔',5:'龙',6:'蛇',7:'马',8:'羊',9:'猴',10:'鸡',11:'狗',12:'猪'}" name="user.userinfo.zodiac"></s:select>
				</td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;"></td>
	            <td style="width:80px;">个人签名：</td>
	            <td style="width:205px;"><input type="text" value="<s:property value="user.userinfo.selfinfo"/>" name="user.userinfo.selfinfo" class="inputxt"/></td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        <tr>
	            <td class="need" style="width:10px;">*</td>
	            <td style="width:80px;">积分：</td>
	            <td style="width:205px;"><s:property value="user.score"/> </td>
	            <td><div class="Validform_checktip"></div></td>
	        </tr>
	        
	        <tr>
	            <td class="need"></td>
	            <td></td>
	            <td colspan="2" align="right">
	                <input type="submit" value="提 交" class="buttom"/>
	            </td>
	        </tr>
	    </table>
		</form>
		</fieldset>
		</div>
	</body>
</html>
<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>common/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
function saveEditorContent(){
	var oEditor = CKEDITOR.instances.usermessage;
	// alert(oEditor.getData());
	var title = $("#title").val();
	var content = oEditor.getData();
	content = content.replace(/<[^>]+>/g,"");
    content = content.replace(/\&nbsp;/g,"");
	//document.getElementById("content").value = content;
	$("#messageContent").val(content);
	// alert(content);
	// alert(document.getElementById("content").value);
	if(title == "" || title.length <4){
		alert("标题不得少于4个字符");
		return false;
	}else if(content.length < 10 || content.length >10000){
		alert("内容字数限制在10-10000字符内");
		return false;
	}
	return true;
}

function preSaveEditorContent(){
	var oEditor = CKEDITOR.instances.usermessage;
	// alert(oEditor.getData());
	var content = oEditor.getData();
	content = content.replace(/<[^>]+>/g,"");
    content = content.replace(/\&nbsp;/g,"");
	$("#messageContent").val(content);
	//alert($("#content").val());
}
</script>
<div class="lay-main">
	<div class="main-wrap">
		<div class="mod-box-e">
			<b class="r-t"><b></b> </b>
			<div class="bc-e">
				<div class="submit-form">
					<h4><s:property value="title" />
						 <i class="icon-s icon-til"></i>
						 <s:if test="feedbackType == 1">
				           您好,这里是 反馈中心,欢迎您留下你在使用我们产品中产生的疑问!
				         </s:if>
				         <s:elseif test="feedbackType == 2">
				           您好,这里是 反馈中心,欢迎您给我们提供产品的使用感受和意见建议!
				         </s:elseif>
					</h4>
					<s:if test="feedbackType == 2">
				    <div class="sug-til"><i class="icon-s icon-til-sug"></i>如果您的建议被采纳，可获得积分奖励。</div>
				    </s:if>
					
					<div class="form-table">
						<form action="<%=basePath%>message/message_save.action" method="post" id="form1" onsubmit="return saveEditorContent();">
							<table width="100%" border="0" cellpadding="0" cellspacing="5">
								<tr>
									<th valign="top">
										<label>
											<span>*</span> 选择项目：
										</label>
									</th>
									<td>
										<input name="message.type" type="hidden" value="<s:property value="feedbackType" />" />
										<input name="message.content" id="messageContent" type="hidden" />
										<select name="catalogid" id="catalog">
											<s:iterator value="catalogs">
											<option value="<s:property value="catalogid" />">
												<s:property value="catalogname" />
											</option>
											</s:iterator>
										</select>
									</td>
								</tr>
								<tr>
									<th valign="top">
										<label>
											<span>*</span> 反馈标题：
										</label>
									</th>
									<td>
										<input name="message.title" type="text" vali="notempty" id="title"
											maxlength="36" style="width: 525px" />
									</td>
								</tr>
								<tr>
									<th valign="top">
										<label>
											<span>*</span> 反馈内容
										</label>
										：
									</th>
									<td>
										<div>
											<textarea id="usermessage" name="usermessage" cols="20" rows="2"></textarea>
											<script type="text/javascript">
											CKEDITOR.replace( 'usermessage',
											{
											});
											</script>
										</div>

									</td>
								</tr>
								<tr>
									<th>
										&nbsp;
									</th>
									<td>
										<div class="repay-submit">
											<input id="submit1" type="submit" class="btn btn-submit"
												value="提交问题" />
										</div>
									</td>
								</tr>
							</table>

						</form>

					</div>

				</div>

			</div>
			<b class="r-b"><b></b> </b>
		</div>
	</div>
</div>
<script src="common/js/formValidator.js"></script>
<script>
    function check_qq(){
        var email = $("#email");
        var reg = new RegExp("^[1-9][0-9]{4,9}$");
        if(reg.test(email.val())){
            email.attr("value",email.val()+"@qq.com");
        }
    }
    $(document).ready(function(){
        $("#form1").submit(function(){
          
            var error = "发生以下错误:\n";
            var tf = true;
            var i =1;
            var app = $("#application").val();
            var title = $("#title").val();
            var msg  = $("#messages").val();
                        if(app == 0){
                error +=i +":";
                i++;
                error +="未选择项目\n";
                tf = false;
            }
            if(title == "" || title.length <4){
                 error +=i +":";
                 i++;
                 error += "标题不得少于4个字符\n";
                 tf = false;
            }
            var le = GetMessageLength("messages");
            if(le < 10 || le >10000){
                 error +=i +":";
                 i++;
                 error += "内容字数限制在10-10000字符内\n";
                 tf = false;
            }
            
            if(!tf){
                alert(error);
                return false;
            }
            $('#submit1').val("正在提交...");
            $('#submit1').attr("disabled",true);
            return true;
        })
    })
    function tip_c(){
        $("#tip").hide();
        //$("iframe_topic").focus();
    }


    //取fck内容的长度
    function GetMessageLength(str)
    {
    var oEditor = FCKeditorAPI.GetInstance(str) ;
    var oDOM = oEditor.EditorDocument ;
    var iText ;
    var iLength;
    if ( document.all )        // If Internet Explorer.
    {
        iText = oDOM.body.innerText ;
    }
    else                    // If Gecko.
    {
        var r = oDOM.createRange() ;
        r.selectNodeContents( oDOM.body ) ;
        iText = r.toString() ;
    }
    //    oEditor.InsertHtml('')
    iText = iText.replace(/<[^>]+>/g,"");
    iText = iText.replace(/\&nbsp;/g,"");
    iLength = iText.length;
    return iLength;
 }

function show_note(){
     var app = $("#application").val();
     var message = new Array();
     message[3] = "温馨提示：<br />请提供对应网盘账号的昵称,注册时间(大概年月),注册时的所在地,注册时的IP地址，最近登录的IP记录( 可登录后点击安全设置查看 )，将以上资料发送至Email ，官方工作人员会在24小时内受理。";
     message[111] = "温馨提示：1、为节省您的宝贵时间，如果您确定已充值成功但系统显示未付款的，请登录网上银行获取网银订单号后提供给客服核实。2、查询话费是否到账可以拨打运营商客服电话（移动：10086、电信：10000、联通：10010）。";
     var message_show = "温馨提示：<br />1.感谢您对ADQ的关注,欢迎在此提出您宝贵的建议和意见。<br />2.我们也许无法一一回复,但我们会认真阅读,您的支持是我们前进的最大的动力。<br />3.请至少输入10个汉字。";
     if(typeof(message[app]) != "undefined"){
         message_show = message[app];
     }
         $("#note").html(message_show);
}
// show_note();
</script>
// JavaScript Document
// 那个问题内容 
function ajax_view(fid){
var opt = $("#opt_"+fid);
if($("#icon_"+fid).attr("ref")=="close"){
    $("#icon_"+fid).addClass("icon-open");
    $("#icon_"+fid).attr("ref","open");
    $("#icon_"+fid).removeClass("icon-close");
    $("#dd_"+fid).removeClass("cur");
    opt.slideUp("fast");
}else{
    if ($("#dd_"+fid).attr('rel') == "new"){
    var noread = $("#noread").html();
    noread = parseInt(noread);
    if(noread >0){
    noread--;
    }
    $("#noread").attr("innerHTML",noread);
}

if(!opt.attr("innerHTML")){
$.ajax({
  url: "?ct=feedback&ac=ajax_view&fid="+fid,
  cache: false,
  success: function(html){
   opt.append(html);
  }
});
}
$("dd[id^=opt_]").hide();
$("#dd_"+fid).removeClass("new");
$("dd[id^=dd_]").removeClass("cur");
$("i[id^=icon_]").removeClass("icon-close");
$("i[id^=icon_]").addClass("icon-open");
$("i[id^=icon_]").attr("ref","open");


$("#icon_"+fid).removeClass("icon-open");
$("#icon_"+fid).attr("ref","close");
$("#icon_"+fid).addClass("icon-close");
$("#dd_"+fid).addClass("cur");

opt.slideDown("fast");
}
}
// 访问关闭php,关闭用户的问题
function ajax_close(fid){
$.ajax({
  url: "?ct=feedback&ac=ajax_close&fid="+fid,
  cache: false,
  success: function(html){
    $("#bdiv_"+fid).hide();
    $("#note_"+fid).attr("innerHTML","(该问题已经关闭)");

  }
});
}

// 展开ask框
function ask(fid){
    $("#reply_frame_"+fid).append($("#fck_d").html());

    $("div[id^=reply_box_]").hide();
    $("#reply_box_"+fid).show();
}
// JavaScript Document
var editor = "http://feedback.115.com/?ac=editor";
var app_id = "feedback";
var vkey = "12345";




var url = window.location.href;
var regex = /.*\:\/\/([^\/]*).*/;
var mat = url.match(regex);
var host = mat[1];


function editor_init(text_id,iframe_id,b){
	var txtval = $("#"+text_id).html();
	var obj_iframe = $("#"+iframe_id);
        var obj_form = document.createElement("form");

        var w = obj_iframe.attr("width");
        var h = obj_iframe.attr("height")-5;
        var t = new Date();
	var src = editor+"&host="+host+"&app_id="+app_id+"&vkey="+vkey+"&txtkey="+text_id+"&w="+w+"&h="+h+"&t="+t.getTime();
        if(b>0){
            src +="&b=1";
        }
        obj_form.setAttribute("action",src);
	if(txtval&&txtval.length >0){
        // alert(src);
	obj_form.setAttribute("name","from_"+text_id);
	obj_form.setAttribute("method","POST");
	obj_form.setAttribute("target",obj_iframe.attr("name"));
	
	if(txtval){
	var obj_txt = document.createElement("input");
	obj_txt.setAttribute("type","hidden");
	obj_txt.setAttribute("name","txtval");
	obj_txt.setAttribute("value",txtval);
        // alert(txtval);
	obj_form.appendChild(obj_txt);
	}
	document.body.appendChild(obj_form);
	obj_form.submit();
        }
        else{
            obj_iframe.attr("src",src);
        }
}
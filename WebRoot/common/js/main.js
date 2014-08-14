var isIE6=$.browser.version==6&&$.browser.msie;

if (isIE6) {
    document.execCommand("BackgroundImageCache", false, true);  //IE6下缓存背景图
}

function addFav() {
	var title = document.title;
	var url = document.location.href;
	if (window.sidebar) { 
	window.sidebar.addPanel(title, url,""); 
	} else if( document.all ) {
	window.external.AddFavorite( url, title);
} else if( window.opera && window.print ) {
return true;
}
}


/*
* js 实现伪类
*/
function tagHover(id,tag){
	var obj = document.getElementById(id).getElementsByTagName(tag);
	for(var i=0;i<obj.length;i++){
		obj[i].onmouseover=function(){this.className+=(this.className.length>0? " ": "") + "hover"; }
		obj[i].onmouseout=function(){this.className=this.className.replace(new RegExp("( ?|^)hover\\b"),""); }
	}
}

var Public = {};

Public.Config = {
    //遮罩层背景颜色
    Screen_Background: "#999",
    //遮罩层透明度
    Screen_Opacity: "2",
    //遮罩层内容背景颜色
    Screen_ContentBg: "transparent",
    Screen_PositionTop:"0",
    Screen_PositionLeft:"50%"
}
/*
* 弹出层
*/
Public.ScreenManager = {
    //获取滚动条高度
    GetScrollTop:function(){
        var scrollTop=0;
        if(document.documentElement&&document.documentElement.scrollTop){
            scrollTop=document.documentElement.scrollTop;
        }else if(document.body){
            scrollTop=document.body.scrollTop;
        }
        return scrollTop;
    },
    /*Public 隐藏方法*/
    Hide: function(doFun){
        this.canClose = true;
        this.popCoverDiv(false);
        if(doFun){
            doFun();
        }
    },
    /*Public 显示方法*/
    Show: function(containBox,isClickHide,type,url){
        if(isClickHide != undefined){
            Public.ScreenManager.IsClickHide = isClickHide;
        }
        else{
            Public.ScreenManager.IsClickHide = false;
        }
        Public.ScreenManager.setMiddle(containBox);
        this.popCoverDiv(true,containBox);

		if(typeof(url) == "string" ){
			var goto = UrlEncode("http://"+document.domain+"/"+url);
			var href = $("#login_form").attr("action");
			var reg=new RegExp("goto=(.*)$","g"); 
			var href = href.replace(reg,"goto="+UrlDecode(goto));
			$("#login_form").attr("action",href.replace(reg,"goto="+goto));
		}
		if(type){
			$("#noname").show();
			var href = $("#noname").attr("href");
			$("#noname").attr("href",href+"&type="+type);
		}
		else{
			$("#noname").hide();
		}
    },
    //取得页面的高宽
    getBodySize: function (){
        var bodySize = [];
        with(document.documentElement) {
            bodySize[0] = (scrollWidth>clientWidth)?scrollWidth:clientWidth;//如果滚动条的宽度大于页面的宽度，取得滚动条的宽度，否则取页面宽度
            bodySize[1] = (scrollHeight>clientHeight)?scrollHeight:clientHeight;//如果滚动条的高度大于页面的高度，取得滚动条的高度，否则取高度
        }
        return bodySize;
    },
    //弹出框居中显示 add:zen
    setMiddle:function(containBox){
        if(isIE6){
            with (document.documentElement) {
                var tops=Public.ScreenManager.GetScrollTop()+85;
            }
            containBox.style.top=tops+"px";
        }else{
            containBox.style.position="fixed";
        }
        return containBox;
    },
    config:{
        cachebox:"screen_cache_box",/*缓存层*/
        contentbox:"screen_content_box",/*内容层*/
        coverbox:"screen_cover_div",/*透明层*/
        gonebox:"screen_gone_box"	/*移位缓存层*/
    },
    canClose:true,
    ShowSelfControl:function(containBox,showFun){
        Public.ScreenManager.IsClickHide = true;
        this.popCoverDiv(3,containBox,undefined,showFun);
    },
    //创建遮盖层
    popCoverDiv: function (isShow,containBox,setWidth,showFun){
        var screenBox = document.getElementById(Public.ScreenManager.config.coverbox);
        if (!screenBox) {
            //如果存在遮盖层，则让其显示
            //否则创建遮盖层
            var coverDiv = document.createElement('div');
            document.body.appendChild(coverDiv);
            coverDiv.id = Public.ScreenManager.config.coverbox;
            var bodySize;
            with(coverDiv.style) {
                if ($.browser.msie && $.browser.version == 6) {
                    position = 'absolute';
                    background = Public.Config.Screen_Background;
                    left = '0px';
                    top = '0px';
                    bodySize = this.getBodySize();
                    width = '100%';
                    height = bodySize[1] + 'px';
                }
                else{
                    position = 'fixed';
                    background = Public.Config.Screen_Background;
                    left = '0';
                    top = '0';
                    width = '100%'
                    height = '100%';
                }
                zIndex = 99;
                if (document.all) {
                    filter = "Alpha(Opacity=" + Public.Config.Screen_Opacity + "0)";	//IE逆境
                } else {
                    opacity = Number("0."+Public.Config.Screen_Opacity);
                }
            }
            coverDiv.onclick = function(){
                if(Public.ScreenManager.canClose){
                    if(Public.ScreenManager.IsClickHide == undefined || Public.ScreenManager.IsClickHide == false){
                        //coverDiv.style.display = "none";
                        //document.getElementById(Public.ScreenManager.config.contentbox).style.display = "none";
						Public.ScreenManager.Hide();
                    }
                }
            };

            var contentDiv = document.createElement("div");
            contentDiv.id = Public.ScreenManager.config.contentbox;
            with(contentDiv.style){
                position = "absolute";
                backgroundColor = Public.Config.Screen_ContentBg;
                var widthNum = Number(setWidth != undefined?setWidth:500);
                width = widthNum + "px";
                left = Public.Config.Screen_PositionLeft;
                var mfNum = widthNum/2;
                marginLeft = "-" + mfNum + 'px';
                top = Public.Config.Screen_PositionTop;
                zIndex = 100;
            }
            document.body.appendChild(contentDiv);
            contentDiv.onmouseover = function(){
                Public.ScreenManager.canClose = false;
            };

            contentDiv.onmouseout = function(){
                Public.ScreenManager.canClose = true;
            };
            screenBox = contentDiv;
        }
        screenBox.style.display = isShow ? "block" : "none" ;
        if(isShow == 3){
            if(showFun){
                showFun();
            }
        }
        else{
            document.getElementById(Public.ScreenManager.config.contentbox).style.display = isShow ? "block" : "none" ;
            if(isShow && containBox){
                //创建Cache Box
                var cacheBox = document.getElementById(Public.ScreenManager.config.cachebox);
                if(!cacheBox){

                    var cBox = document.createElement("div");
                    document.body.appendChild(cBox);
                    cBox.id = Public.ScreenManager.config.cachebox;
                    cBox.style.display = "none";
                    cacheBox = cBox;
                }

                var goneBox = document.getElementById(Public.ScreenManager.config.gonebox);
                if(!goneBox){
                    var gBox = document.createElement("div");
                    document.body.appendChild(gBox);
                    gBox.id = Public.ScreenManager.config.gonebox;
                    gBox.style.display = "none";
                    goneBox = cBox;
                }

                var cBox = document.getElementById(Public.ScreenManager.config.contentbox);
                var contentNodes = cBox.childNodes;
                for(var i = 0,len = contentNodes.length; i < len; i++){
                    cacheBox.appendChild(contentNodes[i]);
                }
                containBox.style.display = "";
                cBox.appendChild(containBox);
            }
        }
		var hide_tags = ["select","iframe"];
		if(isShow){
			for(var iN = 0,Nlen = hide_tags.length; iN < Nlen; iN++){
				var selList = document.getElementsByTagName(hide_tags[iN]);
				for(var i = 0,len = selList.length; i < len; i++){
					selList[i].style.visibility = "hidden";
				}
				selList = containBox.getElementsByTagName(hide_tags[iN]);
				for(var i = 0,len = selList.length; i < len; i++){
					selList[i].style.visibility = "";
				}
			}
		}
		else{
			for(var iN = 0,Nlen = hide_tags.length; iN < Nlen; iN++){
				var selList = document.getElementsByTagName(hide_tags[iN]);
				for(var i = 0,len = selList.length; i < len; i++){
					selList[i].style.visibility = "";
				}
			}
		}
        this.canClose = true;
    }
}


function UrlEncode(str)
{ 
     var ret=""; 
     var strSpecial="!\"#$%&()*+,/:;<=>?[]^`{|}~%"; var tt="";
     for(var i=0;i<str.length;i++)
     { 
         var chr = str.charAt(i); 
         var c=str2asc(chr); 
         tt += chr+":"+c+"n"; 
         if(parseInt("0x"+c) > 0x7f)
         { 
             ret+="%"+c.slice(0,2)+"%"+c.slice(-2); 
         }
         else
         { 
             if(chr==" ") 
                 ret+="+"; 
             else if(strSpecial.indexOf(chr)!=-1) 
                 ret+="%"+c.toString(16); 
             else 
                 ret+=chr; 
         } 
     } 
     return ret; 
} 

function UrlDecode(str){ 
     var ret=""; 
     for(var i=0;i<str.length;i++)
     { 
         var chr = str.charAt(i); 
         if(chr == "+")
         { 
             ret+=" "; 
         }
         else if(chr=="%")
         { 
             var asc = str.substring(i+1,i+3); 
             if(parseInt("0x"+asc)>0x7f)
             { 
                 ret+=asc2str(parseInt("0x"+asc+str.substring(i+4,i+6))); 
                 i+=5; 
             }
             else
             { 
                 ret+=asc2str(parseInt("0x"+asc)); 
                 i+=2; 
             } 
         }
         else
         { 
             ret+= chr; 
         } 
     } 
     return ret; 
} 

function str2asc(str){
    return str.charCodeAt(0).toString(16);
}
function asc2str(str){
    return String.fromCharCode(str);
}
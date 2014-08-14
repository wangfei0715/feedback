
function checkNum(obj) {
	var flag = 0;
	var num = "0123456789";
	for (var i = 0; i < obj.value.length; i++) {
		tmp = obj.value.substring(i, i + 1);
		if (num.indexOf(tmp) < 0) {
			flag++;
		}
	}
	if (flag > 0) {
		alert("\u8bf7\u8f93\u5165\u5408\u6cd5\u7684\u6570\u5b57\uff01");
		obj.focus();
		obj.value = "";
		return (false);
	}
	return (true);
}
function checkMobileCode(obj) {
	var flag = 0;
	var num = "0123456789";
	for (var i = 0; i < obj.length; i++) {
		tmp = obj.substring(i, i + 1);
		if (num.indexOf(tmp) < 0) {
			flag++;
		}
	}
	if (flag > 0) {
		return (false);
	}
	return (true);
}
function strtrim(value) {
	for (; value.length > 0 && value.charAt(value.length - 1) == " "; ) {
		value = value.substring(0, value.length - 1);
	}
	for (; value.length > 0 && value.charAt(0) == " "; ) {
		value = value.substr(1);
	}
	return value;
}
/*
 * function xmlSend(strUrl, xmlDoc) { var xmlhttp = new
 * ActiveXObject("Msxml2.XMLHTTP"); var context = null; if (null !=
 * this.oDomDoc) { context =
 * this.oDomDoc.documentElement.getAttribute("Context"); } if (context != null) {
 * var rtn = strUrl.indexOf("?"); if (-1 == rtn) { strUrl += "?Context=" +
 * context; } else { strUrl += "&Context=" + context; } } xmlhttp.open("POST",
 * strUrl, false); xmlhttp.send(xmlDoc); return xmlhttp.responseXML; }
 */
function selwords() {
	window.open("normalwords.jsp", "\u9009\u62e9\u7528\u8bed");
}
function retrieveURL(url, nameOfFormToPost) {
	/*     alert(url);
     alert(nameOfFormToPost);*/
	// get the (form based) params to push up as part of the get request
	url = url + getFormAsString(nameOfFormToPost);
	//alert(url);
	
	// Do the Ajax call
	if (window.XMLHttpRequest) { // Non-IE browsers
		req = new XMLHttpRequest();
		req.onreadystatechange = processStateChange;
		try {
			req.open("GET", url, true); // was get
		}
		catch (e) {
			alert("Problem Communicating with Server\n" + e);
		}
		req.send(null);
	} else {
		if (window.ActiveXObject) { // IE
			req = new ActiveXObject("Microsoft.XMLHTTP");
			if (req) {
				req.onreadystatechange = processStateChange;
				req.open("GET", url, true);
				req.send();
			}
		}
	}
}
function getFormAsString(formName) {

	// Setup the return String
	returnString = "";

	// Get the form values
	formElements = document.forms[formName].elements;

	// loop through the array , building up the url
	// in the form /strutsaction.do&name=value
	for (var i = formElements.length - 1; i >= 0; --i) {
		// we escape (encode) each value
		if (returnString == "") {
			returnString = escape(formElements[i].name) + "=" + escape(encodeURIComponent(formElements[i].value));
		} else {
			returnString = returnString + "&" + escape(formElements[i].name) + "=" + escape(encodeURIComponent(formElements[i].value));
		}
	}

	// return the values
	return returnString;
}
/*
 * Set as the callback method for when XmlHttpRequest State Changes used by
 * retrieveUrl
 */
function processStateChange() {
	if (req.readyState == 4) { // Complete
		if (req.status == 200) { // OK response
			//alert(req.responseText);
			createStatus(req.responseText);
		} else {
			alert("Problem with server response:\n " + req.statusText);
		}
	}
}
function createXml(str) {
	if (document.all) {
		var xmlDom = new ActiveXObject("Microsoft.XMLDOM");
		xmlDom.loadXML(str);
		return xmlDom;
	} else {
		return new DOMParser().parseFromString(str, "text/xml");
	}
}
function createStatus(domStr) {
	var dom = createXml(domStr);
    //alert(domStr);
	var succList = null;
	var failureList = null;
	//prompt("",dom.xml);
	dom = dom.documentElement;
	// 获取当前系统日期和时间
	var myDate = new Date();
	myDate = myDate.toFormatString();
	// alert(dom.childNodes[0].tagName);
	for (var i = 0; i < dom.childNodes.length; i++) {
		if (dom.childNodes[i].tagName == "succList") {
			if (succList == null) {
				succList = "<br>" + dom.childNodes[i].text + myDate + "<br>";
			} else {
				succList = succList + dom.childNodes[i].text + myDate + "<br>";
			}
		} else {
			if (dom.childNodes[i].tagName == "failureList") {
				if (failureList == null) {
					failureList = "<br>" + dom.childNodes[i].text + myDate + "<br>";
				} else {
					failureList = failureList + dom.childNodes[i].text + myDate + "<br>";
				}
			}
		}
	}
	return succList;
	/*
	if (succList != null) {
		document.getElementById("A1").innerHTML = succList;
	}
	if (failureList != null) {
		document.getElementById("A2").innerHTML = failureList;
	}
	*/
}
function checkall(check) {
	var checkobj = $(":checkbox");
	checkobj.attr("checked", check);
	/*
	var a = document.getElementsByName(str);
	var objLen = a.length;
	var theObj;
	for (var i = 0; i < objLen; i++) {
		theObj = eval("document.postSmsForm.chk" + i);
		if (theObj != null) {
			theObj.checked = check;
		}
	}*/
}
function allcheck_onclick(obj) {
	if (obj.checked == true) {
		checkall(true);
	} else {
		checkall(false);
	}
}

function checkallmsg(check) {
	var checkobj = $("input[name='chk']");
	checkobj.attr("checked", check);
}
function allcheckmsg_onclick(obj) {
	if (obj.checked == true) {
		checkallmsg(true);
	} else {
		checkallmsg(false);
	}
}

function hasChecked(str) {
	var chk = $("input[name='"+str+"']");
	for (var i = 0; i < chk.length; i++){
		if (chk[i].checked == true) {
			return true;
		}
	}
	return false;
	/*
	var a = document.getElementsByName(str);
	var objLen = a.length;
	var theObj;
	for (var i = 0; i < objLen; i++) {
		theObj = eval("document.postSmsForm.chk" + i);
		if (theObj.checked == true) {
			return true;
		}
	}
	return false;
	*/
}
function gotopage(page) {
	if(checkNumber($("#gotopage").val())){
		window.location = page + $("#gotopage").val();
	}
	else{
		$("#gotopage").val("")
		return;
	}
}
function checkNumber(num) {
	var reg = /^\d+$/;
	if (!reg.test(num)) {
		alert("请您输入正确数字");
		return false;
	}else{
		return true;
	}
}
Date.prototype.toFormatString = function () {
	var strMonth = (this.getMonth() + parseInt(1)).toString();
	strMonth = (strMonth.length == 1) ? ("0" + strMonth) : strMonth;
	var strDate = this.getDate().toString();
	strDate = (strDate.length == 1) ? ("0" + strDate) : strDate;
	var strHour = this.getHours().toString();
	strHour = (strHour.length == 1) ? ("0" + strHour) : strHour;
	var strMin = this.getMinutes().toString();
	strMin = (strMin.length == 1) ? ("0" + strMin) : strMin;
	var strSen = this.getSeconds().toString();
	strSen = (strSen.length == 1) ? ("0" + strSen) : strSen;
	return this.getFullYear() + "-" + strMonth + "-" + strDate + " " + strHour + ":" + strMin + ":" + strSen;
};


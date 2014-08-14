Validator = {
    Require : /.+/,
    Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
    Phone : /(^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$)|(^((\(\d{2,3}\))|(\d{3}\-))?(1\d{10}|01\d{10})$)/,
    Mobile : /^((\(\d{2,3}\))|(\d{3}\-))?(1\d{10}|01\d{10})$/,
    Telephone:/^(((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?)$/,
    Url : /^(http|https|ftp):\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
    IdCard : "this.IsIdCard(value)",
    Age : "this.IsAge(value)",
    Currency : /^\d+(\.\d+)?$/,
    Number : /^\d+$/,
    Zip : /^[0-9]\d{5}$/,
    QQ : /^[1-9]\d{4,8}$/,
    Integer : /^[-\+]?\d+$/,
    Double : /^[-\+]?\d+(\.\d+)?$/,
    DoubleEx : /^[-\+]?\d+\.\d{2}$/,//DoubleEx : /^[-\+]?\d{8}\.\d{2}$/,====== /^[-\+]?\d{8}\+(\.\d{2}\+)$/
    English : /^[A-Za-z]+$/,
    Chinese :  /^[\u0391-\uFFE5]+$/,
    UserName : /^\w{1,}$/i,
    UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
    SpecialCharacter:/^([\u4e00-\u9fa5]|[a-zA-Z]|[\x21-\/]+|[\:-\@]+|[\x5b-\x60]+|[\{-\~]+|\s)*$/g,
    IsSafe : function(str) {return !this.UnSafe.test(str);},
    SafeString : "this.IsSafe(value)",
    Filter : "this.DoFilter(value, getAttribute('accept'))",
    LimitLength: "this.strlen(value,getAttribute('limitLen'))",
    Limit : "this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
    LimitB : "this.limit(this.LenB(value), getAttribute('min'), getAttribute('max'))",
    Date : "this.IsDate(value, getAttribute('format'))",
    Repeat : "value != document.getElementsByName(getAttribute('to'))[0].value",
    Range : "getAttribute('min') < parseInt(value) && parseInt(value) < getAttribute('max')",
    IntegerRange : "getAttribute('min') <= parseInt(value) && parseInt(value) < getAttribute('max')",
    DoubleRange : "getAttribute('min') <= parseInt(value) && parseInt(value) < getAttribute('max')",
    IntegerLimit:"this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
    DoubleLimit:"this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
    Compare : "this.compare(value,getAttribute('operator'),getAttribute('to'))",
    Custom : "this.Exec(value, getAttribute('regexp'))",
    Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",
    ErrorItem : [document.forms[0]],
    ErrorMessage : ["以下原因导致提交失败：\t\t\t\t"],
    tempIdCard : "",
    className2Function:{
        "number3":function(oFormElement) {
            number(oFormElement, 3);
        },
        "require3":function(oFormElement) {
            require(oFormElement, 3);
        },
        "email3":function(oFormElement) {
            email(oFormElement, 3);
        },
        "phone3":function(oFormElement) {
            phone(oFormElement, 3);
        },
        "mobile3":function(oFormElement) {
            mobile(oFormElement, 3);
        },
        "telephone3":function(oFormElement) {
            telephone(oFormElement, 3);
        },
        "idCard3":function(oFormElement) {
            idCard(oFormElement, 3);
        },
        "age3":function(oFormElement) {
            age(oFormElement, 3);
        },
        "url3":function(oFormElement) {
            url(oFormElement, 3);
        },
        "qq3":function(oFormElement) {
            qq(oFormElement, 3);
        },
        "integer3":function(oFormElement) {
            integer(oFormElement, 3);
        },
        "double3":function(oFormElement) {
            double1(oFormElement, 3);
        },
        "doubleEx3":function(oFormElement) {
            double2(oFormElement, 3);
        },
        "english3":function(oFormElement) {
            english(oFormElement, 3);
        },
        "chinese3":function(oFormElement) {
            chinese(oFormElement, 3);
        },
        "date3":function(oFormElement) {
            date(oFormElement, 3);
        },
        "filter3":function(oFormElement) {
            filter(oFormElement, 3);
        },
        "compare3":function(oFormElement) {
            compare(oFormElement, 3);
        },
        "compare_lessThan3":function(oFormElement) {
            compare_lessThan(oFormElement, 3);
        },
        "compare_greaterThan3":function(oFormElement) {
            compare_greaterThan(oFormElement, 3);
        },
        "compare_greaterThanEqual3":function(oFormElement) {
            compare_greaterThanEqual(oFormElement, 3);
        },
        "compare_lessThanEqual3":function(oFormElement) {
            compare_lessThanEqual(oFormElement, 3);
        },
        "compare_notEqual3":function(oFormElement) {
            compare_notEqual(oFormElement, 3);
        },
        "currency3":function(oFormElement) {
            currency(oFormElement, 3);
        },
        "userName3":function(oFormElement) {
            userName(oFormElement, 3);
        },
        "unSafe3":function(oFormElement) {
            unSafe(oFormElement, 3);
        },
        "safeString3":function(oFormElement) {
            safeString(oFormElement, 3);
        },
        "limitLength3":function(oFormElement) {
            limitLength(oFormElement, 3);
        },
        "limit3":function(oFormElement) {
            limit(oFormElement, 3);
        },
        "limitB3":function(oFormElement) {
            limitB(oFormElement, 3);
        },
        "repeat3":function(oFormElement) {
            repeat(oFormElement, 3);
        },
        "range3":function(oFormElement) {
            range(oFormElement, 3);
        },
        "custom3":function(oFormElement) {
            custom(oFormElement, 3);
        },
        "group3":function(oFormElement) {
            group(oFormElement, 3);
        },
        "zip3":function(oFormElement) {
            zip(oFormElement, 3);
        },
        "integerRange3":function(oFormElement) {
            integerRange(oFormElement, 3);
        },
        "doubleRange3":function(oFormElement) {
            doubleRange(oFormElement, 3);
        },
        "SpecialCharacter3":function(oFormElement) {
            SpecialCharacter(oFormElement, 3);
        },
        "number2":function(oFormElement) {
            number(oFormElement, 2);
        },
        "require2":function(oFormElement) {
            require(oFormElement, 2);
        },
        "email2":function(oFormElement) {
            email(oFormElement, 2);
        },
        "phone2":function(oFormElement) {
            phone(oFormElement, 2);
        },
        "mobile2":function(oFormElement) {
            mobile(oFormElement, 2);
        },
        "telephone2":function(oFormElement) {
            telephone(oFormElement, 2);
        },
        "idCard2":function(oFormElement) {
            idCard(oFormElement, 2);
        },
        "age2":function(oFormElement) {
            age(oFormElement, 2);
        },
        "url2":function(oFormElement) {
            url(oFormElement, 2);
        },
        "qq2":function(oFormElement) {
            qq(oFormElement, 2);
        },
        "integer2":function(oFormElement) {
            integer(oFormElement, 2);
        },
        "double2":function(oFormElement) {
            double1(oFormElement, 2);
        },
        "doubleEx2":function(oFormElement) {
            double2(oFormElement, 2);
        },
        "english2":function(oFormElement) {
            english(oFormElement, 2);
        },
        "chinese2":function(oFormElement) {
            chinese(oFormElement, 2);
        },
        "date2":function(oFormElement) {
            date(oFormElement, 2);
        },
        "filter2":function(oFormElement) {
            filter(oFormElement, 2);
        },
        "compare2":function(oFormElement) {
            compare(oFormElement, 2);
        },
        "compare_lessThan2":function(oFormElement) {
            compare_lessThan(oFormElement, 2);
        },
        "compare_greaterThan2":function(oFormElement) {
            compare_greaterThan(oFormElement, 2);
        },
        "compare_greaterThanEqual2":function(oFormElement) {
            compare_greaterThanEqual(oFormElement, 2);
        },
        "compare_lessThanEqual2":function(oFormElement) {
            compare_lessThanEqual(oFormElement, 2);
        },
        "compare_notEqual2":function(oFormElement) {
            compare_notEqual(oFormElement, 2);
        },
        "currency2":function(oFormElement) {
            currency(oFormElement, 2);
        },
        "userName2":function(oFormElement) {
            userName(oFormElement, 2);
        },
        "unSafe2":function(oFormElement) {
            unSafe(oFormElement, 2);
        },
        "safeString2":function(oFormElement) {
            safeString(oFormElement, 2);
        },
        "limitLength2":function(oFormElement) {
            limitLength(oFormElement, 2);
        },
        "limit2":function(oFormElement) {
            limit(oFormElement, 2);
        },
        "limitB2":function(oFormElement) {
            limitB(oFormElement, 2);
        },
        "repeat2":function(oFormElement) {
            repeat(oFormElement, 2);
        },
        "range2":function(oFormElement) {
            range(oFormElement, 2);
        },
        "custom2":function(oFormElement) {
            custom(oFormElement, 2);
        },
        "group2":function(oFormElement) {
            group(oFormElement, 2);
        },
        "zip2":function(oFormElement) {
            zip(oFormElement, 2);
        },
        "integerRange2":function(oFormElement) {
            integerRange(oFormElement, 2);
        },
        "doubleRange2":function(oFormElement) {
            doubleRange(oFormElement, 2);
        },
        "SpecialCharacter2":function(oFormElement) {
            SpecialCharacter(oFormElement, 2);
        }
    },
    ValidateTextArea:function (theForm, mode){

        var obj = theForm || $event(event);
        if (mode == 1) {   //验证DIV
            while (obj.tagName.toLowerCase() != 'div')
            {
                obj = obj.parentNode;
            }
        }
        else if (mode == 2) {
            while (obj.tagName.toLowerCase() != 'td')
            {
                obj = obj.parentNode;
            }
        }
        for (var i = 0; i < obj.getElementsByTagName('TEXTAREA').length; i++) {
            var textareaobj = obj.getElementsByTagName('textarea')[i];
            if (textareaobj.getAttribute("oldclassName") == null && textareaobj.getAttribute("oldtitle") == null){
                textareaobj.setAttribute("oldclassName", textareaobj.className);
                textareaobj.setAttribute("oldtitle", textareaobj.title);
            }
            this.ClearState(textareaobj);
            if (textareaobj.getAttribute("className") == "must"){
                if (this.Trim(textareaobj.value) == "") {
                    textareaobj.title = textareaobj.getAttribute("msg");
                    return false;
                }
            }

        }
        return true;
    },
    Validate:function(theForm, mode, df, da) {
        //alert(pp);
        var obj = theForm || $event(event);
        var theForm = theForm || $event(event);
        if (mode == 1) {   //验证DIV
            while (obj.tagName.toLowerCase() != 'div')
            {
                obj = obj.parentNode;
            }
        }
        else if (mode == 2 || mode == 3) {
            while (obj.tagName.toLowerCase() != 'td'){
                obj = obj.parentNode;
            }
        }
        var count = obj.getElementsByTagName('INPUT').length;
        this.ErrorMessage.length = 1;
        this.ErrorItem.length = 1;
        this.ErrorItem[0] = obj;
        for (var i = 0; i < count; i++) {
        	with (obj.getElementsByTagName('INPUT')[i]) {
        	    var value1 = value ;
                if(style.display=="none"){
                   continue;
                }
                if (getAttribute('prikey') != null){
                    if (getAttribute("oldclassName") == null && getAttribute("oldtitle") == null){
                        setAttribute("oldclassName", className);
                        setAttribute("oldtitle", title);
                    }
                    this.ClearState(obj.getElementsByTagName('INPUT')[i]);
                    if ((getAttribute("input_Must") == "true" && this.Trim(getAttribute("realvalue")) == "") ||
                        (getAttribute("dataType") == "Require" && this.Trim(getAttribute("realvalue")) == "")) {
                        if (getAttribute("msg")==""||getAttribute("msg")==null)msg="必填";
                        this.AddError(i, getAttribute("msg"));
                        title = getAttribute("msg");
                        var span = document.createElement("SPAN");
                        span.id = "__ErrorMessagePanel";
                        span.style.color = "red";
                        span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
                        parentNode.appendChild(span);
                        continue;
                    }
                    continue;
                }
                if (getAttribute("oldclassName") == null && getAttribute("oldtitle") == null){
                    setAttribute("oldclassName", className);
                    setAttribute("oldtitle", title);
                }
                if (getAttribute("input_Must") == "true" && this.Trim(value1) == "") {
                    this.AddError(i, getAttribute("msg"));
                    title = getAttribute("msg");
                    this.ClearState(obj.getElementsByTagName('INPUT')[i]);
                    var span = document.createElement("SPAN");
                    span.id = "__ErrorMessagePanel";
                    span.style.color = "red";
                    span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
                    parentNode.appendChild(span);
                    continue;
                }
                var _dataType = obj.getElementsByTagName('INPUT')[i].dataType;
                if (getAttribute("input_Must") == "true" || typeof(_dataType) != "object" || typeof(this[_dataType]) != "undefined") {
                    this.ClearState(obj.getElementsByTagName('INPUT')[i]);
                }
                if (typeof(_dataType) == "object" || typeof(this[_dataType]) == "undefined")  continue;
                if (this.Trim(value1) == "" && _dataType != "LimitLength" && _dataType != "Require") {
                    className = getAttribute("oldclassName");
                    title = getAttribute("oldtitle");
                    continue;
                }
                if (value1 != "" && getAttribute('prikey') == null){
                    value1 = this.Trim(value1);
                }
                var tempDataTypeArr = null;
	            if(_dataType!=null&&_dataType!="undefined"&&_dataType.indexOf(" ")!=-1){
	                tempDataTypeArr = _dataType.split(" ");
	            }
	            if(tempDataTypeArr != null){
	            	for(var ss = 0 ; ss <tempDataTypeArr.length ; ss++ ){
	                       var tempDataType = tempDataTypeArr[ss];
	                       switch (tempDataType) {
				                    case "IdCard" :
				                    case "Age" :
				                    case "Date" :
				                    case "Repeat" :
				                    case "Range" :
				                    case "Compare" :
				                    case "Custom" :
				                    case "Group" :
				                    case "Limit" :
				                    case "LimitB" :
				                    case "SafeString" :
				                    case "LimitLength":
				                    case "Filter" :
				                        if (!eval(this[tempDataType])) {
				                            this.AddError(i, getAttribute('msg'));
				                            title = getAttribute('msg');
				                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        } else {
				                            if (tempDataType == "IdCard") {
				                                value = this.tempIdCard;
				                            }
				                        }
				                        break;
				                    case "DoubleEx":
				                        if (!this[tempDataType].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                    case "IntegerLimit" :
				                    case "IntegerRange" :
				                        if (!eval(this[tempDataType]) || !this["Integer"].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                    case "DoubleLimit" :
				                    case "DoubleRange" :
				                        if (!eval(this[tempDataType]) || !this["Double"].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                    default :
				                        if (!this[tempDataType].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                }
				               var lastNode = parentNode.childNodes[parentNode.childNodes.length - 1];
                               if (lastNode.id == "__ErrorMessagePanel") {
                                  break;
                               }
				            }
				        }else{
		               switch (_dataType) {
		                    case "IdCard" :
		                    case "Age" :
		                    case "Date" :
		                    case "Repeat" :
		                    case "Range" :
		                    case "Compare" :
		                    case "Custom" :
		                    case "Group" :
		                    case "Limit" :
		                    case "LimitB" :
		                    case "SafeString" :
		                    case "LimitLength":
		                    case "Filter" :
		                        if (!eval(this[_dataType])) {
		                            this.AddError(i, getAttribute("msg"));
		                            title = getAttribute("msg");
		                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
		                            var span = document.createElement("SPAN");
		                            span.id = "__ErrorMessagePanel";
		                            span.style.color = "red";
		                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
		                            parentNode.appendChild(span);
		                        } else {
		                            if (_dataType == "IdCard") {
		                                value = this.tempIdCard;
		                            }
		                        }
		                        break;
		                    case "DoubleEx":
		                        if (!this[_dataType].test(value1)) {
		                            this.AddError(i, getAttribute("msg"));
		                            title = getAttribute("msg");
		                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
		                            var span = document.createElement("SPAN");
		                            span.id = "__ErrorMessagePanel";
		                            span.style.color = "red";
		                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
		                            parentNode.appendChild(span);
		                        }
		                        break;
		                    case "IntegerLimit" :
		                    case "IntegerRange" :
		                        if (!eval(this[_dataType]) || !this["Integer"].test(value1)) {
		                            this.AddError(i, getAttribute("msg"));
		                            title = getAttribute("msg");
		                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
		                            var span = document.createElement("SPAN");
		                            span.id = "__ErrorMessagePanel";
		                            span.style.color = "red";
		                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
		                            parentNode.appendChild(span);
		                        }
		                        break;
		                    case "DoubleLimit" :
		                    case "DoubleRange" :
		                        if (!eval(this[_dataType]) || !this["Double"].test(value1)) {
		                            this.AddError(i, getAttribute("msg"));
		                            title = getAttribute("msg");
		                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
		                            var span = document.createElement("SPAN");
		                            span.id = "__ErrorMessagePanel";
		                            span.style.color = "red";
		                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
		                            parentNode.appendChild(span);
		                        }
		                        break;
		                    default :
		                        if (!this[_dataType].test(value1)) {
		                            this.AddError(i, getAttribute("msg"));
		                            title = getAttribute("msg");
		                            this.ClearState(obj.getElementsByTagName('INPUT')[i]);
		                            var span = document.createElement("SPAN");
		                            span.id = "__ErrorMessagePanel";
		                            span.style.color = "red";
		                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
		                            parentNode.appendChild(span);
		                        }
		                        break;
		                }
		            }
		        }
        }
        
        var textareaCount = obj.getElementsByTagName('TEXTAREA').length;
        for (var i = 0; i < textareaCount; i++) {
            with (obj.getElementsByTagName('textarea')[i]) {
            	if(obj.getElementsByTagName('textarea')[i].style.display=="none"){
                   continue;
                }
                var value1 = obj.getElementsByTagName('textarea')[i].innerHTML ;
                if (getAttribute("oldclassName") == null && getAttribute("oldtitle") == null){
                    setAttribute("oldclassName", className);
                    setAttribute("oldtitle", title);
                }
                this.ClearState(obj.getElementsByTagName('textarea')[i]);
                var _dataType = obj.getElementsByTagName('textarea')[i].dataType;
                var tempDataTypeArr1 = null;
	            if(_dataType!=null&&_dataType!="undefined"&&_dataType.indexOf(" ")!=-1){
	                tempDataTypeArr1 = _dataType.split(" ");
	            }
	            if(tempDataTypeArr1 != null){
	            	for(var kk = 0 ; kk <tempDataTypeArr1.length ; kk++ ){
	                       var tempDataType = tempDataTypeArr1[kk];
	                           switch (tempDataType) {
				                    case "IdCard" :
				                    case "Age" :
				                    case "Date" :
				                    case "Repeat" :
				                    case "Range" :
				                    case "Compare" :
				                    case "Custom" :
				                    case "Group" :
				                    case "Limit" :
				                    case "LimitB" :
				                    case "SafeString" :
				                    case "LimitLength":
				                    case "Filter" :
				                        if (!eval(this[tempDataType])) {
				                            this.AddError(i,getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        } else {
				                            if (tempDataType == "IdCard") {
				                                value = this.tempIdCard;
				                            }
				                        }
				                        break;
				                    case "IntegerLimit" :
				                    case "IntegerRange" :
				                        if (!eval(this[tempDataType]) || !this["Integer"].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                    case "DoubleLimit" :
				                    case "DoubleRange" :
				                        if (!eval(this[tempDataType]) || !this["Double"].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                    case "DoubleEx":
				                        if (!this[tempDataType].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                    default :
				                        if (tempDataType != null && !this[tempDataType].test(value1)) {
				                            this.AddError(i, getAttribute("msg"));
				                            title = getAttribute("msg");
				                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
				                            var span = document.createElement("SPAN");
				                            span.id = "__ErrorMessagePanel";
				                            span.style.color = "red";
				                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
				                            parentNode.appendChild(span);
				                        }
				                        break;
				                }
				               var lastNode = parentNode.childNodes[parentNode.childNodes.length - 1];
                               if (lastNode.id == "__ErrorMessagePanel") {
                                  break;
                               }
	                  }
                }else{
                    switch (_dataType) {
	                    case "IdCard" :
	                    case "Age" :
	                    case "Date" :
	                    case "Repeat" :
	                    case "Range" :
	                    case "Compare" :
	                    case "Custom" :
	                    case "Group" :
	                    case "Limit" :
	                    case "LimitB" :
	                    case "SafeString" :
	                    case "LimitLength":
	                    case "Filter" :
	                        if (!eval(this[_dataType])) {
	                            this.AddError(i,getAttribute("msg"));
	                            title = getAttribute("msg");
	                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
	                            var span = document.createElement("SPAN");
	                            span.id = "__ErrorMessagePanel";
	                            span.style.color = "red";
	                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
	                            parentNode.appendChild(span);
	                        } else {
	                            if (_dataType == "IdCard") {
	                                value = this.tempIdCard;
	                            }
	                        }
	                        break;
	                    case "IntegerLimit" :
	                    case "IntegerRange" :
	                        if (!eval(this[_dataType]) || !this["Integer"].test(value1)) {
	                            this.AddError(i, getAttribute("msg"));
	                            title = getAttribute("msg");
	                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
	                            var span = document.createElement("SPAN");
	                            span.id = "__ErrorMessagePanel";
	                            span.style.color = "red";
	                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
	                            parentNode.appendChild(span);
	                        }
	                        break;
	                    case "DoubleLimit" :
	                    case "DoubleRange" :
	                        if (!eval(this[_dataType]) || !this["Double"].test(value1)) {
	                            this.AddError(i, getAttribute("msg"));
	                            title = getAttribute("msg");
	                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
	                            var span = document.createElement("SPAN");
	                            span.id = "__ErrorMessagePanel";
	                            span.style.color = "red";
	                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
	                            parentNode.appendChild(span);
	                        }
	                        break;
	                    case "DoubleEx":
	                        if (!this[_dataType].test(value1)) {
	                            this.AddError(i, getAttribute("msg"));
	                            title = getAttribute("msg");
	                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
	                            var span = document.createElement("SPAN");
	                            span.id = "__ErrorMessagePanel";
	                            span.style.color = "red";
	                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
	                            parentNode.appendChild(span);
	                        }
	                        break;
	                    default :
	                        if (_dataType != null && !this[_dataType].test(value1)) {
	                            this.AddError(i, getAttribute("msg"));
	                            title = getAttribute("msg");
	                            this.ClearState(obj.getElementsByTagName('textarea')[i]);
	                            var span = document.createElement("SPAN");
	                            span.id = "__ErrorMessagePanel";
	                            span.style.color = "red";
	                            span.innerHTML = "<br>"+this.ErrorMessage[this.ErrorMessage.length - 1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
	                            parentNode.appendChild(span);
	                        }
	                        break;
	                }
              }
            }
        }
        if (this.ErrorMessage.length > 1) {
            if (obj.getElementsByTagName('INPUT')[0]) {
                this.ClearState(obj.getElementsByTagName('INPUT')[0]);
            } else if (obj.getElementsByTagName('textarea')[0]) {
                this.ClearState(obj.getElementsByTagName('textarea')[0]);
            }
            mode = mode || 1;
            var errCount = this.ErrorItem.length;
            switch (mode) {
                case 3 :
                    for (var i = 0; i < errCount; i++)
                        this.ErrorItem[i].style.color = "red";
                    var divPartId = theForm.id;
                    var divObj = document.getElementById("popup" + divPartId);
                    if (divObj == null) {
                        var tableStr = " <table width='11%' border='0' cellspacing='0' cellpadding='0' height='14'><tr><td><img src='" +validator_ImageFolder+
                                       "tc_03.jpg' width='31' height='21'></td></tr></table>" +
                                       "<table width='198' border='0' cellspacing='0' cellpadding='0' height='105'><tr><td width='13' height='2'><img src='"+validator_ImageFolder+"tc_05.jpg' width='13' height='13'></td><td  width='176' height='2'><img src='"+validator_ImageFolder+"tc_07.jpg' width='176' height='13' ></td><td  width='10' height='2'><img src='"+validator_ImageFolder+"tc_08.jpg' width='10' height='13'></td></tr>" +
                                       "<tr><td width='13' height='82' ><img src='"+validator_ImageFolder+"tc_10.jpg' width='13' height='82' ></td><td width='176' height='82' id='info" + divPartId + "'></td><td width='10' height='82'><img width='10' height='82' src='"+validator_ImageFolder+"tc_12.jpg'/></td></tr><tr><td width='13'><img src='"+validator_ImageFolder+"tc_13.jpg' width='13' height='11' valign='top'></td><td width='176'  ><img src='"+validator_ImageFolder+"tc_14.jpg' width='176' height='11'/></td><td valign='top' width='10'><img src='"+validator_ImageFolder+"tc_15.jpg' width='10' height='11'></td></tr></table>";
                       
                        var div1 = document.createElement('<div style="OVERFLOW-Y:auto;POSITION:absolute;HEIGHT:160px;width:198px;background-color:#fffafa;filter:Alpha(opacity=100)" id="popup' + divPartId + '">');
                        div1.innerHTML = tableStr;
                        var left = nLeft(theForm);
                        var width = theForm.offsetWidth;
                        var top = nTop(theForm);
                        var scrollLeft = getOutterDIV(theForm).scrollLeft;
                        var divLeft = left - scrollLeft;
                        div1.style.left = divLeft + "px";
                        div1.style.top = top + "px";
                        document.body.appendChild(div1);
                        var info = div1.document.getElementById("info" + divPartId);
                        var textNode = document.createTextNode(theForm.getAttribute("msg"));
                        info.appendChild(textNode);
                        dispear(divPartId);
                    } else {
                        divObj.filters.Alpha.opacity = 100;
                    }
                    break;
                case 1 :
                    alert(this.ErrorMessage.join("\n"));
                    break;
                case 2 :
                    try {
                        var span = document.createElement("SPAN");
                        span.id = "__ErrorMessagePanel";
                        span.style.color = "red";
                        span.innerHTML = "<br>"+this.ErrorMessage[1].replace(/\d+:/, "<img src='"+validator_ImageFolder+"/icon_fault.gif'>");
                        this.ErrorItem[0].appendChild(span);
                    }
                    catch(e) {
                        alert(e.description);
                    }
                    break;
                default :
                    alert(this.ErrorMessage.join("\n"));
                    break;
            }

            return false;
        }
        return true;

    },
    Trim     :function(str) {
        return  str.replace(/^\s*(.*?)[\s\n]*$/g, '$1');
    },
    strlen   :function(str, limitLen) {
        var len = 0;
        str = this.Trim(str);
        if (str == "") return false;
        for (var i = 0; i < str.length; i++)
        {
            var temp = str.charAt(i);
            if (str.charCodeAt(i) > 127 || str.charCodeAt(i) < 0)len += 2;
            else len++;
        }
        if (len != limitLen) {
            return false;
        } else {
            return true;
        }
    },
    limit : function(len, min, max) {
        min = min || 0;
        max = max || Number.MAX_VALUE;
        return min <= len && len <= max;
    },
    LenB : function(str) {
        return str.replace(/[^\x00-\xff]/g, "**").length;
    },
    ClearState : function(elem) {
        elem.className = elem.getAttribute("oldclassName");
        elem.title = elem.getAttribute("oldtitle");
        with (elem) {
            if (style.color == "red")
                style.color = "";
            var lastNode = parentNode.childNodes[parentNode.childNodes.length - 1];
            if (lastNode.id == "__ErrorMessagePanel") {
                parentNode.removeChild(lastNode);
            }
        }

    },
    AddError : function(index, str) {
        this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
    },
    Exec : function(op, reg) {
        return new RegExp(reg, "g").test(op);
    },
    compare : function(op1, operator, op2) {
        switch (operator) {
            case "NotEqual":
            	return (op1 != op2);
            case "GreaterThan":
                return (op1 > op2);
            case "GreaterThanEqual":
                return (op1 >= op2);
            case "LessThan":
                return (op1 < op2);
            case "LessThanEqual":
                return (op1 <= op2);
            default:
                return (op1 == op2);
        }
    },
    MustChecked : function(name, min, max) {
        var groups = document.getElementsByName(name);
        var hasChecked = 0;
        min = min || 1;
        max = max || groups.length;
        for (var i = groups.length - 1; i >= 0; i--)
            if (groups[i].checked) hasChecked++;
        return min <= hasChecked && hasChecked <= max;
    },
    DoFilter : function(input, filter) {
        return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
    },
    IsIdCard : function(number) {
        var date, Ai;
        var verify = "10X98765432";
        var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
        var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
        number = number.toUpperCase();
        var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[X\d])))$/i);
        if (re == null) return false;
        if (re[1] >= area.length || area[re[1]] == "") return false;
        if (re[2].length == 12) {
            Ai = number.substr(0, 17);
            date = [re[9], re[10], re[11]].join("-");
        }
        else {
            Ai = number.substr(0, 6) + "19" + number.substr(6);
            date = ["19" + re[4], re[5], re[6]].join("-");
        }
        if (!this.IsDate(date, "ymd")) return false;
        var sum = 0;
        for (var i = 0; i <= 16; i++) {
            sum += Ai.charAt(i) * Wi[i];
        }
        Ai += verify.charAt(sum % 11);
        if (number.length == 15 || number.length == 18 && number == Ai) {
            if (number.length == 15) {
                this.tempIdCard = Ai;
                return true;
            } else {
                this.tempIdCard = number;
            }
            return true;
        } else {
            return false;
        }
    },
    IsDate : function(op, formatString) {
        formatString = formatString || "ymd";
        if (formatString == "ymdhms") {
            var rr = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\d):[0-5]?\d:[0-5]?\d$/
            if (!rr.test(op))
            {
                return false;
            }
            return true;
        }
        var m, year, month, day;
        switch (formatString) {
            case "ymd" :
                m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
                if (m == null) return false;
                day = m[6];
                month = m[5] * 1;
                year = (m[2]!=null&&m[2]!="") ? m[2] : GetFullYear(m[3],parseInt(m[3], 10));
                break;
            case "dmy" :
                m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
                if (m == null) return false;
                day = m[1];
                month = m[3] * 1;
                year = (m[5]!=null&&m[5]!="") ? m[5] : GetFullYear(m[6],parseInt(m[6], 10));
                break;
            default :
                break;
        }
        if (!parseInt(month)) return false;
        month = month == 0 ? 12 : month;
        var date = new Date(year, month - 1, day);
        return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth() + 1) && day == date.getDate());
		function GetFullYear(m3,y) {
		  	var t = (y < 30 ? "20" : "19");
		  	if(m3.length>1&&m3.substring(0,1)=="0"){
		      	return t+"0"+y;
		  	}else{
		      	return t+y;
		 	}
        }
    },
    IsAge : function(number) {
        if (number > 0 && number < 150) {
            return true;
        } else {
            return false;
        }
    },
    attachInfo:function(oElement) {
        if ("string" == typeof oElement) {
            oElement = document.getElementById(oElement);
        }
        oElement = oElement || document;
        this.doAttachment(oElement, "input");
        this.doAttachment(oElement, "textarea");
    },
    doAttachment:function(oElement, sTagName) {
        var cFormElements = oElement.getElementsByTagName(sTagName);
        for (var i = 0; i < cFormElements.length; i++) {
            //获取当前操作form表单元素的cssRule属性
            var aClassNames = cFormElements[i].getAttribute("cssRule");
            var aClassNamesArr = null;
            if(aClassNames!=null&&aClassNames!="undefined"&&aClassNames.indexOf(" ")!=-1){
                aClassNamesArr = aClassNames.split(" ");
            }
            if(aClassNamesArr != null){
                for(var ii = 0 ; ii <aClassNamesArr.length ; ii++ ){
                     var temp = aClassNamesArr[ii];
                     var fInitValidation = this.className2Function[temp];
                     if (fInitValidation) {
                        fInitValidation(cFormElements[i]);
                     }
                }
            }else{
                var fInitValidation = this.className2Function[aClassNames];
                if (fInitValidation) {
                    fInitValidation(cFormElements[i]);
                }
            }
        }
    }
}
function dispear(divPartId) {
    var ele = document.getElementById("popup" + divPartId);
    ele.filters.Alpha.opacity -= 2;
    if (ele.filters.Alpha.opacity)
        setTimeout("dispear('" + divPartId + "');", 20);
    if (!ele.filters.Alpha.opacity) {
        document.body.removeChild(ele);
    }
}
function nTop(obj){
    if (obj != null){
        var nTop = 0;
        while (obj != null){
            nTop = nTop + obj.offsetTop;
            if (obj.offsetParent != null && obj.offsetParent.tagName != null && obj.offsetParent.tagName.toLowerCase() == "body")
                break;
            obj = obj.offsetParent;
        }
        return nTop;
    }
}
function nLeft(obj){
    if (obj != null){
        var nLeft = 0;
        while (obj != null){
            nLeft = nLeft + obj.offsetLeft;
            if (obj.offsetParent != null && obj.offsetParent.tagName != null && obj.offsetParent.tagName.toLowerCase() == "body")
                break;
            obj = obj.offsetParent;
        }
        return nLeft;
    }
}
function getOutterDIV(obj) {
    while (obj != null && obj.tagName != "DIV") {
        obj = obj.parentNode;
    }
    return obj;
}
function judgeValidate(obj,kind){
	  var srcEle = obj||event.srcElement;
            var dataType = srcEle.dataType;
            var dataTypeArr = null;
            if(dataType!=null&&dataType!="undefined"&&dataType.indexOf(" ")!=-1){
                dataTypeArr = dataType.split(" ");
            }
            var tempDataType = 	srcEle.dataType;
            if(dataTypeArr != null){
                for(var ii = 0 ; ii <dataTypeArr.length ; ii++ ){
                	if(ii>0){
                	   var lastNode = srcEle.parentNode.childNodes[srcEle.parentNode.childNodes.length - 1];
                       if (lastNode.id == "__ErrorMessagePanel") {
                             break;
                       }
                	}
                	srcEle.dataType = dataTypeArr[ii];
                    return Validator.Validate(srcEle, kind);
                }
            }else{
               return Validator.Validate(srcEle, kind);
           }
           srcEle.dataType = tempDataType;  
}

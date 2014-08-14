package com.assist.platform.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 管理控制类
 * 
 * @author FLY
 * 
 */
@Controller
@Scope("prototype")
public class ManagerAction extends BaseAction {
	private String title;
	private String message;
	private String feedtype; // 0 question  1 suggestion
	private String includeurl;

	public String redirectQuestion() {
		title = "提问中心";
		
		includeurl = "/feedback/page/question/question.jsp";
		return "question";
	}

	public String redirectSuggestion() {
		return "suggestion";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIncludeurl() {
		return includeurl;
	}

	public void setIncludeurl(String includeurl) {
		this.includeurl = includeurl;
	}

}

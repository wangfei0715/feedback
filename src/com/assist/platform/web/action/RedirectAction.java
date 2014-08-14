package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.assist.platform.common.constant.MsgStatus;
import com.assist.platform.common.constant.MsgType;
import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Catalog;
import com.assist.platform.model.Message;
import com.assist.platform.model.User;
import com.assist.platform.service.CatalogService;
import com.assist.platform.service.MessageService;

/**
 * 跳转控制类
 * 
 * @author FLY
 * 
 */
@Controller
@Scope("prototype")
public class RedirectAction extends BaseAction {
	private String title;
	private String message;
	private String feedbackType; // 1 question 2 suggestion
	private String myQuestionType; // 0 all 1 no 3 yes
	private String includeUrl;
	private List<Catalog> catalogs;
	private List<Message> messages;
	
	@Resource
	private CatalogService catalogService;

	@Resource
	private MessageService messageService;

	public String question() {
		title = "提问中心";
		includeUrl = request.getContextPath() + "/page/question/question.jsp";
		feedbackType = "1";
		catalogs = catalogService.getAll();
		return "question";
	}

	public String suggestion() {
		title = "建议中心";
		includeUrl = request.getContextPath() + "/page/question/question.jsp";
		feedbackType = "2";
		catalogs = catalogService.getAll();
		return "question";
	}

	public String myquestions() {
		title = "结果查询";
		includeUrl = request.getContextPath()
				+ "/page/question/myquestions.jsp";
		feedbackType = "3";
		myQuestionType = MsgStatus.ALL + "";
		User user = (User) session.get("user");
		messages = messageService.getByUser(user.getUserid(), MsgType.ALL,
				MsgStatus.ALL);
		return "myquestions";
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

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public String getIncludeUrl() {
		return includeUrl;
	}

	public void setIncludeUrl(String includeUrl) {
		this.includeUrl = includeUrl;
	}

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getMyQuestionType() {
		return myQuestionType;
	}

	public void setMyQuestionType(String myQuestionType) {
		this.myQuestionType = myQuestionType;
	}

}

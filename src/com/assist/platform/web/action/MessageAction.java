package com.assist.platform.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;

import com.assist.platform.common.constant.MsgSign;
import com.assist.platform.common.constant.MsgStatus;
import com.assist.platform.common.constant.MsgType;
import com.assist.platform.common.page.Page;
import com.assist.platform.common.page.Pagination;
import com.assist.platform.model.Catalog;
import com.assist.platform.model.Message;
import com.assist.platform.model.Msg;
import com.assist.platform.model.Reply;
import com.assist.platform.model.User;
import com.assist.platform.service.MessageService;
import com.assist.platform.service.ReplyService;

/**
 * 管理控制类
 * 
 * @author FLY
 * 
 */
@Controller
@Scope("prototype")
public class MessageAction extends BaseAction {
	private String title;
	private Message message;
	private Msg msg;
	private String feedbackType; // 1 question 2 suggestion
	private String myQuestionType; // 0 all 1 no 3 yes
	private Integer topType;
	private Integer myMsgType;
	private Integer myMsgStatus;
	private String includeUrl;
	private Integer messageid;
	private Integer replyid;
	private Integer catalogid;
	private Integer topLimit;
	private String replyContent;
	private String resultmsg;
	private List<Message> messages;
	private Document xmlDoc;
	// private List<String> msgType;
	// private List<String> msgStatus;

	/**
	 * 分页属性
	 */
	private Pagination<Message> pagination;
	private Page page;
	private int gotoPage;
	private String pageinfo = "message/message_commquestions.action?page.currentPage=";

	@Resource
	private MessageService messageService;

	@Resource
	private ReplyService replyService;

	public String save() {
		User user = (User) session.get("user");
		message.setCatalog(new Catalog(catalogid));
		// message.setContent(messageContent);
		messageService.save(user.getUserid(), message);
		resultmsg = "保存成功";
		return "save";
	}

	public String getMyQuestions() {
		int type = MsgType.ALL;
		int status = MsgStatus.ALL;
		User user = (User) session.get("user");
		title = "结果查询";
		feedbackType = "3";
		// myQuestionType = MsgStatus.ALL + "";

		if (null != myQuestionType && !"".equals(myQuestionType)) {
			// 切换 全部/等待解决/已结束
			if ("0".equals(myQuestionType)) {
				type = MsgType.ALL;
				status = MsgStatus.ALL;
			} else if ("1".equals(myQuestionType)) {
				type = MsgType.ALL;
				status = MsgStatus.UNREPLY;
			} else if ("3".equals(myQuestionType)) {
				type = MsgType.ALL;
				status = MsgStatus.REPLIED;
			}
			myMsgType = MsgType.ALL;
			myMsgStatus = MsgStatus.ALL;
		} else {
			// 切换 提问建议 类型/状态
			type = myMsgType;
			status = myMsgStatus;
			myQuestionType = MsgStatus.ALL + "";
		}

		messages = messageService.getByUser(user.getUserid(), type, status);
		return "myquestions";
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public String commquestions() {
		title = "常见问题";
		includeUrl = request.getContextPath()
				+ "/page/question/commquestions.jsp";
		feedbackType = "4";
		myQuestionType = "1";
		if ("".equals(catalogid) || null == catalogid)
			catalogid = 1;
		pageinfo = "message/message_commquestions.action?page.currentPage=";
		pagination = messageService.getRecommendByPage(MsgType.QUESTION,
				catalogid, getPage(page, gotoPage));
		return "commquestions";
	}

	@SuppressWarnings("unchecked")
	public String greatsuggestions() {
		title = "精彩建议";
		includeUrl = request.getContextPath()
				+ "/page/question/greatsuggestions.jsp";
		feedbackType = "5";
		myQuestionType = "2";
		if ("".equals(catalogid) || null == catalogid)
			catalogid = 1;
		pageinfo = "message/message_greatsuggestions.action?page.currentPage=";
		pagination = messageService.getRecommendByPage(MsgType.SUGGESTION,
				catalogid, getPage(page, gotoPage));
		return "greatquestions";
	}

	public String detail() {
		feedbackType = "6";
		if (null != messageid && !"".equals(messageid)){
			message = messageService.getById(messageid);
			title = "详细信息: " + message.getTitle();
			return "detail";
		}else{
			return "error";
		}
		
	}

	@SuppressWarnings("unchecked")
	public String questionadmin() {
		int type = MsgType.ALL;
		int status = MsgStatus.ALL;
		if (myMsgType == null)
			myMsgType = 0;
		if (myMsgStatus == null)
			myMsgStatus = 0;
		pageinfo = "message/message_questionadmin.action?myQuestionType="
				+ myQuestionType + "&myMsgType=" + myMsgType + "&myMsgStatus="
				+ myMsgStatus + "&page.currentPage=";
		title = "问题建议管理";
		feedbackType = "7";
		// myQuestionType = MsgStatus.ALL + "";

		if (null != myQuestionType && !"".equals(myQuestionType)
				&& !"null".equals(myQuestionType)) {
			// 切换 全部/等待解决/已结束
			if ("0".equals(myQuestionType)) {
				type = MsgType.ALL;
				status = MsgStatus.ALL;
			} else if ("1".equals(myQuestionType)) {
				type = MsgType.ALL;
				status = MsgStatus.UNREPLY;
			} else if ("3".equals(myQuestionType)) {
				type = MsgType.ALL;
				status = MsgStatus.REPLIED;
			}
			myMsgType = MsgType.ALL;
			myMsgStatus = MsgStatus.ALL;
		} else {
			// 切换 提问建议 类型/状态
			type = myMsgType;
			status = myMsgStatus;
			myQuestionType = MsgStatus.ALL + "";
		}
		if ("".equals(catalogid) || null == catalogid)
			catalogid = 0;
		pagination = messageService.getAdminByPage(type, status, catalogid,
				getPage(page, gotoPage));
		return "questionadmin";
	}

	public String admindetail() {
		feedbackType = "8";
		if (null != messageid && !"".equals(messageid)){
			message = messageService.getById(messageid);
			title = "详细信息: " + message.getTitle();
			setMsgValue(message);
			return "admindetail";
		}else{
			return "adminerror";
		}
	}

	public String savereply() {
		feedbackType = "8";
		Reply reply = null;
		Integer messageid = message.getMessageid();
		setMessageValue();
		if (!"".equals(replyContent) && null != replyContent) {
			reply = new Reply();
			reply.setContent(replyContent);
		}
		User user = (User) session.get("user");
		messageService.update(user.getUserid(), message, reply);

		message = messageService.getById(messageid);
		title = "详细信息: " + message.getTitle();
		setMsgValue(message);
		return "admindetail";
	}

	public String replyupdate() {
		feedbackType = "8";
		Reply reply = new Reply();
		reply.setContent(replyContent);
		User user = (User) session.get("user");
		replyService.update(user.getUserid(), replyid, reply);
		message = messageService.getById(messageid);
		title = "详细信息: " + message.getTitle();
		setMsgValue(message);
		return "admindetail";
	}

	public String getTop() {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		if (null == topType || "".equals(topType))
			topType = MsgType.QUESTION;
		if (null == topLimit || "".equals(topLimit))
			topLimit = 0;
		xmlDoc = messageService.getTop(topType, topLimit);
		return "xml";
	}

	private void setMessageValue() {
		if ("true".equals(msg.getIsdel())) {
			message.setIsdel(MsgSign.YES);
		} else {
			message.setIsdel(MsgSign.NOT);
		}
		if ("true".equals(msg.getIstop())) {
			message.setIstop(MsgSign.YES);
		} else {
			message.setIstop(MsgSign.NOT);
		}
		if ("true".equals(msg.getRecommend())) {
			message.setRecommend(MsgSign.YES);
		} else {
			message.setRecommend(MsgSign.NOT);
		}
		if ("true".equals(msg.getChecked())) {
			message.setChecked(MsgSign.YES);
		} else {
			message.setChecked(MsgSign.NOT);
		}
	}

	private void setMsgValue(Message message) {
		if (null == msg)
			msg = new Msg();
		if (1 == message.getChecked()) {
			msg.setChecked("true");
		} else {
			msg.setChecked("false");
		}
		if (1 == message.getIstop()) {
			msg.setIstop("true");
		} else {
			msg.setIstop("false");
		}
		if (1 == message.getIsdel()) {
			msg.setIsdel("true");
		} else {
			msg.setIsdel("false");
		}
		if (1 == message.getRecommend()) {
			msg.setRecommend("true");
		} else {
			msg.setRecommend("false");
		}

	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
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

	public String getResultmsg() {
		return resultmsg;
	}

	public void setResultmsg(String resultmsg) {
		this.resultmsg = resultmsg;
	}

	public Integer getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getMyQuestionType() {
		return myQuestionType;
	}

	public void setMyQuestionType(String myQuestionType) {
		this.myQuestionType = myQuestionType;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Integer getMyMsgType() {
		return myMsgType;
	}

	public void setMyMsgType(Integer myMsgType) {
		this.myMsgType = myMsgType;
	}

	public Integer getMyMsgStatus() {
		return myMsgStatus;
	}

	public void setMyMsgStatus(Integer myMsgStatus) {
		this.myMsgStatus = myMsgStatus;
	}

	public Pagination<Message> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Message> pagination) {
		this.pagination = pagination;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	public String getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(String pageinfo) {
		this.pageinfo = pageinfo;
	}

	public Integer getMessageid() {
		return messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	public Document getXmlDoc() {
		return xmlDoc;
	}

	public void setXmlDoc(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}

	public Integer getTopType() {
		return topType;
	}

	public void setTopType(Integer topType) {
		this.topType = topType;
	}

	public Integer getTopLimit() {
		return topLimit;
	}

	public Integer getReplyid() {
		return replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	public void setTopLimit(Integer topLimit) {
		this.topLimit = topLimit;
	}

}

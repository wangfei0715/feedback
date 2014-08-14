package com.assist.platform.model;


/**
 * 类说明:
 * 
 * @author 作者:王飞
 * @version
 * @copyright Jul 3, 2011 7:00:09 AM
 */

public class Msg {
	private String messageid;
	private String user;
	private String catalog;
	private String title;
	private String content;
	private String status; // 状态 1 未回复 2 部分回复 3 已回复 4 已忽略
	private String type; // 类别 1 提问 2 建议
	private String createtime;
	private String modifytime;
	private String replytime;
	private String istop; // 置顶,出现在首页 0 未被置顶 1已被置顶
	private String checked; // 是否已读 0 未读 1已读
	private String isdel; // 是否被删除 0 未删 1已删
	private String recommend; // 是否被推荐出现在常见问题/精彩建议 0 未被推荐 1已被推荐
	private String replys;
	private String favorites;

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getReplys() {
		return replys;
	}

	public void setReplys(String replys) {
		this.replys = replys;
	}

	public String getFavorites() {
		return favorites;
	}

	public void setFavorites(String favorites) {
		this.favorites = favorites;
	}
}

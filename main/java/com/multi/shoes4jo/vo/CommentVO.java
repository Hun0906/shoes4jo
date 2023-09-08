package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("CommentVO")
public class CommentVO {

	private int cno;
	private String member_id;
	private int fno;
	private String content;
	private String date;
	private String update_date;

	public CommentVO() {
	}

	public CommentVO(int cno, String member_id, int fno, String content, String date, String update_date) {
		super();
		this.cno = cno;
		this.member_id = member_id;
		this.fno = fno;
		this.content = content;
		this.date = date;
		this.update_date = update_date;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
}
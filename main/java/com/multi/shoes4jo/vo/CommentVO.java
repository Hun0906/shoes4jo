package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component("CommentVO")
public class CommentVO {

	private int cno;
	private String member_id;
	private int fno;
	private String content;
	private Date date;
	private Date update_date;

	public CommentVO() {
	}

	public CommentVO(int cno, String member_id, int fno, String content, Date date, Date update_date) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}


}
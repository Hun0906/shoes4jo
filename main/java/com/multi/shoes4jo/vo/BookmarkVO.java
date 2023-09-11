package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("BookmarkVO")
public class BookmarkVO {

	private String member_id;
	private int gno;
	private String keyword;
	private String add_date;

	public BookmarkVO() {
	}

	public BookmarkVO(String member_id, int gno, String keyword, String add_date) {

		this.member_id = member_id;
		this.gno = gno;
		this.keyword = keyword;
		this.add_date = add_date;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}
}
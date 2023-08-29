package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("BookmarkVO")
public class BookmarkVO {

	private int bookmark_no;
	private String member_id;
	private String keywords;
	private String category;
	private String add_date;

	public int getBookmark_no() {
		return bookmark_no;
	}

	public void setBookmark_no(int bookmark_no) {
		this.bookmark_no = bookmark_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}
}
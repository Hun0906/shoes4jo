package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("BookmarkK")
public class BookmarkK {
		public int getBookmark_id() {
		return bookmark_id;
	}
	public void setBookmark_id(int bookmark_id) {
		this.bookmark_id = bookmark_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getTime_unit() {
		return time_unit;
	}
	public void setTime_unit(String time_unit) {
		this.time_unit = time_unit;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAges() {
		return ages;
	}
	public void setAges(String ages) {
		this.ages = ages;
	}
	public String getAdd_date() {
		return add_date;
	}
	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}
		private int bookmark_id;
		private String member_id;
		private String start_date;
		private String end_date;
		private String time_unit;
		private String keywords;
		private String device;
		private String gender;
		private String ages;
		private String add_date;
	}


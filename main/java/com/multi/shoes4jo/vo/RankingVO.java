package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("RankingVO")
public class RankingVO {
	private String date;
	private String keyword;
	private String title;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

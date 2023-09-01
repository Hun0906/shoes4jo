package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("KeywordTrendVO")
public class KeywordTrendVO {
	private String group;
	private String keyword;
	private String query;
	private long value;
	
	public KeywordTrendVO() {
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	
}

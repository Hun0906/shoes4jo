package com.multi.shoes4jo.keywordtrend;

import org.springframework.stereotype.Component;

@Component("KeywordTrendVO")
public class KeywordTrendVO {
	private String keyword_group;
	private String keyword;
	private String query;
	private long query_value;
	
	public KeywordTrendVO() {
	}


	public String getKeyword_group() {
		return keyword_group;
	}

	public void setKeyword_group(String keyword_group) {
		this.keyword_group = keyword_group;
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


	public long getQuery_value() {
		return query_value;
	}


	public void setQuery_value(long query_value) {
		this.query_value = query_value;
	}


	
}

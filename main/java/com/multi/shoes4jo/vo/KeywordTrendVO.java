package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("KeywordTrendVO")
public class KeywordTrendVO {
	private String period_sdata;
	private String keyword;
	private int ratio_cnt;
	
	public KeywordTrendVO() {
	}
	
	public KeywordTrendVO(String period_sdata, String keyword, int ratio_cnt) {
		this.period_sdata = period_sdata;
		this.keyword = keyword;
		this.ratio_cnt = ratio_cnt;
	}
	
	public String getPeriod_sdata() {
		return period_sdata;
	}
	public void setPeriod_sdata(String period_sdata) {
		this.period_sdata = period_sdata;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getRatio_cnt() {
		return ratio_cnt;
	}
	public void setRatio_cnt(int ratio_cnt) {
		this.ratio_cnt = ratio_cnt;
	}
	
}

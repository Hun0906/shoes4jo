package com.multi.shoes4jo.categorytrend;

import org.springframework.stereotype.Component;

@Component()
public class CategoryTrendVO {

	private String period_sdata;
	private String category_name;
	private String catId;
	private int ratio_cnt;
	
	public CategoryTrendVO() {
	}

	public String getPeriod_sdata() {
		return period_sdata;
	}

	public void setPeriod_sdata(String period_sdata) {
		this.period_sdata = period_sdata;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public int getRatio_cnt() {
		return ratio_cnt;
	}

	public void setRatio_cnt(int ratio_cnt) {
		this.ratio_cnt = ratio_cnt;
	}
	
	
}

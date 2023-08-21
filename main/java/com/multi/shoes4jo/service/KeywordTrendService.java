package com.multi.shoes4jo.service;

import com.multi.shoes4jo.vo.KeywordTrendVO;

public interface KeywordTrendService {

	public KeywordTrendVO select(String keyword);
	
	public void insert(KeywordTrendVO KeywordTrend);
	
	public void updateRatio(String period_sdata, String keyword);
 
}

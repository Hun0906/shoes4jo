package com.multi.shoes4jo.service;

import com.multi.shoes4jo.vo.KeywordTrendVO;

public interface KeywordTrendService {

	public KeywordTrendVO select(String keyword, String table);
	
	public void insert(KeywordTrendVO vo);
	
	public boolean isExists(String period_sdata, String keyword);

	public int oldRatio(String period_sdata, String keyword);
	
	public void update(KeywordTrendVO vo);

}

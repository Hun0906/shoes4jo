package com.multi.shoes4jo.service.keyword;

import com.multi.shoes4jo.vo.KeywordTrendVO;

public interface KeywordTrendService {

	public KeywordTrendVO select(String keyword);
	
	public void insert(KeywordTrendVO vo);
	
	public boolean isExists(String period_sdata, String keyword);

	public long oldRatio(String period_sdata, String keyword);
	
	public void update(KeywordTrendVO vo);
 
}

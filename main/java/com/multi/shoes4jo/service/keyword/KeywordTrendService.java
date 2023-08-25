package com.multi.shoes4jo.service.keyword;

import java.util.List;
import com.multi.shoes4jo.vo.KeywordTrendVO;

public interface KeywordTrendService {

	public List<KeywordTrendVO> selectAll(String keyword);
	
	public List<KeywordTrendVO> selectGen(String keyword);
	
	public List<KeywordTrendVO> selectAge(String keyword);
	
	public void insert(KeywordTrendVO vo);
	
	public boolean isExists(String period_sdata, String keyword);

	public int oldRatio(String period_sdata, String keyword);
	
	public void update(KeywordTrendVO vo);

}

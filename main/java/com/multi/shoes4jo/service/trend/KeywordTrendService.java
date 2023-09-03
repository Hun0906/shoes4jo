package com.multi.shoes4jo.service.trend;

import java.util.List;

import com.multi.shoes4jo.vo.KeywordTrendVO;

public interface KeywordTrendService {
	public List<KeywordTrendVO> selectGroup(String group);
	public List<KeywordTrendVO> selectKeyword(String keyword);

	public void insert(KeywordTrendVO vo);

	public boolean isExists(String keyword, String query);

	public int oldValue(String keyword, String query);

	public void update(KeywordTrendVO vo);

}

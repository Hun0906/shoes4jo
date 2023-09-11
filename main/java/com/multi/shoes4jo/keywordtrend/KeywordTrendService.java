package com.multi.shoes4jo.keywordtrend;

import java.util.List;

public interface KeywordTrendService {
	public List<String> selectGroup(String group);
	public List<KeywordTrendVO> selectKeyword(String keyword);
	public List<KeywordTrendVO> selectAll();

	public void insert(KeywordTrendVO vo);

	public boolean isExists(String keyword, String query);

	public int oldValue(String keyword, String query);

	public void update(KeywordTrendVO vo);

}

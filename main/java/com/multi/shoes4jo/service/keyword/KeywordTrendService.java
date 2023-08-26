package com.multi.shoes4jo.service.keyword;

import java.util.List;
import com.multi.shoes4jo.vo.KeywordTrendVO;

public interface KeywordTrendService {

	public List<KeywordTrendVO> selectAll(String keyword);
	public List<KeywordTrendVO> selectGen(String keyword, String gender);
	public List<KeywordTrendVO> selectAge(String keyword, int age);
	
	public void insert(KeywordTrendVO vo);
	public void insertGen(KeywordTrendVO vo);
	public void insertAge(KeywordTrendVO vo);
	
	public boolean isExists(String period_sdata, String keyword);
	public boolean isExistsGen(String period_sdata, String keyword, String gender);
	public boolean isExistsAge(String period_sdata, String keyword, int age);

	public int oldRatio(String period_sdata, String keyword);
	public int oldRatioGen(String period_sdata, String keyword, String gender);
	public int oldRatioAge(String period_sdata, String keyword, int age);
	
	public void update(KeywordTrendVO vo);
	public void updateGen(KeywordTrendVO vo);
	public void updateAge(KeywordTrendVO vo);





}

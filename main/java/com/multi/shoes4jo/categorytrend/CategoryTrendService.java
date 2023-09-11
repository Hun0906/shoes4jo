package com.multi.shoes4jo.categorytrend;

import java.util.List;

public interface CategoryTrendService {

	public List<CategoryTrendVO> select(String catId);

	public List<CategoryTrendVO> selectCatInfo();
	
	public void insert(CategoryTrendVO vo);
	
	public boolean isExists(String period_sdata, String catId);

	public int oldRatio(String period_sdata, String catId);
	
	public void update(CategoryTrendVO vo);

}
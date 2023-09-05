package com.multi.shoes4jo.service.trend;

import java.util.List;
import com.multi.shoes4jo.vo.CategoryTrendVO;

public interface CategoryTrendService {

	public List<CategoryTrendVO> selectAll(String keyword);
	public List<CategoryTrendVO> selectSearch(String keyword);
	public List<CategoryTrendVO> selectGen(String keyword, String gender);
	public List<CategoryTrendVO> selectDev(String keyword, String device);
	public List<CategoryTrendVO> selectAge(String keyword, int age);
	
	public void insert(CategoryTrendVO vo);
	public void insertSearch(CategoryTrendVO vo);
	public void insertGen(CategoryTrendVO vo);
	public void insertDev(CategoryTrendVO vo);
	public void insertAge(CategoryTrendVO vo);
	
	public boolean isExists(String period_sdata, String keyword);
	public boolean isExistsSearch(String period_sdata, String keyword);
	public boolean isExistsGen(String period_sdata, String keyword, String gender);
	public boolean isExistsDev(String period_sdata, String keyword, String device);
	public boolean isExistsAge(String period_sdata, String keyword, int age);

	public int oldRatio(String period_sdata, String keyword);
	public int oldRatioSearch(String period_sdata, String keyword);
	public int oldRatioGen(String period_sdata, String keyword, String gender);
	public int oldRatioDev(String period_sdata, String keyword, String device);
	public int oldRatioAge(String period_sdata, String keyword, int age);
	
	public void update(CategoryTrendVO vo);
	public void updateSearch(CategoryTrendVO vo);
	public void updateGen(CategoryTrendVO vo);
	public void updateDev(CategoryTrendVO vo);
	public void updateAge(CategoryTrendVO vo);

}
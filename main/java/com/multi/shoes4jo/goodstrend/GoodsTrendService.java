package com.multi.shoes4jo.goodstrend;

import java.util.List;

public interface GoodsTrendService {

	public List<GoodsTrendVO> selectAll(String keyword);
	public List<GoodsTrendVO> selectSearch(String keyword);
	public List<GoodsTrendVO> selectGen(String keyword, String gender);
	public List<GoodsTrendVO> selectDev(String keyword, String device);
	public List<GoodsTrendVO> selectAge(String keyword, int age);
	
	public void insert(GoodsTrendVO vo);
	public void insertSearch(GoodsTrendVO vo);
	public void insertGen(GoodsTrendVO vo);
	public void insertDev(GoodsTrendVO vo);
	public void insertAge(GoodsTrendVO vo);
	
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
	
	public void update(GoodsTrendVO vo);
	public void updateSearch(GoodsTrendVO vo);
	public void updateGen(GoodsTrendVO vo);
	public void updateDev(GoodsTrendVO vo);
	public void updateAge(GoodsTrendVO vo);

}

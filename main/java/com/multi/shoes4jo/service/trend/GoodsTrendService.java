package com.multi.shoes4jo.service.trend;

import java.util.List;
import com.multi.shoes4jo.vo.GoodsTrendVO;

public interface GoodsTrendService {

	public List<GoodsTrendVO> selectAll(String keyword);
	public List<GoodsTrendVO> selectGen(String keyword, String gender);
	public List<GoodsTrendVO> selectAge(String keyword, int age);
	
	public void insert(GoodsTrendVO vo);
	public void insertGen(GoodsTrendVO vo);
	public void insertAge(GoodsTrendVO vo);
	
	public boolean isExists(String period_sdata, String keyword);
	public boolean isExistsGen(String period_sdata, String keyword, String gender);
	public boolean isExistsAge(String period_sdata, String keyword, int age);

	public int oldRatio(String period_sdata, String keyword);
	public int oldRatioGen(String period_sdata, String keyword, String gender);
	public int oldRatioAge(String period_sdata, String keyword, int age);
	
	public void update(GoodsTrendVO vo);
	public void updateGen(GoodsTrendVO vo);
	public void updateAge(GoodsTrendVO vo);





}

package com.multi.shoes4jo.service.ranking;

import java.util.List;

import com.multi.shoes4jo.vo.RankingVO;

public interface RankingService {
	
	public void insert(String keyword, String title);
	
	public RankingVO select(String keyword);
	
	public boolean isExists(String keyword, String date);
    
	public void update(String keyword, String date);
	
	public List<RankingVO> searchRanking();

}

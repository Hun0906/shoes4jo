package com.multi.shoes4jo.ranking;

import java.util.List;

public interface RankingService {
	
	public void insert(String keyword, String title);
	
	public RankingVO select(String keyword);
	
	public boolean isExists(String keyword, String date);
    
	public void update(String keyword, String date);
	
	public List<RankingVO> searchRanking();

	public List<RankingVO> selectTopTen(String date, int limit);

}

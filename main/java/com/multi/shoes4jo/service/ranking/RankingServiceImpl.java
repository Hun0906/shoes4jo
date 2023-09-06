package com.multi.shoes4jo.service.ranking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.RankingMapper;
import com.multi.shoes4jo.vo.RankingVO;

@Service("RankingService")
public class RankingServiceImpl implements RankingService {
	@Autowired
	private RankingMapper mapper;

	@Override
	public void insert(String keyword, String title) {
		mapper.insert(keyword, title);
	}

	@Override
	public RankingVO select(String keyword) {
		RankingVO vo = mapper.selectAll(keyword);
		return vo;
	}

	@Override
	public boolean isExists(String keyword, String date) {
		int num = mapper.isExists(keyword, date);
		return num == 1;
	}

	@Override
	public void update(String keyword, String date) {
		mapper.update(keyword, date);
	}

	@Override
	public List<RankingVO> searchRanking() {
		return mapper.searchRanking();
	}
	
	@Override
	public List<RankingVO> selectTopTen(String date, int limit) {
		return mapper.selectTopTen(date, limit);
	}

}
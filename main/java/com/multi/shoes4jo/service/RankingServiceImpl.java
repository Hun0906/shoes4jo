package com.multi.shoes4jo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multi.shoes4jo.mapper.RankingMapper;
import com.multi.shoes4jo.vo.RankingVO;

@Service("rankingService")
public class RankingServiceImpl implements RankingService {
    @Autowired
    private RankingMapper rankingMapper;
    
	@Override
	public void insert(String keyword, String title) {
		rankingMapper.insert(keyword, title);
	}

	@Override
	public RankingVO select(String keyword) {
		RankingVO vo = rankingMapper.selectAll(keyword);
		return vo;
	}

	@Override
	public boolean isExists(String keyword, String date) {
		int num = rankingMapper.isExists(keyword, date);
		return num == 1;
	}

	@Override
	public void update(String keyword, String date) {
		rankingMapper.update(keyword, date);
	}


}

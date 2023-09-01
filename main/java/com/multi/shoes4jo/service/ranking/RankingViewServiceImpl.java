package com.multi.shoes4jo.service.ranking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.RankingMapper;
import com.multi.shoes4jo.vo.RankingVO;

@Service("RankingViewService")
public class RankingViewServiceImpl implements RankingViewService {

	@Autowired
	private RankingMapper mapper;

	@Override
	public List<RankingVO> searchRanking() {
		return mapper.searchRanking();
	}

}

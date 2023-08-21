package com.multi.shoes4jo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.KeywordTrendMapper;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Service("keywordTrendService")
public class KeywordTrendServiceImpl implements KeywordTrendService {
    @Autowired
    private KeywordTrendMapper keywordTrendMapper;

	@Override
	public KeywordTrendVO select(String keyword) {
		KeywordTrendVO vo = keywordTrendMapper.select(keyword);
		return vo;
	}

	@Override
	public void insert(KeywordTrendVO vo) {
		keywordTrendMapper.insert(vo);
	}

	@Override
	public void updateRatio(String period_sdata, String keyword) {
		keywordTrendMapper.updateRatio(period_sdata, keyword);
	}

}

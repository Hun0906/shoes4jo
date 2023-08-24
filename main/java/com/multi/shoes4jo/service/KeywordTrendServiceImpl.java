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
	public void update(KeywordTrendVO vo) {
		keywordTrendMapper.update(vo);
	}

	@Override
	public boolean isExists(String period_sdata, String keyword) {
		int num = keywordTrendMapper.isExists(period_sdata, keyword);
		return num == 1;
	}

	@Override
	public int oldRatio(String period_sdata, String keyword) {
		return keywordTrendMapper.oldRatio(period_sdata, keyword);
	}

}

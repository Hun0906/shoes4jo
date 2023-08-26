package com.multi.shoes4jo.service.keyword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.KeywordTrendMapper;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Service("keywordTrendService")
public class KeywordTrendServiceImpl implements KeywordTrendService {
    @Autowired
    private KeywordTrendMapper keywordTrendMapper;

    @Override
	public List<KeywordTrendVO> selectAll(String keyword) {
	    List<KeywordTrendVO> resultList = keywordTrendMapper.selectAll(keyword);
	    return resultList;
	}
	
	@Override
	public List<KeywordTrendVO> selectGen(String keyword, String gender) {
		List<KeywordTrendVO> vo = keywordTrendMapper.selectGen(keyword, gender);
		return vo;
	}
	
	@Override
	public List<KeywordTrendVO> selectAge(String keyword, int age) {
		List<KeywordTrendVO> vo = keywordTrendMapper.selectAge(keyword, age);
		return vo;
	}

	@Override
	public void insert(KeywordTrendVO vo) {
		keywordTrendMapper.insert(vo);
	}
	
	@Override
	public void insertGen(KeywordTrendVO vo) {
		keywordTrendMapper.insertGen(vo);
	}
	
	@Override
	public void insertAge(KeywordTrendVO vo) {
		keywordTrendMapper.insertAge(vo);
	}

	@Override
	public void update(KeywordTrendVO vo) {
		keywordTrendMapper.update(vo);
	}
	
	@Override
	public void updateGen(KeywordTrendVO vo) {
		keywordTrendMapper.updateGen(vo);
	}
	
	@Override
	public void updateAge(KeywordTrendVO vo) {
		keywordTrendMapper.updateAge(vo);
	}

	@Override
	public boolean isExists(String period_sdata, String keyword) {
		int num = keywordTrendMapper.isExists(period_sdata, keyword);
		return num == 1;
	}
	
	@Override
	public boolean isExistsGen(String period_sdata, String keyword, String gender) {
		int num = keywordTrendMapper.isExistsGen(period_sdata, keyword, gender);
		return num == 1;
	}
	
	@Override
	public boolean isExistsAge(String period_sdata, String keyword, int age) {
		int num = keywordTrendMapper.isExistsAge(period_sdata, keyword, age);
		return num == 1;
	}

	@Override
	public int oldRatio(String period_sdata, String keyword) {
		return keywordTrendMapper.oldRatio(period_sdata, keyword);
	}

	@Override
	public int oldRatioGen(String period_sdata, String keyword, String gender) {
		return keywordTrendMapper.oldRatioGen(period_sdata, keyword, gender);
	}

	@Override
	public int oldRatioAge(String period_sdata, String keyword, int age) {
		return keywordTrendMapper.oldRatioAge(period_sdata, keyword, age);
	}

}

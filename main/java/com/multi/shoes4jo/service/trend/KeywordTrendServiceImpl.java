package com.multi.shoes4jo.service.trend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.KeywordTrendMapper;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Service("keywordTrendService")
public class KeywordTrendServiceImpl implements KeywordTrendService {
    @Autowired
    private KeywordTrendMapper mapper;
    
	@Override
	public List<String> selectGroup(String group) {
		List<String> resultList = mapper.selectGroup(group);
		return resultList;
	}

	@Override
	public List<KeywordTrendVO> selectKeyword(String keyword) {
		List<KeywordTrendVO> resultList = mapper.selectKeyword(keyword);
		return resultList;
	}
	
	@Override
	public List<KeywordTrendVO> selectAll() {
		List<KeywordTrendVO> resultList = mapper.selectAll();
		return resultList;
	}

	@Override
	public void insert(KeywordTrendVO vo) {
		mapper.insert(vo);
	}

	@Override
	public boolean isExists(String keyword, String query) {
		int num = mapper.isExists(keyword, query);
		return num == 1;
	}

	@Override
	public int oldValue(String keyword, String query) {
		int value = mapper.oldValue(keyword, query);
		return value;
	}

	@Override
	public void update(KeywordTrendVO vo) {
		mapper.update(vo);
	}

}

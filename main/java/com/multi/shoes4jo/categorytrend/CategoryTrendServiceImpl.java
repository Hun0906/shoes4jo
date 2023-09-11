package com.multi.shoes4jo.categorytrend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.CategoryTrendMapper;

@Service("categoryTrendService")
public class CategoryTrendServiceImpl implements CategoryTrendService {
	@Autowired
	private CategoryTrendMapper mapper;

	// list
	@Override
	public List<CategoryTrendVO> select(String catId) {
		List<CategoryTrendVO> resultList = mapper.select(catId);
		return resultList;
	}
	
	
	// category info list
	@Override
	public List<CategoryTrendVO> selectCatInfo() {
		List<CategoryTrendVO> resultList = mapper.selectCatInfo();
		return resultList;
	}


	// insert
	@Override
	public void insert(CategoryTrendVO vo) {
		mapper.insert(vo);
	}


	// update
	@Override
	public void update(CategoryTrendVO vo) {
		mapper.update(vo);
	}

	// isExists
	@Override
	public boolean isExists(String period_sdata, String catId) {
		int num = mapper.isExists(period_sdata, catId);
		return num == 1;
	}


	// oldRatio
	@Override
	public int oldRatio(String period_sdata, String catId) {
		return mapper.oldRatio(period_sdata, catId);
	}


}

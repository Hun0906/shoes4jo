package com.multi.shoes4jo.service.trend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.CategoryTrendMapper;
import com.multi.shoes4jo.vo.CategoryTrendVO;

@Service("CategoryTrendService")
public class CategoryTrendServiceImpl implements CategoryTrendService {
	@Autowired
	private CategoryTrendMapper mapper;

	// list
	@Override
	public List<CategoryTrendVO> selectAll(String keyword) {
		List<CategoryTrendVO> resultList = mapper.selectAll(keyword);
		return resultList;
	}

	@Override
	public List<CategoryTrendVO> selectSearch(String keyword) {
		List<CategoryTrendVO> resultList = mapper.selectSearch(keyword);
		return resultList;
	}

	@Override
	public List<CategoryTrendVO> selectGen(String keyword, String gender) {
		List<CategoryTrendVO> vo = mapper.selectGen(keyword, gender);
		return vo;
	}

	@Override
	public List<CategoryTrendVO> selectDev(String keyword, String device) {
		List<CategoryTrendVO> vo = mapper.selectDev(keyword, device);
		return vo;
	}

	@Override
	public List<CategoryTrendVO> selectAge(String keyword, int age) {
		List<CategoryTrendVO> vo = mapper.selectAge(keyword, age);
		return vo;
	}

	// insert
	@Override
	public void insert(CategoryTrendVO vo) {
		mapper.insert(vo);
	}

	@Override
	public void insertSearch(CategoryTrendVO vo) {
		mapper.insertSearch(vo);
	}

	@Override
	public void insertGen(CategoryTrendVO vo) {
		mapper.insertGen(vo);
	}

	@Override
	public void insertDev(CategoryTrendVO vo) {
		mapper.insertDev(vo);
	}

	@Override
	public void insertAge(CategoryTrendVO vo) {
		mapper.insertAge(vo);
	}

	// update
	@Override
	public void update(CategoryTrendVO vo) {
		mapper.update(vo);
	}

	@Override
	public void updateSearch(CategoryTrendVO vo) {
		mapper.updateSearch(vo);
	}

	@Override
	public void updateGen(CategoryTrendVO vo) {
		mapper.updateGen(vo);
	}

	@Override
	public void updateDev(CategoryTrendVO vo) {
		mapper.updateDev(vo);
	}

	@Override
	public void updateAge(CategoryTrendVO vo) {
		mapper.updateAge(vo);
	}

	// isExists
	@Override
	public boolean isExists(String period_sdata, String keyword) {
		int num = mapper.isExists(period_sdata, keyword);
		return num == 1;
	}

	@Override
	public boolean isExistsSearch(String period_sdata, String keyword) {
		int num = mapper.isExistsSearch(period_sdata, keyword);
		return num == 1;
	}

	@Override
	public boolean isExistsGen(String period_sdata, String keyword, String gender) {
		int num = mapper.isExistsGen(period_sdata, keyword, gender);
		return num == 1;
	}

	@Override
	public boolean isExistsDev(String period_sdata, String keyword, String device) {
		int num = mapper.isExistsDev(period_sdata, keyword, device);
		return num == 1;
	}

	@Override
	public boolean isExistsAge(String period_sdata, String keyword, int age) {
		int num = mapper.isExistsAge(period_sdata, keyword, age);
		return num == 1;
	}

	// oldRatio
	@Override
	public int oldRatio(String period_sdata, String keyword) {
		return mapper.oldRatio(period_sdata, keyword);
	}

	@Override
	public int oldRatioSearch(String period_sdata, String keyword) {
		return mapper.oldRatioSearch(period_sdata, keyword);
	}

	@Override
	public int oldRatioGen(String period_sdata, String keyword, String gender) {
		return mapper.oldRatioGen(period_sdata, keyword, gender);
	}

	@Override
	public int oldRatioDev(String period_sdata, String keyword, String device) {
		return mapper.oldRatioDev(period_sdata, keyword, device);
	}

	@Override
	public int oldRatioAge(String period_sdata, String keyword, int age) {
		return mapper.oldRatioAge(period_sdata, keyword, age);
	}

}

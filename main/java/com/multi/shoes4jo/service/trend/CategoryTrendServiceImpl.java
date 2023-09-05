package com.multi.shoes4jo.service.trend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.CategoryTrendMapper;
import com.multi.shoes4jo.vo.CategoryTrendVO;

@Service("CategoryTrendService")
public class CategoryTrendServiceImpl implements CategoryTrendService {
    @Autowired
    private CategoryTrendMapper CategoryTrendMapper;

    //list
    @Override
	public List<CategoryTrendVO> selectAll(String keyword) {
	    List<CategoryTrendVO> resultList = CategoryTrendMapper.selectAll(keyword);
	    return resultList;
	}

	@Override
	public List<CategoryTrendVO> selectSearch(String keyword) {
		List<CategoryTrendVO> resultList = CategoryTrendMapper.selectSearch(keyword);
	    return resultList;
	}

	@Override
	public List<CategoryTrendVO> selectGen(String keyword, String gender) {
		List<CategoryTrendVO> vo = CategoryTrendMapper.selectGen(keyword, gender);
		return vo;
	}
	
	@Override
	public List<CategoryTrendVO> selectDev(String keyword, String device) {
		List<CategoryTrendVO> vo = CategoryTrendMapper.selectDev(keyword, device);
		return vo;
	}
	
	@Override
	public List<CategoryTrendVO> selectAge(String keyword, int age) {
		List<CategoryTrendVO> vo = CategoryTrendMapper.selectAge(keyword, age);
		return vo;
	}

	
	//insert
	@Override
	public void insert(CategoryTrendVO vo) {
		CategoryTrendMapper.insert(vo);
	}

	@Override
	public void insertSearch(CategoryTrendVO vo) {
		CategoryTrendMapper.insertSearch(vo);
	}
	
	@Override
	public void insertGen(CategoryTrendVO vo) {
		CategoryTrendMapper.insertGen(vo);
	}
	
	@Override
	public void insertDev(CategoryTrendVO vo) {
		CategoryTrendMapper.insertDev(vo);
	}
	
	@Override
	public void insertAge(CategoryTrendVO vo) {
		CategoryTrendMapper.insertAge(vo);
	}

	
	//update
	@Override
	public void update(CategoryTrendVO vo) {
		CategoryTrendMapper.update(vo);
	}

	@Override
	public void updateSearch(CategoryTrendVO vo) {
		CategoryTrendMapper.updateSearch(vo);
	}
	
	@Override
	public void updateGen(CategoryTrendVO vo) {
		CategoryTrendMapper.updateGen(vo);
	}
	
	@Override
	public void updateDev(CategoryTrendVO vo) {
		CategoryTrendMapper.updateDev(vo);
	}
	
	@Override
	public void updateAge(CategoryTrendVO vo) {
		CategoryTrendMapper.updateAge(vo);
	}

	
	//isExists
	@Override
	public boolean isExists(String period_sdata, String keyword) {
		int num = CategoryTrendMapper.isExists(period_sdata, keyword);
		return num == 1;
	}
	
	@Override
	public boolean isExistsSearch(String period_sdata, String keyword) {
		int num = CategoryTrendMapper.isExistsSearch(period_sdata, keyword);
		return num == 1;
	}
	
	@Override
	public boolean isExistsGen(String period_sdata, String keyword, String gender) {
		int num = CategoryTrendMapper.isExistsGen(period_sdata, keyword, gender);
		return num == 1;
	}
	
	@Override
	public boolean isExistsDev(String period_sdata, String keyword, String device) {
		int num = CategoryTrendMapper.isExistsDev(period_sdata, keyword, device);
		return num == 1;
	}
	
	@Override
	public boolean isExistsAge(String period_sdata, String keyword, int age) {
		int num = CategoryTrendMapper.isExistsAge(period_sdata, keyword, age);
		return num == 1;
	}

	
	//oldRatio
	@Override
	public int oldRatio(String period_sdata, String keyword) {
		return CategoryTrendMapper.oldRatio(period_sdata, keyword);
	}

	@Override
	public int oldRatioSearch(String period_sdata, String keyword) {
		return CategoryTrendMapper.oldRatioSearch(period_sdata, keyword);
	}
	
	@Override
	public int oldRatioGen(String period_sdata, String keyword, String gender) {
		return CategoryTrendMapper.oldRatioGen(period_sdata, keyword, gender);
	}
	
	@Override
	public int oldRatioDev(String period_sdata, String keyword, String device) {
		return CategoryTrendMapper.oldRatioDev(period_sdata, keyword, device);
	}

	@Override
	public int oldRatioAge(String period_sdata, String keyword, int age) {
		return CategoryTrendMapper.oldRatioAge(period_sdata, keyword, age);
	}

}


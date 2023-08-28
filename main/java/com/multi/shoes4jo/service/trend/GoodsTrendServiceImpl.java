package com.multi.shoes4jo.service.trend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.GoodsTrendMapper;
import com.multi.shoes4jo.vo.GoodsTrendVO;

@Service("goodsTrendService")
public class GoodsTrendServiceImpl implements GoodsTrendService {
    @Autowired
    private GoodsTrendMapper goodsTrendMapper;

    @Override
	public List<GoodsTrendVO> selectAll(String keyword) {
	    List<GoodsTrendVO> resultList = goodsTrendMapper.selectAll(keyword);
	    return resultList;
	}
	
	@Override
	public List<GoodsTrendVO> selectGen(String keyword, String gender) {
		List<GoodsTrendVO> vo = goodsTrendMapper.selectGen(keyword, gender);
		return vo;
	}
	
	@Override
	public List<GoodsTrendVO> selectAge(String keyword, int age) {
		List<GoodsTrendVO> vo = goodsTrendMapper.selectAge(keyword, age);
		return vo;
	}

	@Override
	public void insert(GoodsTrendVO vo) {
		goodsTrendMapper.insert(vo);
	}
	
	@Override
	public void insertGen(GoodsTrendVO vo) {
		goodsTrendMapper.insertGen(vo);
	}
	
	@Override
	public void insertAge(GoodsTrendVO vo) {
		goodsTrendMapper.insertAge(vo);
	}

	@Override
	public void update(GoodsTrendVO vo) {
		goodsTrendMapper.update(vo);
	}
	
	@Override
	public void updateGen(GoodsTrendVO vo) {
		goodsTrendMapper.updateGen(vo);
	}
	
	@Override
	public void updateAge(GoodsTrendVO vo) {
		goodsTrendMapper.updateAge(vo);
	}

	@Override
	public boolean isExists(String period_sdata, String keyword) {
		int num = goodsTrendMapper.isExists(period_sdata, keyword);
		return num == 1;
	}
	
	@Override
	public boolean isExistsGen(String period_sdata, String keyword, String gender) {
		int num = goodsTrendMapper.isExistsGen(period_sdata, keyword, gender);
		return num == 1;
	}
	
	@Override
	public boolean isExistsAge(String period_sdata, String keyword, int age) {
		int num = goodsTrendMapper.isExistsAge(period_sdata, keyword, age);
		return num == 1;
	}

	@Override
	public int oldRatio(String period_sdata, String keyword) {
		return goodsTrendMapper.oldRatio(period_sdata, keyword);
	}

	@Override
	public int oldRatioGen(String period_sdata, String keyword, String gender) {
		return goodsTrendMapper.oldRatioGen(period_sdata, keyword, gender);
	}

	@Override
	public int oldRatioAge(String period_sdata, String keyword, int age) {
		return goodsTrendMapper.oldRatioAge(period_sdata, keyword, age);
	}

}

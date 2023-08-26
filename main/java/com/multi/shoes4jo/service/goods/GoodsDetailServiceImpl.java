package com.multi.shoes4jo.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.GoodsDetailMapper;
import com.multi.shoes4jo.vo.GoodsDetailVO;

@Service("goodsDetailService")

public class GoodsDetailServiceImpl implements GoodsDetailService {

	@Autowired
	private GoodsDetailMapper goodsMapper;

	@Override
	public void insertGoods(GoodsDetailVO vo) {
		goodsMapper.insertGoods(vo);
	}

	@Override
	public List<GoodsDetailVO> selectAllGoods() {
		return goodsMapper.selectAllGoods();
	}
	
	@Override
	public GoodsDetailVO selectOneGoods(String goods_id) {
		return goodsMapper.selectOneGoods(goods_id);
	}

	@Override
	public void updateGoods(GoodsDetailVO vo) {
		goodsMapper.updateGoods(vo);
	}

	@Override
	public void deleteGoods(String goods_id) {
		goodsMapper.deleteGoods(goods_id);
	}

}

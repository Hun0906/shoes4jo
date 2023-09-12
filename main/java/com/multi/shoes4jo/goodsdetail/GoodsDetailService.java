package com.multi.shoes4jo.goodsdetail;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;

public interface GoodsDetailService {

	public void insert(GoodsDetailVO vo);

	public List<GoodsDetailVO> selectAllGoods(Criteria cri);

	public int listCount();

	public List<GoodsDetailVO> selectOne(String keyword);

	public void update(GoodsDetailVO vo);

	public void delete(int gno);

	public void deleteByKeyword(String keyword);

}

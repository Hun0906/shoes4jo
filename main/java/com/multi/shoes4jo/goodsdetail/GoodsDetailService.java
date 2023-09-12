package com.multi.shoes4jo.goodsdetail;

import java.util.List;

public interface GoodsDetailService {

    public void insert(GoodsDetailVO vo);

	public List<GoodsDetailVO> selectAllGoods();

	public List<GoodsDetailVO> selectOne(String keyword);

	public void update(GoodsDetailVO vo);

    public void delete(int gno);
    
    public void deleteByKeyword(String keyword);

}

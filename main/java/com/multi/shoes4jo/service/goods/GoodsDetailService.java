package com.multi.shoes4jo.service.goods;

import java.util.List;

import com.multi.shoes4jo.vo.GoodsDetailVO;

public interface GoodsDetailService {
	
    public void insertGoods(GoodsDetailVO vo);
    
    public List<GoodsDetailVO> selectAllGoods();

    public GoodsDetailVO selectOneGoods(String goods_id);
    
    public void updateGoods(GoodsDetailVO vo);
    
    public void deleteGoods(String goods_id);

}
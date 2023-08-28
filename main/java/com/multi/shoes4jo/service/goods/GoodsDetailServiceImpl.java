package com.multi.shoes4jo.service.goods;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void insert(GoodsDetailVO vo) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(new Date());

        vo.setDate(dateString); 

        goodsMapper.insert(vo);
    }

	@Override
	public List<GoodsDetailVO> selectAllGoods() {
		return goodsMapper.selectAllGoods();
	}

	@Override
	public GoodsDetailVO selectOne(int gno) {
		return goodsMapper.selectOne(gno);
	}

	@Override
	public void update(GoodsDetailVO vo) {
		

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(new Date());

        vo.setDate(dateString); 

        
		goodsMapper.update(vo);
	}

	@Override
	public void delete(int gno) {
		goodsMapper.delete(gno);
	}

}

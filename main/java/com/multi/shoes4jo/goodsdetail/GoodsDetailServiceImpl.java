package com.multi.shoes4jo.goodsdetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.GoodsDetailMapper;
import com.multi.shoes4jo.util.Criteria;

@Service("goodsDetailService")
public class GoodsDetailServiceImpl implements GoodsDetailService {

	@Autowired
	private GoodsDetailMapper mapper;

	@Override
	public void insert(GoodsDetailVO vo) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(new Date());

		vo.setDate(dateString);

		mapper.insert(vo);
	}

	@Override
	public List<GoodsDetailVO> selectAllGoods(Criteria cri) {
		return mapper.selectAllGoods(cri);
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public List<GoodsDetailVO> selectOne(String keyword) {
		return mapper.selectOne(keyword);
	}

	@Override
	public void update(GoodsDetailVO vo) {
		mapper.update(vo);
	}

	@Override
	public void delete(int gno) {
		mapper.delete(gno);
	}

	@Override
	public void deleteByKeyword(String keyword) {
		mapper.deleteByKeyword(keyword);
	}
}

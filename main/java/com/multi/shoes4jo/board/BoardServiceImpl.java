package com.multi.shoes4jo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.BoardMapper;
import com.multi.shoes4jo.util.Criteria;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> listPage(Criteria cri) {
		return mapper.listPage(cri);
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public List<BoardVO> selectForMagazine(String category) {
		return mapper.selectForMagazine(category);
	}

	@Override
	public List<BoardVO> selectOneCat(String category) {
		return mapper.selectOneCat(category);
	}

	@Override
	public BoardVO selectOne(int bno) {
		return mapper.select(bno);
	}

	@Override
	public void insertOne(BoardVO vo) {
		Integer maxBno = mapper.maxBno();
		vo.setBno((maxBno == null) ? 1 : maxBno + 1);
		mapper.insert(vo);
	}

	@Override
	public void updateOne(BoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void updateviewcnt(int bno) {
		mapper.updateCount(bno);
	}

	@Override
	public void deleteOne(int bno) {
		mapper.delete(bno);
	}

}

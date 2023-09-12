package com.multi.shoes4jo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.BoardMapper;
import com.multi.shoes4jo.util.Criteria;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> listPage(Criteria cri) {
		return boardMapper.listPage(cri);
	}

	@Override
	public int listCount() {
		return boardMapper.listCount();
	}

	@Override
	public List<BoardVO> selectForMagazine(String category) {
		return boardMapper.selectForMagazine(category);
	}

	@Override
	public List<BoardVO> selectOneCat(String category) {
		return boardMapper.selectOneCat(category);
	}

	@Override
	public BoardVO selectOne(String bno) {
		return boardMapper.select(bno);
	}

	@Override
	public void insertOne(BoardVO board) {
		Integer maxBno = boardMapper.maxBno();
		board.setBno((maxBno == null) ? 1 : maxBno + 1);
		boardMapper.insert(board);
	}

	@Override
	public void updateOne(BoardVO board) {
		boardMapper.update(board);
	}

	@Override
	public void updateviewcnt(String bno) {
		boardMapper.updateCount(bno);
	}

	@Override
	public void deleteOne(String bno) {
		boardMapper.delete(bno);
	}

}

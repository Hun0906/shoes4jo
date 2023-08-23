package com.multi.shoes4jo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.command.PageInfo;
import com.multi.shoes4jo.mapper.BoardMapper;
import com.multi.shoes4jo.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> selectBoardList(PageInfo pageInfo, Map<String, String> param) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());

		Map<String, String> searchMap = new HashMap<String, String>();
		String searchValue = param.get("searchValue");
		if (searchValue != null && searchValue.length() > 0) {
			String type = param.get("searchType");
			if (type.equals("title")) {
				searchMap.put("titleKeyword", searchValue);
			} else if (type.equals("content")) {
				searchMap.put("contentKeyword", searchValue);
			} else if (type.equals("writer")) {
				searchMap.put("writerKeyword", searchValue);
			}
		}

		return boardMapper.selectBoardList(pageInfo, searchMap);
	}

	@Override
	public int selectBoardCount(Map<String, String> searchMap) {
		return boardMapper.selectBoardCount(searchMap);
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

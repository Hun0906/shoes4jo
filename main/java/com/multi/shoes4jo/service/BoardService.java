package com.multi.shoes4jo.service;

import java.util.List;
import java.util.Map;

import com.multi.shoes4jo.command.PageInfo;
import com.multi.shoes4jo.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> selectBoardList(PageInfo pageInfo, Map<String, String> param);

	public int selectBoardCount(Map<String, String> param);

	public List<BoardVO> selectForMagazine(String category);

	public List<BoardVO> selectOneCat(String category);

	public BoardVO selectOne(String bno);

	public void updateviewcnt(String bno);

	public void insertOne(BoardVO board);

	public void updateOne(BoardVO board);

	public void deleteOne(String bno);

}

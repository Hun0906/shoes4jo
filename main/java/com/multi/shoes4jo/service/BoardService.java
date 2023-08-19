package com.multi.shoes4jo.service;

import java.util.List;

import com.multi.shoes4jo.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> selectList();
	
	public List<BoardVO> selectNews();
	
	public List<BoardVO> selectEvents();
	
	public List<BoardVO> selectColumns();
	
	public BoardVO selectOne(String bno);
	
	public void updateviewcnt(String bno);
	
	public void insertOne(BoardVO board);
	
	public void updateOne(BoardVO board);
	
	public void deleteOne(String bno);

}

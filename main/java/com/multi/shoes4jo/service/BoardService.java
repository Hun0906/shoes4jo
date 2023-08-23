package com.multi.shoes4jo.service;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> listPage(Criteria cri);

	public int listCount();

	public List<BoardVO> selectForMagazine(String category);

	public List<BoardVO> selectOneCat(String category);

	public BoardVO selectOne(String bno);

	public void updateviewcnt(String bno);

	public void insertOne(BoardVO board);

	public void updateOne(BoardVO board);

	public void deleteOne(String bno);

}

package com.multi.shoes4jo.board;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;

public interface BoardService {

	public List<BoardVO> listPage(Criteria cri);

	public int listCount(String searchType, String keyword);

	public List<BoardVO> selectForMagazine(String category);

	public List<BoardVO> selectOneCat(String category);

	public BoardVO selectOne(int bno);

	public void updateviewcnt(int bno);

	public void insertOne(BoardVO vo);

	public void updateOne(BoardVO vo);

	public void deleteOne(int bno);

}

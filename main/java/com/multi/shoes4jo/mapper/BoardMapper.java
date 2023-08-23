package com.multi.shoes4jo.mapper;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> listPage(Criteria cri);

	public int listCount();

	public List<BoardVO> selectForMagazine(String category);

	public List<BoardVO> selectOneCat(String category);

	public BoardVO select(String bno);

	public BoardVO insert(BoardVO board);

	public int update(BoardVO board);

	public String updateCount(String bno);

	public int delete(String bno);

	public int maxBno();
}

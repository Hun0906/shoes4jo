package com.multi.shoes4jo.freeboard;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;

public interface FreeBoardService {

	public List<FreeBoardVO> listPage(Criteria cri);

	public int listCount();

	public FreeBoardVO select(int fno);

	public List<FreeBoardVO> selectCat(String category);

	public List<FreeBoardVO> myBoardList(String member_id);

	public void updateviewcnt(int fno);

	public void insert(FreeBoardVO vo);

	public void update(FreeBoardVO vo);

	public void delete(int fno);

}
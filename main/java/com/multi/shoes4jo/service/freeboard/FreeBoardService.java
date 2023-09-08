package com.multi.shoes4jo.service.freeboard;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.FreeBoardVO;

public interface FreeBoardService {

	public List<FreeBoardVO> listPage(Criteria cri);

	public int listCount();

	public FreeBoardVO select(int fno);

	public List<FreeBoardVO> selectCat(String category);

	public List<FreeBoardVO> FreeListById(String member_id);

	public void updateviewcnt(int fno);

	public void insert(FreeBoardVO vo);

	public void update(FreeBoardVO vo);

	public void delete(int fno);

}
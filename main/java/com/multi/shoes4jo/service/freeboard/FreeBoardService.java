package com.multi.shoes4jo.service.freeboard;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.CommentVO;
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

	public int insertComment(CommentVO vo);

	public int deleteComment(int cno);

	public List<CommentVO> selectComment(int fno);
	// 게시물 번호에 해당하는 모든 댓글 조회

	public List<CommentVO> selectByIdComment(String member_id);
	// 본인 아이디로 쓴 댓글 리스트 조회
}
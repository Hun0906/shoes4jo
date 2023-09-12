package com.multi.shoes4jo.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.FreeBoardMapper;
import com.multi.shoes4jo.util.Criteria;

@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper mapper;

	@Autowired
	private CommentService comm_service;

	@Override
	public List<FreeBoardVO> listPage(Criteria cri) {
		List<FreeBoardVO> list = mapper.listPage(cri);

		for (FreeBoardVO vo : list) {
			int comment_cnt = comm_service.getTotal(vo.getFno()); // 각 게시글의 댓글 수도 조회
			vo.setComment_cnt(comment_cnt); // 조회한 댓글 수를 VO에 설정
		}

		return list;
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public FreeBoardVO select(int fno) {
		return mapper.select(fno);
	}

	@Override
	public void updateviewcnt(int fno) {
		mapper.updateCount(fno);
	}

	@Override
	public void insert(FreeBoardVO vo) {
		Integer maxFno = mapper.maxfno();
		vo.setFno((maxFno == null) ? 1 : maxFno + 1);
		mapper.insert(vo);
	}

	@Override
	public void update(FreeBoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void delete(int fno) {
		mapper.delete(fno);
	}

	@Override
	public List<FreeBoardVO> selectCat(String category) {
		return mapper.selectCat(category);
	}

	@Override
	public List<FreeBoardVO> myBoardList(String member_id) {
		return mapper.myBoardList(member_id);
	}
}

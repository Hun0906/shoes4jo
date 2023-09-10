package com.multi.shoes4jo.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.CommentMapper;
import com.multi.shoes4jo.vo.CommentVO;

@Service("CommentService")
public class CommentService {

	@Autowired
	private CommentMapper mapper;

	public void insert(CommentVO vo) {
		mapper.insert(vo);
	}

	public List<CommentVO> commentList(int fno) {
		return mapper.commentList(fno);
	}

	public int getTotal(int fno) {
		return mapper.getTotal(fno);
	}

	public List<CommentVO> myComment(String member_id) {
		return mapper.myComment(member_id);
	}

	public void update(CommentVO vo) {
		mapper.update(vo);
	}

	public void delete(int cno) {
		mapper.delete(cno);
	}
}

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

	public List<CommentVO> selectCo(int fno) {
		return mapper.selectCo(fno);
	}

	public List<CommentVO> selectByIdCo(String member_id) {
		return mapper.selectByIdCo(member_id);
	}

	public int insertCo(CommentVO vo) {
		return mapper.insertCo(vo);
	}

	public int deleteCo(int cno) {
		return mapper.deleteCo(cno);
	}
}

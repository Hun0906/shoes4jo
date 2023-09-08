package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.multi.shoes4jo.vo.CommentVO;

@Mapper
public interface CommentMapper {


	@Select("SELECT * FROM comment WHERE fno = #{fno}")
	List<CommentVO> selectCo(@Param("fno") int fno);
	// 게시물 번호에 해당하는 댓글 조회

	@Select("SELECT * FROM comment WHERE member_id = #{member_id}")
	List<CommentVO> selectByIdCo(@Param("member_id") String member_id);
	// 본인 아이디 댓글들 조회

	@Insert("INSERT INTO comment (cno, member_id, fno, content) VALUES (#{cno}, #{member_id}, #{fno}, #{content})")
	int insertCo(CommentVO vo);
	// 새 댓글 추가

	@Delete("DELETE FROM comment WHERE cno = #{cno}")
	int deleteCo(@Param("cno") int cno);
	// 번호에 해당하는 댓글 삭제
}

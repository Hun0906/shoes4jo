package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.CommentVO;
import com.multi.shoes4jo.vo.FreeBoardVO;

@Mapper
public interface FreeBoardMapper {

	@Select("SELECT fno, member_id, category, title, content, viewcnt, date FROM 4jo_freeboard ORDER BY fno DESC LIMIT #{perPageNum} OFFSET #{pageStart}")
	public List<FreeBoardVO> listPage(Criteria cri);
	// 페이징 목록조회

	@Select("SELECT COUNT(fno) FROM 4jo_freeboard WHERE fno > 0")
	public int listCount();

	@Select("SELECT * FROM 4jo_freeboard WHERE fno = #{fno}")
	FreeBoardVO select(@Param("fno") int fno);
	// 게시물 번호에 해당하는 게시물 조회

	@Select("SELECT * FROM 4jo_freeboard WHERE category = #{category} ORDER BY fno DESC")
	List<FreeBoardVO> selectCat(@Param("category") String category);
	// 카테고리에 해당하는 게시물 전부 내림차순 정렬해서 조회

	@Select("SELECT * FROM 4jo_freeboard WHERE member_id = #{member_id}")
	List<FreeBoardVO> FreeListById(String member_id);
	// 본인 아이디의 게시글 전체 조회

	@Insert("INSERT INTO 4jo_freeboard (fno, member_id, category, title, content, file_name, file_path, comment) VALUES (#{fno}, #{member_id}, #{category}, #{title}, #{content}, #{file_name}, #{file_path}, #{comment})")
	int insert(FreeBoardVO vo);
	// 새 게시물 추가

	@Update("UPDATE 4jo_freeboard SET category = #{category}, title = #{title}, content = #{content}, file_name = #{file_name}, file_path = #{file_path}, comment = #{comment} WHERE fno = #{fno}")
	int update(FreeBoardVO vo);
	// 기존 게시물 업데이트

	@Update("UPDATE 4jo_freeboard SET viewcnt = viewcnt + 1 WHERE fno = #{fno}")
	int updateCount(@Param("fno") int fno);
	// 게시물 번호에 해당하는 조회수 1 증가

	@Delete("DELETE FROM 4jo_freeboard WHERE fno = #{fno}")
	int delete(@Param("fno") int fno);
	// 번호에 해당하는 게시물 삭제

	@Select("SELECT MAX(fno) FROM 4jo_freeboard")
	Integer maxfno();
	// 최대 게시물 번호 조회

	@Select("SELECT * FROM 4jo_comment WHERE fno = #{fno}")
	List<CommentVO> selectComment(@Param("fno") int fno);
	// 게시물 번호에 해당하는 모든 댓글 조회

	@Select("SELECT * FROM 4jo_comment WHERE member_id = #{member_id}")
	List<CommentVO> selectByIdComment(@Param("member_id") String member_id);
	// 본인 아이디 댓글들 조회

	@Insert("INSERT INTO 4jo_comment (cno, member_id, fno, content) VALUES (#{cno}, #{member_id}, #{fno}, #{content})")
	int insertComment(CommentVO comment);
	// 새 댓글 추가

	@Delete("DELETE FROM 4jo_comment WHERE cno = #{cno}")
	int deleteComment(@Param("cno") int cno);
	// 번호에 해당하는 댓글 삭제

}

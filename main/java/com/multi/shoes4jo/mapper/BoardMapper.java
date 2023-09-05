package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Select("SELECT bno, category, title, content, writer, viewcnt, regdate FROM board ORDER BY bno DESC LIMIT #{perPageNum} OFFSET #{pageStart}")
	public List<BoardVO> listPage(Criteria cri);
	// 페이징 목록조회

	@Select("SELECT COUNT(bno) FROM board WHERE bno > 0")
	public int listCount();

	@Select("SELECT * FROM board where category = #{category} ORDER BY bno DESC limit 3")
	List<BoardVO> selectForMagazine(@Param("category") String category);
	// 카테고리에 해당하는 게시물 중 상위 3개 내림차순 정렬해 조회

	@Select("SELECT * FROM board WHERE category = #{category} ORDER BY bno DESC")
	List<BoardVO> selectOneCat(@Param("category") String category);
	// 카테고리에 해당하는 게시물 전부 내림차순 정렬해서 조회

	@Select("SELECT * FROM board WHERE bno = #{bno}")
	BoardVO select(@Param("bno") String bno);
	// 게시물 번호에 해당하는 게시물 조회

	@Insert("INSERT INTO board (bno, category, title, content, writer, file_name, file_path, link) VALUES (#{bno}, #{category}, #{title}, #{content}, #{writer}, #{file_name}, #{file_path}, #{link})")
	int insert(BoardVO board);
	// 새 게시물 추가

	@Update("UPDATE board SET category = #{category}, title = #{title}, content = #{content}, file_name = #{file_name}, file_path = #{file_path}, link = #{link} WHERE bno = #{bno}")
	int update(BoardVO board);
	// 기존 게시물 업데이트

	@Update("UPDATE board SET viewcnt = viewcnt + 1 WHERE bno = #{bno}")
	void updateCount(@Param("bno") String bno);
	// 게시물 번호에 해당하는 조회수 1 증가

	@Delete("DELETE FROM board WHERE bno = #{bno}")
	void delete(@Param("bno") String bno);
	// 번호에 해당하는 게시물 삭제

	@Select("SELECT MAX(bno) FROM board")
	Integer maxBno();
	// 최대 게시물 번호 조회

}

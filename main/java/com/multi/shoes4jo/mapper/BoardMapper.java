package com.multi.shoes4jo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.command.PageInfo;
import com.multi.shoes4jo.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Select("SELECT COUNT(*) FROM 4jo_board WHERE title LIKE '%'|| #{param.titleKeyword} ||'%' AND content LIKE '%'|| #{param.contentKeyword} ||'%' AND writer LIKE '%'|| #{param.writerKeyword} ||'%' AND category LIKE '%'|| #{param.category} ||'%'")
	int selectBoardCount(@Param("param") Map<String, String> param);
	// titleKeyword, contentKeyword, writerKeyword를 카테고리로 만들고 category값을 사용하여 검색 조건을
	// 만족하는 게시물의 개수 조회

	@Select("SELECT * FROM 4jo_board WHERE title LIKE '%'|| #{param.titleKeyword} ||'%' AND content LIKE '%'|| #{param.contentKeyword} ||'%' AND writer LIKE '%'|| #{param.writerKeyword} ||'%' AND category LIKE '%'|| #{param.category} ||'%' ORDER BY bno DESC LIMIT #{pageInfo.startIndex}, #{pageInfo.listLimit}")
	List<BoardVO> selectBoardList(@Param("pageInfo") PageInfo pageInfo, @Param("param") Map<String, String> param);
//특정 페이지에 해당하는 게시물 목록 조회

	@Select("SELECT * FROM 4jo_board ORDER BY bno DESC")
	List<BoardVO> selectAll();
	// 모든 게시물을 번호순(내림차순)으로 정렬해 조회

	@Select("SELECT * FROM 4jo_board where category = #{category} ORDER BY bno DESC limit 3")
	List<BoardVO> selectForMagazine(@Param("category") String category);
	// 카테고리에 해당하는 게시물 중 상위 3개 내림차순 정렬해 조회

	@Select("SELECT * FROM 4jo_board WHERE category = #{category} ORDER BY bno DESC")
	List<BoardVO> selectOneCat(@Param("category") String category);
	// 카테고리에 해당하는 게시물 전부 내림차순 정렬해서 조회

	@Select("SELECT * FROM 4jo_board WHERE bno = #{bno}")
	BoardVO select(@Param("bno") String bno);
	// 게시물 번호에 해당하는 게시물 조회

	@Insert("INSERT INTO 4jo_board (bno, category, title, content, writer, file_name, file_path, link) VALUES (#{bno}, #{category}, #{title}, #{content}, #{writer}, #{file_name}, #{file_path}, #{link})")
	int insert(BoardVO board);
	// 새 게시물 추가

	@Update("UPDATE 4jo_board SET category = #{category}, title = #{title}, content = #{content}, file_name = #{file_name}, file_path = #{file_path}, link = #{link} WHERE bno = #{bno}")
	int update(BoardVO board);
	// 기존 게시물 업데이트

	@Update("UPDATE 4jo_board SET viewcnt = viewcnt + 1 WHERE bno = #{bno}")
	void updateCount(@Param("bno") String bno);
	// 게시물 번호에 해당하는 조회수 1 증가

	@Delete("DELETE FROM 4jo_board WHERE bno = #{bno}")
	void delete(@Param("bno") String bno);
	// 번호에 해당하는 게시물 삭제

	@Select("SELECT MAX(bno) FROM 4jo_board")
	Integer maxBno();
	// 최대 게시물 번호 조회

}

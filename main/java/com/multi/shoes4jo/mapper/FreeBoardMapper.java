package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.freeboard.FreeBoardVO;
import com.multi.shoes4jo.util.Criteria;

@Mapper
public interface FreeBoardMapper {

	@Select("SELECT fno, member_id, category, title, content, viewcnt, date, update_date FROM freeboard ORDER BY fno DESC LIMIT #{perPageNum} OFFSET #{pageStart}")
	public List<FreeBoardVO> listPage(Criteria cri);
	// 페이징 목록조회

	@Select("SELECT COUNT(fno) FROM freeboard WHERE fno > 0")
	public int listCount();

	@Select("SELECT * FROM freeboard WHERE fno = #{fno}")
	FreeBoardVO select(@Param("fno") int fno);
	// 게시물 번호에 해당하는 게시물 조회

	@Select("SELECT * FROM freeboard WHERE category = #{category} ORDER BY fno DESC")
	List<FreeBoardVO> selectCat(@Param("category") String category);
	// 카테고리에 해당하는 게시물 전부 내림차순 정렬해서 조회

	@Select("SELECT * FROM freeboard WHERE member_id = #{member_id} ORDER BY fno DESC LIMIT #{cri.perPageNum} OFFSET #{cri.pageStart}")
	List<FreeBoardVO> myBoardList(@Param("member_id") String member_id, @Param("cri") Criteria cri);
	// 본인 아이디의 게시글 전체 조회(페이징)

	@Select("SELECT COUNT(fno) FROM freeboard WHERE member_id = #{memberId}")
	int listCountMember(@Param("memberId") String memberId);
	// 아이디 게시글 조회 페이징

	@Insert("INSERT INTO freeboard (fno, member_id, category, title, content, file_name, file_path) VALUES (#{fno}, #{member_id}, #{category}, #{title}, #{content}, #{file_name}, #{file_path})")
	int insert(FreeBoardVO vo);
	// 새 게시물 추가

	@Update("UPDATE freeboard SET category = #{category}, title = #{title}, content = #{content}, file_name = #{file_name}, file_path = #{file_path} WHERE fno = #{fno}")
	int update(FreeBoardVO vo);
	// 기존 게시물 업데이트

	@Update("UPDATE freeboard SET viewcnt = viewcnt + 1 WHERE fno = #{fno}")
	int updateCount(@Param("fno") int fno);
	// 게시물 번호에 해당하는 조회수 1 증가

	@Delete("DELETE FROM freeboard WHERE fno = #{fno}")
	int delete(@Param("fno") int fno);
	// 번호에 해당하는 게시물 삭제

	@Select("SELECT MAX(fno) FROM freeboard")
	Integer maxfno();
	// 최대 게시물 번호 조회

}

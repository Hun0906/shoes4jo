package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.multi.shoes4jo.vo.BookmarkVO;

@Mapper
public interface BookmarkMapper {

	//북마크 여부 조회
    @Select("SELECT * FROM 4jo_bookmark WHERE gno = #{gno} AND member_id = #{memberId}")
    BookmarkVO check(@Param("memberId") String memberId,@Param("gno") int gno);
	
	//본인 아이디의 북마크 전체 조회
	@Select("SELECT * FROM 4jo_bookmark WHERE member_id = #{member_id}")
	List<BookmarkVO> BookmarkList(String member_id);

    //북마크 추가
    @Insert("INSERT INTO 4jo_bookmark(member_id, gno, add_date) VALUES(#{member_id}, #{gno}, #{add_date})")
    int insert(BookmarkVO vo);

    //북마크 삭제
    @Delete("DELETE FROM 4jo_bookmark WHERE gno = #{gno} AND member_id = #{member_id}")
    int delete(@Param("gno") int gno, @Param("member_id")String member_id);

}

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

	@Select("SELECT * FROM 4jo_bookmark")
	List<BookmarkVO> selectAll();

	@Select("SELECT * FROM 4jo_bookmark WHERE bookmark_no = #{bookmark_no}")
	BookmarkVO selectOne(@Param("bookmark_no") int bookmark_no);

	@Insert("INSERT INTO 4jo_bookmark(bookmark_no, member_id, keywords, category, add_date) VALUES(#{bookmark_no}, #{member_id}, #{keywords}, #{category}, #{add_date})")
	void insert(BookmarkVO bookmark);

	@Delete("DELETE FROM 4jo_bookmark WHERE bookmark_no =  {#bookmark_no}")
	void delete(@Param("bookmark_no") int bookmarkNo);
}

package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookmarkMapC {

	@Results(id = "bookmarkCResult", value = { @Result(property = "bookmark_id", column = "bookmark_id"),
			@Result(property = "member_id", column = "member_id"),
			@Result(property = "start_date", column = "start_date"),
			@Result(property = "end_date", column = "end_date"), @Result(property = "time_unit", column = "time_unit"),
			@Result(property = "category", column = "category"),
			@Result(property = "category_name", column = "category_name"),
			@Result(property = "category_param", column = "category_param"),
			@Result(property = "device", column = "device"), @Result(property = "gender", column = "gender"),
			@Result(property = "ages", column = "ages"), @Result(property = "add_date", column = "add_date") })
	@Select("SELECT * FROM campusDB.4jo_bookmark_category WHERE member_id = #{member_id}")
	List<BookmarkMapC> findByMemberId(String member_id);

	@Insert("INSERT INTO campusDB.4jo_bookmark_category (bookmark_id, member_id, start_date, end_date, "
			+ "time_unit, category, category_name, category_param, device, gender, ages, add_date) "
			+ "VALUES (#{bookmark_id}, #{member_id}, #{start_date}, #{end_date}, "
			+ "#{time_unit}, #{category}, #{category_name}, #{category_param}, "
			+ "#{device}, #{gender}, #{ages}, #{add_date})")
	int insertBookmarkC(BookmarkMapC bookmarkC);

	@Delete("DELETE FROM campusDB.4jo_bookmark_category " + "WHERE member_id = #{member_id}")
	int deleteBookmarkC(BookmarkMapC bookmarkC);
}


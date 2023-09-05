package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.vo.KeywordTrendVO;

@Mapper
public interface KeywordTrendMapper {
	//list
    @Select("SELECT * FROM `keyword_trend` WHERE keyword = #{keyword} ORDER BY query_value DESC limit 10")
    List<KeywordTrendVO> selectKeyword(@Param("keyword") String keyword);
    
    @Select("SELECT `keyword` FROM `keyword_trend` WHERE keyword_group = #{keyword_group}")
    List<String> selectGroup(@Param("keyword_group") String keyword_group);
    
    @Select("SELECT * FROM `keyword_trend` ORDER BY query_value DESC")
    List<KeywordTrendVO> selectAll();
    
    
    //isExists
    @Select("SELECT count(*) FROM `keyword_trend` WHERE keyword = #{keyword} and query = #{query}")
    int isExists(@Param("keyword") String keyword, @Param("query") String query);
    
    
    //oldValue
    @Select("SELECT query_value FROM `keyword_trend` WHERE keyword = #{keyword} and query = #{query}")
    int oldValue(@Param("keyword") String keyword, @Param("query") String query);

    
    //insert
    @Insert("INSERT INTO `keyword_trend` (keyword_group, keyword, query, query_value) VALUES (#{keyword_group}, #{keyword}, #{query}, #{query_value})")
    void insert(KeywordTrendVO vo);

    
    //update
    @Update("UPDATE `keyword_trend` SET query_value = #{query_value} WHERE keyword = #{keyword} AND query = #{query}")
    void update(KeywordTrendVO vo);

}

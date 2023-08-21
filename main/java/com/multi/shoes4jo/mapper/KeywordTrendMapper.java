package com.multi.shoes4jo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Mapper
public interface KeywordTrendMapper {
    @Select("SELECT * FROM api_search_all WHERE keyword = #{keyword}")
    KeywordTrendVO select(@Param("keyword") String keyword);

    @Insert("INSERT INTO api_search_all (period_sdata, keyword, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{ratio_cnt})")
    void insert(KeywordTrendVO KeywordTrend);

    @Update("UPDATE api_search_all SET title = #{title}, content = #{content}, thumb = #{thumb}, link = #{link} WHERE bno = #{bno}")
    void update(KeywordTrendVO KeywordTrend);

    @Update("UPDATE api_search_all SET ratio_cnt = #{ratio_cnt} WHERE keyword = #{keyword} and period_sdata = #{period_sdata}")
    void updateRatio(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);

}

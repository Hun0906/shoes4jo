package com.multi.shoes4jo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Mapper
public interface KeywordTrendMapper {
    @Select("SELECT * FROM 4jo_api_search_all WHERE keyword = #{keyword}")
    KeywordTrendVO select(@Param("keyword") String keyword);

    @Select("SELECT count(*) FROM 4jo_api_search_all WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int isExists(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_search_all WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int oldRatio(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);

    @Insert("INSERT INTO 4jo_api_search_all (period_sdata, keyword, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{ratio_cnt})")
    void insert(KeywordTrendVO vo);

    @Update("UPDATE 4jo_api_search_all SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    void update(KeywordTrendVO vo);

}

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
    @Select("SELECT * FROM `4jo_api_search_all` WHERE keyword = #{keyword} ORDER BY period_sdata DESC limit 30")
    List<KeywordTrendVO> selectAll(@Param("keyword") String keyword);

    @Select("SELECT * FROM `4jo_api_search_gender` WHERE keyword = #{keyword} and gender = #{gender} ORDER BY period_sdata DESC limit 30")
    List<KeywordTrendVO> selectGen(@Param("keyword") String keyword, @Param("gender") String gender);
    
    @Select("SELECT * FROM `4jo_api_search_ages` WHERE keyword = #{keyword} and age = #{age} ORDER BY period_sdata DESC limit 30")
    List<KeywordTrendVO> selectAge(@Param("keyword") String keyword, @Param("age") int age);
    
    @Select("SELECT count(*) FROM 4jo_api_search_all WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int isExists(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT count(*) FROM 4jo_api_search_gender WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and gender = #{gender}")
    int isExistsGen(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("gender") String gender);
    
    @Select("SELECT count(*) FROM 4jo_api_search_ages WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and age = #{age}")
    int isExistsAge(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("age") int age);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_search_all WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int oldRatio(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_search_gender WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and gender = #{gender}")
    int oldRatioGen(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("gender") String gender);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_search_ages WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and age = #{age}")
    int oldRatioAge(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("age") int age);

    @Insert("INSERT INTO 4jo_api_search_all (period_sdata, keyword, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{ratio_cnt})")
    void insert(KeywordTrendVO vo);
    
    @Insert("INSERT INTO 4jo_api_search_gender (period_sdata, keyword, gender, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{gender}, #{ratio_cnt})")
    void insertGen(KeywordTrendVO vo);
    
    @Insert("INSERT INTO 4jo_api_search_ages (period_sdata, keyword, age, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{age}, #{ratio_cnt})")
    void insertAge(KeywordTrendVO vo);

    @Update("UPDATE 4jo_api_search_all SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    void update(KeywordTrendVO vo);
    
    @Update("UPDATE 4jo_api_search_gender SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and gender = #{gender}")
    void updateGen(KeywordTrendVO vo);
    
    @Update("UPDATE 4jo_api_search_ages SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and age = #{age}")
    void updateAge(KeywordTrendVO vo);

}

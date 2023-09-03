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
    @Select("SELECT * FROM `4jo_keyword_trend` WHERE keyword = #{keyword} ORDER BY value DESC")
    List<KeywordTrendVO> selectKeyword(@Param("keyword") String keyword);
    
    @Select("SELECT `keyword` FROM `4jo_keyword_trend` WHERE group = #{group})
    List<KeywordTrendVO> selectGroup(@Param("group") String group);
    
    
    //isExists
    @Select("SELECT count(*) FROM 4jo_api_click_all WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int isExists(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT count(*) FROM 4jo_api_search WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int isExistsSearch(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT count(*) FROM 4jo_api_click_gender WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and gender = #{gender}")
    int isExistsGen(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("gender") String gender);
    
    @Select("SELECT count(*) FROM 4jo_api_click_device WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and device = #{device}")
    int isExistsDev(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("device") String device);
    
    @Select("SELECT count(*) FROM 4jo_api_click_ages WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and age = #{age}")
    int isExistsAge(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("age") int age);
    
    
    //oldRatio update
    @Select("SELECT ratio_cnt FROM 4jo_api_click_all WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int oldRatio(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_search WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    int oldRatioSearch(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_click_gender WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and gender = #{gender}")
    int oldRatioGen(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("gender") String gender);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_click_device WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and device = #{device}")
    int oldRatioDev(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("device") String device);
    
    @Select("SELECT ratio_cnt FROM 4jo_api_click_ages WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and age = #{age}")
    int oldRatioAge(@Param("period_sdata") String period_sdata, @Param("keyword") String keyword, @Param("age") int age);

    
    //insert
    @Insert("INSERT INTO 4jo_api_click_all (period_sdata, keyword, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{ratio_cnt})")
    void insert(KeywordTrendVO vo);
    
    @Insert("INSERT INTO 4jo_api_search (period_sdata, keyword, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{ratio_cnt})")
    void insertSearch(KeywordTrendVO vo);
    
    @Insert("INSERT INTO 4jo_api_click_gender (period_sdata, keyword, gender, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{gender}, #{ratio_cnt})")
    void insertGen(KeywordTrendVO vo);
    
    @Insert("INSERT INTO 4jo_api_click_device (period_sdata, keyword, device, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{device}, #{ratio_cnt})")
    void insertDev(KeywordTrendVO vo);
    
    @Insert("INSERT INTO 4jo_api_click_ages (period_sdata, keyword, age, ratio_cnt) VALUES (#{period_sdata}, #{keyword}, #{age}, #{ratio_cnt})")
    void insertAge(KeywordTrendVO vo);

    
    //update
    @Update("UPDATE 4jo_api_click_all SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    void update(KeywordTrendVO vo);
    
    @Update("UPDATE 4jo_api_search SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword}")
    void updateSearch(KeywordTrendVO vo);
    
    @Update("UPDATE 4jo_api_click_gender SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and gender = #{gender}")
    void updateGen(KeywordTrendVO vo);
    
    @Update("UPDATE 4jo_api_click_device SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and device = #{device}")
    void updateDev(KeywordTrendVO vo);
    
    @Update("UPDATE 4jo_api_click_ages SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and keyword = #{keyword} and age = #{age}")
    void updateAge(KeywordTrendVO vo);

}

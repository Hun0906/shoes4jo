package com.multi.shoes4jo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.multi.shoes4jo.vo.RankingVO;

@Mapper
public interface RankingMapper {
    @Select("SELECT * FROM `shoes_4jo`.ranking WHERE keyword = #{keyword}")
    RankingVO selectAll(@Param("keyword") String keyword);
    
    @Select("SELECT count(*) FROM `shoes_4jo`.ranking WHERE keyword = #{keyword} and date = #{date}")
    int isExists(String keyword, String date);
    
    @Insert("INSERT INTO `shoes_4jo`.ranking (keyword, title) VALUES (#{keyword}, #{title})")
    void insert(String keyword, String title);
    
    @Update("UPDATE `shoes_4jo`.ranking SET cnt += 1 WHERE keyword = #{keyword} and date = #{date}")
    void update(String keyword, String date);

}

package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.categorytrend.CategoryTrendVO;

@Mapper
public interface CategoryTrendMapper {
	//list
    @Select("SELECT * FROM `category_click_all` WHERE catId = #{catId} ORDER BY period_sdata DESC limit 30")
    List<CategoryTrendVO> select(@Param("catId") String catId);
    
    //category name inner join
    @Select("SELECT * FROM `category_info`")
    List<CategoryTrendVO> selectCatInfo();
    
    //isExists
    @Select("SELECT count(*) FROM `category_click_all` WHERE period_sdata = #{period_sdata} and catId = #{catId}")
    int isExists(@Param("period_sdata") String period_sdata, @Param("catId") String catId);
    
    //oldRatio update
    @Select("SELECT ratio_cnt FROM `category_click_all` WHERE period_sdata = #{period_sdata} and catId = #{catId}")
    int oldRatio(@Param("period_sdata") String period_sdata, @Param("catId") String catId);

    //insert
    @Insert("INSERT INTO `category_click_all` (period_sdata, catId, ratio_cnt) VALUES (#{period_sdata}, #{catId}, #{ratio_cnt})")
    void insert(CategoryTrendVO vo);
    
    //update
    @Update("UPDATE `category_click_all` SET ratio_cnt = #{ratio_cnt} WHERE period_sdata = #{period_sdata} and catId = #{catId}")
    void update(CategoryTrendVO vo);

}

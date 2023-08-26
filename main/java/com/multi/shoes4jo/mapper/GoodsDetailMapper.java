package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.vo.GoodsDetailVO;

@Mapper
public interface GoodsDetailMapper {

    // 상품 등록
    @Insert("INSERT INTO 4jo_goods_detail(keyword, thumbnail, goods_id, goods_name, seller_name, seller_url," +
            "goods_price, delivery_fee, goods_img, update_date, category) VALUES(#{keyword}, #{thumbnail}, #{goods_id}," +
            "#{goods_name}, #{seller_name}, #{seller_url}, #{goods_price}, #{delivery_fee}," +
            "#{goods_img}, NOW(), #{category})")
    void insertGoods(GoodsDetailVO vo);

    // 전체 상품 목록 조회
    @Select("SELECT * FROM 4jo_goods_detail")
    List<GoodsDetailVO> selectAllGoods();

    // 특정 상품 조회
    @Select("SELECT * FROM 4jo_goods_detail WHERE goods_id=#{goods_id}")
    GoodsDetailVO selectOneGoods(@Param("goods_id") String goods_id);
    
    // 상품 등록 정보 수정
    @Update("UPDATE 4jo_goods_detail SET keyword = #{keyword}, thumbnail = #{thumbnail}," +
            "goods_name = #{goods_name}, seller_name = #{seller_name}," + 
            "seller_url = #{seller_url},  goods_price =  #{goods_price}," + 
            "delivery_fee =  #{delivery_fee} ,  goods_img=  #{goods_img} ," + 
            "update_date=NOW(), category=#{category} WHERE goods_id=#{goods_id}")
     void updateGoods(GoodsDetailVO vo);

     // 등록 상품 삭제
     @Delete("DELETE FROM 4jo_goods_detail WHERE id=#{goods_id}")
     void deleteGoods(@Param("goods_id") String goods_id);
}

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
    @Insert("INSERT INTO 4jo_goods_detail(gno, keyword, category, goods_name, goods_img, seller_name, seller_url, goods_price, delivery_fee, date) VALUES(#{gno}, #{keyword}, #{category}, #{goods_name}, #{goods_img}, #{seller_name}, #{seller_url}, #{goods_price}, #{delivery_fee}, #{date})")
    void insert(GoodsDetailVO vo);

    // 전체 상품 목록 조회
    @Select("SELECT * FROM 4jo_goods_detail")
    List<GoodsDetailVO> selectAllGoods();

    // 특정 상품 조회
    @Select("SELECT * FROM 4jo_goods_detail WHERE gno=#{gno}")
    GoodsDetailVO selectOne(@Param("gno") int gno);
    
    // 상품 등록 정보 수정
    @Update("UPDATE 4jo_goods_detail SET keyword=#{keyword}, category=#{category}, goods_name=#{goods_name}, goods_img=#{goods_img} , seller_name=#{seller_name} , seller_url=#{seller_url} , goods_price=#{goods_price} , delivery_fee=#{delivery_fee} , date=#{date} WHERE gno =#{gno}")
     void update(GoodsDetailVO vo);

     // 등록 상품 삭제
     @Delete("DELETE FROM 4jo_goods_detail WHERE gno=#{gno}")
     void delete(@Param("gno") int gno);
}


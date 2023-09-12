package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.goodsdetail.GoodsDetailVO;
import com.multi.shoes4jo.util.Criteria;

@Mapper
public interface GoodsDetailMapper {

	// 상품 등록
	@Insert("INSERT INTO goods_detail(gno, keyword, category, goods_name, goods_img, seller_name, seller_url, goods_price, delivery_fee, date) VALUES(#{gno}, #{keyword}, #{category}, #{goods_name}, #{goods_img}, #{seller_name}, #{seller_url}, #{goods_price}, #{delivery_fee}, #{date})")
	void insert(GoodsDetailVO vo);

	// 전체 상품 목록 조회(키워드별로 번호가 가장 작은것만 노출되게하고 번호순 정렬),페이징
	@Select("SELECT a.* FROM goods_detail a JOIN (SELECT keyword, MIN(gno) as min_gno FROM goods_detail GROUP BY keyword) b ON a.keyword = b.keyword AND a.gno = b.min_gno ORDER BY gno ASC LIMIT #{perPageNum} OFFSET #{pageStart}")
	List<GoodsDetailVO> selectAllGoods(Criteria cri);

	// 페이징
	@Select("SELECT COUNT(gno) FROM goods_detail WHERE gno > 0")
	public int listCount();

	// 특정 상품 조회
	@Select("SELECT * FROM goods_detail WHERE keyword=#{keyword} ORDER BY goods_price ASC")
	List<GoodsDetailVO> selectOne(@Param("keyword") String keyword);

	// 상품 등록 정보 수정
	@Update("UPDATE goods_detail SET category=#{category}, goods_name=#{goods_name} , goods_img=#{goods_img} , seller_name=#{seller_name} , seller_url=#{seller_url} , goods_price=#{goods_price} , delivery_fee=#{delivery_fee} WHERE gno =#{gno} AND keyword =#{keyword}")
	void update(GoodsDetailVO vo);

	// 상품 번호 기준으로 등록 상품 삭제
	@Delete("DELETE FROM goods_detail WHERE gno=#{gno}")
	void delete(@Param("gno") int gno);

	// 같은 키워드에 해당하는 상품 전부 삭제
	@Delete("DELETE FROM goods_detail WHERE keyword=#{keyword}")
	void deleteByKeyword(@Param("keyword") String keyword);

}

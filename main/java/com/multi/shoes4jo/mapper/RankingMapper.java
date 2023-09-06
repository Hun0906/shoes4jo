package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.vo.RankingVO;

@Mapper
public interface RankingMapper {

	@Insert("INSERT INTO ranking (keyword, title) VALUES (#{keyword}, #{title})")
	void insert(@Param("keyword") String keyword, @Param("title") String title);

	@Select("SELECT * FROM ranking WHERE keyword = #{keyword}")
	RankingVO selectAll(@Param("keyword") String keyword);

	@Select("SELECT COUNT(*) FROM ranking WHERE keyword = #{keyword} AND date = #{date}")
	int isExists(@Param("keyword") String keyword, @Param("date") String date);

	@Update("UPDATE ranking SET cnt = cnt + 1 WHERE keyword = #{keyword} AND date = #{date}")
	void update(@Param("keyword") String keyword, @Param("date") String date);

	@Select("SELECT keyword, cnt, RANK() OVER (ORDER BY cnt DESC) AS ranking " + "FROM ( "
			+ "SELECT keyword, SUM(cnt) AS cnt " + "FROM ranking "
			+ "WHERE date_format(date,'%Y%m%d') BETWEEN date_format(DATE_sub(NOW(), INTERVAL 7 DAY),'%Y%m%d') AND date_format(NOW(),'%Y%m%d') "
			+ "GROUP BY keyword " + "ORDER BY cnt DESC " + ") a " + "ORDER BY ranking")
	List<RankingVO> searchRanking();
	
	@Select("SELECT * FROM shoes_4jo.ranking where date >= #{date} order by cnt DESC limit #{limit}")
	List<RankingVO> selectTopTen(@Param("date") String date, @Param("limit") int limit);
}

package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.vo.RankingVO;

@Mapper
public interface RankingMapper {

	@Insert("INSERT INTO 4jo_ranking (keyword, title) VALUES (#{keyword}, #{title})")
	void insert(String keyword, String title);

	@Select("SELECT * FROM 4jo_ranking WHERE keyword = #{keyword}")
	RankingVO selectAll(String keyword);

	@Select("SELECT COUNT(*) FROM 4jo_ranking WHERE keyword = #{keyword} AND date = #{date}")
	int isExists(String keyword, String date);

	@Update("UPDATE 4jo_ranking SET cnt = cnt + 1 WHERE keyword = #{keyword} AND date = #{date}")
	void update(String keyword, String date);

	@Select("SELECT keyword, cnt, RANK() OVER (ORDER BY cnt DESC) AS ranking " + "FROM ( "
			+ "SELECT keyword, SUM(cnt) AS cnt " + "FROM 4jo_ranking "
			+ "WHERE date_format(date,'%Y%m%d') BETWEEN date_format(DATE_sub(NOW(), INTERVAL 7 DAY),'%Y%m%d') AND date_format(NOW(),'%Y%m%d') "
			+ "GROUP BY keyword " + "ORDER BY cnt DESC " + ") a " + "ORDER BY ranking")
	List<RankingVO> searchRanking();
}

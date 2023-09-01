package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.multi.shoes4jo.vo.RankingVO;

@Mapper
public interface RankingMapper {
	@Select("SELECT keyword, cnt, RANK() OVER (ORDER BY cnt DESC) AS ranking " + "FROM ( "
			+ "SELECT keyword, SUM(cnt) AS cnt " + "FROM 4jo_ranking "
			+ "WHERE date_format(date,'%Y%m%d') BETWEEN date_format(DATE_sub(NOW(), INTERVAL 7 DAY),'%Y%m%d') AND date_format(NOW(),'%Y%m%d') "
			+ "GROUP BY keyword " + "ORDER BY cnt DESC " + ") a " + "ORDER BY ranking")
	List<RankingVO> searchRanking();

}

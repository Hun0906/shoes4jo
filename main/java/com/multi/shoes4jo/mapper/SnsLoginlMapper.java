package com.multi.shoes4jo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.multi.shoes4jo.vo.SnsVO;

@Mapper
public interface SnsLoginlMapper {


    //sns회원가입 한 내역 존재하는지 찾음
	@Select("SELECT * FROM 4jo_sns_member WHERE sns_id = #{sns_id}")
	SnsVO connect(@Param("sns_id") String sns_id);

	// sns 아이디로 회원가입
	@Insert("insert into 4jo_sns_member(sns_id, sns_type, sns_name, sns_profile, sns_connect_date) "
			+ "values (#{sns_id}, #{sns_type}, #{sns_name}, #{sns_profile}, now())")
	void insert(@Param("sns_id") String sns_id,
			@Param("sns_type") String sns_type, @Param("sns_name") String sns_name,
			@Param("sns_profile") String sns_profile);
}

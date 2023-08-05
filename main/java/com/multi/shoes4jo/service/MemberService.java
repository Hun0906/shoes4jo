package com.multi.shoes4jo.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.multi.shoes4jo.vo.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO memberVO) throws DataAccessException;
	
	public int loginMember(MemberVO memberVO) throws DataAccessException;
	
	public int memberInfo(MemberVO member) throws DataAccessException;

	public int updateMember(MemberVO member) throws DataAccessException;

	public int deleteMember(String member_id) throws DataAccessException;


}
package com.multi.shoes4jo.service;

import java.util.List;


import org.springframework.dao.DataAccessException;
import com.multi.shoes4jo.vo.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO memberVO) throws Exception;
	
	public int loginMember(MemberVO memberVO) throws Exception;

	public void updateMember(MemberVO memberVO) throws Exception;
	
	MemberVO memberInfo(String memberId) throws Exception;

	public int deleteMember(String memberVO) throws Exception;

	public int findPw(String member_email,String member_id)throws Exception;

	public int findPwCheck(MemberVO memberVO)throws Exception;



}
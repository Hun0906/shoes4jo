package com.multi.shoes4jo.service;

import com.multi.shoes4jo.vo.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO memberVO) throws Exception;
	
	public int loginMember(MemberVO memberVO) throws Exception;

	public void updateMember(MemberVO memberVO) throws Exception;
	
	MemberVO memberInfo(String memberId) throws Exception;

	public int deleteMember(String memberVO) throws Exception;

	public int duplicationId(String id) throws Exception;
  
}
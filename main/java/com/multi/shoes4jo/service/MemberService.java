package com.multi.shoes4jo.service;

import java.util.List;

import com.multi.shoes4jo.vo.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO memberVO) throws Exception;
	
	public int loginMember(MemberVO memberVO) throws Exception;

	public void updateMember(MemberVO memberVO) throws Exception;
	
	public MemberVO memberInfo(String memberId) throws Exception;

	public int deleteMember(String memberVO) throws Exception;

	public int duplicationId(String id) throws Exception;
	
	public List<MemberVO> memberIdSearch(MemberVO searchVO);
	
	public int pwCheck(MemberVO searchVO);
	
	public void pwUpdate(MemberVO searchVO);
	
	public List<MemberVO> listMembers() throws Exception;
 
   
}
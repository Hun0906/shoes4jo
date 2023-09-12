package com.multi.shoes4jo.member;

import java.util.List;

public interface MemberService {

	public int insertMember(MemberVO vo) throws Exception;
	
	public int loginMember(MemberVO vo) throws Exception;

	public void updateMember(MemberVO vo) throws Exception;
	
	public MemberVO memberInfo(String member_id) throws Exception;

	public int deleteMember(String member_id) throws Exception;

	public int duplicationId(String member_id) throws Exception;
	
	public List<MemberVO> memberIdSearch(MemberVO searchVO);
	
	public int pwCheck(MemberVO searchVO);
	
	public void pwUpdate(MemberVO searchVO);
	
	public List<MemberVO> listMembers() throws Exception;
 
   
}
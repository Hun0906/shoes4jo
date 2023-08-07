package com.multi.shoes4jo.dao;

import com.multi.shoes4jo.vo.MemberVO;

public interface MemberDAO

{
	int insertMember(MemberVO member);
	
	int loginMember(MemberVO member);
	
    int memberInfo(MemberVO member);

	int updateMember(MemberVO member);

	int deleteMember(String id);

	void setMemberDAO(MemberDAO memberDAO);
	
	int duplicationId(String id);
	

}

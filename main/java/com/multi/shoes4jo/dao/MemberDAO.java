package com.multi.shoes4jo.dao;
 
import java.util.List;
import com.multi.shoes4jo.vo.MemberVO;

public interface MemberDAO

{
	public int insertMember(MemberVO member) throws Exception;

	public int loginMember(MemberVO member) throws Exception;

	public void updateMember(MemberVO member) throws Exception;
	
	public MemberVO memberInfo(String memberId) throws Exception;

	public int deleteMember(String id) throws Exception;

	public int duplicationId(String id);
}
 
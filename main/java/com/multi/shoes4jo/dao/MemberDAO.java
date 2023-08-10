package com.multi.shoes4jo.dao;
<<<<<<< HEAD
 
=======

>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
import java.util.List;
import com.multi.shoes4jo.vo.MemberVO;

public interface MemberDAO

{
<<<<<<< HEAD
	public int insertMember(MemberVO member) throws Exception;

	public int loginMember(MemberVO member) throws Exception;

	public void updateMember(MemberVO member) throws Exception;
	
	public MemberVO memberInfo(String memberId) throws Exception;

	public int deleteMember(String id) throws Exception;

	public int duplicationId(String id);
}
 
=======
	int insertMember(MemberVO member);
	
	int loginMember(MemberVO member);
	
    int memberInfo(MemberVO member);

	int updateMember(MemberVO member);

	int deleteMember(String id);

	void setMemberDAO(MemberDAO memberDAO);

}
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132

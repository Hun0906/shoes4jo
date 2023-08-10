package com.multi.shoes4jo.service;

<<<<<<< HEAD
=======
import java.util.List;

import org.springframework.dao.DataAccessException;
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
import com.multi.shoes4jo.vo.MemberVO;

public interface MemberService {

<<<<<<< HEAD
	public int insertMember(MemberVO memberVO) throws Exception;
	
	public int loginMember(MemberVO memberVO) throws Exception;

	public void updateMember(MemberVO memberVO) throws Exception;
	
	MemberVO memberInfo(String memberId) throws Exception;

	public int deleteMember(String memberVO) throws Exception;

	public int duplicationId(String member_id) throws Exception;
  
=======
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	
	public int loginMember(MemberVO memberVO) throws DataAccessException;
	
	public int memberInfo(MemberVO member) throws DataAccessException;

	public int updateMember(MemberVO member) throws DataAccessException;

	public int deleteMember(String member_id) throws DataAccessException;


>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
}
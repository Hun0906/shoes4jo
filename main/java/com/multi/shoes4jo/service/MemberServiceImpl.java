package com.multi.shoes4jo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.dao.MemberDAO;
import com.multi.shoes4jo.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO)throws Exception  {
		this.memberDAO = memberDAO;
	}

	@Override
	public int insertMember(MemberVO member)throws Exception  {
		try {
			return memberDAO.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int loginMember(MemberVO member) throws Exception {
		try {
			return memberDAO.loginMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MemberVO memberInfo(String memberId) throws Exception {
		return memberDAO.memberInfo(memberId);
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		try {
			memberDAO.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int deleteMember(String id) throws Exception {
		try {
			return memberDAO.deleteMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int findPw(String member_email, String member_id) throws Exception  {

		return 0;
	}

	@Override
	public int findPwCheck(MemberVO memberVO)throws Exception  {

		return 0;
	}
}
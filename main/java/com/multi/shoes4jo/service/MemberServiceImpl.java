package com.multi.shoes4jo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.dao.MemberDAO;
import com.multi.shoes4jo.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public int insertMember(MemberVO member) {
		return memberDAO.insertMember(member);
	}
	
	@Override
	public int loginMember(MemberVO member) {
	    return memberDAO.loginMember(member);
	}
	
	@Override
	public int memberInfo(MemberVO member) {
	    return memberDAO.memberInfo(member);
	}

	@Override
	public int updateMember(MemberVO member) {
		return memberDAO.updateMember(member);
	}

	@Override
	public int deleteMember(String id) {
		return memberDAO.deleteMember(id);
	}
	
    @Override 
    public int duplicationId(String id) {
        return memberDAO.duplicationId(id);
 	     
    }
	 
}
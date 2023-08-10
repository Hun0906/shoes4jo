package com.multi.shoes4jo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.dao.MemberDAO;
import com.multi.shoes4jo.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

<<<<<<< HEAD
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
    public int duplicationId(String id) {
        return memberDAO.duplicationId(id);
 	     
    }
}
=======
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

}
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132

package com.multi.shoes4jo.service.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	private MemberServiceImpl memberMapper;

	@Override
	public int insertMember(MemberVO member) throws Exception {
		try {
			return sqlSession.insert("memberMapper.insertMember", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int loginMember(MemberVO member) throws Exception {
		try {
			return sqlSession.selectOne("memberMapper.loginMember", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MemberVO memberInfo(String memberId) throws Exception {
		return sqlSession.selectOne("memberMapper.memberInfo", memberId);
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		try {
			sqlSession.update("memberMapper.updateMember", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int deleteMember(String id) throws Exception {
		try {
			return sqlSession.delete("memberMapper.deleteMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int duplicationId(String id) throws Exception {
		return sqlSession.selectOne("memberMapper.duplicationId", id);
	}

	
	@Override
	public List<MemberVO> memberIdSearch(MemberVO searchVO) {
	return sqlSession.selectList("memberMapper.memberIdSearch", searchVO);
	}
	
	
	@Override
	public int pwCheck(MemberVO searchVO) {
		return sqlSession.selectOne("memberMapper.pwCheck", searchVO); 
	}
	 
	@Override
	public void pwUpdate(MemberVO searchVO) {
		sqlSession.update("memberMapper.pwUpdate", searchVO);
	}
	
    @Override
    public List<MemberVO> listMembers() throws Exception {
        return sqlSession.selectList("memberMapper.showMember");
    }
}  


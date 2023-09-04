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

	@Override
	public int insertMember(MemberVO vo) throws Exception {
		try {
			return sqlSession.insert("memberMapper.insertMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int loginMember(MemberVO vo) throws Exception {
		try {
			return sqlSession.selectOne("memberMapper.loginMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MemberVO memberInfo(String member_id) throws Exception {
		return sqlSession.selectOne("memberMapper.memberInfo", member_id);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		try {
			sqlSession.update("memberMapper.updateMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int deleteMember(String member_id) throws Exception {
		try {
			return sqlSession.delete("memberMapper.deleteMember",member_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int duplicationId(String member_id) throws Exception {
		return sqlSession.selectOne("memberMapper.duplicationId", member_id);
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


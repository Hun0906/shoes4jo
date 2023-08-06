package com.multi.shoes4jo.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.shoes4jo.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;
    private static final String ns = "mapper.member.";

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insertMember(MemberVO member) throws Exception {
    	return sqlSession.insert(ns + "insertMember", member);
    }

    @Override
    public int loginMember(MemberVO member) throws Exception {
        return sqlSession.selectOne(ns + "loginMember", member);
    }

    @Override
    public MemberVO memberInfo(String memberId) throws Exception {
        return sqlSession.selectOne(ns + "memberInfo", memberId);
    }

    @Override
    public void updateMember(MemberVO member) throws Exception {
        sqlSession.update(ns + "updateMember", member);
    }

    @Override
    public int deleteMember(String id) {
    	return sqlSession.delete(ns + "deleteMember", id);
    }

    @Override
    public int findPwCheck(MemberVO memberVO) throws Exception {
        return sqlSession.selectOne("mapper.member.findPwCheck", memberVO);
    }

    @Override
    public int findPw(String member_email, String member_id, String member_pw) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("member_email", member_email);
        map.put("member_id", member_id);
        map.put("member_pw", member_pw);
        return sqlSession.update("mapper.member.findPw", map);
    }

}

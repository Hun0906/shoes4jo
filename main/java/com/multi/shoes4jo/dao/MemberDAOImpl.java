package com.multi.shoes4jo.dao;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
 
=======
import java.util.List;

>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.shoes4jo.vo.MemberVO;
<<<<<<< HEAD
 
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
	public int duplicationId(String id) {
	    return sqlSession.selectOne(ns + "duplicationId", id);
	}

}
=======

@Repository

public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String ns = "mapper.member.";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertMember(MemberVO member) {
		sqlSession.insert(ns + "insertMember", member);
		return 1;
	}

	@Override
	public int loginMember(MemberVO member) {
	    return sqlSession.selectOne(ns + "loginMember", member);
	}
	
    @Override
    public int memberInfo(MemberVO member) {
        return sqlSession.selectOne(ns + "memberInfo", member);
    }

	@Override
	public int updateMember(MemberVO member) {
		sqlSession.update(ns + "updateMember", member);
		return 1;
	}

	@Override
	public int deleteMember(String id) {
		sqlSession.delete(ns + "deleteMember", id);
		return -1;
	}

	@Override
	public void setMemberDAO(MemberDAO memberDAO) {

	}

}
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132

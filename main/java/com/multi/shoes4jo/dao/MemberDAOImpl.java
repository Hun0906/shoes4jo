/*
 * //고쳐서 쓸거(찜)!!!
 * 
 * package com.multi.shoes4jo.dao;
 * 
 * import java.util.List;
 * 
 * import org.apache.ibatis.session.SqlSession; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * import shoes4jo.vo.MemberVO;
 * 
 * @Repository("memberDAO") public class MemberDAOImpl implements MemberDAO {
 * 
 * @Autowired private SqlSession sqlSession;
 * 
 * @Override public List selectAllMemberList() throws DataAccessException {
 * List<MemberVO> membersList = null; membersList =
 * sqlSession.selectList("mapper.selectAllMemberList"); return membersList; }
 * 
 * @Override public int insertMember(MemberVO memberVO) throws
 * DataAccessException { int result = sqlSession.insert("mapper.insertMember",
 * memberVO); return result; }
 * 
 * @Override public int deleteMember(String id) throws DataAccessException { int
 * result = sqlSession.delete("mapper.deleteMember", id); return result; }
 * 
 * @Override public MemberVO loginById(MemberVO memberVO) throws
 * DataAccessException { MemberVO vo = sqlSession.selectOne("mapper.loginById",
 * memberVO); return vo; }
 * 
 * }
 */
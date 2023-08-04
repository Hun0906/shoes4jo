<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.multi.shoes4jo.DBUtil" %>
<%
    String memberId = request.getParameter("memberId");
    String memberName = request.getParameter("memberName");
    String memberPw = request.getParameter("memberPw");

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DBUtil.getConnection();

        pstmt = conn.prepareStatement("UPDATE member SET member_id=?, member_name=? WHERE member_pw=?");
        pstmt.setString(1, memberId);
        pstmt.setString(2, memberName);
        pstmt.setString(3, memberPw);

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            // DB 업데이트 성공 시, 세션 정보도 업데이트
            session.setAttribute("memberId", memberId);
           // session.setAttribute("memberEmail", memberEmail);
            out.println("회원 정보가 수정되었습니다.");
        } else {
            out.println("회원 정보 수정에 실패했습니다.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn, pstmt, null);
    }
%>
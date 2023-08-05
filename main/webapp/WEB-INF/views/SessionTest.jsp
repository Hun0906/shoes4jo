<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.multi.shoes4jo.DBUtil"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = DBUtil.getConnection();

		// 세션에 저장된 memberId를 이용하여 해당 회원 정보 조회
		String memberId = (String) session.getAttribute("memberId");
		pstmt = conn.prepareStatement("SELECT * FROM member WHERE member_id=?");
		pstmt.setString(1, memberId);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			String memberName = rs.getString("member_name");
			String memberEmail = rs.getString("member_email");
			String memberPw = rs.getString("member_pw");
			String memberdate = rs.getString("signup_date");
			// 세션에 회원 정보를 저장
			session.setAttribute("memberName", memberName);
			session.setAttribute("memberEmail", memberEmail);
			session.setAttribute("memberPw", memberPw);
			session.setAttribute("memberdate", memberdate);
			// 다음 페이지로 이동
			response.sendRedirect("Testpage.jsp");
		} else {
			// 회원 정보를 찾지 못했을 경우 에러 페이지로 이동
			response.sendRedirect("ErrorPage.jsp");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		response.sendRedirect("ErrorPage.jsp");
	} finally {
		DBUtil.close(conn, pstmt, rs);
	}
%> --%>
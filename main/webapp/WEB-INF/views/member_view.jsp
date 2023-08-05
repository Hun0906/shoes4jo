<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.multi.shoes4jo.DBUtil"%>

<title>SHOES4JO | 회원 정보 조회 </title>
	<%@include file="header-head.jsp"%>
	<body>
		<%@include file="header.jsp"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = DBUtil.getConnection();

		// 세션에 저장된 memberId를 이용하여 해당 회원 정보만 조회
		String memberId = (String) session.getAttribute("memberId");
		pstmt = conn.prepareStatement("SELECT * FROM member WHERE member_id=?");
		pstmt.setString(1, memberId);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			String memberName = rs.getString("member_name");
			String signupDate = rs.getString("signup_date");

			out.println("회원 아이디: " + memberId + ", 이름: " + memberName + ", 가입날짜: " + signupDate + "<br>");
		} else {
			out.println("회원 정보를 찾을 수 없습니다.");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBUtil.close(conn, pstmt, rs);
	}
%>



	<%@include file="footer.jsp"%>

</body>
</html> --%>
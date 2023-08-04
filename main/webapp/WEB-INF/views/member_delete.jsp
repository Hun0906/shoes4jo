<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.multi.shoes4jo.DBUtil" %>
<%
    String memberId = (String) session.getAttribute("memberId"); // 세션에서 memberId 가져옴

    Connection conn = null;
    PreparedStatement pstmt = null;
    
%>
<script>
    var confirmed = confirm("정말로 회원 정보를 삭제하시겠습니까?");
    if (!confirmed) {
        // 사용자가 취소를 선택한 경우 이전 페이지로 돌아갑니다.
        window.history.back();
    }
</script>
<%
    if (memberId != null) {
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM member WHERE member_id=?");
            pstmt.setString(1, memberId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // 회원 정보 삭제에 성공했을 때, 세션에서 로그인 정보 제거
                session.removeAttribute("memberId");
               // session.removeAttribute("memberName");
               // session.removeAttribute("memberEmail");
                // JavaScript 코드로 경고창을 띄웁니다.
                %>
                <script>
                    alert("회원 정보가 삭제되었습니다.");
                    // 메인 페이지로 이동
                    window.location.href = "main.jsp";
                </script>
                <%
            } else {
                // JavaScript 코드로 경고창을 띄웁니다.
                %>
                <script>
                    alert("회원 정보 삭제에 실패했습니다.");
                    // 이전 페이지로 이동
                    window.history.back();
                </script>
                <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt, null);
        }
    }
%>
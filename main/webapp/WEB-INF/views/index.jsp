<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO</title>
</head>
<body>
<%
String context = ((HttpServletRequest)request).getContextPath(); 
response.sendRedirect("main");
%>
</body>
</html>
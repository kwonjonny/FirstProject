
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
 Date now = new Date();

 LocalDateTime time = LocalDateTime.now();
 
// 
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>안녕하세요!!!!</h1>
<h3><%= now %></h3>
<h3><%= time %></h3>
<h3><%= "time" %></h3>

</body>
</html>


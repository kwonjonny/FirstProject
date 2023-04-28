<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	List<Member> members = new ArrayList<>();
 	members.add(new Member("cool00", "0000", "COOL00"));
 	members.add(new Member("cool01", "0001", null));
 	members.add(new Member("cool02", "0002", "COOL02"));
 	members.add(new Member("cool03", "0003", "COOL03"));
 	members.add(new Member("cool04", "0004", null));
 	members.add(new Member("cool05", "0005", null));
 	members.add(new Member("cool06", "0006", "COOL06"));
 	members.add(new Member("cool07", "0007", null));
 	members.add(new Member("cool08", "0008", "COOL08"));
 	members.add(new Member("cool09", "0009", "COOL09"));
 	
 	session.setAttribute("members", members);
 	
%>


</body>
</html>
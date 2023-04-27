<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!-- 구현 영역(서버 사이드) -->

<%

	String msg = (String)session.getAttribute("member_error_msg");

	String redirect_url = (String)session.getAttribute("member_redirect_url");

%>



<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>에러 - 페이지(Error - Page / Session)</title>

<script>

	alert('<%= msg %>');

	location.href('<%= redirect_url %>');

</script>

</head>

<body>



</body>

</html>
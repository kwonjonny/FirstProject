<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!-- 구현 -->

<%

	String userID = (String)session.getAttribute("userID");

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>로그인 상태 - <%= userID %> 세션(Session)</title>

<style>

	<!-- 바디 영역 -->

	body{

		font-family:'Arial';

		font-size:13px;

	}

	

	#memberTbl{

	

		font-family:'Arial';

		font-size:13px;

		width:700px;

		border:2px solid #e2e2e2;

		

		text-align:center;

		margin:auto;

	

	}

	

	a { 

		text-decoration:none 

	}

	

	div{

		text-align:center;

	}



</style>



<script>

	

	function welcome(){

		alert("Hello World");

	}



	function logout(){



		location.href ('logout.do');

		

	}

	

</script>

</head>

<body>



<div>

<h3>로그인 상태 출력 - 페이지(Session)</h3>



<!-- 화면 출력 -->

<table id="memberTbl">

	<tr>

		<td style="width:20%">

			아이디(ID)		

		</td>

		<td style="border-left:2px solid #e2e2e2;">

			<%= userID %>

		</td>

	</tr>

	<tr>

		<td colspan="2" style="border-top:2px solid #e2e2e2;">

			<a href="javascript:welcome();">인사말 출력</a>

			&nbsp;&nbsp;

			<a href="javascript:logout();">로그아웃</a>

		</td>

	</tr>	

</table>

</div>



</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>로그인 - Member Login(세션 - Session)</title>

<style>
a {
	text-decoration: none
}

body {
	font-size: 12px;
	font-family: 'Arial';
}

#memberTbl {
	width: 700px;
	border: 1px solid #e2e2e2;
	text-align: center;
	margin: auto;
}

div {
	text-align: center;
}
</style>



</head>

<body>



	<div>



		<h3>로그인 페이지(Login - Page) - 세션(Session)</h3>

		<!-- 본문 -->

		<form action="process.do" method="POST">

			<table id="memberTbl">

				<tr>

					<td style="width: 20%; text-align: center;">아이디(userID)</td>

					<td style="border-left: 1px solid #e2e2e2; text-align: center;">

						<input type="text" name="userID" style="width: 90%">

					</td>

				</tr>

				<tr>

					<td
						style="width: 20%; border-top: 1px solid #e2e2e2; text-align: center;">

						비밀번호(password)</td>

					<td
						style="border-left: 1px solid #e2e2e2; border-top: 1px solid #e2e2e2; text-align: center;">

						<input type="text" name="password" style="width: 90%">

					</td>

				</tr>

				<tr>

					<td colspan="2"
						style="border-top: 1px solid #e2e2e2; text-align: center;"><input
						type="submit" value="로그인(Login)" style="width: 90%"></td>

				</tr>

			</table>

		</form>

	</div>



</body>

</html>
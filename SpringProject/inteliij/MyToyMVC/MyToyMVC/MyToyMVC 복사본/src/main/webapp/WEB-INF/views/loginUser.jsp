<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form method="post" action="/custom-login">

        <div class="form-group">
            <label for="id">id:</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <div class="form-group">
            <input type="checkbox" id="rememberMe" name="rememberMe" value="true">
            <label for="rememberMe">Remember Me</label>
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <a href="/forgotPassword">아이디 또는 비밀번호를 잊으셨나요? (회원 정보 이메일 발송)</a> <!-- 아이디 패스워드를 잊어버렸을 때의 링크 -->
    <br>
    <a href="/send-temp-password">아이디 또는 비밀번호를 잊으셨나요? (임시 비밀번호로 변경 후 이메일 발송)</a> <!-- 아이디 패스워드를 잊어버렷을 때의 임시비밀번호 링크-->
</div>
</body>
</html>

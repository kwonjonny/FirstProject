<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Verify Code</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <h1>이메일로 발송된 인증코드를 입력하세요.</h1>

    <form method="post" action="/waiting">
        <input type="hidden" name="username" value="${user.username}" />
        <input type="hidden" name="email" value="${user.email}" />
        <input type="hidden" name="id" value="${user.id}" />
        <input type="hidden" name="password" value="${user.password}" />
        <input type="hidden" name="agree" value="true" />
        <div class="form-group">
            <label for="authCode">인증 코드:</label>
            <input type="text" class="form-control" id="authCode" name="authCode" placeholder="인증 코드 입력" required>
        </div>
        <button type="submit" class="btn btn-primary">인증</button>
    </form>
    <form action="resendCode" method="post">
        <button type="submit" class="btn btn-primary">인증 코드 재발송</button>
    </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Password Recovery</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>비밀번호 찾기</h2>
        <form action="shootInformaiton" method="post">
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="이메일 주소를 입력하세요" required>
            </div>
            <button type="submit" class="btn btn-primary">비밀번호 찾기 이메일에 사용자 정보가 전송됩니다!.</button>
        </form>
    </div>
</body>
</html>




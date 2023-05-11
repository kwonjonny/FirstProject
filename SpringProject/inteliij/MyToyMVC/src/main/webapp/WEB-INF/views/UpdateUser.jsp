<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Update User</h2>
    <form action="update" method="post">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" name="id" value="${user.id}" required readonly>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="${user.password}" required>
        </div>
        <div class="form-group">
            <label for="username">Name:</label>
            <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
        </div>

        <div class="form-group">
            <input type="checkbox" id="agree" name="agree" value="agree" required>
            <label for="agree">이용 약관 및 개인정보 처리방침에 동의합니다. (<a href="/terms-of-service" target="_blank">이용 약관</a>, <a href="/privacy-policy" target="_blank">개인정보 처리방침</a>)</label>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Create User</h2>
    <div id="error" class="alert alert-danger" style="display: none;">${error}</div>
    <form action="create" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">Name:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <input type="checkbox" id="agree" name="agree" value="agree" required>
            <label for="agree">이용 약관 및 개인정보 처리방침에 동의합니다. (<a href="/terms-of-service" target="_blank">이용 약관</a>, <a href="/privacy-policy" target="_blank">개인정보 처리방침</a>)</label>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>

<script>
    function validateForm() {
        var username = document.getElementById("username").value;
        var email = document.getElementById("email").value;
        var id = document.getElementById("id").value;
        var password = document.getElementById("password").value;

        if (!username || !email || !id || !password) {
            alert("모든 필드를 입력하세요.");
            return false;
        }

        // 이후에 추가적인 유효성 검사 로직을 작성할 수 있습니다.

        return true;
    }
</script>
<script>
    window.onload = function() {
        var error = document.getElementById("error").innerText;
        if (error.trim() !== "") {
            document.getElementById("error").style.display = "block";
        }
    };
</script>
</body>
</html>

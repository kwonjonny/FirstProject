<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
        }

        .btn {
            margin-top: 10px;
        }

        form {
            display: inline-block;
        }

        .warning-message {
            color: red;
        }

        /* 다크 모드 스타일 */
        body.dark-mode {
            background-color: #222;
            color: #fff;
        }

        .container.dark-mode {
            color: #fff;
        }

        .btn.dark-mode {
            background-color: #333;
            border-color: #333;
            color: #fff;
        }

        .btn.dark-mode:hover {
            background-color: #555;
            border-color: #555;
        }

        .alert.dark-mode {
            background-color: #444;
            border-color: #333;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Main</h2>

    <div id="warningMessage" class="alert alert-warning" style="display:none;"></div>

    <div>
        <form action="/list" method="get">
            <button type="submit" class="btn btn-primary">내 정보</button>
        </form>
        <a href="/create" class="btn btn-primary">회원 가입</a>
        <a href="/update" class="btn btn-primary">회원 정보 수정</a>

        <form action="/delete" method="post">
            <button type="submit" class="btn btn-primary">회원 탈퇴</button>
        </form>

        <a href="/custom-login" class="btn btn-primary">login</a>

        <form action="/logout" method="post">
            <button type="submit" class="btn btn-primary">logout</button>
        </form>

        <!-- 게시판 버튼 -->
        <form action="/boardList" method="get">
            <button type="submit" class="btn btn-primary">게시판</button>
        </form>

        <!-- 다크 모드 토글 버튼 -->
        <button id="darkModeToggle" class="btn btn-dark-mode">다크 모드</button>
    </div>
</div>

<script>
    // Check if the warning message exists in the DOM
    const warningMessage = document.getElementById('warningMessage');
    if (warningMessage) {
        const warningText = '${warning}'; // Replace with the actual warning message value from the server
        if (warningText) {
            warningMessage.innerText = warningText;
            warningMessage.style.display = 'block';
        }
    }

    // 다크 모드 토글 기능
    const darkModeToggle = document.getElementById('darkModeToggle');
    const body = document.body;

    darkModeToggle.addEventListener('click', function() {
        body.classList.toggle('dark-mode');
    });
</script>

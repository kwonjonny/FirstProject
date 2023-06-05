<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Board Update Page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        .form-area {
            margin-bottom: 20px;
        }

        .form-area label {
            font-weight: bold;
        }

        .form-area textarea {
            height: 200px;
        }

        .btn-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body class="container">
<h2>Board Update Page</h2>
<hr>

<div class="btn-group">
    <a href="/boardList">게시판 돌아가기</a>
</div>

<div class="form-area">
    <form method="post">
        <input type="hidden" name="bno" value="${boardUpdate.bno}">

        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" name="title" value="${boardUpdate.title}" required>
        </div>

        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" id="content" name="content" required>${boardUpdate.content}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">글 수정</button>
    </form>
</div>
</body>
</html>

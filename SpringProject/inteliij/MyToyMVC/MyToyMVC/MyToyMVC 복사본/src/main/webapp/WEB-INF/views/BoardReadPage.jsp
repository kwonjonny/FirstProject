<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Board Read Page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        .table {
            margin-top: 30px;
        }

        .table td:first-child {
            font-weight: bold;
            width: 150px;
        }

        .btn-group {
            margin-top: 20px;
        }

        .btn {
            margin-right: 10px;
        }
    </style>
</head>
<body class="container">
<h2>Board Read Page</h2>
<hr>

<table class="table">
    <tr>
        <td>게시글 번호</td>
        <td>${article.bno}</td>
    </tr>
    <tr>
        <td>글 제목</td>
        <td>${article.title}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td>${article.content}</td>
    </tr>
    <tr>
        <td>작성자</td>
        <td>${article.user_id}</td>
    </tr>
    <tr>
        <td>작성 날짜</td>
        <td>${article.regdate}</td>
    </tr>
    <tr>
        <td>수정 날짜</td>
        <td>${article.updatedate}</td>
    </tr>
</table>

<div class="btn-group">
    <a href="/boardList" class="btn btn-default">게시판 돌아가기</a>
</div>
<%-- 수정 삭제 버튼은 ROLE_USER와 각자의 id를 비교해서 보여준다 --%>
<security:authorize access="hasRole('ROLE_USER')">
    <c:if test="${article.user_id ==  currentUserId}">
<div class="btn-group">
    <a href="/boardUpdate?bno=${article.bno}" class="btn btn-primary">수정</a>
    <a href="/boardDelete?bno=${article.bno}" class="btn btn-danger">삭제</a>
</div>
    </c:if>
</security:authorize>

</body>
</html>

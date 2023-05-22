<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search Result</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Search Result</h2>
    <hr>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>게시물 번호</th>
            <th>제     목</th>
            <th>내     용</th>
            <th>작  성  자</th>
            <th>등록   날짜</th>
            <th>수정   일시</th>
            <th>작   업</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="board">
            <tr>
                <td>${board.bno}</td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.user_id}</td>
                <td>${board.regdate}</td>
                <td>${board.updatedate}</td>
                <td>
                    <form action="/boardUpdate" method="get" style="display: inline;">
                        <input type="hidden" name="bno" value="${board.bno}">
                        <button type="submit" class="btn btn-warning">수정</button>
                    </form>
                    <form action="/boardDelete" method="post" style="display: inline;">
                        <input type="hidden" name="bno" value="${board.bno}">
                        <button type="submit" class="btn btn-danger">삭제</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Board List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Board List</h2>
    <hr>

    <!-- 검색 폼 -->
    <form action="/boardread" method="get" class="form-inline">
        <div class="form-group">
            <input type="text" class="form-control" id="searchText" name="searchText" placeholder="제목 혹은 내용을 입력해주세요...">
        </div>
        <button type="submit" class="btn btn-default">검색</button>
    </form>
    <hr>

    <!-- 글작성 버튼 -->
    <button onclick="location.href='/boardCreate'" class="btn btn-primary">글 작성</button>
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
            <th>작   업</th> <!-- 추가된 칼럼 -->
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.bno}</td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.user_id}</td>
                <td>${board.regdate}</td>
                <td>${board.updatedate}</td>
                <td> <!-- 작업 버튼 추가 -->
                    <button onclick="location.href='/board/update/${board.bno}'" class="btn btn-warning">수정</button>
                    <button onclick="location.href='/boardDelete/${board.bno}'" class="btn btn-danger">삭제</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

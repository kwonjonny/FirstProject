<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="seucrity" uri="http://www.springframework.org/security/tags" %>
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
    <div class="searchArea">
    <form action="/boardRead" method="post" class="form-inline">
        <div class="form-group">
            <select class="form-control" id="searchType" name="searchType">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="writer">작성자</option>
            </select>
        </div>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form>
</div>


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
                <td><a href="/boardContact?bno=${board.bno}">${board.title}${board.content}</a></td>
                <td>${board.content}</td>
                <td>${board.user_id}</td>
                <td>${board.regdate}</td>
                <td>${board.updatedate}</td>
                <td>

                    <!-- 수정, 삭제 작업버튼 ROLE_USER 에게만 보여준다 -->
                    <seucrity:authorize access="hasRole('ROLE_USER')">
                    <form action="/boardUpdate" method="get" style="display: inline;">
                        <input type="hidden" name="bno" value="${board.bno}">
                        <button type="submit" class="btn btn-warning">수정</button>
                    </form>


                    <form action="/boardDelete" method="post" style="display: inline;">
                        <input type="hidden" name="bno" value="${board.bno}">
                        <button type="submit" class="btn btn-danger">삭제</button>
                    </form>
                    </seucrity:authorize>


                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

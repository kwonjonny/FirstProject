<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    <h2>Board Read</h2>
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
            <th><security:authorize access="hasRole('ROLE_USER')">작 업</security:authorize> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="board">
            <tr>
                <td>${board.bno}</td>
                <td><a href="/boardContact?bno=${board.bno}">${board.title}${board.content}</a></td>
                <td>${board.content}</td>
                <td>${board.user_id}</td>
                <td>${board.regdate}</td>
                <td>${board.updatedate}</td>
                <td>

                    <!-- 수정, 삭제 작업버튼 ROLE_USER 에게만 보여준다 -->
                    <security:authorize access="hasRole('ROLE_USER')">
                        <c:if test="${board.user_id eq currentUserId}">
                    <form action="/boardUpdate" method="get" style="display: inline;">
                        <input type="hidden" name="bno" value="${board.bno}">
                        <button type="submit" class="btn btn-warning">수정</button>
                    </form>

                    <form action="/boardDelete" method="post" style="display: inline;">
                        <input type="hidden" name="bno" value="${board.bno}">
                        <button type="submit" class="btn btn-danger">삭제</button>
                    </form>
                        </c:if>
                    </security:authorize>


                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

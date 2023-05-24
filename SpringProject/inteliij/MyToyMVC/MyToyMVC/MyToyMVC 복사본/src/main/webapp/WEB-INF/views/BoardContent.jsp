<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Board Content</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Board Content</h2>
    <hr>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>제     목</th>
            <th>내     용</th>
            <th>작  성  자</th>
            <th>작   업</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${content.title}</td>
            <td>${content.content}</td>
            <td>${content.user_id}</td>
            <td>

                <!-- 수정, 삭제 작업버튼 ROLE_USER 에게만 보여준다 -->
                <security:authorize access="hasRole('ROLE_USER')">
                <form action="/boardUpdate" method="get" style="display: inline;">
                    <input type="hidden" name="bno" value="${content.bno}">
                    <button type="submit" class="btn btn-warning">수정</button>
                </form>
                <form action="/boardDelete" method="post" style="display: inline;">
                    <input type="hidden" name="bno" value="${content.bno}">
                    <button type="submit" class="btn btn-danger">삭제</button>
                </form>
                </security:authorize>


            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>

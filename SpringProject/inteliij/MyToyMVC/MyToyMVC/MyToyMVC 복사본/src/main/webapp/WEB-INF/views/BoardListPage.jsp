<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Board List Page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        .searchArea {
            margin-bottom: 20px;
        }

        .table {
            margin-bottom: 30px;
        }

        .paging {
            margin-top: 20px;
        }

        .pagination li.active a {
            display: inline;
            margin-right: 5px;
            background-color: green;
        }

    </style>
</head>
<body class="container">
<h2>Board List Page</h2>
<hr>

<!-- 검색 폼 -->
<div class="searchArea">
    <form class="form-inline">
        <div class="form-group">
            <select name="searchType" class="form-control">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="user_id">작성자</option>
            </select>
        </div>
        <div class="form-group">
            <input type="text" name="keyword" class="form-control">
        </div>
        <button type="submit" class="btn btn-default">검색</button>
    </form>
</div>

<%-- 수정 삭제 버튼은 ROLE_USER와 각자의 id를 비교해서 보여준다 --%>
<security:authorize access="hasRole('ROLE_USER')">
        <div class="btn-group">
            <a href="/boardCreate">글 쓰기</a>
        </div>

</security:authorize>

<table class="table">
    <thead>
    <tr>
        <th>게시물 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>수정일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="board">
        <tr>
            <td>${board.bno}</td>
            <td><a href="/boardRead?bno=${board.bno}">${board.title}</a></td>
            <td>${board.user_id}</td>
            <td>${board.regdate}</td>
            <td>${board.updatedate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="paging">
    <nav>
        <ul class="pagination">
            <c:if test="${page.prev}">
                <li><a href="/boardList?p=${page.startNumber-1}&searchType=${param.searchType}&keyword=${param.keyword}">이전</a></li>
            </c:if>
            <c:forEach begin="${page.startNumber}" end="${page.endNumber}" var="num">
                <li class="${num == page.pageNumber ? 'active' : ''}"><a href="/boardList?p=${num}&searchType=${param.searchType}&keyword=${param.keyword}">${num}</a></li>
            </c:forEach>
            <c:if test="${page.next}">
                <li><a href="/boardList?p=${page.endNumber+1}&searchType=${param.searchType}&keyword=${param.keyword}">다음</a></li>
            </c:if>
        </ul>
    </nav>
</div>

</body>
</html>
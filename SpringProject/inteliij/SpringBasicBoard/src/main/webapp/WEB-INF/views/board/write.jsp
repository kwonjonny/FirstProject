<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-05-18
  Time: 오후 5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 쓰기</title>
</head>
<body>

<h1> 게시글 쓰기 </h1>
<hr>
<form method="post" enctype="multipart/form-data">
  <table>
    <tr>
        <td>작성자</td>
        <td><input type="text" name="writer" required></td>
    </tr>
      <tr>
          <td>제목</td>
          <td><input type="text" name="title" required></td>
      </tr>
      <tr>
          <td>내용</td>
          <td><textarea name="content" cols="22" rows="5"></textarea></td>
      </tr>
      <tr>
          <td>첨부파일(이미지)</td>
          <td><input type="file" name="file1"></td>
      </tr>

      <tr>
          <td></td>
          <td>
              <input type="reset">
              <input type="submit">
          </td>
      </tr>
  </table>
</form>

</body>
</html>

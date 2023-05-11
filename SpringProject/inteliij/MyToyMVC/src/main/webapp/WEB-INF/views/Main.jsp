<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-05-11
  Time: 오후 1:38
  To change this template use File | Settings | File Templates.
--%>
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
    </style>
</head>
<body>
<div class="container">
    <h2>Main</h2>
    <% if (request.getAttribute("message") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getAttribute("message") %>
    </div>
    <% } %>
    <% if (request.getAttribute("passwordChangeMessage") != null) { %>
    <div class="alert alert-warning" role="alert">
        <%= request.getAttribute("passwordChangeMessage") %>
        <a href="updateUser.jsp" class="btn btn-primary">Update User</a>
    </div>
    <% } %>

    <div>
        <form action="/list" method="get">
            <button type="submit" class="btn btn-primary">List User</button>
        </form>
        <a href="/create" class="btn btn-primary">Create User</a>
        <a href="/update" class="btn btn-primary">Update User</a>
        <a href="/delete" class="btn btn-primary">Delete User</a>

        <a href="/login" class="btn btn-primary">login</a>

        <form action="logout" method="get">
            <button type="submit" class="btn btn-primary">logout</button>
        </form>
    </div>
</div>
</body>
</html>


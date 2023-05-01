
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
       form{
       display:inline-block;
       }
    </style>
</head>
<body>
    <div class="container">
        <h2>Main</h2>
        <% if(request.getAttribute("message") != null){ %>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("message") %>
            </div>
        <% } %>
        <div>
            <form action="readUser" method="get">
                <button type="submit" class="btn btn-primary">List User</button>
            </form>
            <a href="createUser.jsp" class="btn btn-primary">Create User</a>
            <a href="updateUser.jsp" class="btn btn-primary">Update User</a>
            <a href="deleteUser.jsp" class="btn btn-primary">Delete User</a>
            
            <a href="login.jsp" class="btn btn-primary">login</a>
            
            <form action="logout" method="get">
            <button type="submit" class="btn btn-primary">logout</button>
            </form>
        </div>
    </div>
</body>
</html>


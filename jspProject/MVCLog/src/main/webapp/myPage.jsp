<%@ page import="domain.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 mx-auto">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title text-center">My Page</h3>
                    </div>
                    <div class="card-body text-center">
                        <% 
                            User user = (User) session.getAttribute("user");
                            if (user != null) {
                        %>
                            <p>Username: <%= user.getUsername() %></p>
                            <p>Email: <%= user.getEmail() %></p>
                            <p>ID: <%= user.getId() %></p>
                            <p>Password: <%= user.getPassword() %></p>
                            <a href="main" class="btn btn-primary">Logout</a> 
                        <% } else { %>
                            <p>Please log in.</p>
                            <a href="login.jsp" class="btn btn-primary">Login</a> 
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>


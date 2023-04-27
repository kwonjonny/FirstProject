<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Join Member Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center mt-5">Join Member Page</h1>
        <form method="post" action="myPage.jsp" class="mt-5">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" name="id" id="id" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Password:</label>
                <input type="password" name="confirm-password" id="confirm-password" class="form-control" required>
            </div>	
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">Join Member</button>
            </div>
        </form>
        <div class="text-center mt-3">
            <a href="login.jsp">Already a member? Log in here</a>
        </div>
    </div>
</body>
</html>

